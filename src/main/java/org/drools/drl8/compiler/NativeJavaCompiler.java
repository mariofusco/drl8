/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.drl8.compiler;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.Arrays.asList;

public class NativeJavaCompiler {
    // Compiler requires source files with a ".java" extension:
    static final String JAVA_EXTENSION = ".java";

    private final ClassLoaderImpl classLoader;

    // The compiler instance that this facade uses.
    private final JavaCompiler compiler;

    // The compiler options (such as "-target" "1.5").
    private final List<String> options;

    // collect compiler diagnostics in this instance.
    private DiagnosticCollector<JavaFileObject> diagnostics;

    // The FileManager which will store source and class "files".
    private final FileManagerImpl javaFileManager;

    public NativeJavaCompiler( ClassLoader loader, String... options ) {
        this.compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new IllegalStateException("Cannot find the system Java compiler. "
                                            + "Check that your class path includes tools.jar");
        }
        this.classLoader = new ClassLoaderImpl(loader);
        this.javaFileManager = new FileManagerImpl(compiler.getStandardFileManager(diagnostics, null, null), classLoader);
        this.options = asList(options);
    }

    public synchronized Class<?> compile( String qualifiedClassName, CharSequence javaSource ) {
        return compile(Collections.singletonMap( qualifiedClassName, javaSource )).get(qualifiedClassName);
    }

    public synchronized Map<String, Class<?>> compile( Map<String, CharSequence> classes ) {
        this.diagnostics = new DiagnosticCollector<>();
        List<JavaFileObject> sources = new ArrayList<>();
        for (Entry<String, CharSequence> entry : classes.entrySet()) {
            String qualifiedClassName = entry.getKey();
            CharSequence javaSource = entry.getValue();
            if (javaSource != null) {
                final int dotPos = qualifiedClassName.lastIndexOf('.');
                final String className = dotPos == -1 ? qualifiedClassName
                                                      : qualifiedClassName.substring(dotPos + 1);
                final String packageName = dotPos == -1 ? "" : qualifiedClassName
                        .substring(0, dotPos);
                final JavaFileObjectImpl source = new JavaFileObjectImpl(className,
                                                                         javaSource);
                sources.add(source);
                // Store the source file in the FileManager via package/class
                // name.
                // For source files, we add a .java extension
                javaFileManager.putFileForInput(StandardLocation.SOURCE_PATH, packageName,
                                                className + JAVA_EXTENSION, source);
            }
        }
        // Get a CompliationTask from the compiler and compile the sources
        final CompilationTask task = compiler.getTask(null, javaFileManager, diagnostics,
                                                      options, null, sources);
        final Boolean result = task.call();
        if (result == null || !result ) {
            throw new CompilationException( "Compilation failed.", classes.keySet(), diagnostics);
        }
        try {
            // For each class name in the inpput map, get its compiled
            // class and put it in the output map
            Map<String, Class<?>> compiled = new HashMap<>();
            for (String qualifiedClassName : classes.keySet()) {
                final Class<?> newClass = loadClass(qualifiedClassName);
                compiled.put(qualifiedClassName, newClass);
            }
            return compiled;
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
            throw new CompilationException( classes.keySet(), e, diagnostics);
        }
    }

    public Class<?> loadClass(final String qualifiedClassName) throws ClassNotFoundException {
        return classLoader.loadClass(qualifiedClassName);
    }

    public ClassLoader getClassLoader() {
        return javaFileManager.getClassLoader();
    }

    private static class FileManagerImpl extends ForwardingJavaFileManager<JavaFileManager> {
        // the delegating class loader (passed to the constructor)
        private final ClassLoaderImpl classLoader;

        // Internal map of filename URIs to JavaFileObjects.
        private final Map<URI, JavaFileObject> fileObjects = new HashMap<>();

        /**
         * Construct a new FileManager which forwards to the <var>fileManager</var>
         * for source and to the <var>classLoader</var> for classes
         *
         * @param fileManager
         *           another FileManager that this instance delegates to for
         *           additional source.
         * @param classLoader
         *           a ClassLoader which contains dependent classes that the compiled
         *           classes will require when compiling them.
         */
        public FileManagerImpl(JavaFileManager fileManager, ClassLoaderImpl classLoader) {
            super(fileManager);
            this.classLoader = classLoader;
        }

        public ClassLoader getClassLoader() {
            return classLoader;
        }

        @Override
        public FileObject getFileForInput(Location location, String packageName,
                                          String relativeName) throws IOException {
            FileObject o = fileObjects.get(uri(location, packageName, relativeName));
            return o != null ? o : super.getFileForInput(location, packageName, relativeName);
        }

        public void putFileForInput(StandardLocation location, String packageName,
                                    String relativeName, JavaFileObject file) {
            fileObjects.put(uri(location, packageName, relativeName), file);
        }

        private URI uri(Location location, String packageName, String relativeName) {
            return toURI( location.getName() + '/' + packageName + '/' + relativeName );
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String qualifiedName,
                                                   Kind kind, FileObject outputFile) throws IOException {
            JavaFileObject file = new JavaFileObjectImpl(qualifiedName, kind);
            classLoader.add(qualifiedName, file);
            return file;
        }

        @Override
        public ClassLoader getClassLoader(JavaFileManager.Location location) {
            return classLoader;
        }

        @Override
        public String inferBinaryName(Location loc, JavaFileObject file) {
            return file instanceof JavaFileObjectImpl ? file.getName() : super.inferBinaryName(loc, file);
        }

        @Override
        public Iterable<JavaFileObject> list(Location location, String packageName,
                                             Set<Kind> kinds, boolean recurse) throws IOException {
            Iterable<JavaFileObject> result = super.list(location, packageName, kinds, recurse);
            ArrayList<JavaFileObject> files = new ArrayList<>();
            if (location == StandardLocation.CLASS_PATH
                && kinds.contains(JavaFileObject.Kind.CLASS)) {
                for (JavaFileObject file : fileObjects.values()) {
                    if (file.getKind() == Kind.CLASS && file.getName().startsWith(packageName))
                        files.add(file);
                }
                files.addAll(classLoader.files());
            } else if (location == StandardLocation.SOURCE_PATH
                       && kinds.contains(JavaFileObject.Kind.SOURCE)) {
                for (JavaFileObject file : fileObjects.values()) {
                    if (file.getKind() == Kind.SOURCE && file.getName().startsWith(packageName))
                        files.add(file);
                }
            }
            for (JavaFileObject file : result) {
                files.add(file);
            }
            return files;
        }
    }

    private static class JavaFileObjectImpl extends SimpleJavaFileObject {
        // If kind == CLASS, this stores byte code from openOutputStream
        private ByteArrayOutputStream byteCode;

        // if kind == SOURCE, this contains the source text
        private final CharSequence source;

        /**
         * Construct a new instance which stores source
         *
         * @param baseName
         *           the base name
         * @param source
         *           the source code
         */
        JavaFileObjectImpl(final String baseName, final CharSequence source) {
            super( toURI( baseName + NativeJavaCompiler.JAVA_EXTENSION ), Kind.SOURCE);
            this.source = source;
        }

        JavaFileObjectImpl(final String name, final Kind kind) {
            super( toURI( name ), kind );
            source = null;
        }

        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors)
                throws UnsupportedOperationException {
            if (source == null)
                throw new UnsupportedOperationException("getCharContent()");
            return source;
        }

        @Override
        public InputStream openInputStream() {
            return new ByteArrayInputStream(getByteCode());
        }

        @Override
        public OutputStream openOutputStream() {
            byteCode = new ByteArrayOutputStream();
            return byteCode;
        }

        byte[] getByteCode() {
            return byteCode.toByteArray();
        }
    }

    /**
     * A custom ClassLoader which maps class names to JavaFileObjectImpl instances.
     */
    private static class ClassLoaderImpl extends ClassLoader {
        private final Map<String, JavaFileObject> classes = new HashMap<>();

        ClassLoaderImpl(final ClassLoader parentClassLoader) {
            super(parentClassLoader);
        }

        Collection<JavaFileObject> files() {
            return Collections.unmodifiableCollection(classes.values());
        }

        @Override
        protected Class<?> findClass(final String qualifiedClassName) throws ClassNotFoundException {
            JavaFileObject file = classes.get(qualifiedClassName);
            if (file != null) {
                byte[] bytes = ((JavaFileObjectImpl) file).getByteCode();
                return defineClass(qualifiedClassName, bytes, 0, bytes.length);
            }
            // Workaround for "feature" in Java 6
            // see http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6434149
            try {
                return Class.forName(qualifiedClassName);
            } catch (ClassNotFoundException nf) {
                // Ignore and fall through
            }
            return super.findClass(qualifiedClassName);
        }

        void add(final String qualifiedClassName, final JavaFileObject javaFile) {
            classes.put(qualifiedClassName, javaFile);
        }

        @Override
        protected synchronized Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }

        @Override
        public InputStream getResourceAsStream(final String name) {
            if (name.endsWith(".class")) {
                String qualifiedClassName = name.substring(0, name.length() - ".class".length()).replace('/', '.');
                JavaFileObjectImpl file = (JavaFileObjectImpl) classes.get(qualifiedClassName);
                if (file != null) {
                    return new ByteArrayInputStream(file.getByteCode());
                }
            }
            return super.getResourceAsStream(name);
        }
    }

    private static URI toURI(String name) {
        try {
            return new URI(name);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}


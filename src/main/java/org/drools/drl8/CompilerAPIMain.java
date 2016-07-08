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

package org.drools.drl8;

import com.sun.source.tree.ClassTree;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.Arrays;
import java.util.Set;

public class CompilerAPIMain {

    private static final String TEST_FILE = "src/test/resources/examples/Test.java";

    public static void main( String[] args ) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector< JavaFileObject > diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager manager = compiler.getStandardFileManager( diagnostics, null, null );

        ASTVisitor scanner = new ASTVisitor();
        ASTProcessor processor = new ASTProcessor( scanner );

        Iterable<? extends JavaFileObject> sources = manager.getJavaFileObjects(new File(TEST_FILE));

        JavaCompiler.CompilationTask task = compiler.getTask( null, manager, diagnostics, null, null, sources );
        task.setProcessors( Arrays.asList( processor ) );
        task.call();

        System.out.println( scanner.getClassTree() );
    }

    public static class ASTVisitor extends TreePathScanner< Object, Trees > {
        private ClassTree classTree;

        @Override
        public Object visitClass( ClassTree node, Trees trees ) {
            classTree = node;
            return super.visitClass( node, trees );
        }

        public ClassTree getClassTree() {
            return classTree;
        }
    }

    @SupportedSourceVersion( SourceVersion.RELEASE_8 )
    @SupportedAnnotationTypes( "*" )
    public static class ASTProcessor extends AbstractProcessor {
        private final ASTVisitor scanner;
        private Trees trees;

        public ASTProcessor( final ASTVisitor scanner ) {
            this.scanner = scanner;
        }

        @Override
        public synchronized void init( final ProcessingEnvironment processingEnvironment ) {
            super.init( processingEnvironment );
            trees = Trees.instance( processingEnvironment );
        }

        public boolean process( final Set< ? extends TypeElement> types,
                                final RoundEnvironment environment ) {

            if( !environment.processingOver() ) {
                for( final Element element: environment.getRootElements() ) {
                    scanner.scan( trees.getPath( element ), trees );
                }
            }

            return false;
        }
    }
}

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
import javax.tools.JavaFileObject;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class CompilationException extends RuntimeException {

    private Set<String> classNames;

    private DiagnosticCollector<JavaFileObject> diagnostics;

    public CompilationException( String message,
                                 Set<String> qualifiedClassNames, Throwable cause,
                                 DiagnosticCollector<JavaFileObject> diagnostics ) {
        super(message, cause);
        setClassNames(qualifiedClassNames);
        setDiagnostics(diagnostics);
    }

    public CompilationException( String message,
                                 Set<String> qualifiedClassNames,
                                 DiagnosticCollector<JavaFileObject> diagnostics ) {
        super(message);
        setClassNames(qualifiedClassNames);
        setDiagnostics(diagnostics);
    }

    public CompilationException( Set<String> qualifiedClassNames,
                                 Throwable cause, DiagnosticCollector<JavaFileObject> diagnostics ) {
        super(cause);
        setClassNames(qualifiedClassNames);
        setDiagnostics(diagnostics);
    }

    private void setClassNames(Set<String> qualifiedClassNames) {
        classNames = qualifiedClassNames;
    }

    private void setDiagnostics(DiagnosticCollector<JavaFileObject> diagnostics) {
        this.diagnostics = diagnostics;
    }

    /**
     * Gets the diagnostics collected by this exception.
     *
     * @return this exception's diagnostics
     */
    public DiagnosticCollector<JavaFileObject> getDiagnostics() {
        return diagnostics;
    }

    /**
     * @return The name of the classes whose compilation caused the compile
     *         exception
     */
    public Collection<String> getClassNames() {
        return Collections.unmodifiableSet(classNames);
    }
}
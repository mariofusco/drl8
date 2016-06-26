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

package org.drools.drl8.util;

import org.drools.drl8.ast.Node;
import org.drools.drl8.ast.SourceNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerationContext {

    private final ClassResolver classResolver = new ClassResolver();

    private boolean equalityMode = false;

    public String generateCode( Node node ) {
        if (node instanceof SourceNode) {
            classResolver.indexSource( ( (SourceNode) node ) );
        }
        return codeOf( node );
    }

    private String codeOf( Node node ) {
        StringBuilder sb = new StringBuilder();
        node.generateCode( this, sb );
        return sb.toString();
    }

    public Map<String, String> generateCode( Iterable<SourceNode> sources ) {
        for (SourceNode source : sources) {
            classResolver.indexSource( source );
        }
        Map<String, String> result = new HashMap<>();
        for (SourceNode source : sources) {
            result.put( source.type.getFullyQualifiedName(), codeOf( source ) );
        }
        return result;
    }


    public boolean isEqualityMode() {
        return equalityMode;
    }

    public CodeGenerationContext setEqualityMode( boolean equalityMode ) {
        this.equalityMode = equalityMode;
        return this;
    }

    public ClassDescriptor resolve( String name, List<String> imports ) {
        return classResolver.resolve( name, imports );
    }
}

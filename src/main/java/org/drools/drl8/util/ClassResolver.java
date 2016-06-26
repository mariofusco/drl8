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

import org.drools.drl8.ast.SourceNode;
import org.drools.drl8.ast.TypeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassResolver {

    private final Map<String, ClassDescriptor> classMap = new HashMap<>();

    public ClassDescriptor resolve( String name, List<String> imports) {
        ClassDescriptor resolved = resolve( name );
        if (resolved != null) {
            return resolved;
        }
        resolved = resolve( "java.lang." + name );
        if (resolved != null) {
            return resolved;
        }
        for (String imp : imports) {
            if (imp.endsWith( name )) {
                resolved = resolve(imp);
            } else if(imp.endsWith( ".*" )) {
                resolved = resolve(imp.substring( 0, imp.length()-1 ) + name);
            }
            if (resolved != null) {
                return resolved;
            }
        }
        throw new RuntimeException( "Cannot resolve " + name );
    }

    private ClassDescriptor resolve(String fqn) {
        ClassDescriptor clsDesc = classMap.get(fqn);
        if (clsDesc != null) {
            return clsDesc;
        }
        try {
            clsDesc = ClassDescriptor.fromClass( Class.forName( fqn ) );
            classMap.put( fqn, clsDesc );
            return clsDesc;
        } catch (ClassNotFoundException e) {
            // ignore
        }
        return null;
    }

    public void indexSource( SourceNode source ) {
        classMap.put(source.type.getFullyQualifiedName(), ClassDescriptor.fromNode( source.type ));
        if (source.type.innerTypes != null) {
            for ( TypeNode inner : source.type.innerTypes ) {
                classMap.put(inner.getFullyQualifiedName(), ClassDescriptor.fromNode( inner ));
            }
        }
    }
}

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

import org.drools.drl8.ast.MethodNode;
import org.drools.drl8.ast.ParamTypeNode;
import org.drools.drl8.ast.TypeNode;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public interface ClassDescriptor {

    String getFullyQualifiedName();

    boolean isPrimitive();

    ParamTypeNode getMethodReturnType( String name, ClassDescriptor... parameterTypes );

    static ClassDescriptor fromNode(TypeNode typeNode) {
        return new NodeDescriptor( typeNode );
    }

    static ClassDescriptor fromClass(Class<?> cls) {
        return new IntrospectiveDescriptor( cls );
    }

    class NodeDescriptor implements ClassDescriptor {
        private final TypeNode typeNode;

        public NodeDescriptor( TypeNode typeNode ) {
            this.typeNode = typeNode;
        }

        @Override
        public String getFullyQualifiedName() {
            return typeNode.getFullyQualifiedName();
        }

        @Override
        public boolean isPrimitive() {
            return false;
        }

        @Override
        public ParamTypeNode getMethodReturnType( String name, ClassDescriptor... parameterTypes ) {
            for (MethodNode method : typeNode.methods) {
                if (method.name.equals( name )) {
                    return method.result;
                }
            }
            return null;
        }
    }

    class IntrospectiveDescriptor implements ClassDescriptor {
        private final Class<?> cls;

        public IntrospectiveDescriptor( Class<?> cls ) {
            this.cls = cls;
        }

        @Override
        public String getFullyQualifiedName() {
            return cls.getName();
        }

        @Override
        public boolean isPrimitive() {
            return cls.isPrimitive();
        }

        public ParamTypeNode getMethodReturnType(String name, ClassDescriptor... parameterTypes) {
            Class[] params = parameterTypes != null && parameterTypes.length > 0 ?
                             Stream.of( parameterTypes ).map( param -> ( (IntrospectiveDescriptor) param ).cls ).toArray( Class[]::new ) :
                             new Class[0];
            try {
                Method m = cls.getMethod( name, params );
                Class returnType = m.getReturnType();
                return new ParamTypeNode( returnType.getName(), returnType.isPrimitive() );
            } catch (NoSuchMethodException e) {
                throw new RuntimeException( e );
            }
        }
    }
}

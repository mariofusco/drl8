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

package org.drools.drl8.ast;

import org.drools.drl8.util.CodeGenerationContext;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ClassNode extends TypeNode {

    public String extend;
    public List<String> interfaces;
    public List<FieldNode> fields;
    public List<MethodNode> methods;

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        for ( String modifier : modifiers ) {
            sb.append( modifier ).append( " " );
        }
        sb.append( "class " ).append( name ).append( " " );
        if (extend != null) {
            sb.append( "extends " ).append( extend ).append( " " );
        }
        if (interfaces != null) {
            sb.append( "implements " ).append( " " )
              .append( interfaces.stream().collect( joining(", ")) ).append( " " );
        }
        sb.append( "{\n" );
        appendList( ctx, sb, fields, "\n" );
        sb.append( "\n" );
        appendList( ctx, sb, methods, "\n" );
        sb.append( "\n" );
        appendList( ctx, sb, innerTypes, "\n" );
        sb.append( "}" );
    }
}

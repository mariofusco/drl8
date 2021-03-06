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

import org.drools.drl8.ast.statements.VariableDeclarationNode;
import org.drools.drl8.util.CodeGenerationContext;

public class FieldNode extends MemberNode implements TypedNode {
    public ParamTypeNode type;
    public VariableDeclarationNode declaration;

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        for ( String modifier : modifiers ) {
            sb.append( modifier ).append( " " );
        }
        type.generateCode( ctx, sb );
        sb.append( " " );
        declaration.generateCode( ctx, sb );
        sb.append( ";" );
    }

    @Override
    public void setType( ParamTypeNode type ) {
        this.type = type;
    }

    @Override
    public ParamTypeNode getType() {
        return type;
    }
}
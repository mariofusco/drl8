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

package org.drools.drl8.ast.expressions;

import org.drools.drl8.ast.ParamTypeNode;
import org.drools.drl8.ast.SourceNode;
import org.drools.drl8.ast.TypeNode;
import org.drools.drl8.util.ClassDescriptor;
import org.drools.drl8.util.CodeGenerationContext;

import java.util.List;

public class MethodInvocationExpressionNode extends ExpressionNode {
    public ParamTypeNode invokedType;
    public String invokedObject;
    public String methodName;
    public List<ExpressionNode> arguments;

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        if (invokedObject != null) {
            sb.append( invokedObject ).append( "." );
        }
        sb.append( methodName );
        sb.append( "(" );
        appendList( ctx, sb, arguments, ", " );
        sb.append( ")" );
    }

    @Override
    public ParamTypeNode getType(CodeGenerationContext ctx) {
        ClassDescriptor classDescriptor = ctx.resolve( getInvokedType().rawType, getParentOfType( SourceNode.class ).imports );
        return classDescriptor.getMethodReturnType( methodName );
    }

    public ParamTypeNode getInvokedType() {
        if (invokedType == null) {
            TypeNode typeNode = getParentOfType( TypeNode.class );
            invokedType = new ParamTypeNode( typeNode.getFullyQualifiedName() );
        }
        return invokedType;
    }
}

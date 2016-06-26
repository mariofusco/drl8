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

import org.drools.drl8.ast.ExpressionContainerNode;
import org.drools.drl8.ast.ParamTypeNode;
import org.drools.drl8.util.CodeGenerationContext;

public class EqualityExpressionNode extends ExpressionNode implements ExpressionContainerNode {
    public ExpressionNode left;
    public ExpressionNode right;
    public boolean negated;

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        left.generateCode( ctx, sb );
        if (ctx.isEqualityMode() && !left.getType(ctx).isPrimitive) {
            sb.append( ".equals(" );
            right.generateCode( ctx, sb );
            sb.append( ")" );
        } else {
            sb.append( negated ? " != " : " == " );
            right.generateCode( ctx, sb );
        }
    }

    @Override
    public ParamTypeNode getType(CodeGenerationContext ctx) {
        return left.getType(ctx);
    }

    @Override
    public void setExpression( ExpressionNode expression ) {
        if (left == null) {
            left = expression;
        } else {
            right = expression;
        }
    }
}

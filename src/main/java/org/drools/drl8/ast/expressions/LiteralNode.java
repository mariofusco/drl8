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

import org.drools.drl8.util.CodeGenerationContext;

public abstract class LiteralNode<T> extends ExpressionNode {
    private final T literal;

    public LiteralNode( T literal ) {
        this.literal = literal;
    }

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        sb.append( literal );
    }
}
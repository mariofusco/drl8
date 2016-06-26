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
import org.drools.drl8.util.CodeGenerationContext;

public class BooleanLiteralNode extends LiteralNode<Boolean> {

    private static final ParamTypeNode TYPE = new ParamTypeNode( "boolean", true );

    public BooleanLiteralNode( Boolean literal ) {
        super( literal );
    }

    public BooleanLiteralNode( String literal ) {
        this( Boolean.parseBoolean( literal ) );
    }

    @Override
    public ParamTypeNode getType(CodeGenerationContext ctx) {
        return TYPE;
    }
}
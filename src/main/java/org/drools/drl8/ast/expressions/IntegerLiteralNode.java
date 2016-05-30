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

public class IntegerLiteralNode extends LiteralNode<Long> {

    private static final ParamTypeNode TYPE = new ParamTypeNode( "long", true );

    public IntegerLiteralNode( Long literal ) {
        super( literal );
    }

    public IntegerLiteralNode( String literal ) {
        this( Long.parseLong( literal ) );
    }

    @Override
    public ParamTypeNode getType() {
        return TYPE;
    }
}
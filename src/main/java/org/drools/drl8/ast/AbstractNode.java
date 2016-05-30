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

public abstract class AbstractNode implements Node {
    public Node parent;

    protected void appendList( CodeGenerationContext ctx, StringBuilder sb, List<? extends Node> list, String separator ) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0 || separator.equals( "\n" )) {
                    sb.append( separator );
                }
                list.get(i).generateCode( ctx, sb );
            }
        }
    }

    public void setParent( Node parent ) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateCode( null, sb );
        return sb.toString();
    }
}

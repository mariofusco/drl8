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

import java.util.List;

public class MethodNode extends MemberNode {
    public ParamTypeNode result;
    public List<ParamNode> params;
    public MethodBodyNode body;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for ( String modifier : modifiers ) {
            sb.append( modifier ).append( " " );
        }
        sb.append( name ).append( " " );
        sb.append( result ).append( " " );
        sb.append( "(" );
        appendList( sb, params, "," );
        sb.append( ") {\n" );
        sb.append( body );
        sb.append( "}\n" );
        return sb.toString();
    }

}

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

public class SourceNode extends AbstractNode {
    public String pkg;
    public List<String> imports;
    public TypeNode type;

    @Override
    public void generateCode( CodeGenerationContext ctx, StringBuilder sb ) {
        if (pkg != null) {
            sb.append( "package " ).append( pkg ).append( ";\n\n" );
        }
        if (imports != null) {
            for ( String imp : imports ) {
                sb.append( "import " ).append( imp ).append( ";\n" );
            }
            sb.append( "\n" );
        }
        type.generateCode( ctx, sb );
    }

    @Override
    public void setParent( Node parent ) {
        throw new UnsupportedOperationException();
    }
}

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

public class ParamTypeNode extends AbstractNode {
    public int arrayDim = 0;
    public String rawType;
    public boolean isPrimitive;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( rawType );
        for (int i = 0; i < arrayDim; i++) {
            sb.append( "[]" );
        }
        return sb.toString();
    }
}

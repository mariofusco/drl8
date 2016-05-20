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

package org.drools.drl8.util;

import org.drools.drl8.ast.ParamTypeNode;

import java.util.HashMap;
import java.util.Map;

public class VariablesScope {
    private final VariablesScope parent;
    private final Map<String, ParamTypeNode> variables = new HashMap<>();

    public VariablesScope( ) {
        this(null);
    }

    public VariablesScope( VariablesScope parent ) {
        this.parent = parent;
    }

    public ParamTypeNode lookup(String name) {
        ParamTypeNode type = variables.get(name);
        if (type != null) {
            return type;
        }
        return parent != null ? parent.lookup( name ) : null;
    }

    public void define(String name, ParamTypeNode type) {
        variables.put( name, type );
    }

    public VariablesScope enterScope() {
        return new VariablesScope( this );
    }

    public VariablesScope exitScope() {
        return parent;
    }
}

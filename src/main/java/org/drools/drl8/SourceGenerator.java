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

package org.drools.drl8;

import org.drools.drl8.antlr4.DRL8BaseListener;
import org.drools.drl8.antlr4.DRL8Parser;
import org.drools.drl8.ast.ClassNode;
import org.drools.drl8.ast.Node;
import org.drools.drl8.ast.SourceNode;
import org.drools.drl8.ast.TypeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SourceGenerator extends DRL8BaseListener {
    private Stack<Node> stack = new Stack<>();
    private SourceNode source = new SourceNode();

    public SourceGenerator() {
        stack.push( source );
    }

    public SourceNode getSource() {
        return source;
    }

    @Override
    public void enterNormalClassDeclaration( DRL8Parser.NormalClassDeclarationContext ctx ) {
        ClassNode classNode = new ClassNode();
        Node parent = stack.peek();
        if (parent instanceof SourceNode) {
            ( (SourceNode) parent ).type = classNode;
        } else {
            TypeNode parentType = (TypeNode) parent;
            if (parentType.innerTypes == null) {
                parentType.innerTypes = new ArrayList<>();
            }
            parentType.innerTypes.add( classNode );
        }
        classNode.parent = parent;
        stack.push( classNode );
    }

    @Override
    public void exitNormalClassDeclaration( DRL8Parser.NormalClassDeclarationContext ctx ) {
        ClassNode classNode = (ClassNode) stack.pop();
        classNode.modifiers = ctx.classModifier().stream()
                                 .flatMap( mod -> IntStream.range( 0, mod.getChildCount() ).mapToObj( i -> mod.getChild( i ) ) )
                                 .map( Object::toString )
                                 .collect( toList() );
        classNode.name = ctx.Identifier().toString();
    }
}

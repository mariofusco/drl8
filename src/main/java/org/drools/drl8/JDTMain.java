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

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import java.io.File;
import java.lang.reflect.Field;

import static org.drools.drl8.util.IOUtils.readFileAsString;

public class JDTMain {

    private static final String TEST_FILE = "src/test/resources/examples/Test.java";

    public static void main( String[] args ) {
        SourceVisitor sourceVisitor = new SourceVisitor();
        parse(readFileAsString(new File(TEST_FILE)), sourceVisitor);
        System.out.println(sourceVisitor.getCompilationUnit());
    }

    public static void parse(String str, ASTVisitor visitor) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        ASTNode astRoot = parser.createAST( null );

        astRoot.accept(visitor);
    }

    public static class SourceVisitor extends ASTVisitor {
        CompilationUnit compilationUnit;

        @Override
        public boolean visit(CompilationUnit node) {
            compilationUnit = node;
            return super.visit(node);
        }

        @Override
        public boolean visit( InfixExpression node ) {
            if ( node.getOperator() == InfixExpression.Operator.EQUALS) {
                MethodInvocation equalsInvocation = (MethodInvocation) node.getAST().createInstance( MethodInvocation.class );

                Expression left = node.getLeftOperand();
                equalsInvocation.setExpression( resetParent(node.getLeftOperand()) );

                equalsInvocation.arguments().add( 0, resetParent(node.getRightOperand()) );

                SimpleName equalsName = (SimpleName) node.getAST().createInstance( SimpleName.class );
                equalsName.setIdentifier( "equals" );
                equalsInvocation.setName( equalsName );

                ( (VariableDeclarationFragment) node.getParent() ).setInitializer( equalsInvocation );
            }
            return super.visit( node );
        }

        @Override
        public boolean visit( Assignment node ) {
            System.out.println(node);
            return super.visit( node );
        }

        public CompilationUnit getCompilationUnit() {
            return compilationUnit;
        }
    }

    private static <T extends ASTNode> T resetParent(T node) {
        try {
            Field f = ASTNode.class.getDeclaredField( "parent" );
            f.setAccessible( true );
            f.set( node, null );
            return node;
        } catch (Exception e) {
            throw new RuntimeException( e );
        }

    }
}

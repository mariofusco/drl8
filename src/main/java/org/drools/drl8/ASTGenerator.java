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

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.drools.drl8.antlr4.DRL8BaseListener;
import org.drools.drl8.antlr4.DRL8Parser;
import org.drools.drl8.ast.ClassNode;
import org.drools.drl8.ast.MethodBodyNode;
import org.drools.drl8.ast.MethodNode;
import org.drools.drl8.ast.Node;
import org.drools.drl8.ast.ParamNode;
import org.drools.drl8.ast.ParamTypeNode;
import org.drools.drl8.ast.SourceNode;
import org.drools.drl8.ast.TypeNode;
import org.drools.drl8.ast.TypedNode;
import org.drools.drl8.ast.expressions.BooleanLiteralNode;
import org.drools.drl8.ast.expressions.EqualityExpressionNode;
import org.drools.drl8.ast.expressions.ExpressionNode;
import org.drools.drl8.ast.expressions.LiteralNode;
import org.drools.drl8.ast.expressions.MethodInvocationExpressionNode;
import org.drools.drl8.ast.expressions.StringLiteralNode;
import org.drools.drl8.ast.expressions.VariableNameNode;
import org.drools.drl8.ast.statements.ExpressionStatementNode;
import org.drools.drl8.ast.statements.StatementNode;
import org.drools.drl8.ast.statements.VariableDeclarationNode;
import org.drools.drl8.ast.statements.VariableDeclarationStatementNode;
import org.drools.drl8.util.VariablesScope;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.drools.drl8.util.ASTUtil.parseTreeToString;

public class ASTGenerator extends DRL8BaseListener {
    private final SourceNode source = new SourceNode();
    private final Stack<Node> stack = new Stack<>();
    private VariablesScope scope = new VariablesScope();

    public ASTGenerator() {
        stack.push( source );
    }

    public SourceNode getSource() {
        return source;
    }

    @Override
    public void exitPackageDeclaration( DRL8Parser.PackageDeclarationContext ctx ) {
        source.pkg = parseTreeToString(ctx, 1, ctx.getChildCount()-1);
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

    @Override
    public void enterBlock( DRL8Parser.BlockContext ctx ) {
        scope = scope.enterScope();
    }

    @Override
    public void exitBlock( DRL8Parser.BlockContext ctx ) {
        scope = scope.exitScope();
    }

    @Override
    public void enterMethodDeclaration( DRL8Parser.MethodDeclarationContext ctx ) {
        MethodNode methodNode = new MethodNode();
        ClassNode parent = (ClassNode) stack.peek();
        if (parent.methods == null) {
            parent.methods = new ArrayList<>();
        }
        parent.methods.add(methodNode);
        methodNode.parent = parent;
        stack.push( methodNode );
    }

    @Override
    public void exitMethodDeclaration( DRL8Parser.MethodDeclarationContext ctx ) {
        MethodNode methodNode = (MethodNode) stack.pop();
        methodNode.modifiers = ctx.methodModifier().stream()
                                 .flatMap( mod -> IntStream.range( 0, mod.getChildCount() ).mapToObj( i -> mod.getChild( i ) ) )
                                 .map( Object::toString )
                                 .collect( toList() );
    }

    @Override
    public void exitMethodDeclarator( DRL8Parser.MethodDeclaratorContext ctx ) {
        MethodNode methodNode = (MethodNode) stack.peek();
        methodNode.name = ctx.Identifier().toString();
    }

    @Override
    public void enterResult( DRL8Parser.ResultContext ctx ) {
        MethodNode methodNode = (MethodNode) stack.peek();
        ParamTypeNode paramTypeNode = new ParamTypeNode();
        methodNode.result = paramTypeNode;
        paramTypeNode.parent = methodNode;
        stack.push( paramTypeNode );
    }

    @Override
    public void exitResult( DRL8Parser.ResultContext ctx ) {
        ParamTypeNode paramTypeNode = (ParamTypeNode) stack.pop();
        if (paramTypeNode.rawType == null) {
            paramTypeNode.rawType = "void";
        }
    }

    @Override
    public void enterFormalParameter( DRL8Parser.FormalParameterContext ctx ) {
        MethodNode methodNode = (MethodNode) stack.peek();
        ParamNode paramNode = new ParamNode();
        paramNode.parent = methodNode;
        if (methodNode.params == null) {
            methodNode.params = new ArrayList<>();
        }
        methodNode.params.add(paramNode);

        stack.push( paramNode );
    }

    @Override
    public void enterUnannType( DRL8Parser.UnannTypeContext ctx ) {
        TypedNode parent = (TypedNode) stack.peek();
        ParamTypeNode paramTypeNode = new ParamTypeNode();
        parent.setType( paramTypeNode );
        paramTypeNode.parent = parent;
        stack.push( paramTypeNode );
    }

    @Override
    public void exitUnannType( DRL8Parser.UnannTypeContext ctx ) {
        stack.pop();
    }

    @Override
    public void exitFormalParameter( DRL8Parser.FormalParameterContext ctx ) {
        ParamNode paramNode = (ParamNode) stack.pop();
        paramNode.name = ctx.variableDeclaratorId().Identifier().toString();
    }

    @Override
    public void exitUnannPrimitiveType( DRL8Parser.UnannPrimitiveTypeContext ctx ) {
        Node node = stack.peek();
        if (node instanceof ParamTypeNode) {
            ParamTypeNode typeNode = (ParamTypeNode) node;
            typeNode.isPrimitive = true;
            if (ctx.numericType() == null) {
                typeNode.rawType = "boolean";
            } else {
                if (ctx.numericType().floatingPointType() != null) {
                    typeNode.rawType = ctx.numericType().floatingPointType().children.get( 0 ).toString();
                } else {
                    typeNode.rawType = ctx.numericType().integralType().children.get( 0 ).toString();
                }
            }
        }
    }

    @Override
    public void exitUnannArrayType( DRL8Parser.UnannArrayTypeContext ctx ) {
        ParamTypeNode paramTypeNode = (ParamTypeNode) stack.peek();
        paramTypeNode.arrayDim++;
    }

    @Override
    public void exitUnannClassOrInterfaceType( DRL8Parser.UnannClassOrInterfaceTypeContext ctx ) {
        Node node = stack.peek();
        if (node instanceof ParamTypeNode) {
            ( (ParamTypeNode) node ).rawType = ctx.unannClassType_lfno_unannClassOrInterfaceType().Identifier().toString();
        }
    }

    @Override
    public void enterMethodBody( DRL8Parser.MethodBodyContext ctx ) {
        MethodNode methodNode = (MethodNode) stack.peek();
        MethodBodyNode methodBodyNode = new MethodBodyNode();
        methodBodyNode.parent = methodNode;
        methodNode.body = methodBodyNode;
        stack.push( methodBodyNode );
    }

    @Override
    public void exitMethodBody( DRL8Parser.MethodBodyContext ctx ) {
        stack.pop();
    }

    @Override
    public void exitBlockStatement( DRL8Parser.BlockStatementContext ctx ) {
        StatementNode statementNode = (StatementNode) stack.pop();
        MethodBodyNode methodBodyNode = (MethodBodyNode) stack.peek();
        if (methodBodyNode.statements == null) {
            methodBodyNode.statements = new ArrayList<>();
        }
        methodBodyNode.statements.add(statementNode);
    }

    @Override
    public void enterExpressionStatement( DRL8Parser.ExpressionStatementContext ctx ) {
        ExpressionStatementNode expression = new ExpressionStatementNode();
        expression.parent = stack.peek();
        stack.push( expression );
    }

    @Override
    public void enterLocalVariableDeclaration( DRL8Parser.LocalVariableDeclarationContext ctx ) {
        VariableDeclarationStatementNode statementNode = new VariableDeclarationStatementNode();
        statementNode.parent = stack.peek();
        stack.push( statementNode );
    }

    @Override
    public void enterMethodInvocation( DRL8Parser.MethodInvocationContext ctx ) {
        ExpressionStatementNode expression = (ExpressionStatementNode) stack.peek();
        MethodInvocationExpressionNode invocation = new MethodInvocationExpressionNode();
        invocation.parent = expression;
        expression.expression = invocation;
        stack.push( invocation );
    }

    @Override
    public void exitMethodInvocation( DRL8Parser.MethodInvocationContext ctx ) {
        MethodInvocationExpressionNode invocation = (MethodInvocationExpressionNode) stack.pop();

        StringBuilder sb = new StringBuilder();
        for (ParseTree child : ctx.children) {
            if (child.toString().equals( "(" )) {
                break;
            }
            if (child instanceof TerminalNode) {
                sb.append( child );
            } else {
                sb.append( parseTreeToString( child ) );
            }
        }
        String invoked = sb.toString();
        int dotPos = invoked.lastIndexOf( '.' );
        if (dotPos > 0) {
            invocation.invokedObject = invoked.substring( 0, dotPos );
            invocation.methodName = invoked.substring( dotPos+1 );
        } else {
            invocation.methodName = invoked;
        }
    }

    @Override
    public void enterVariableDeclarator( DRL8Parser.VariableDeclaratorContext ctx ) {
        VariableDeclarationStatementNode statementNode = (VariableDeclarationStatementNode) stack.peek();
        VariableDeclarationNode declarationNode = new VariableDeclarationNode();
        declarationNode.parent = statementNode;
        if (statementNode.declarations == null) {
            statementNode.declarations = new ArrayList<>();
        }
        statementNode.declarations.add(declarationNode);
        stack.push(declarationNode);
    }

    @Override
    public void exitVariableDeclarator( DRL8Parser.VariableDeclaratorContext ctx ) {
        VariableDeclarationNode declarationNode = (VariableDeclarationNode) stack.pop();
        declarationNode.id = ctx.variableDeclaratorId().Identifier().toString();
        scope.define( declarationNode.id, ( (VariableDeclarationStatementNode) declarationNode.parent ).type );
    }

    @Override
    public void enterEqualityExpression( DRL8Parser.EqualityExpressionContext ctx ) {
        stack.push( new EqualityExpressionNode() );
    }

    @Override
    public void exitEqualityExpression( DRL8Parser.EqualityExpressionContext ctx ) {
        EqualityExpressionNode expressionNode = (EqualityExpressionNode) stack.pop();
        if (ctx.children.size() == 3) {
            expressionNode.negated = ctx.children.get(1).toString() == "!=";
            VariableDeclarationNode declarationNode = (VariableDeclarationNode) stack.peek();
            if (expressionNode.right == null) {
                expressionNode.right = expressionNode.left;
                expressionNode.left = declarationNode.expression;
            }
            declarationNode.expression = expressionNode;
            expressionNode.parent = declarationNode;
        } else {
            Node node = stack.peek();
            if (node instanceof VariableDeclarationNode) {
                VariableDeclarationNode declarationNode = (VariableDeclarationNode) node;
                declarationNode.expression = expressionNode.left;
                expressionNode.left.parent = declarationNode;
            } else if (node instanceof MethodInvocationExpressionNode) {
                MethodInvocationExpressionNode invocationNode = (MethodInvocationExpressionNode) node;
                if (invocationNode.arguments == null) {
                    invocationNode.arguments = new ArrayList<>();
                }
                invocationNode.arguments.add(expressionNode.left);
                expressionNode.left.parent = invocationNode;
            } else {
                throw new RuntimeException( "unknown type " + node.getClass() );
            }
        }
    }

    @Override
    public void exitExpressionName( DRL8Parser.ExpressionNameContext ctx ) {
        String id = ctx.Identifier().toString();
        VariableNameNode variable = new VariableNameNode();
        variable.id = id;
        variable.type = scope.lookup( id );
        setAtomicExpressionOnParentNode( stack.peek(), variable );
    }

    @Override
    public void exitLiteral( DRL8Parser.LiteralContext ctx ) {
        LiteralNode literal = null;
        if (ctx.StringLiteral() != null) {
            literal = new StringLiteralNode( ctx.StringLiteral().toString() );
        } else if (ctx.BooleanLiteral() != null) {
            literal = new BooleanLiteralNode( ctx.BooleanLiteral().toString() );
        }
        setAtomicExpressionOnParentNode( stack.peek(), literal );
    }

    private void setAtomicExpressionOnParentNode( Node node, ExpressionNode atomic ) {
        atomic.parent = node;
        if (node instanceof VariableDeclarationNode ) {
            ( (VariableDeclarationNode) node ).expression = atomic;
        } else if (node instanceof EqualityExpressionNode ) {
            EqualityExpressionNode expression = ( (EqualityExpressionNode) node );
            if (expression.left == null) {
                expression.left = atomic;
            } else {
                expression.right = atomic;
            }
        }
    }
}

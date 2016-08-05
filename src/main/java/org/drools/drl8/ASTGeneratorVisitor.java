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

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.drools.drl8.antlr4.DRL8BaseVisitor;
import org.drools.drl8.antlr4.DRL8Parser.BlockContext;
import org.drools.drl8.antlr4.DRL8Parser.ClassBodyContext;
import org.drools.drl8.antlr4.DRL8Parser.ClassBodyDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.ClassMemberDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.CompilationUnitContext;
import org.drools.drl8.antlr4.DRL8Parser.EqualityExpressionContext;
import org.drools.drl8.antlr4.DRL8Parser.ExpressionNameContext;
import org.drools.drl8.antlr4.DRL8Parser.ExpressionStatementContext;
import org.drools.drl8.antlr4.DRL8Parser.FieldDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.FormalParameterContext;
import org.drools.drl8.antlr4.DRL8Parser.FormalParameterListContext;
import org.drools.drl8.antlr4.DRL8Parser.LiteralContext;
import org.drools.drl8.antlr4.DRL8Parser.LocalVariableDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.LocalVariableDeclarationStatementContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodBodyContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodDeclaratorContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodHeaderContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodInvocationContext;
import org.drools.drl8.antlr4.DRL8Parser.MethodInvocation_lfno_primaryContext;
import org.drools.drl8.antlr4.DRL8Parser.NormalClassDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.PackageDeclarationContext;
import org.drools.drl8.antlr4.DRL8Parser.ResultContext;
import org.drools.drl8.antlr4.DRL8Parser.ReturnStatementContext;
import org.drools.drl8.antlr4.DRL8Parser.UnannArrayTypeContext;
import org.drools.drl8.antlr4.DRL8Parser.UnannClassOrInterfaceTypeContext;
import org.drools.drl8.antlr4.DRL8Parser.UnannPrimitiveTypeContext;
import org.drools.drl8.antlr4.DRL8Parser.UnannReferenceTypeContext;
import org.drools.drl8.antlr4.DRL8Parser.UnannTypeContext;
import org.drools.drl8.antlr4.DRL8Parser.VariableDeclaratorContext;
import org.drools.drl8.antlr4.DRL8Parser.VariableDeclaratorListContext;
import org.drools.drl8.ast.AbstractNode;
import org.drools.drl8.ast.ClassNode;
import org.drools.drl8.ast.FieldNode;
import org.drools.drl8.ast.MethodBodyNode;
import org.drools.drl8.ast.MethodNode;
import org.drools.drl8.ast.Node;
import org.drools.drl8.ast.ParamNode;
import org.drools.drl8.ast.ParamTypeNode;
import org.drools.drl8.ast.SourceNode;
import org.drools.drl8.ast.TypeNode;
import org.drools.drl8.ast.expressions.BooleanLiteralNode;
import org.drools.drl8.ast.expressions.EqualityExpressionNode;
import org.drools.drl8.ast.expressions.ExpressionNode;
import org.drools.drl8.ast.expressions.IntegerLiteralNode;
import org.drools.drl8.ast.expressions.MethodInvocationExpressionNode;
import org.drools.drl8.ast.expressions.StringLiteralNode;
import org.drools.drl8.ast.expressions.VariableNameNode;
import org.drools.drl8.ast.statements.ExpressionStatementNode;
import org.drools.drl8.ast.statements.ReturnStatementNode;
import org.drools.drl8.ast.statements.StatementNode;
import org.drools.drl8.ast.statements.VariableDeclarationNode;
import org.drools.drl8.ast.statements.VariableDeclarationStatementNode;
import org.drools.drl8.util.VariablesScope;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.drools.drl8.util.ASTUtil.addToList;
import static org.drools.drl8.util.ASTUtil.parseTreeToString;

public class ASTGeneratorVisitor extends DRL8BaseVisitor {

    private static final boolean DEBUG = false;

    private SourceNode source;
    private VariablesScope scope = new VariablesScope();

    @Override
    public Object visitCompilationUnit( CompilationUnitContext ctx ) {
        source = new SourceNode();
        for (ParseTree child : ctx.children) {
            source.pkg = (String) visit( ctx.packageDeclaration() );
            source.type = (TypeNode) visit( ctx.typeDeclaration( 0 ) );
            source.type.parent = source;
        }
        super.visitCompilationUnit( ctx );
        return source;
    }

    @Override
    public Object visitPackageDeclaration( PackageDeclarationContext ctx ) {
        return parseTreeToString(ctx, 1, ctx.getChildCount()-1);
    }

    @Override
    public Object visitNormalClassDeclaration( NormalClassDeclarationContext ctx ) {
        ClassNode classNode = new ClassNode();
        classNode.modifiers = parseModifiers( ctx.classModifier() );
        classNode.name = ctx.Identifier().toString();

        ClassBodyContext classBody = ctx.classBody();
        for (ClassBodyDeclarationContext classBodyDeclar : classBody.classBodyDeclaration()) {
            ClassMemberDeclarationContext classMemberDeclar = classBodyDeclar.classMemberDeclaration();
            boolean childParsed =
                    visitChild( classMemberDeclar, ClassMemberDeclarationContext::methodDeclaration,
                                classNode, (node, obj) -> node.methods = addToList(node.methods, obj) ) ||
                    visitChild( classMemberDeclar, ClassMemberDeclarationContext::fieldDeclaration,
                                classNode, (node, obj) -> node.fields = addToList(node.fields, obj) );
        }
        return classNode;
    }

    @Override
    public Object visitFieldDeclaration( FieldDeclarationContext ctx ) {
        FieldNode fieldNode = new FieldNode();
        fieldNode.modifiers = parseModifiers( ctx.fieldModifier() );
        fieldNode.type = (ParamTypeNode)visit( ctx.unannType() );
        fieldNode.declaration = ((List<VariableDeclarationNode>) visit( ctx.variableDeclaratorList() )).get(0);
        fieldNode.declaration.parent = fieldNode;
        scope.define( fieldNode.declaration.id, fieldNode.type );
        return fieldNode;
    }

    @Override
    public List<VariableDeclarationNode> visitVariableDeclaratorList( VariableDeclaratorListContext ctx ) {
        return visitList( ctx.variableDeclarator(), VariableDeclarationNode.class );
    }

    @Override
    public Object visitMethodDeclaration( MethodDeclarationContext ctx ) {
        MethodNode methodNode = new MethodNode();
        methodNode.modifiers = parseModifiers( ctx.methodModifier() );

        MethodHeaderContext header = ctx.methodHeader();
        methodNode.result = (ParamTypeNode) visit( header.result() );

        MethodDeclaratorContext declarator = header.methodDeclarator();
        methodNode.name = declarator.Identifier().toString();

        FormalParameterListContext params = declarator.formalParameterList();
        if (params != null) {
            methodNode.params = params.formalParameters() != null ?
                                visitList( params.formalParameters().formalParameter(), ParamNode.class ) :
                                new ArrayList<>();
            methodNode.params.add( (ParamNode) visit( params.lastFormalParameter() ) );
        }

        methodNode.body = (MethodBodyNode) visit( ctx.methodBody() );
        methodNode.body.parent = methodNode;

        return methodNode;
    }

    @Override
    public Object visitResult( ResultContext ctx ) {
        UnannTypeContext type = ctx.unannType();
        if (type != null) {
            return (ParamTypeNode) visit( type );
        }
        ParamTypeNode voidType = new ParamTypeNode();
        voidType.rawType = "void";
        return voidType;
    }

    @Override
    public Object visitFormalParameter( FormalParameterContext ctx ) {
        ParamNode paramNode = new ParamNode();
        paramNode.type = (ParamTypeNode) visit( ctx.unannType() );
        paramNode.name = ctx.variableDeclaratorId().Identifier().toString();
        scope.define( paramNode.name, paramNode.type );
        return paramNode;
    }

    @Override
    public Object visitUnannType( UnannTypeContext ctx ) {
        ParamTypeNode paramTypeNode = new ParamTypeNode();
        UnannPrimitiveTypeContext primitiveType = ctx.unannPrimitiveType();
        if (primitiveType != null) {
            paramTypeNode.isPrimitive = true;
            paramTypeNode.rawType = ctx2String(primitiveType);
        } else {
            UnannReferenceTypeContext refType = ctx.unannReferenceType();
            UnannArrayTypeContext array = refType.unannArrayType();
            if (array != null) {
                for (ParseTree child : array.dims().children) {
                    if ("[".equals( child.toString() )) {
                        paramTypeNode.arrayDim++;
                    }
                }
                UnannPrimitiveTypeContext arrayprimitiveType = array.unannPrimitiveType();
                if (arrayprimitiveType != null) {
                    paramTypeNode.rawType = ctx2String(arrayprimitiveType);
                } else {
                    paramTypeNode.rawType = (String) visit(array.unannClassOrInterfaceType());
                }
            } else {
                paramTypeNode.rawType = (String) visit(refType.unannClassOrInterfaceType());
            }
        }
        return paramTypeNode;
    }

    @Override
    public String visitUnannClassOrInterfaceType( UnannClassOrInterfaceTypeContext ctx ) {
        return ctx.unannClassType_lfno_unannClassOrInterfaceType().Identifier().toString();
    }

    @Override
    public Object visitMethodBody( MethodBodyContext ctx ) {
        MethodBodyNode methodBodyNode = new MethodBodyNode();
        methodBodyNode.statements = (List<StatementNode>) visit( ctx.block() );
        methodBodyNode.statements.forEach( s -> s.parent = methodBodyNode );
        return methodBodyNode;
    }

    @Override
    public Object visitBlock( BlockContext ctx ) {
        scope = scope.enterScope();
        List<StatementNode> statements = visitList( ctx.blockStatements().blockStatement(), StatementNode.class );
        scope = scope.exitScope();
        return statements;
    }

    @Override
    public Object visitReturnStatement( ReturnStatementContext ctx ) {
        ReturnStatementNode returnNode = new ReturnStatementNode();
        if (ctx.expression() != null) {
            returnNode.result = (ExpressionNode) visit( ctx.expression() );
            returnNode.result.parent = returnNode;
        }
        return returnNode;
    }

    @Override
    public Object visitExpressionStatement( ExpressionStatementContext ctx ) {
        ExpressionStatementNode exprStatement = new ExpressionStatementNode();
        exprStatement.expression = (ExpressionNode) visit( ctx.statementExpression() );
        return exprStatement;
    }

    @Override
    public Object visitLocalVariableDeclarationStatement( LocalVariableDeclarationStatementContext ctx ) {
        return visit( ctx.localVariableDeclaration() );
    }

    @Override
    public Object visitLocalVariableDeclaration( LocalVariableDeclarationContext ctx ) {
        VariableDeclarationStatementNode statementNode = new VariableDeclarationStatementNode();
        statementNode.type = (ParamTypeNode) visit( ctx.unannType() );
        statementNode.declarations = ((List<VariableDeclarationNode>) visit( ctx.variableDeclaratorList() ));
        statementNode.declarations.forEach( varDecl -> {
            varDecl.parent = statementNode;
            scope.define( varDecl.id, statementNode.type );
        } );
        return statementNode;
    }

    @Override
    public Object visitMethodInvocation( MethodInvocationContext ctx ) {
        MethodInvocationExpressionNode invocation = new MethodInvocationExpressionNode();
        parseMethodInvocation( ctx, invocation );
        invocation.arguments = visitList( ctx.argumentList().expression(), ExpressionNode.class );
        invocation.arguments.forEach( arg -> arg.parent = invocation );
        return invocation;
    }

    @Override
    public Object visitMethodInvocation_lfno_primary( MethodInvocation_lfno_primaryContext ctx ) {
        MethodInvocationExpressionNode invocation = new MethodInvocationExpressionNode();
        parseMethodInvocation( ctx, invocation );
        if (ctx.argumentList() != null) {
            invocation.arguments = visitList( ctx.argumentList().expression(), ExpressionNode.class );
            invocation.arguments.forEach( arg -> arg.parent = invocation );
        }
        return invocation;
    }

    private void parseMethodInvocation( ParserRuleContext ctx, MethodInvocationExpressionNode invocation ) {
        StringBuilder sb = new StringBuilder();
        for (ParseTree child : ctx.children) {
            if (child.toString().equals( "(" )) {
                break;
            }
            if (child instanceof TerminalNode ) {
                sb.append( child );
            } else {
                sb.append( parseTreeToString( child ) );
            }
        }
        String invoked = sb.toString();
        int dotPos = invoked.lastIndexOf( '.' );
        if (dotPos > 0) {
            invocation.invokedObject = invoked.substring( 0, dotPos );
            invocation.invokedType = scope.lookup( invocation.invokedObject );
            invocation.methodName = invoked.substring( dotPos+1 );
        } else {
            invocation.methodName = invoked;
        }
    }

    @Override
    public Object visitVariableDeclarator( VariableDeclaratorContext ctx ) {
        VariableDeclarationNode declarationNode = new VariableDeclarationNode();
        declarationNode.id = ctx.variableDeclaratorId().Identifier().toString();
        declarationNode.expression = (ExpressionNode) visit( ctx.variableInitializer() );
        declarationNode.expression.parent = declarationNode;
        return declarationNode;
    }

    @Override
    public Object visitEqualityExpression( EqualityExpressionContext ctx ) {
        if (ctx.children.size() == 3) {
            EqualityExpressionNode equality = new EqualityExpressionNode();
            equality.negated = ctx.children.get(1).toString() == "!=";
            equality.left = (ExpressionNode) visit( ctx.children.get(0) );
            equality.left.parent = equality;
            equality.right = (ExpressionNode) visit( ctx.children.get(2) );
            equality.right.parent = equality;
            return equality;
        }
        return visit(ctx.children.get(0));
    }

    @Override
    public Object visitExpressionName( ExpressionNameContext ctx ) {
        VariableNameNode variable = new VariableNameNode();
        String id = ctx.Identifier().toString();
        variable.id = id;
        variable.type = scope.lookup( id );
        return variable;
    }

    @Override
    public Object visitLiteral( LiteralContext ctx ) {
        if (ctx.StringLiteral() != null) {
            return new StringLiteralNode( ctx.StringLiteral().toString() );
        } else if (ctx.BooleanLiteral() != null) {
            return new BooleanLiteralNode( ctx.BooleanLiteral().toString() );
        } else if (ctx.IntegerLiteral() != null) {
            return new IntegerLiteralNode( ctx.IntegerLiteral().toString() );
        }
        throw new RuntimeException( "Unknown literal " + ctx );
    }

    private <T extends ParserRuleContext, V> List<V> visitList(List<T> list, Class<V> clazz) {
        return list.stream().map( this::visit ).map( clazz::cast ).collect(toList());
    }

    private <T extends ParserRuleContext> List<String> parseModifiers( List<T> ctx ) {
        return ctx.stream()
                  .flatMap( mod -> IntStream.range( 0, mod.getChildCount() ).mapToObj( i -> mod.getChild( i ) ) )
                  .map( Object::toString )
                  .collect( toList() );
    }

    private <N extends Node, P extends ParserRuleContext, C extends ParserRuleContext> boolean visitChild( P parent, Function<P, C> f, N node, BiConsumer<N, Object> bi ) {
        C child = f.apply( parent );
        if (child != null) {
            AbstractNode childNode = (AbstractNode) visit( child );
            childNode.parent = node;
            bi.accept( node, childNode );
            return true;
        }
        return false;
    }

    private String ctx2String(ParserRuleContext ctx) {
        if (ctx.children.size() == 0) {
            return ctx.toString();
        }
        if (ctx.children.size() == 1) {
            ParseTree child = ctx.children.get(0);
            return child instanceof ParserRuleContext ? ctx2String((ParserRuleContext) child) : child.toString();
        }
        throw new RuntimeException( ctx + " has more than one child" );
    }
}

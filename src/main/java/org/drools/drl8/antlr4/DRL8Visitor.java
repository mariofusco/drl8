// Generated from DRL8.g4 by ANTLR 4.5.1

    package org.drools.drl8.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DRL8Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DRL8Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DRL8Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DRL8Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(DRL8Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(DRL8Parser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(DRL8Parser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(DRL8Parser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(DRL8Parser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(DRL8Parser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(DRL8Parser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lf_classOrInterfaceType(DRL8Parser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lfno_classOrInterfaceType(DRL8Parser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(DRL8Parser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lf_classOrInterfaceType(DRL8Parser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lfno_classOrInterfaceType(DRL8Parser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(DRL8Parser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(DRL8Parser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(DRL8Parser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(DRL8Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(DRL8Parser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(DRL8Parser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(DRL8Parser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(DRL8Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(DRL8Parser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(DRL8Parser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(DRL8Parser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(DRL8Parser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(DRL8Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(DRL8Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(DRL8Parser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName(DRL8Parser.ExpressionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(DRL8Parser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(DRL8Parser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(DRL8Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(DRL8Parser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(DRL8Parser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(DRL8Parser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(DRL8Parser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(DRL8Parser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(DRL8Parser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(DRL8Parser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(DRL8Parser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(DRL8Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(DRL8Parser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(DRL8Parser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(DRL8Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(DRL8Parser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(DRL8Parser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#superinterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperinterfaces(DRL8Parser.SuperinterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(DRL8Parser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(DRL8Parser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(DRL8Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(DRL8Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(DRL8Parser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier(DRL8Parser.FieldModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(DRL8Parser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(DRL8Parser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(DRL8Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(DRL8Parser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType(DRL8Parser.UnannTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType(DRL8Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType(DRL8Parser.UnannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(DRL8Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(DRL8Parser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lf_unannClassOrInterfaceType(DRL8Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lfno_unannClassOrInterfaceType(DRL8Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(DRL8Parser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lf_unannClassOrInterfaceType(DRL8Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lfno_unannClassOrInterfaceType(DRL8Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(DRL8Parser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(DRL8Parser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(DRL8Parser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(DRL8Parser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(DRL8Parser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(DRL8Parser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(DRL8Parser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(DRL8Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(DRL8Parser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(DRL8Parser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(DRL8Parser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(DRL8Parser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(DRL8Parser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#throws_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrows_(DRL8Parser.Throws_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(DRL8Parser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(DRL8Parser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(DRL8Parser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(DRL8Parser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(DRL8Parser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(DRL8Parser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(DRL8Parser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(DRL8Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(DRL8Parser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(DRL8Parser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(DRL8Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(DRL8Parser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(DRL8Parser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(DRL8Parser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(DRL8Parser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(DRL8Parser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(DRL8Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(DRL8Parser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(DRL8Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(DRL8Parser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#extendsInterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsInterfaces(DRL8Parser.ExtendsInterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(DRL8Parser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(DRL8Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(DRL8Parser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(DRL8Parser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(DRL8Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(DRL8Parser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(DRL8Parser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(DRL8Parser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeMemberDeclaration(DRL8Parser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(DRL8Parser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementModifier(DRL8Parser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(DRL8Parser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(DRL8Parser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(DRL8Parser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(DRL8Parser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(DRL8Parser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(DRL8Parser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(DRL8Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(DRL8Parser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(DRL8Parser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(DRL8Parser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(DRL8Parser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(DRL8Parser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DRL8Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(DRL8Parser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(DRL8Parser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(DRL8Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(DRL8Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DRL8Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(DRL8Parser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement(DRL8Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(DRL8Parser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(DRL8Parser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(DRL8Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(DRL8Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(DRL8Parser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(DRL8Parser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(DRL8Parser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(DRL8Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(DRL8Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(DRL8Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(DRL8Parser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(DRL8Parser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#switchLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabels(DRL8Parser.SwitchLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(DRL8Parser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(DRL8Parser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(DRL8Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(DRL8Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(DRL8Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(DRL8Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(DRL8Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(DRL8Parser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(DRL8Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(DRL8Parser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(DRL8Parser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(DRL8Parser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(DRL8Parser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(DRL8Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(DRL8Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(DRL8Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(DRL8Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(DRL8Parser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(DRL8Parser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(DRL8Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(DRL8Parser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(DRL8Parser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(DRL8Parser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(DRL8Parser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(DRL8Parser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(DRL8Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(DRL8Parser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(DRL8Parser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(DRL8Parser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(DRL8Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(DRL8Parser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_arrayAccess(DRL8Parser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess(DRL8Parser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary(DRL8Parser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(DRL8Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(DRL8Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary(DRL8Parser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(DRL8Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(DRL8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(DRL8Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lf_primary(DRL8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lfno_primary(DRL8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(DRL8Parser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(DRL8Parser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lf_primary(DRL8Parser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lfno_primary(DRL8Parser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(DRL8Parser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lf_primary(DRL8Parser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lfno_primary(DRL8Parser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(DRL8Parser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lf_primary(DRL8Parser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary(DRL8Parser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(DRL8Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(DRL8Parser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lf_primary(DRL8Parser.MethodReference_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lfno_primary(DRL8Parser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(DRL8Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(DRL8Parser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(DRL8Parser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(DRL8Parser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DRL8Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(DRL8Parser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(DRL8Parser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredFormalParameterList(DRL8Parser.InferredFormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(DRL8Parser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(DRL8Parser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(DRL8Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(DRL8Parser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(DRL8Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(DRL8Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression(DRL8Parser.ConditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression(DRL8Parser.ConditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(DRL8Parser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(DRL8Parser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(DRL8Parser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(DRL8Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(DRL8Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(DRL8Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(DRL8Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(DRL8Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(DRL8Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(DRL8Parser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(DRL8Parser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus(DRL8Parser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(DRL8Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(DRL8Parser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression_lf_postfixExpression(DRL8Parser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(DRL8Parser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression_lf_postfixExpression(DRL8Parser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DRL8Parser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(DRL8Parser.CastExpressionContext ctx);
}
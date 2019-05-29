// Code generated from Lang.g4 by ANTLR 4.7.1. DO NOT EDIT.

package parser // Lang

import "github.com/antlr/antlr4/runtime/Go/antlr"

// LangListener is a complete listener for a parse tree produced by LangParser.
type LangListener interface {
	antlr.ParseTreeListener

	// EnterProgram is called when entering the program production.
	EnterProgram(c *ProgramContext)

	// EnterAssignmentExpr is called when entering the assignmentExpr production.
	EnterAssignmentExpr(c *AssignmentExprContext)

	// EnterDotExpr is called when entering the dotExpr production.
	EnterDotExpr(c *DotExprContext)

	// EnterFuncExpr is called when entering the funcExpr production.
	EnterFuncExpr(c *FuncExprContext)

	// EnterArrayExpr is called when entering the arrayExpr production.
	EnterArrayExpr(c *ArrayExprContext)

	// EnterParenExpr is called when entering the parenExpr production.
	EnterParenExpr(c *ParenExprContext)

	// EnterPrefixExpr is called when entering the prefixExpr production.
	EnterPrefixExpr(c *PrefixExprContext)

	// EnterDeclExpr is called when entering the declExpr production.
	EnterDeclExpr(c *DeclExprContext)

	// EnterInfixExpr is called when entering the infixExpr production.
	EnterInfixExpr(c *InfixExprContext)

	// EnterTernaryExpr is called when entering the ternaryExpr production.
	EnterTernaryExpr(c *TernaryExprContext)

	// EnterLambdaExpr is called when entering the lambdaExpr production.
	EnterLambdaExpr(c *LambdaExprContext)

	// EnterLiteralExpr is called when entering the literalExpr production.
	EnterLiteralExpr(c *LiteralExprContext)

	// EnterPostfixExpr is called when entering the postfixExpr production.
	EnterPostfixExpr(c *PostfixExprContext)

	// EnterIdExpr is called when entering the idExpr production.
	EnterIdExpr(c *IdExprContext)

	// EnterFuncArgsExpr is called when entering the funcArgsExpr production.
	EnterFuncArgsExpr(c *FuncArgsExprContext)

	// EnterBlock is called when entering the block production.
	EnterBlock(c *BlockContext)

	// EnterTypeDecl is called when entering the typeDecl production.
	EnterTypeDecl(c *TypeDeclContext)

	// EnterVarType is called when entering the varType production.
	EnterVarType(c *VarTypeContext)

	// EnterVarDecl is called when entering the varDecl production.
	EnterVarDecl(c *VarDeclContext)

	// EnterFuncArgDecl is called when entering the funcArgDecl production.
	EnterFuncArgDecl(c *FuncArgDeclContext)

	// EnterFuncType is called when entering the funcType production.
	EnterFuncType(c *FuncTypeContext)

	// EnterFuncBody is called when entering the funcBody production.
	EnterFuncBody(c *FuncBodyContext)

	// EnterFuncDecl is called when entering the funcDecl production.
	EnterFuncDecl(c *FuncDeclContext)

	// EnterClassDecl is called when entering the classDecl production.
	EnterClassDecl(c *ClassDeclContext)

	// EnterIfStmnt is called when entering the ifStmnt production.
	EnterIfStmnt(c *IfStmntContext)

	// EnterElseIfStmnt is called when entering the elseIfStmnt production.
	EnterElseIfStmnt(c *ElseIfStmntContext)

	// EnterElseStmnt is called when entering the elseStmnt production.
	EnterElseStmnt(c *ElseStmntContext)

	// EnterWhileStmnt is called when entering the whileStmnt production.
	EnterWhileStmnt(c *WhileStmntContext)

	// EnterDoWhileStmnt is called when entering the doWhileStmnt production.
	EnterDoWhileStmnt(c *DoWhileStmntContext)

	// EnterForStmnt is called when entering the forStmnt production.
	EnterForStmnt(c *ForStmntContext)

	// EnterReturnStmnt is called when entering the returnStmnt production.
	EnterReturnStmnt(c *ReturnStmntContext)

	// EnterContinueStmnt is called when entering the continueStmnt production.
	EnterContinueStmnt(c *ContinueStmntContext)

	// EnterBreakStmnt is called when entering the breakStmnt production.
	EnterBreakStmnt(c *BreakStmntContext)

	// EnterFuncDeclStmnt is called when entering the funcDeclStmnt production.
	EnterFuncDeclStmnt(c *FuncDeclStmntContext)

	// EnterClassDeclStmnt is called when entering the classDeclStmnt production.
	EnterClassDeclStmnt(c *ClassDeclStmntContext)

	// EnterExprStmnt is called when entering the exprStmnt production.
	EnterExprStmnt(c *ExprStmntContext)

	// EnterBlockStmnt is called when entering the blockStmnt production.
	EnterBlockStmnt(c *BlockStmntContext)

	// EnterLiteral is called when entering the literal production.
	EnterLiteral(c *LiteralContext)

	// EnterArrayLiteral is called when entering the arrayLiteral production.
	EnterArrayLiteral(c *ArrayLiteralContext)

	// ExitProgram is called when exiting the program production.
	ExitProgram(c *ProgramContext)

	// ExitAssignmentExpr is called when exiting the assignmentExpr production.
	ExitAssignmentExpr(c *AssignmentExprContext)

	// ExitDotExpr is called when exiting the dotExpr production.
	ExitDotExpr(c *DotExprContext)

	// ExitFuncExpr is called when exiting the funcExpr production.
	ExitFuncExpr(c *FuncExprContext)

	// ExitArrayExpr is called when exiting the arrayExpr production.
	ExitArrayExpr(c *ArrayExprContext)

	// ExitParenExpr is called when exiting the parenExpr production.
	ExitParenExpr(c *ParenExprContext)

	// ExitPrefixExpr is called when exiting the prefixExpr production.
	ExitPrefixExpr(c *PrefixExprContext)

	// ExitDeclExpr is called when exiting the declExpr production.
	ExitDeclExpr(c *DeclExprContext)

	// ExitInfixExpr is called when exiting the infixExpr production.
	ExitInfixExpr(c *InfixExprContext)

	// ExitTernaryExpr is called when exiting the ternaryExpr production.
	ExitTernaryExpr(c *TernaryExprContext)

	// ExitLambdaExpr is called when exiting the lambdaExpr production.
	ExitLambdaExpr(c *LambdaExprContext)

	// ExitLiteralExpr is called when exiting the literalExpr production.
	ExitLiteralExpr(c *LiteralExprContext)

	// ExitPostfixExpr is called when exiting the postfixExpr production.
	ExitPostfixExpr(c *PostfixExprContext)

	// ExitIdExpr is called when exiting the idExpr production.
	ExitIdExpr(c *IdExprContext)

	// ExitFuncArgsExpr is called when exiting the funcArgsExpr production.
	ExitFuncArgsExpr(c *FuncArgsExprContext)

	// ExitBlock is called when exiting the block production.
	ExitBlock(c *BlockContext)

	// ExitTypeDecl is called when exiting the typeDecl production.
	ExitTypeDecl(c *TypeDeclContext)

	// ExitVarType is called when exiting the varType production.
	ExitVarType(c *VarTypeContext)

	// ExitVarDecl is called when exiting the varDecl production.
	ExitVarDecl(c *VarDeclContext)

	// ExitFuncArgDecl is called when exiting the funcArgDecl production.
	ExitFuncArgDecl(c *FuncArgDeclContext)

	// ExitFuncType is called when exiting the funcType production.
	ExitFuncType(c *FuncTypeContext)

	// ExitFuncBody is called when exiting the funcBody production.
	ExitFuncBody(c *FuncBodyContext)

	// ExitFuncDecl is called when exiting the funcDecl production.
	ExitFuncDecl(c *FuncDeclContext)

	// ExitClassDecl is called when exiting the classDecl production.
	ExitClassDecl(c *ClassDeclContext)

	// ExitIfStmnt is called when exiting the ifStmnt production.
	ExitIfStmnt(c *IfStmntContext)

	// ExitElseIfStmnt is called when exiting the elseIfStmnt production.
	ExitElseIfStmnt(c *ElseIfStmntContext)

	// ExitElseStmnt is called when exiting the elseStmnt production.
	ExitElseStmnt(c *ElseStmntContext)

	// ExitWhileStmnt is called when exiting the whileStmnt production.
	ExitWhileStmnt(c *WhileStmntContext)

	// ExitDoWhileStmnt is called when exiting the doWhileStmnt production.
	ExitDoWhileStmnt(c *DoWhileStmntContext)

	// ExitForStmnt is called when exiting the forStmnt production.
	ExitForStmnt(c *ForStmntContext)

	// ExitReturnStmnt is called when exiting the returnStmnt production.
	ExitReturnStmnt(c *ReturnStmntContext)

	// ExitContinueStmnt is called when exiting the continueStmnt production.
	ExitContinueStmnt(c *ContinueStmntContext)

	// ExitBreakStmnt is called when exiting the breakStmnt production.
	ExitBreakStmnt(c *BreakStmntContext)

	// ExitFuncDeclStmnt is called when exiting the funcDeclStmnt production.
	ExitFuncDeclStmnt(c *FuncDeclStmntContext)

	// ExitClassDeclStmnt is called when exiting the classDeclStmnt production.
	ExitClassDeclStmnt(c *ClassDeclStmntContext)

	// ExitExprStmnt is called when exiting the exprStmnt production.
	ExitExprStmnt(c *ExprStmntContext)

	// ExitBlockStmnt is called when exiting the blockStmnt production.
	ExitBlockStmnt(c *BlockStmntContext)

	// ExitLiteral is called when exiting the literal production.
	ExitLiteral(c *LiteralContext)

	// ExitArrayLiteral is called when exiting the arrayLiteral production.
	ExitArrayLiteral(c *ArrayLiteralContext)
}

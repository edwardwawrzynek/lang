// Code generated from Lang.g4 by ANTLR 4.7.1. DO NOT EDIT.

package parser // Lang

import "github.com/antlr/antlr4/runtime/Go/antlr"

// BaseLangListener is a complete listener for a parse tree produced by LangParser.
type BaseLangListener struct{}

var _ LangListener = &BaseLangListener{}

// VisitTerminal is called when a terminal node is visited.
func (s *BaseLangListener) VisitTerminal(node antlr.TerminalNode) {}

// VisitErrorNode is called when an error node is visited.
func (s *BaseLangListener) VisitErrorNode(node antlr.ErrorNode) {}

// EnterEveryRule is called when any rule is entered.
func (s *BaseLangListener) EnterEveryRule(ctx antlr.ParserRuleContext) {}

// ExitEveryRule is called when any rule is exited.
func (s *BaseLangListener) ExitEveryRule(ctx antlr.ParserRuleContext) {}

// EnterProgram is called when production program is entered.
func (s *BaseLangListener) EnterProgram(ctx *ProgramContext) {}

// ExitProgram is called when production program is exited.
func (s *BaseLangListener) ExitProgram(ctx *ProgramContext) {}

// EnterAssignmentExpr is called when production assignmentExpr is entered.
func (s *BaseLangListener) EnterAssignmentExpr(ctx *AssignmentExprContext) {}

// ExitAssignmentExpr is called when production assignmentExpr is exited.
func (s *BaseLangListener) ExitAssignmentExpr(ctx *AssignmentExprContext) {}

// EnterDotExpr is called when production dotExpr is entered.
func (s *BaseLangListener) EnterDotExpr(ctx *DotExprContext) {}

// ExitDotExpr is called when production dotExpr is exited.
func (s *BaseLangListener) ExitDotExpr(ctx *DotExprContext) {}

// EnterFuncExpr is called when production funcExpr is entered.
func (s *BaseLangListener) EnterFuncExpr(ctx *FuncExprContext) {}

// ExitFuncExpr is called when production funcExpr is exited.
func (s *BaseLangListener) ExitFuncExpr(ctx *FuncExprContext) {}

// EnterArrayExpr is called when production arrayExpr is entered.
func (s *BaseLangListener) EnterArrayExpr(ctx *ArrayExprContext) {}

// ExitArrayExpr is called when production arrayExpr is exited.
func (s *BaseLangListener) ExitArrayExpr(ctx *ArrayExprContext) {}

// EnterParenExpr is called when production parenExpr is entered.
func (s *BaseLangListener) EnterParenExpr(ctx *ParenExprContext) {}

// ExitParenExpr is called when production parenExpr is exited.
func (s *BaseLangListener) ExitParenExpr(ctx *ParenExprContext) {}

// EnterPrefixExpr is called when production prefixExpr is entered.
func (s *BaseLangListener) EnterPrefixExpr(ctx *PrefixExprContext) {}

// ExitPrefixExpr is called when production prefixExpr is exited.
func (s *BaseLangListener) ExitPrefixExpr(ctx *PrefixExprContext) {}

// EnterDeclExpr is called when production declExpr is entered.
func (s *BaseLangListener) EnterDeclExpr(ctx *DeclExprContext) {}

// ExitDeclExpr is called when production declExpr is exited.
func (s *BaseLangListener) ExitDeclExpr(ctx *DeclExprContext) {}

// EnterInfixExpr is called when production infixExpr is entered.
func (s *BaseLangListener) EnterInfixExpr(ctx *InfixExprContext) {}

// ExitInfixExpr is called when production infixExpr is exited.
func (s *BaseLangListener) ExitInfixExpr(ctx *InfixExprContext) {}

// EnterTernaryExpr is called when production ternaryExpr is entered.
func (s *BaseLangListener) EnterTernaryExpr(ctx *TernaryExprContext) {}

// ExitTernaryExpr is called when production ternaryExpr is exited.
func (s *BaseLangListener) ExitTernaryExpr(ctx *TernaryExprContext) {}

// EnterLambdaExpr is called when production lambdaExpr is entered.
func (s *BaseLangListener) EnterLambdaExpr(ctx *LambdaExprContext) {}

// ExitLambdaExpr is called when production lambdaExpr is exited.
func (s *BaseLangListener) ExitLambdaExpr(ctx *LambdaExprContext) {}

// EnterLiteralExpr is called when production literalExpr is entered.
func (s *BaseLangListener) EnterLiteralExpr(ctx *LiteralExprContext) {}

// ExitLiteralExpr is called when production literalExpr is exited.
func (s *BaseLangListener) ExitLiteralExpr(ctx *LiteralExprContext) {}

// EnterPostfixExpr is called when production postfixExpr is entered.
func (s *BaseLangListener) EnterPostfixExpr(ctx *PostfixExprContext) {}

// ExitPostfixExpr is called when production postfixExpr is exited.
func (s *BaseLangListener) ExitPostfixExpr(ctx *PostfixExprContext) {}

// EnterIdExpr is called when production idExpr is entered.
func (s *BaseLangListener) EnterIdExpr(ctx *IdExprContext) {}

// ExitIdExpr is called when production idExpr is exited.
func (s *BaseLangListener) ExitIdExpr(ctx *IdExprContext) {}

// EnterFuncArgsExpr is called when production funcArgsExpr is entered.
func (s *BaseLangListener) EnterFuncArgsExpr(ctx *FuncArgsExprContext) {}

// ExitFuncArgsExpr is called when production funcArgsExpr is exited.
func (s *BaseLangListener) ExitFuncArgsExpr(ctx *FuncArgsExprContext) {}

// EnterBlock is called when production block is entered.
func (s *BaseLangListener) EnterBlock(ctx *BlockContext) {}

// ExitBlock is called when production block is exited.
func (s *BaseLangListener) ExitBlock(ctx *BlockContext) {}

// EnterTypeDecl is called when production typeDecl is entered.
func (s *BaseLangListener) EnterTypeDecl(ctx *TypeDeclContext) {}

// ExitTypeDecl is called when production typeDecl is exited.
func (s *BaseLangListener) ExitTypeDecl(ctx *TypeDeclContext) {}

// EnterVarType is called when production varType is entered.
func (s *BaseLangListener) EnterVarType(ctx *VarTypeContext) {}

// ExitVarType is called when production varType is exited.
func (s *BaseLangListener) ExitVarType(ctx *VarTypeContext) {}

// EnterVarDecl is called when production varDecl is entered.
func (s *BaseLangListener) EnterVarDecl(ctx *VarDeclContext) {}

// ExitVarDecl is called when production varDecl is exited.
func (s *BaseLangListener) ExitVarDecl(ctx *VarDeclContext) {}

// EnterFuncArgDecl is called when production funcArgDecl is entered.
func (s *BaseLangListener) EnterFuncArgDecl(ctx *FuncArgDeclContext) {}

// ExitFuncArgDecl is called when production funcArgDecl is exited.
func (s *BaseLangListener) ExitFuncArgDecl(ctx *FuncArgDeclContext) {}

// EnterFuncType is called when production funcType is entered.
func (s *BaseLangListener) EnterFuncType(ctx *FuncTypeContext) {}

// ExitFuncType is called when production funcType is exited.
func (s *BaseLangListener) ExitFuncType(ctx *FuncTypeContext) {}

// EnterFuncBody is called when production funcBody is entered.
func (s *BaseLangListener) EnterFuncBody(ctx *FuncBodyContext) {}

// ExitFuncBody is called when production funcBody is exited.
func (s *BaseLangListener) ExitFuncBody(ctx *FuncBodyContext) {}

// EnterFuncDecl is called when production funcDecl is entered.
func (s *BaseLangListener) EnterFuncDecl(ctx *FuncDeclContext) {}

// ExitFuncDecl is called when production funcDecl is exited.
func (s *BaseLangListener) ExitFuncDecl(ctx *FuncDeclContext) {}

// EnterClassDecl is called when production classDecl is entered.
func (s *BaseLangListener) EnterClassDecl(ctx *ClassDeclContext) {}

// ExitClassDecl is called when production classDecl is exited.
func (s *BaseLangListener) ExitClassDecl(ctx *ClassDeclContext) {}

// EnterIfStmnt is called when production ifStmnt is entered.
func (s *BaseLangListener) EnterIfStmnt(ctx *IfStmntContext) {}

// ExitIfStmnt is called when production ifStmnt is exited.
func (s *BaseLangListener) ExitIfStmnt(ctx *IfStmntContext) {}

// EnterElseIfStmnt is called when production elseIfStmnt is entered.
func (s *BaseLangListener) EnterElseIfStmnt(ctx *ElseIfStmntContext) {}

// ExitElseIfStmnt is called when production elseIfStmnt is exited.
func (s *BaseLangListener) ExitElseIfStmnt(ctx *ElseIfStmntContext) {}

// EnterElseStmnt is called when production elseStmnt is entered.
func (s *BaseLangListener) EnterElseStmnt(ctx *ElseStmntContext) {}

// ExitElseStmnt is called when production elseStmnt is exited.
func (s *BaseLangListener) ExitElseStmnt(ctx *ElseStmntContext) {}

// EnterWhileStmnt is called when production whileStmnt is entered.
func (s *BaseLangListener) EnterWhileStmnt(ctx *WhileStmntContext) {}

// ExitWhileStmnt is called when production whileStmnt is exited.
func (s *BaseLangListener) ExitWhileStmnt(ctx *WhileStmntContext) {}

// EnterDoWhileStmnt is called when production doWhileStmnt is entered.
func (s *BaseLangListener) EnterDoWhileStmnt(ctx *DoWhileStmntContext) {}

// ExitDoWhileStmnt is called when production doWhileStmnt is exited.
func (s *BaseLangListener) ExitDoWhileStmnt(ctx *DoWhileStmntContext) {}

// EnterForStmnt is called when production forStmnt is entered.
func (s *BaseLangListener) EnterForStmnt(ctx *ForStmntContext) {}

// ExitForStmnt is called when production forStmnt is exited.
func (s *BaseLangListener) ExitForStmnt(ctx *ForStmntContext) {}

// EnterReturnStmnt is called when production returnStmnt is entered.
func (s *BaseLangListener) EnterReturnStmnt(ctx *ReturnStmntContext) {}

// ExitReturnStmnt is called when production returnStmnt is exited.
func (s *BaseLangListener) ExitReturnStmnt(ctx *ReturnStmntContext) {}

// EnterContinueStmnt is called when production continueStmnt is entered.
func (s *BaseLangListener) EnterContinueStmnt(ctx *ContinueStmntContext) {}

// ExitContinueStmnt is called when production continueStmnt is exited.
func (s *BaseLangListener) ExitContinueStmnt(ctx *ContinueStmntContext) {}

// EnterBreakStmnt is called when production breakStmnt is entered.
func (s *BaseLangListener) EnterBreakStmnt(ctx *BreakStmntContext) {}

// ExitBreakStmnt is called when production breakStmnt is exited.
func (s *BaseLangListener) ExitBreakStmnt(ctx *BreakStmntContext) {}

// EnterFuncDeclStmnt is called when production funcDeclStmnt is entered.
func (s *BaseLangListener) EnterFuncDeclStmnt(ctx *FuncDeclStmntContext) {}

// ExitFuncDeclStmnt is called when production funcDeclStmnt is exited.
func (s *BaseLangListener) ExitFuncDeclStmnt(ctx *FuncDeclStmntContext) {}

// EnterClassDeclStmnt is called when production classDeclStmnt is entered.
func (s *BaseLangListener) EnterClassDeclStmnt(ctx *ClassDeclStmntContext) {}

// ExitClassDeclStmnt is called when production classDeclStmnt is exited.
func (s *BaseLangListener) ExitClassDeclStmnt(ctx *ClassDeclStmntContext) {}

// EnterExprStmnt is called when production exprStmnt is entered.
func (s *BaseLangListener) EnterExprStmnt(ctx *ExprStmntContext) {}

// ExitExprStmnt is called when production exprStmnt is exited.
func (s *BaseLangListener) ExitExprStmnt(ctx *ExprStmntContext) {}

// EnterBlockStmnt is called when production blockStmnt is entered.
func (s *BaseLangListener) EnterBlockStmnt(ctx *BlockStmntContext) {}

// ExitBlockStmnt is called when production blockStmnt is exited.
func (s *BaseLangListener) ExitBlockStmnt(ctx *BlockStmntContext) {}

// EnterLiteral is called when production literal is entered.
func (s *BaseLangListener) EnterLiteral(ctx *LiteralContext) {}

// ExitLiteral is called when production literal is exited.
func (s *BaseLangListener) ExitLiteral(ctx *LiteralContext) {}

// EnterArrayLiteral is called when production arrayLiteral is entered.
func (s *BaseLangListener) EnterArrayLiteral(ctx *ArrayLiteralContext) {}

// ExitArrayLiteral is called when production arrayLiteral is exited.
func (s *BaseLangListener) ExitArrayLiteral(ctx *ArrayLiteralContext) {}

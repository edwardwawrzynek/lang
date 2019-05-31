// Generated from Lang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(LangParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(LangParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(LangParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(LangParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(LangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(LangParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclExpr(LangParser.DeclExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(LangParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(LangParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(LangParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(LangParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(LangParser.PostfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(LangParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcArgsExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgsExpr(LangParser.FuncArgsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(LangParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(LangParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#varInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInit(LangParser.VarInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(LangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcArgDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncArgDecl(LangParser.FuncArgDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(LangParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncBody(LangParser.FuncBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(LangParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(LangParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmnt(LangParser.IfStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseIfStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStmnt(LangParser.ElseIfStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmnt(LangParser.ElseStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmnt(LangParser.WhileStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doWhileStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmnt(LangParser.DoWhileStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmnt(LangParser.ForStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmnt(LangParser.ReturnStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmnt(LangParser.ContinueStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmnt(LangParser.BreakStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDeclStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclStmnt(LangParser.FuncDeclStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclStmnt(LangParser.ClassDeclStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmnt(LangParser.ExprStmntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmnt}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmnt(LangParser.BlockStmntContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(LangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(LangParser.ArrayLiteralContext ctx);
}
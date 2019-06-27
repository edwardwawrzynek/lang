package ast

class ASTFuncCallExpr(loc: ASTFileLocation, internal var func: ASTExpr, internal var args: ASTNodeArray<ASTExpr>) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTFuncCallExpr: (function, args)")
        func.print(i + 1)
        args.print(i + 1)
    }
}
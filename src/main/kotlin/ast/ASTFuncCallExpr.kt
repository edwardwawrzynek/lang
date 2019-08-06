package ast

class ASTFuncCallExpr(loc: ASTFileLocation, val func: ASTExpr, val args: ASTNodeArray<ASTExpr>) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTFuncCallExpr: (function, args)")
        func.print(i + 1)
        args.print(i + 1)
    }
}
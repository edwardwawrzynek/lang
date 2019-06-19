package ast

class ASTArrayLiteralExpr(loc: ASTFileLocation, internal var lits: List<ASTLiteralExpr>) : ASTLiteralExpr(loc, null) {

    override fun print(i: Int) {
        printIndent(i)
        System.out.println("ASTArrayLiteralExpr:")
        for (n in 0 until lits.size) {
            lits[n].print(i + 1)
        }
    }
}
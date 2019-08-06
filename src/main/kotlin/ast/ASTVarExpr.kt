package ast

class ASTVarExpr(loc: ASTFileLocation, val name: String) : ASTExpr(loc) {

    override fun isLValue(): Boolean {
        return true
    }

    override fun print(i: Int) {
        printIndent(i)
        print("ASTVarExpr: ")
        println(name)

    }
}
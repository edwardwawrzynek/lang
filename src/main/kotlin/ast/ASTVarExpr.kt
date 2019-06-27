package ast

class ASTVarExpr(loc: ASTFileLocation, internal var name: String) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTVarExpr: ")
        println(name)

    }
}
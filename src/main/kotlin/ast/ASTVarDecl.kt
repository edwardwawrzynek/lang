package ast

class ASTVarDecl(loc: ASTFileLocation, val name: String, val type: ASTType?, var init_val: ASTExpr?, var mutable: VarMut) : ASTNode(loc) {

    enum class VarMut {
        MUT, IMUT
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTVarDecl: (name, mutable, type, init_val)")
        printIndent(i + 1)
        println(name)
        printIndent(i + 1)
        println(mutable)
        if (type != null) {
            type.print(i + 1)
        } else {
            printIndent(i + 1)
            println("null")
        }
        if (init_val != null) {
            init_val!!.print(i + 1)
        } else {
            printIndent(i + 1)
            println("null")
        }
    }
}
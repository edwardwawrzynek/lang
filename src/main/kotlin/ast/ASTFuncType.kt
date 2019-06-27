package ast

open class ASTFuncType(loc: ASTFileLocation, var args: List<ASTVarDecl>, var ret_type: ASTType?) : ASTType(loc, null) {

    override fun print(i: Int) {
        printIndent(i)
        System.out.println("ASTFuncType: (ret_type, args[])")
        if (ret_type != null) {
            ret_type!!.print(i + 1)
        } else {
            printIndent(i + 1)
            System.out.println("null")
        }
        for (p in 0 until args.size) {
            args[p].print(i + 1)
        }
    }

}
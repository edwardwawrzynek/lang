package ast

class ASTArrayFuncType(loc: ASTFileLocation, args: List<ASTVarDecl>, ret_type: ASTType?, var length: Int) : ASTFuncType(loc, args, ret_type) {

    override fun print(i: Int) {
        printIndent(i)
        System.out.println("ASTArrayFuncType: (ret_type, args[])")
        ret_type!!.print(i + 1)
        for (p in 0 until args.size) {
            args[p].print(i + 1)
        }
    }
}
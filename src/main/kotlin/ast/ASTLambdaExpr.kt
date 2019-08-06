package ast

import compiler.genUniqueId

class ASTLambdaExpr(loc: ASTFileLocation, val type: ASTFuncType, val body: ASTNodeArray<ASTNode>) : ASTExpr(loc) {

    var enclosing_func: ASTNodeArray<ASTNode>? = null
    val id_num = genUniqueId()

    override fun print(i: Int) {
        printIndent(i)
        println("ASTLambdaExpr: (type, body)")
        type.print(i + 1)
        body.print(i + 1)
    }

}
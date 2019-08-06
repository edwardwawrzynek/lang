package ast

import compiler.genUniqueId

class ASTFuncDecl(loc: ASTFileLocation, val name: String, val type: ASTFuncType, val body: ASTNodeArray<ASTNode>) : ASTNode(loc) {

    val id_num = genUniqueId()

    fun getEmitName(scope: ASTNodeArray<ASTNode>): String {
        if(scope.higher_fun_scope == null){
            return name
        } else {
            return "_nested_func_$id_num"
        }
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTFuncDecl: (name, type, body)")
        printIndent(i + 1)
        println(name)
        type.print(i + 1)
        body.print(i + 1)
    }

}
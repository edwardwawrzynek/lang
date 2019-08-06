package ast

import compiler.*

class ASTClassDeclStmnt(loc: ASTFileLocation, val name: String, val fields: ASTNodeArray<ASTVarDecl>, val methods: ASTNodeArray<ASTFuncDecl>, val type: Type, val superclass: String?) : ASTNode(loc) {

    val scope = SymbolTable(null)
    fun setParentScope(pscope: SymbolTable?) {
        scope.parent = pscope
    }

    enum class Type {
        CLASS, OBJECT, STRUCT
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTClassDeclStmnt: (name, superclass, type, fields, methods)")
        printIndent(i + 1)
        println(name)
        printIndent(i + 1)
        println(superclass)
        printIndent(i + 1)
        println(type)
        fields.print(i + 1)
        methods.print(i + 1)
    }

}
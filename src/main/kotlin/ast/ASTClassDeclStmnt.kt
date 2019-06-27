package ast

import compiler.*

class ASTClassDeclStmnt(loc: ASTFileLocation, var name: String, var fields: ASTNodeArray<ASTVarDecl>, var methods: ASTNodeArray<ASTFuncDecl>, var type: Type, var superclass: String?) : ASTNode(loc) {

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
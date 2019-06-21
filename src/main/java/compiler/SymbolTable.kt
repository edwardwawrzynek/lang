package compiler

import ast.ASTVarDecl
import kotlin.collections.HashMap

class Symbol(/* name of the symbol */
        var name: String, /* mutability of the symbol */
        var mutable: Mutability, /* type of the symbol */
        internal var type: Type) {

    enum class Mutability {
        MUT, IMUT
    }

    companion object {
        fun fromASTMut(mut: ASTVarDecl.VarMut): Mutability {
            if (mut == ASTVarDecl.VarMut.MUT) {
                return Mutability.MUT
            } else if (mut == ASTVarDecl.VarMut.IMUT){
                return Mutability.IMUT
            } else {
                error("no such ast mutability type", null)
                return Mutability.MUT
            }
        }
    }
}

/* TODO: allow function overrides */
/* if we keep track scope in ast, we don't need child scopes */
class SymbolTable(
        var parent: SymbolTable?) {
    /* TODO: hash table of symbol string to type, etc, as well as map parent/child tables */
    /* Also, global symbol table (vars + functions), symbol table for class name lookup, symbol table for each class,
        local symbol tables for each function (TODO: how to handle check if var is declared yet)
     */
    var table: HashMap<String, Symbol>

    init {
        table = HashMap()
    }

    fun addSymbol(name: String, symbol: Symbol) {
        table[name] = symbol
    }

    fun findSymbol(name: String): Symbol? {
        val res = table[name]
        return res ?: parent?.findSymbol(name)
    }

}




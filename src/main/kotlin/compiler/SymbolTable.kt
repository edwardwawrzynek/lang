package compiler

import ast.*
import kotlin.collections.HashMap

class Symbol(
        var name: String,
        var mutable: Mutability,
        var type: Type,
        var storage: StorageType,
        /* ast node that this type comes from - used to get enclosing_func, etc from ASTFuncDecl */
        var ast_node: ASTNode?
        ) {

    /* class in which this variable is a member (only matters for CLASSVAR and CLASSFUNC) */
    var of_class: ClassType? = null

    /* used during type checking phase to make sure var's aren't used before they are declared */
    var is_declared: Boolean = false

    enum class Mutability {
        MUT, IMUT
    }

    enum class StorageType {
        GLOBAL,     /* global variable, static storage allocation */
        LOCAL,      /* local variable, stack storage allocation */
        NONLOCAL,   /* used in nested closure, needs to be alloc'd in heap */
        CLASSVAR,   /* a member of a class */

        GLBFUNC,    /* global function */
        NESTFUNC,   /* nested function (closure) */
        CLASSFUNC,  /* class method */

        CLASS,      /* entry is a class */
        NAMESPACE,  /* entry is namespace */
    }

    companion object {
        fun fromASTMut(mut: ASTVarDecl.VarMut): Mutability {
            if (mut == ASTVarDecl.VarMut.MUT) {
                return Mutability.MUT
            } else if (mut == ASTVarDecl.VarMut.IMUT){
                return Mutability.IMUT
            } else {
                compilerError("no such ast mutability type", null)
            }
        }
    }
}

/* TODO: allow function overrides */
class SymbolTable(
        var parent: SymbolTable?) {
    var table: HashMap<String, Symbol>

    init {
        table = HashMap()
    }

    fun getKeys(): MutableSet<String> {
        return table.keys
    }

    fun addSymbol(name: String, symbol: Symbol) {
        table[name] = symbol
    }

    fun findSymbol(name: String): Symbol? {
        val res = table[name]
        return res ?: parent?.findSymbol(name)
    }

    fun findSymbolNoParent(name: String): Symbol? {
        return table[name]
    }

}




package compiler
import ast.*

/* represents the type of an object */
open class Type {

    /* create a var of this type */
    protected open fun emitVarTypeDecl(emit: Emit) {
        emit.write("// emitVarTpe called on Type\n___trigger_error")
    }

    fun emitVarDecl(emit: Emit, name: String) {
        emitVarTypeDecl(emit)
        emit.write(" $name;\n")
    }

    companion object {
        fun fromASTType (type: ASTType, classTable: SymbolTable): Type {
            val res: Type
            when(type){
                is ASTArrayType -> res = ArrayType(
                        Type.fromStringLitType(type.lit_type, classTable, type.loc),
                        if (type.length != -1) type.length else null)
                is ASTFuncType -> {
                    val ret_type: Type?
                    if (type.ret_type == null) {
                        /* TODO: type inference later */
                        error("return type was not inferred", type.loc)
                        ret_type = null
                    } else {
                        ret_type = Type.fromASTType(type.ret_type!!, classTable)
                    }
                    val args = mutableListOf<Type>()
                    for(arg in type.args) {
                        if (arg.type == null) {
                            error("arg type was not inferred", type.loc)
                        }
                        args += Type.fromASTType(arg.type, classTable)
                    }
                    res = FunctionType(ret_type, args)
                }
                is ASTArrayFuncType -> res = ArrayType(
                        Type.fromASTType(type as ASTFuncType, classTable),
                        if (type.length != -1) type.length else null)

                else -> res = Type.fromStringLitType(type.lit_type, classTable, type.loc)
            }

            return res
        }

        private fun fromStringLitType(type: String, classTable: SymbolTable, loc: ASTFileLocation?): Type {
             when(type) {
                "void" -> return VoidType()
                "string" -> return StringType()
                "int" -> return IntType()
                else -> {
                    val symbol = classTable.findSymbol(type)
                    if (symbol == null) {
                        /* TODO: class name lookup */
                        error("identifier ${type} is not a recognized type", loc!!)
                        /* unreachable */
                        return VoidType()
                    } else {
                        return symbol.type
                    }
                }
            }
        }
    }
}

/* Type of a class (names of fields + methods are part of type) */
class ClassType(var name: String, var table: SymbolTable, var superclass: ClassType?) : Type() {
    fun emitShapeDecl (emit: Emit) {
        emit.write("typedef struct {\n")
        if(superclass != null) {
            emit.write("\t")
            superclass?.emitVarDecl(emit, "_super")
        }
        for((name, symbol) in table.table) {
            /* functions go in vtable */
            if(symbol.type !is FunctionType) {
                emit.write("\t");
                symbol.type.emitVarDecl(emit, name)
            }
        }
        emit.write("} ")
        emit.writeID(name)
        emit.write(";\n\n")

        /* add definition for arrays of this type (TODO: gc description) */
        emit.write("struct ")
        emit.writeID(name)
        emit.write("_array_type_ {\n\tint len;\n\t")
        emitVarTypeDecl(emit)
        emit.write("* vals;\n}\n\n")
    }

    override fun emitVarTypeDecl(emit: Emit) {
        emit.writeID(this.name)
        emit.write("*")
    }
}

/* names of args are not part of type - they are part of scope for code */
data class FunctionType(var return_type: Type?, var args: List<Type>) : Type()

/* array type */
data class ArrayType(var type: Type, val length: Int?): Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        /* TODO: bound checked array (struct for each type of array used) */
        emit.write("struct ")
        if(type is ClassType) {
            emit.writeID((type as ClassType).name)
            emit.write("_array_type *")
        } else {
            /* TODO: handle primative array types */
            emit.write("primative_arrays_not_implemented *")
        }
    }
}

/* primative void type */
class VoidType: Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("void")
    }
}

/* primative string type */
class StringType : Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        /* TODO: builtin class */
    }
}

/* primative int type */
class IntType : Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("int")
    }
}
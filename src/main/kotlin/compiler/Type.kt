package compiler
import ast.*

/* represents the type of an object */
open class Type {

    /* create a var of this type */
    internal open fun emitVarTypeDecl(emit: Emit) {
        emit.write("// emitVarTpe called on Type\n___trigger_error")
        compilerError("emitVarTypeDecl called on Type", null)
    }

    open fun emitVarDecl(emit: Emit, name: String) {
        emitVarTypeDecl(emit)
        emit.write(" $name;\n")
    }

    /* get name of type (for builtin array types, func overload names, etc) */
    open fun getTypeName(): String {
        compilerError("getName called on Type", null)
        return ""
    }

    override fun toString(): String {
        return getTypeName()
    }

    /* return the zero value to emit in c code for this type */
    open fun getCZeroValue(): String {
        compilerError("getCZeroValue called on Type", null)

        return ""
    }

    companion object {
        fun fromASTType (type: ASTType?, classTable: SymbolTable): Type {
            if(type == null){
                return InferredType()
            }
            val res: Type
            when(type){
                is ASTArrayType -> res = ArrayType(
                        Type.fromStringLitType(type.lit_type!!, classTable, type.loc),
                        if (type.length != -1) type.length else null)
                is ASTFuncType -> {
                    val ret_type: Type?
                    if (type.ret_type == null) {
                        /* TODO: type inference later */
                        ret_type = VoidType()
                    } else {
                        ret_type = Type.fromASTType(type.ret_type!!, classTable)
                    }
                    val args = mutableListOf<Type>()
                    for(arg in type.args) {
                        if (arg.type == null) {
                            compilerError("arg type was not inferred", type.loc)
                        }
                        args += Type.fromASTType(arg.type, classTable)
                    }
                    res = FunctionType(ret_type, args)
                }
                is ASTArrayFuncType -> res = ArrayType(
                        Type.fromASTType(type as ASTFuncType, classTable),
                        if (type.length != -1) type.length else null)

                else -> res = Type.fromStringLitType(type.lit_type!!, classTable, type.loc)
            }

            return res
        }

        private fun fromStringLitType(type: String, classTable: SymbolTable, loc: ASTFileLocation?): Type {
             when(type) {
                 "void" -> return VoidType()
                 "string" -> return ArrayType(CharType(), null)
                 "int" -> return IntType()
                 "bool" -> return BooleanType()
                 "char" -> return CharType()
                 else -> {
                    val symbol = classTable.findSymbol(type)
                    if (symbol == null) {
                        /* TODO: class name lookup */
                        compilerError("identifier ${type} is not a recognized type", loc!!)
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

/* type of a var that needs to be infered later */
class InferredType: Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        compilerError("Can't emit var type for InferredType", null)
    }


    override fun getTypeName(): String {
        compilerError("can't get type name of InferredType", null)
        return ""
    }
}

/* Type of a class (names of fields + methods are part of type) */
/**
 * Class struct layout is as follows:
 *
class B with no superclass:

struct __B {
    struct __B_vtable * _vtable;
    (fields...)
}
struct __B_vtable {
    struct vtable_head _header;
    (methods)
}
 *
class C with superclass B:

struct __C {
    __B _super; // vtable pointer in superclass, casted to (__C_vtable when used)
    (fields...)
}
struct __C_vtable {
    struct __B_vtable _vtable_super;
    (methods...)
}

vtable_head contains:
struct vtable_head {
    struct gc_desk gc;
    //parent vtable is used for runtime type checks - allows class hierchy to be explored
    //may be null if no superclass
    void * parent_vtable;
}

 */
class ClassType(var name: String, var table: SymbolTable, val superclass: ClassType?) : Type() {
    fun emitShapeDeclHeader (emit: Emit) {
        emit.write("struct ${emit.getID(name)};\n")
        emit.write("typedef struct ${emit.getID(name)} ${emit.getID(name)};\n")

        /* emit vtable header */
        emit.write("struct ${emit.getID(name)}_vtable;\n")

        /* add definition for arrays of this type (TODO: gc description) */
        emit.write("struct ${emit.getID(name)}_array_type {\n")
        emit.write("\tunsigned int len;\n\t")
        emitVarTypeDecl(emit)
        emit.write("* vals;\n};\n\n")
    }

    fun emitShapeDecl (emit: Emit) {
        emit.write("struct ${emit.getID(name)} {\n")
        if(superclass != null) {
            emit.write("\t${emit.getID(superclass.name)} _super;\n")
        } else {
            emit.write("\tstruct ${emit.getID(name)}_vtable* _vtable;\n")
        }
        for((name, symbol) in table.table) {
            /* functions go in vtable */
            if(symbol.type !is FunctionType) {
                emit.write("\t")
                symbol.type.emitVarDecl(emit, name)
            }
        }
        emit.write("};\n")

        emit.write("struct ${emit.getID(name)}_vtable {\n")

        if(superclass != null) {
            emit.write("\tstruct ${emit.getID(superclass.name)}_vtable _vtable_super;\n")
        } else {
            emit.write("\tstruct vtable_head _header;\n")
        }

        for((name, symbol) in table.table) {
            /* data goes in struct */
            if(symbol.type is FunctionType) {
                emit.write("\t")
                symbol.type.emitVarDecl(emit, name)
            }
        }
        emit.write("};\n\n")
    }


    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("${emit.getID(name)}*")
    }

    override fun getTypeName(): String {
        return name
    }

    override fun getCZeroValue(): String {
        return "NULL"
    }
}

/* names of args are not part of type - they are part of scope for code */
data class FunctionType(var return_type: Type?, var args: List<Type>) : Type() {
    override fun emitVarDecl(emit: Emit, name: String) {
        if(return_type == null){
            return_type = VoidType()
        }
        return_type?.emitVarTypeDecl(emit)
        /* void pointer is data arg for usage in closure
            for global methods, this is null
            for class methods, it is object
            for closures, it is pointer to allocated locals from higher functions
         */
        emit.write(" (*$name)(void*${if(args.isNotEmpty()) ", " else ""}")
        for(i in 0.until(args.size)){
            args[i].emitVarTypeDecl(emit)
            if(i < args.size -1) {
                emit.write(", ")
            }
        }
        emit.write(");\n")
    }

    override fun getCZeroValue(): String {
        return "NULL"
    }
}

/* array type */
data class ArrayType(var type: Type, val length: Int?): Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        /* TODO: bound checked array (struct for each type of array used) */
        emit.write("struct ${emit.getID(type.getTypeName())}_array_type*")
    }

    override fun getTypeName(): String {
        return "${type.getTypeName()}_array_type"
    }

    override fun toString(): String {
        return "[]$type"
    }

    override fun getCZeroValue(): String {
        TODO("empty array default value")
        return ""
    }
}

/* primative void type */
class VoidType: Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("void")
    }

    override fun getTypeName(): String {
        return "void"
    }


    override fun equals(other: Any?): Boolean {
        return other is VoidType
    }
}

/* primative boolean type */
class BooleanType: Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("uint8_t")
    }

    override fun getTypeName(): String {
        return "bool"
    }


    override fun equals(other: Any?): Boolean {
        return other is BooleanType
    }

    override fun getCZeroValue(): String {
        return "0"
    }
}

open class NumberType: Type() {
    override fun getCZeroValue(): String {
        return "0"
    }

    override fun equals(other: Any?): Boolean{
        return other is NumberType
    }

    override fun getTypeName(): String {
        return "castable int"
    }
}

/* primative int type */
class IntType : NumberType() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("int")
    }

    override fun getTypeName(): String {
        return "int"
    }

    override fun equals(other: Any?): Boolean {
        return other is IntType
    }

}

class CharType: NumberType() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("char")
    }

    override fun getTypeName(): String {
        return "char"
    }

    override fun equals(other: Any?): Boolean {
        return other is CharType
    }
}
package compiler
import ast.*

/* represents the type of an object */
open class Type {

    /* create a var of this type */
    open fun emitVarTypeDecl(emit: Emit) {
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

    /* return true if type can be implicitly converted to other type */
    open fun canImplicitConvert(other: Type): Boolean {
        return false
    }

    /* return true if operator is defined for this type and other type (if not a single arg op) */
    open fun hasOpDefined(op: ASTExprOp.ExprType, other: Type?): Boolean {
        return false
    }

    open fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>): Type {
        error("can't emit op on Type")
    }

    /* return true if internal representation is nullable */
    open fun isPointer(): Boolean {
        error("isPointer called on Type")
    }

    companion object {
        fun fromASTType(type: ASTType?, classTable: SymbolTable, binding_type: FunctionType.Binding?): Type {
            if(type == null){
                return InferredType()
            }
            val res: Type
            when(type){
                is ASTArrayFuncType -> {
                    val castd_type = ASTFuncType(type.loc!!, type.args, type.ret_type)
                    res = ArrayType(
                            Type.fromASTType(castd_type, classTable, FunctionType.Binding.CLOSURE),
                            if (type.length != -1) type.length else null)
                }
                is ASTArrayType -> res = ArrayType(
                        Type.fromStringLitType(type.lit_type!!, classTable, type.loc),
                        if (type.length != -1) type.length else null)
                is ASTFuncType -> {
                    val ret_type: Type?
                    if (type.ret_type == null) {
                        ret_type = VoidType()
                    } else {
                        ret_type = Type.fromASTType(type.ret_type!!, classTable, FunctionType.Binding.CLOSURE)
                    }
                    val args = mutableListOf<Type>()
                    for(arg in type.args) {
                        if (arg.type == null) {
                            compilerError("arg type was not inferred", type.loc)
                        }
                        val typ = Type.fromASTType(arg.type, classTable, FunctionType.Binding.CLOSURE)

                        args += typ
                    }
                    res = FunctionType(ret_type, args, binding_type)
                }

                else -> res = Type.fromStringLitType(type.lit_type!!, classTable, type.loc)
            }

            return res
        }

        private fun fromStringLitType(type: String, classTable: SymbolTable, loc: ASTFileLocation?): Type {
             when(type) {
                 "void" -> return VoidType()
                 "string" -> return ArrayType(CharType(), null)
                 "int" -> return IntType()
                 "long" -> return LongType()
                 "bool" -> return BooleanType()
                 "char" -> return CharType()
                 else -> {
                    val symbol = classTable.findSymbol(type)
                    if (symbol == null) {
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
        return "InferredType"
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
                if(symbol.mutable == Symbol.Mutability.IMUT) {
                    emit.write("const ")
                }
                symbol.type.emitVarDecl(emit, name)
            }
        }
        emit.write("};\n")

        emit.write("struct ${emit.getID(name)}_vtable {\n")

        if(superclass != null) {
            emit.write("\tstruct ${emit.getID(superclass.name)}_vtable _vtable_super;\n")
        } else {
            emit.write("\tstruct _lang_vtable_head _header;\n")
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

    override fun canImplicitConvert(other: Type): Boolean {
        if(other is BooleanType){
            return true
        }
        if(other == this){
            return true
        }
        var s = superclass
        while(s != null){
            if(other == s){
                return true
            }
            s = s.superclass
        }

        return false
    }

    override fun isPointer(): Boolean {
        return true
    }
}

/* names of args are not part of type - they are part of scope for code */
class FunctionType(var return_type: Type?, var args: List<Type>, val binding_type: Binding?) : Type() {
    enum class Binding {
        GLOBAL,
        CLASS,
        CLOSURE;

        companion object {
            fun fromStorageType(type: Symbol.StorageType): Binding {
                return when(type) {
                    Symbol.StorageType.GLBFUNC -> GLOBAL
                    Symbol.StorageType.CLASSFUNC -> CLASS
                    Symbol.StorageType.NESTFUNC -> CLOSURE
                    else -> CLOSURE
                }
            }
        }
    }
    /*var binding_type: Binding? = null*/

    override fun equals(other: Any?): Boolean {
        if(other !is FunctionType) return false
        return other.return_type == return_type && other.args == args && other.binding_type == binding_type
    }

    override fun toString(): String {
        return "FunctionType(return_type=$return_type, args=$args, binding_type=$binding_type)"
    }

    override fun emitVarTypeDecl(emit: Emit) {
        /*if(binding_type != Binding.CLOSURE) {
            println(binding_type)
            error("emitVarTypeDecl called on non closure binded function")
        }*/
        emit.write("_lang_closure*");
    }

    override fun emitVarDecl(emit: Emit, name: String) {
        if(binding_type == null) {
            error("emitVarDecl called with binding_type null")
        }
        if(binding_type == Binding.CLOSURE) {
            emit.write("_lang_closure* $name");
        } else {
            if (return_type == null) {
                return_type = VoidType()
            }
            return_type?.emitVarTypeDecl(emit)
            /* void pointer is data arg for usage in closure
            for global methods, this is null
            for class methods, it is object
            for closures, it is pointer to allocated locals from higher functions
         */
            emit.write(" (*$name)(void*${if (args.isNotEmpty()) ", " else ""}")
            for (i in 0.until(args.size)) {
                args[i].emitVarTypeDecl(emit)
                if (i < args.size - 1) {
                    emit.write(", ")
                }
            }
            emit.write(");\n")
        }
    }

    override fun getCZeroValue(): String {
        return "NULL"
    }

    override fun isPointer(): Boolean {
        return true
    }

    override fun canImplicitConvert(other: Type): Boolean {
        if(other !is FunctionType) return false
        if(!(other.return_type == return_type && other.args == args)) return false

        if(binding_type == other.binding_type) return true

        if(other.binding_type == Binding.CLOSURE) return true

        return false
    }
}

/* array type */
data class ArrayType(var type: Type, val length: Int?): Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        /* TODO: bound checked array (struct for each type of array used) */
        emit.write("_lang_array*")
    }

    override fun getTypeName(): String {
        return "_lang_array"
    }

    override fun toString(): String {
        return "[]$type"
    }

    override fun isPointer(): Boolean {
        return true
    }

    override fun getCZeroValue(): String {
        return "(&_lang_empty_array)"
    }

    override fun canImplicitConvert(other: Type): Boolean {
        return equals(other)
    }

    override fun hasOpDefined(op: ASTExprOp.ExprType, other: Type?): Boolean {
        return when(op) {
            ASTExprOp.ExprType.ARRAY -> other is NumberType
            ASTExprOp.ExprType.ADD ->  other == this
            ASTExprOp.ExprType.LSHFT -> other!!.canImplicitConvert(type)
            else -> false
        }
    }

    override fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>): Type {
        when(op) {
            ASTExprOp.ExprType.ARRAY -> {
                emit.write("((")
                type.emitVarTypeDecl(emit)
                emit.write("*)((")
                type_visitor.visitASTExpr(expr1, scope, emit)
                emit.write(")->vals))[")
                type_visitor.visitASTExpr(expr2!!, scope, emit)
                emit.write("]")
                return type
            }
            ASTExprOp.ExprType.ADD -> {
                emit.write("_lang_array_cat(")
                type_visitor.visitASTExpr(expr1, scope, emit)
                emit.write(", ")
                type_visitor.visitASTExpr(expr2!!, scope, emit)
                emit.write(")")
                return this
            }
            ASTExprOp.ExprType.LSHFT -> {
                emit.write("_lang_array_add_${if(type.isPointer()) "pointer" else type.getTypeName()}(")
                type_visitor.visitASTExpr(expr1, scope, emit)
                emit.write(", ")
                type_visitor.visitASTExpr(expr2!!, scope, emit)
                emit.write(")")
                return this
            }
            else -> {
                error("not valid array op")
            }
        }
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

    override fun canImplicitConvert(other: Type): Boolean {
        return other is VoidType
    }

    override fun isPointer(): Boolean {
        return false
    }
}

/* primative boolean type */
class BooleanType: Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("bool")
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

    override fun canImplicitConvert(other: Type): Boolean {
        return other is BooleanType
    }

    override fun isPointer(): Boolean {
        return false
    }
}

open class NumberType: Type() {

    override fun getCZeroValue(): String {
        return "0"
    }

    override fun canImplicitConvert(other: Type): Boolean {
        return other is BooleanType || (other is NumberType && other !is CharType)
    }

    override fun isPointer(): Boolean {
        return false
    }

    override fun hasOpDefined(op: ASTExprOp.ExprType, other: Type?): Boolean {
        return op != ASTExprOp.ExprType.ARRAY && (ASTExprOp.ExprType.isUnary(op) || other is NumberType)
    }

    override fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>): Type {
        if(ASTExprOp.ExprType.isUnary(op)){
            when(op) {
                ASTExprOp.ExprType.POSTFIX_INC -> {
                    emit.write("(")
                    type_visitor.visitASTExpr(expr1, scope, emit)
                    emit.write("++)")
                }
                ASTExprOp.ExprType.POSTFIX_DEC -> {
                    emit.write("(")
                    type_visitor.visitASTExpr(expr1, scope, emit)
                    emit.write("--)")
                }
                else -> {
                    val op_str = when(op) {
                        ASTExprOp.ExprType.PREFIX_INC -> "++"
                        ASTExprOp.ExprType.PREFIX_DEC -> "--"
                        ASTExprOp.ExprType.NEGATIVE -> "-"
                        ASTExprOp.ExprType.BINARY_NOT -> "~"
                        else -> error("not valid unary op")
                    }
                    emit.write("($op_str")
                    type_visitor.visitASTExpr(expr1, scope, emit)
                    emit.write(")")
                }
            }
            return NumberType()
        } else {
            val op_str = when(op) {
                ASTExprOp.ExprType.ADD -> "+"
                ASTExprOp.ExprType.SUB -> "-"
                ASTExprOp.ExprType.MULT -> "*"
                ASTExprOp.ExprType.DIV -> "/"
                ASTExprOp.ExprType.MOD -> "%"
                ASTExprOp.ExprType.LSHFT -> "<<"
                ASTExprOp.ExprType.RSHFT -> ">>"
                ASTExprOp.ExprType.LT -> "<"
                ASTExprOp.ExprType.LTE -> "<="
                ASTExprOp.ExprType.GT -> ">"
                ASTExprOp.ExprType.GTE -> ">="
                ASTExprOp.ExprType.EQ -> "=="
                ASTExprOp.ExprType.BINARY_AND -> "&"
                ASTExprOp.ExprType.BINARY_OR -> "|"
                ASTExprOp.ExprType.BINARY_XOR -> "^"
                else -> error("not valid binary op")
            }
            emit.write("(")
            type_visitor.visitASTExpr(expr1, scope, emit)
            emit.write(op_str)
            type_visitor.visitASTExpr(expr2!!, scope, emit)
            emit.write(")")
            return if(op == ASTExprOp.ExprType.EQ) BooleanType() else NumberType()
        }
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

class LongType: NumberType(){
    override fun emitVarTypeDecl(emit: Emit) {
        emit.write("long")
    }

    override fun getTypeName(): String {
        return "long"
    }

    override fun equals(other: Any?): Boolean {
        return other is LongType
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

    override fun canImplicitConvert(other: Type): Boolean {
        return other is BooleanType || other is CharType
    }
}
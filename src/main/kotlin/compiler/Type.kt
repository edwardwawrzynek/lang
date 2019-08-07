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
    }

    override fun toString(): String {
        return getTypeName()
    }

    /* return the zero value to emit in c code for this type */
    open fun getCZeroValue(): String {
        compilerError("getCZeroValue called on Type", null)

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

    /* field access types */
    enum class FieldType {
        NONE, /* no such fieled */
        READWRITE,
        READONLY,
        WRITEONLY,
    }

    /* check if type has a field, and, if so, how it can be accessed */
    open fun hasField(name: String): FieldType {
        return FieldType.NONE
    }

    /* emit code for reading a field. access_expr is expr before dot */
    open fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>): Type {
        error("invalid field read")
    }

    /* emit code for writing a field. access_expr is code before dot, val_expr is expr field is being set to */
    open fun emitFieldWrite(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, val_expr: ASTExpr, scope: ASTNodeArray<ASTNode>): Type {
        error("invalid field write")
    }

    /* check if the type has a function call with the given field name */
    open fun hasFieldCall(name: String): Boolean {
        return false
    }

    /* emit a function call with the given field name */
    open fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>): Type {
        error("invalid field name call")
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
                        ret_type = Type.fromASTType(type.ret_type, classTable, FunctionType.Binding.CLOSURE)
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

    val overridden_methods = mutableListOf<String>()

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

    fun emitVtableInstance(emit: Emit) {
        emit.write("struct ${emit.getID(name)}_vtable ${emit.getID(name)}_vtable_inst = ")
        emitVtableInstanceBody(this, emit)
        emit.write(";\n")
    }

    fun emitVtableInstanceHeader(emit: Emit) {
        emit.write("extern struct ${emit.getID(name)}_vtable ${emit.getID(name)}_vtable_inst;\n")
    }

    /* find which superclass has the most recent implementation of a method */
    fun findImplementorMethod(name: String, type: ClassType): ClassType? {
        if(name in type.table.table || name in type.overridden_methods) return type
        if(type.superclass == null) return null
        return findImplementorMethod(name, type.superclass)
    }

    /* find in which vtable or object a property is placed in the superclass chain */
    fun findImplementor(name: String, type: ClassType): ClassType? {
        if(name in type.table.table) return type
        if(type.superclass == null) return null
        return findImplementorMethod(name, type.superclass)
    }

    /* find highest parent for this class */
    fun findRootClass(): ClassType {
        if(superclass == null) return this
        return superclass.findRootClass()
    }

    fun emitVtableInstanceBody(type: ClassType, emit: Emit) {
        emit.write("{\n")
        for(field in type.table.table) {
            val f = field.value
            if(f.type !is FunctionType || (f.type as FunctionType).binding_type != FunctionType.Binding.CLASS) {
                continue;
            }
            val implementor = findImplementorMethod(f.name, this)
            if(implementor == null) {
                error("can't find method ${f.name} in table")
            }

            emit.write(".${f.name} = &${emit.getID(implementor.name)}_${f.name},\n")
        }
        if(type.superclass != null) {
            emit.write("._vtable_super = ")
            emitVtableInstanceBody(type.superclass, emit)
            emit.write(",\n")
        } else {
            val supervtable: String
            if(superclass == null) {
                supervtable = "NULL"
            } else {
                supervtable = "&${emit.getID(superclass.name)}_vtable_inst"
            }
            emit.write("._header = {\n/* TODO: gc_desk */\n.parent_vtable = $supervtable,\n},\n")
        }
        emit.write("}")
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

    override fun hasField(name: String): FieldType {
        val sym = table.findSymbol(name)
        if(sym == null) {
            return FieldType.NONE
        }
        if(sym.type is FunctionType && (sym.type as FunctionType).binding_type == FunctionType.Binding.CLASS) {
            /* this is a method in the vtable, so it can't be reassigned */
            return FieldType.READONLY
        }
        return FieldType.READWRITE
    }

    override fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>): Type {
        val sym = table.findSymbol(name)
        if(sym == null) {
            error("invalid field read")
        }
        val implementor = findImplementor(name, this)
        if (implementor == null) {
            error("field implementor not found")
        }
        if(sym.type is FunctionType && (sym.type as FunctionType).binding_type == FunctionType.Binding.CLASS) {
            /* TODO: closure conversion (not here, but special care needed for class bound functions) */
            val root = findRootClass()
            emit.write("((struct ${emit.getID(implementor.name)}_vtable *)(((${emit.getID(root.name)} *)(")
            type_visitor.visitASTExpr(access_expr, scope, emit)
            emit.write("))->_vtable))->$name")
            return sym.type
        } else {
            emit.write("(")
            if (implementor != this) {
                emit.write("(struct ${emit.getID(implementor.name)} *)")
            }
            emit.write("(")
            type_visitor.visitASTExpr(access_expr, scope, emit)
            emit.write("))")
            emit.write("->$name")

            return sym.type
        }
    }

    override fun emitFieldWrite(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, val_expr: ASTExpr, scope: ASTNodeArray<ASTNode>): Type {
        val type = emitFieldRead(name, type_visitor, emit, access_expr, scope)
        emit.write(" = ")
        val val_type = type_visitor.emitExprImplicitConvert(emit, type, val_expr, scope)
        if(!val_type.canImplicitConvert(type)) {
            compilerError("type of value being assigned ($val_type) does not match expected type ($type)", val_expr.loc)
        }
        return type
    }

    override fun hasFieldCall(name: String): Boolean {
        val sym = table.findSymbol(name)
        if(sym == null) {
            return false
        }
        if(sym.type is FunctionType && (sym.type as FunctionType).binding_type == FunctionType.Binding.CLASS) {
            return true
        }
        return false
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>): Type {

        val sym = table.findSymbol(name)
        if(sym == null) {
            error("invalid field read")
        }
        val implementor = findImplementor(name, this)
        if (implementor == null) {
            error("field implementor not found")
        }
        if(!(sym.type is FunctionType && (sym.type as FunctionType).binding_type == FunctionType.Binding.CLASS)) {
            error("not a function field")
        }
        /* TODO: closure conversion (not here, but special care needed for class bound functions) */
        val root = findRootClass()
        emit.write("(_lang_temp_this = ")
        emit.write("(")
        type_visitor.visitASTExpr(access_expr, scope, emit)
        emit.write("), ((struct ${emit.getID(implementor.name)}_vtable *)(((${emit.getID(root.name)} *)_lang_temp_this)->_vtable))->$name")
        emit.write("(_lang_temp_this")

        if (func_expr.args.nodes.size > 0) emit.write(", ")
        if(func_expr.args.nodes.size != (sym.type as FunctionType).args.size) {
            compilerError("number of arguments (${func_expr.args.nodes.size}) doesn't match expected number of ${(sym.type as FunctionType).args.size}", if (func_expr.args.nodes.size > 0) func_expr.args.nodes[0].loc else func_expr.loc)
        }

        for (i in 0.until(func_expr.args.nodes.size)) {
            val type = type_visitor.emitExprImplicitConvert(emit, (sym.type as FunctionType).args[i], func_expr.args.nodes[i], scope)
            if (!type.canImplicitConvert((sym.type as FunctionType).args[i])) {
                compilerError("type of arg ($type) doesn't match expected type of ${(sym.type as FunctionType).args[i]}", func_expr.args.nodes[i].loc)
            }
            if (i < func_expr.args.nodes.size - 1) {
                emit.write(", ")
            }
        }

        emit.write("))")
        return (sym.type as FunctionType).return_type!!
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
class ArrayType(var type: Type, val length: Int?): Type() {
    override fun emitVarTypeDecl(emit: Emit) {
        /* TODO: bound checked array (struct for each type of array used) */
        emit.write("_lang_array*")
    }

    override fun getTypeName(): String {
        return "_lang_array*"
    }

    override fun toString(): String {
        return "[]$type"
    }

    override fun equals(other: Any?): Boolean {
        if(other !is ArrayType) {
            return false
        }
        return type == other.type
    }

    override fun isPointer(): Boolean {
        return true
    }

    override fun getCZeroValue(): String {
        return "_lang_array_make_empty(${type.isPointer()}, sizeof(${type.getTypeName()}))"
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
                emit.write(", ${type.isPointer()})")
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

    override fun hasField(name: String): FieldType {
        return when(name) {
            "len" -> FieldType.READONLY
            else -> FieldType.NONE
        }
    }

    override fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>): Type {
        when(name) {
            "len" -> {
                emit.write("(")
                type_visitor.visitASTExpr(access_expr, scope, emit)
                emit.write("->len)")
                return LongType()
            }
            else -> error("invalid field read")
        }
    }

    override fun hasFieldCall(name: String): Boolean {
        return when(name) {
            "removeAt" -> true
            else -> false
        }
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>): Type {
        when(name) {
            "removeAt" -> {
                if(func_expr.args.nodes.size != 1) {
                    compilerError("number of arguments (${func_expr.args.nodes.size}) doesn't match expected number of 1", if(func_expr.args.nodes.size > 0) func_expr.args.nodes[0].loc else func_expr.loc)
                }
                emit.write("_lang_array_remove_at(")
                type_visitor.visitASTExpr(access_expr, scope, emit)
                emit.write(", ")
                val type = type_visitor.emitExprImplicitConvert(emit, LongType(), func_expr.args.nodes[0], scope)
                if(!type.canImplicitConvert(LongType())) {
                    compilerError("type of arg $type doesn't match expected type of long", func_expr.args.nodes[0].loc)
                }
                emit.write(", ${type.isPointer()})")
                return this
            }
            else -> error("invalid field call name")
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
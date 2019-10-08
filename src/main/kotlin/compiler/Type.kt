package compiler
import ast.*

/* represents the type of an object */
open class Type {

    /* create a var of this type */
    open fun emitVarTypeDecl(emit: Emit): String {
        emit.write("// emitVarTpe called on Type\n___trigger_error")
        error("emitVarTypeDecl called on Type")
    }

    open fun emitVarDecl(emit: Emit, name: String) {
        emitVarTypeDecl(emit)
        emit.write(" $name;\n")
    }

    open fun getName(emit: Emit): String {
        return getTypeName()
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

    open fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        error("can't emit op on Type")
    }

    /* field access types */
    enum class FieldType {
        NONE, /* no such field */
        READWRITE,
        READONLY,
        WRITEONLY,
    }

    /* check if type has a field, and, if so, how it can be accessed */
    open fun hasField(name: String): FieldType {
        return FieldType.NONE
    }

    /* emit code for reading a field. access_expr is expr before dot */
    open fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        error("invalid field read")
    }

    /* emit code for writing a field. access_expr is code before dot, val_expr is expr field is being set to */
    open fun emitFieldWrite(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, val_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        error("invalid field write")
    }

    /* check if the type has a function call with the given field name */
    open fun hasFieldCall(name: String): Boolean {
        return false
    }

    /* emit a function call with the given field name */
    open fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        error("invalid field name call")
    }

    /* return true if internal representation is nullable */
    open fun isPointer(): Boolean {
        error("isPointer called on Type")
    }

    companion object {
        fun fromASTType(type: ASTType?, classTable: SymbolTable, binding_type: FunctionType.Binding?, namespace: Namespace?): Type {
            if(type == null){
                return InferredType()
            }
            val res: Type
            when(type){
                is ASTArrayFuncType -> {
                    val castd_type = ASTFuncType(type.loc!!, type.args, type.ret_type)
                    res = ArrayType(
                            Type.fromASTType(castd_type, classTable, FunctionType.Binding.CLOSURE, namespace),
                            if (type.length != -1) type.length else null)
                }
                is ASTArrayType -> res = ArrayType(
                        Type.fromStringLitType(type.lit_type!!, classTable, type.loc, namespace),
                        if (type.length != -1) type.length else null)
                is ASTFuncType -> {
                    val ret_type: Type?
                    if (type.ret_type == null) {
                        ret_type = VoidType()
                    } else {
                        ret_type = Type.fromASTType(type.ret_type, classTable, FunctionType.Binding.CLOSURE, namespace)
                    }
                    val args = mutableListOf<Type>()
                    for(arg in type.args) {
                        if (arg.type == null) {
                            compilerError("arg type was not inferred", type.loc)
                        }
                        val typ = Type.fromASTType(arg.type, classTable, FunctionType.Binding.CLOSURE, namespace)

                        args += typ
                    }
                    res = FunctionType(ret_type, args, binding_type)
                }

                else -> res = Type.fromStringLitType(type.lit_type!!, classTable, type.loc, namespace)
            }

            return res
        }

        /* search up the whole namespace tree from current location */
        private fun searchUpNamespaces(name: String, namespace: Namespace): Symbol? {
            val sym = classTable.findSymbolByNamespaceName(namespace, name)
            if (sym == null) {
                if (namespace.parent == null) {
                    /* try class table, and fail if not there */
                    val global_sym = classTable.findSymbol(name)
                    return global_sym
                } else {
                    return searchUpNamespaces(name, namespace.parent)
                }
            } else {
                return sym
            }
        }

        private fun fromStringLitType(type: String, classTable: SymbolTable, loc: ASTFileLocation?, namespace: Namespace?): Type {
             when(type) {
                 "void" -> return VoidType()
                 "string" -> return ArrayType(CharType(), null)
                 "float" -> return FloatType()
                 "double" -> return DoubleType()
                 "int" -> return IntType()
                 "long" -> return LongType()
                 "bool" -> return BooleanType()
                 "char" -> return CharType()
                 else -> {
                     var symbol: Symbol?

                     if('.' in type) {
                         /* handle scoped namespaces */
                         val names = type.split(".").filter { it != "" }
                         if(names.isEmpty()){
                             symbol = null
                         } else {
                             if(namespace == null || type[0] == '.'){
                                 symbol = classTable.findSymbol(names[0])
                             } else {
                                 symbol = searchUpNamespaces(names[0], namespace)
                             }
                             for (i in 1..(names.size-1)) {
                                 if(symbol == null || symbol.type !is Namespace) {
                                     symbol = null
                                     break
                                 }
                                 val name = names[i]
                                 symbol = (symbol.type as Namespace).table.findSymbolNoParent(name)
                             }
                         }
                     } else {
                         if (namespace == null) {
                             symbol = classTable.findSymbol(type)
                         } else {
                             symbol = searchUpNamespaces(type, namespace)
                         }
                     }
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
    override fun emitVarTypeDecl(emit: Emit): String {
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
/* shortName is non namespace'd name */
class ClassType(var name: String, var shortName: String, var table: SymbolTable, val superclass: ClassType?) : Type() {

    val overridden_methods = mutableListOf<String>()

    fun emitShapeDeclHeader (emit: Emit) {
        emit.write("struct ${getName(emit)};\n")

        /* emit vtable header */
        emit.write("struct ${getName(emit)}_vtable;\n")
        /* emit vtable implementation header */
        emitVtableInstanceHeader(emit)
    }

    fun emitShapeDecl (emit: Emit) {
        emit.write("struct ${getName(emit)} {\n")
        if(superclass != null) {
            emit.write("\tstruct ${superclass.getName(emit)} _super;\n")
        } else {
            emit.write("\tstruct ${getName(emit)}_vtable* _vtable;\n")
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

        emit.write("struct ${getName(emit)}_vtable {\n")

        if(superclass != null) {
            emit.write("\tstruct ${superclass.getName(emit)}_vtable _vtable_super;\n")
        } else {
            emit.write("\tstruct _lang_vtable_head _header;\n")
        }

        for((name, symbol) in table.table) {
            /* data goes in struct */
            if(symbol.type is FunctionType && name != "construct") {
                emit.write("\t")
                symbol.type.emitVarDecl(emit, name)
            }
        }
        emit.write("};\n\n")
    }

    fun emitVtableInstance(emit: Emit) {
        emit.write("struct ${getName(emit)}_vtable ${getName(emit)}_vtable_inst = ")
        emitVtableInstanceBody(this, emit)
        emit.write(";\n")
        emitGCDeskGenerator(emit)
    }

    fun emitVtableInstanceHeader(emit: Emit) {
        emit.write("extern struct ${getName(emit)}_vtable ${getName(emit)}_vtable_inst;\n")
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

    /* return type of constructor */
    fun findConstructType(): FunctionType? {
        val c = table.findSymbol("construct")
        return c?.type as? FunctionType
    }

    fun emitVtableInstanceBody(type: ClassType, emit: Emit) {
        emit.write("{\n")
        for(field in type.table.table) {
            val f = field.value
            if(f.type !is FunctionType || (f.type as FunctionType).binding_type != FunctionType.Binding.CLASS || f.name == "construct") {
                continue;
            }
            val implementor = findImplementorMethod(f.name, this)
            if(implementor == null) {
                error("can't find method ${f.name} in table")
            }

            emit.write(".${f.name} = &${implementor.getName(emit)}_${f.name},\n")
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
                supervtable = "&${superclass.getName(emit)}_vtable_inst"
            }
            emit.write("._header = {\n.gc = {.type = OBJECT, .size = 0, .is_pointer = NULL},\n.parent_vtable = $supervtable,\n},\n")
        }
        emit.write("}")
    }

    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("struct $name*")
        return "struct $name*"
    }

    override fun getTypeName(): String {
        return shortName
    }

    /* get the properly prefixed name */
    override fun getName(emit: Emit): String {
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

    override fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
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
            emit.write("((struct ${implementor.getName(emit)}_vtable *)(((struct ${root.getName(emit)} *)(")
            type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
            emit.write("))->_vtable))->$name")
            return sym.type
        } else {
            emit.write("(")
            if (implementor != this) {
                emit.write("(struct ${implementor.getName(emit)} *)")
            }
            emit.write("(")
            type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
            emit.write("))")
            emit.write("->$name")

            return sym.type
        }
    }

    override fun emitFieldWrite(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, val_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        val type = emitFieldRead(name, type_visitor, emit, access_expr, scope, namespace)
        emit.write(" = ")
        val val_type = type_visitor.emitExprImplicitConvert(emit, type, val_expr, namespace, scope)
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
            if(name == "construct") return false
            return true
        }
        return false
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {

        val sym = table.findSymbol(name)
        if(sym == null) {
            error("invalid field read")
        }
        val implementor = findImplementor(name, this)
        if (implementor == null) {
            error("field implementor not found")
        }
        if(!(sym.type is FunctionType && (sym.type as FunctionType).binding_type == FunctionType.Binding.CLASS)) {
            /* TODO: call closure bounded functions */
            error("not a function field")
        }

        val root = findRootClass()
        val temp_this_level: Int
        if(emit !is DummyEmit) {
            temp_this_level = lang_temp_this_level++
        } else {
            temp_this_level = lang_temp_this_level
        }
        emit.write("(_lang_temp_this$temp_this_level = ")
        emit.write("(")
        type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
        emit.write("), ((struct ${implementor.getName(emit)}_vtable *)(((struct ${root.getName(emit)} *)_lang_temp_this$temp_this_level)->_vtable))->$name")
        emit.write("(_lang_temp_this$temp_this_level")

        if (func_expr.args.nodes.size > 0) emit.write(", ")
        if(func_expr.args.nodes.size != (sym.type as FunctionType).args.size) {
            compilerError("number of arguments (${func_expr.args.nodes.size}) doesn't match expected number of ${(sym.type as FunctionType).args.size}", if (func_expr.args.nodes.size > 0) func_expr.args.nodes[0].loc else func_expr.loc)
        }

        for (i in 0.until(func_expr.args.nodes.size)) {
            val type = type_visitor.emitExprImplicitConvert(emit, (sym.type as FunctionType).args[i], func_expr.args.nodes[i], namespace, scope)
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

    fun opToFuncName(op: ASTExprOp.ExprType): String {
        return when(op) {
            ASTExprOp.ExprType.ADD -> "_op_add"
            ASTExprOp.ExprType.SUB -> "_op_sub"
            ASTExprOp.ExprType.MULT -> "_op_mul"
            ASTExprOp.ExprType.DIV -> "_op_div"
            ASTExprOp.ExprType.MOD -> "_op_mod"
            ASTExprOp.ExprType.LSHFT -> "_op_lsh"
            ASTExprOp.ExprType.RSHFT -> "_op_rsh"
            ASTExprOp.ExprType.BINARY_AND -> "_op_and"
            ASTExprOp.ExprType.BINARY_OR -> "_op_or"
            ASTExprOp.ExprType.BINARY_XOR -> "_op_xor"
            ASTExprOp.ExprType.BINARY_NOT -> "_op_not"
            ASTExprOp.ExprType.LT -> "_op_lt"
            ASTExprOp.ExprType.LTE -> "_op_lte"
            ASTExprOp.ExprType.GT -> "_op_gt"
            ASTExprOp.ExprType.GTE -> "_op_gte"
            ASTExprOp.ExprType.EQ -> "_op_equals"
            ASTExprOp.ExprType.POSTFIX_INC -> "_op_postinc"
            ASTExprOp.ExprType.POSTFIX_DEC -> "_op_postdec"
            ASTExprOp.ExprType.PREFIX_INC -> "_op_preinc"
            ASTExprOp.ExprType.PREFIX_DEC -> "_op_predec"
            ASTExprOp.ExprType.NEGATIVE -> "_op_neg"
            ASTExprOp.ExprType.ARRAY -> "_op_array"
            else -> {
                error("logical ops invalid for op overloading")
            }
        }
    }

    override fun hasOpDefined(op: ASTExprOp.ExprType, other: Type?): Boolean {
        val op_func_name = opToFuncName(op)
        if(!hasFieldCall(op_func_name)) return false
        val type = (table.findSymbol(op_func_name)?.type as? FunctionType)
        if(type == null) return false
        val expect_len = if(ASTExprOp.ExprType.isUnary(op)) 0 else 1
        if(type.args.size != expect_len) return false
        if(expect_len == 1) {
            if(!other!!.canImplicitConvert(type.args[0])) return false
        }
        return true
    }

    override fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        val func = opToFuncName(op)
        val args = if(ASTExprOp.ExprType.isUnary(op)) mutableListOf<ASTExpr>() else mutableListOf(expr2!!)
        val dummyFunc = ASTFuncCallExpr(expr1.loc!!, ASTExpr(expr1.loc), ASTNodeArray(args))
        return emitFieldCall(func, type_visitor, emit, expr1, dummyFunc, scope, namespace)
    }

    fun emitGCDeskGenerator(emit: Emit) {
        emit.write("void _lang_make_gc_desk${getName(emit)}() {\n")
        emit.write("((struct _lang_vtable_head*)(&${getName(emit)}_vtable_inst))->gc.size = sizeof(struct ${getName(emit)});\n")
        emit.write("((struct _lang_vtable_head*)(&${getName(emit)}_vtable_inst))->gc.type = OBJECT;\n")
        emit.write("bool * is_pointer = _lang_gc_calloc_gc_desk_space(sizeof(struct ${getName(emit)})/sizeof(void *));\n")
        emit.write("((struct _lang_vtable_head*)(&${getName(emit)}_vtable_inst))->gc.is_pointer = is_pointer;")
        emitGCFields(this, emit)
        emit.write("}\n\n")
    }

    private fun emitGCFields(type: ClassType, emit: Emit) {
        val table = type.table
        for(sym in table.table) {
            if(sym.value.type !is FunctionType || (sym.value.type as FunctionType).binding_type != FunctionType.Binding.CLASS) {
                if(sym.value.type.isPointer()) {
                    emit.write("is_pointer[offsetof(struct ${type.getName(emit)}, ${sym.value.name})/sizeof(void *)] = 1;\n")
                }
            }
        }
        if(type.superclass != null) {
            emitGCFields(type.superclass as ClassType, emit)
        }
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

    override fun emitVarTypeDecl(emit: Emit): String {
        /*if(binding_type != Binding.CLOSURE) {
            println(binding_type)
            error("emitVarTypeDecl called on non closure binded function")
        }*/
        emit.write("_lang_closure*")
        return "_lang_closure*"
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
    override fun emitVarTypeDecl(emit: Emit): String {
        /* TODO: bound checked array (struct for each type of array used) */
        emit.write("_lang_array*")
        return "_lang_array*"
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
        return "_lang_array_make_empty(${type.isPointer()}, sizeof(${type.emitVarTypeDecl(DummyEmit())}))"
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

    override fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        when(op) {
            ASTExprOp.ExprType.ARRAY -> {
                emit.write("((")
                type.emitVarTypeDecl(emit)
                emit.write("*)((")
                type_visitor.visitASTExpr(expr1, scope, namespace, emit)
                emit.write(")->vals))[")
                type_visitor.visitASTExpr(expr2!!, scope, namespace, emit)
                emit.write("]")
                return type
            }
            ASTExprOp.ExprType.ADD -> {
                emit.write("_lang_array_cat(")
                type_visitor.visitASTExpr(expr1, scope, namespace, emit)
                emit.write(", ")
                type_visitor.visitASTExpr(expr2!!, scope, namespace, emit)
                emit.write(", ${type.isPointer()})")
                return this
            }
            ASTExprOp.ExprType.LSHFT -> {
                emit.write("_lang_array_add_${if(type.isPointer()) "pointer" else type.getTypeName()}(")
                type_visitor.visitASTExpr(expr1, scope, namespace, emit)
                emit.write(", ")
                type_visitor.visitASTExpr(expr2!!, scope, namespace, emit)
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

    override fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        when(name) {
            "len" -> {
                emit.write("(")
                type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
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

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        when(name) {
            "removeAt" -> {
                if(func_expr.args.nodes.size != 1) {
                    compilerError("number of arguments (${func_expr.args.nodes.size}) doesn't match expected number of 1", if(func_expr.args.nodes.size > 0) func_expr.args.nodes[0].loc else func_expr.loc)
                }
                emit.write("_lang_array_remove_at(")
                type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
                emit.write(", ")
                val type = type_visitor.emitExprImplicitConvert(emit, LongType(), func_expr.args.nodes[0], namespace, scope)
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
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("void")
        return "void"
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

class NullType: Type() {
    override fun equals(other: Any?): Boolean {
        return other is NullType
    }

    override fun canImplicitConvert(other: Type): Boolean {
        return other.isPointer() || other is BooleanType
    }

    override fun isPointer(): Boolean {
        return true
    }

    override fun getTypeName(): String {
        return "null"
    }

    override fun toString(): String {
        return "null"
    }

    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("void * ")
        return "void *"
    }
}

/* primative boolean type */
class BooleanType: Type() {
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("bool")
        return "bool"
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
    /* not really long, but long by default if not cast to anything */
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("long")
        return "long"
    }

    override fun getTypeName(): String {
        return "long"
    }

    override fun equals(other: Any?): Boolean {
        return other is LongType
    }


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

    override fun emitOp(op: ASTExprOp.ExprType, type_visitor: ASTTypeCheckVisitor, emit: Emit, expr1: ASTExpr, expr2: ASTExpr?, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        if(ASTExprOp.ExprType.isUnary(op)){
            val typ: Type
            when(op) {
                ASTExprOp.ExprType.POSTFIX_INC -> {
                    emit.write("(")
                    typ = type_visitor.visitASTExpr(expr1, scope, namespace, emit)
                    emit.write("++)")
                }
                ASTExprOp.ExprType.POSTFIX_DEC -> {
                    emit.write("(")
                    typ = type_visitor.visitASTExpr(expr1, scope, namespace, emit)
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
                    typ = type_visitor.visitASTExpr(expr1, scope, namespace, emit)
                    emit.write(")")
                }
            }
            return if(typ is FloatingType) FloatingType() else NumberType()
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
            val typ1 = type_visitor.visitASTExpr(expr1, scope, namespace, emit)
            emit.write(op_str)
            val typ2 = type_visitor.visitASTExpr(expr2!!, scope, namespace, emit)
            emit.write(")")
            return if(op == ASTExprOp.ExprType.EQ) BooleanType() else (if(typ1 is FloatingType || typ2 is FloatingType) FloatingType() else NumberType())
        }
    }

    override fun hasFieldCall(name: String): Boolean {
        return when(name) {
            "to_string" -> true
            else -> false
        }
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        when(name) {
            "to_string" -> {
                emit.write("_lang_num_to_string(")
                type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
                emit.write(")")
                return ArrayType(CharType(), null)
            }
            else -> error("no such field call $name")
        }
    }
}

/* primative int type */
class IntType : NumberType() {
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("int")
        return "int"
    }

    override fun getTypeName(): String {
        return "int"
    }

    override fun equals(other: Any?): Boolean {
        return other is IntType
    }

}

class LongType: NumberType(){
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("long")
        return "long"
    }

    override fun getTypeName(): String {
        return "long"
    }

    override fun equals(other: Any?): Boolean {
        return other is LongType
    }
}

class CharType: NumberType() {
    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("char")
        return "char"
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

open class FloatingType: NumberType() {

    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("double")
        return "double"
    }

    override fun getTypeName(): String {
        return "double"
    }

    override fun getCZeroValue(): String {
        return "0.0"
    }

    override fun equals(other: Any?): Boolean {
        return other is FloatingType
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        when(name) {
            "to_string" -> {
                emit.write("_lang_float_to_string(")
                type_visitor.visitASTExpr(access_expr, scope, namespace, emit)
                emit.write(")")
                return ArrayType(CharType(), null)
            }
            else -> error("no such field call $name")
        }
    }
}

class FloatType: FloatingType() {

    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("float")
        return "float"
    }

    override fun getTypeName(): String {
        return "float"
    }

    override fun equals(other: Any?): Boolean {
        return  other is FloatType
    }
}

class DoubleType: FloatingType() {

    override fun emitVarTypeDecl(emit: Emit): String {
        emit.write("double")
        return "double"
    }

    override fun getTypeName(): String {
        return "double"
    }

    override fun equals(other: Any?): Boolean {
        return other is DoubleType
    }
}

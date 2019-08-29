package compiler

import ast.ASTExpr
import ast.ASTFuncCallExpr
import ast.ASTNode
import ast.ASTNodeArray

class Namespace (val parent: Namespace?, val name: String, val table: SymbolTable): Type() {
    fun getPrefix(): String {
        if(parent != null && parent.getPrefix() != "") {
            return "${parent.getPrefix()}__$name"
        } else {
            return name
        }
    }

    fun getName(name: String, emit: Emit): String {
        if(getPrefix() == "") {
            return emit.getID(name)
        } else {
            return "${emit.getID(getPrefix())}__$name"
        }
    }

    override fun getTypeName(): String {
        return "namespace $name"
    }

    override fun hasField(name: String): FieldType {
        val sym = table.findSymbolNoParent(name)
        if(sym == null) {
            return FieldType.NONE
        } else {
            if(sym.mutable == Symbol.Mutability.IMUT) {
                return FieldType.READONLY
            } else if (sym.mutable == Symbol.Mutability.MUT) {
                return FieldType.READWRITE
            } else {
                error("no such mutability type")
            }
        }
    }

    override fun emitFieldRead(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        val sym = table.findSymbolNoParent(name)!!
        if(sym.type is Namespace) {
            return sym.type
        }
        emit.write(this.getName(name, emit))
        return sym.type
    }

    override fun emitFieldWrite(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, val_expr: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        val sym = table.findSymbolNoParent(name)!!
        if(sym.type is Namespace) {
            compilerError("can't reassign namespace", access_expr.loc)
        }
        emit.write(this.getName(name, emit))
        emit.write(" = ")
        val typ = type_visitor.emitExprImplicitConvert(emit, sym.type, val_expr, namespace, scope)
        if(!typ.canImplicitConvert(sym.type)) {
            compilerError("type of value being assigned ($typ) does not match expected type (${sym.type})", val_expr.loc)
        }

        return sym.type
    }

    override fun hasFieldCall(name: String): Boolean {
        val sym = table.findSymbolNoParent(name)
        return if(sym == null) {
            false
        } else sym.type is FunctionType
    }

    override fun emitFieldCall(name: String, type_visitor: ASTTypeCheckVisitor, emit: Emit, access_expr: ASTExpr, func_expr: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace): Type {
        val sym = table.findSymbolNoParent(name)!!
        val ftyp = (sym.type as FunctionType)

        if(ftyp.binding_type != FunctionType.Binding.GLOBAL) {
            error("non global function call")
        }

        if(ftyp.args.size != func_expr.args.nodes.size) {
            compilerError("number of arguments (${func_expr.args.nodes.size}) doesn't match expected number of ${ftyp.args.size}", if(func_expr.args.nodes.size > 0) func_expr.args.nodes[0].loc else func_expr.loc)
        }

        this.emitFieldRead(name, type_visitor, emit, access_expr, scope, namespace)
        emit.write("(NULL")
        for(i in 0.until(func_expr.args.nodes.size)) {
            emit.write(", ")
            val arg = func_expr.args.nodes[i]
            val etyp = ftyp.args[i]
            val rtyp = type_visitor.emitExprImplicitConvert(emit, etyp, arg, namespace, scope)
            if(!rtyp.canImplicitConvert(etyp)) {
                compilerError("type of arg ($rtyp) doesn't match expected type of $etyp", arg.loc)
            }
        }

        return ftyp.return_type!!
    }

}
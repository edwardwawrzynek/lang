package compiler

import ast.*

/* general arguments to visit functions:
ast: ast node to be visited
fun_ast: ASTNodeArray of function statements are in, or null
parent_scope: SymbolTable of parent scope to link to current scope
classTable: global table of classes
 */

/* pass to construct symbol tables, and mark variable types (TODO: including finding escaping variables and marking them) */
/* also emits some function headers */
class ASTSymbolConstructVisitor {
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, fun_ast: ASTNodeArray<ASTNode>?, parent_scope: SymbolTable?, classTable: SymbolTable, emit: Emit) {
        /* link scope of objects */
        if(ast.scope === parent_scope) {
            if(!ast.is_proto_decl){
                compilerError("ast scope and parent scope matches", ast.loc)
            }
        } else {
            ast.setParentScope(parent_scope)
        }
        /* set nested function links */
        ast.fun_scope = fun_ast
        ast.higher_fun_scope = fun_ast?.higher_fun_scope

        for(node in ast.nodes){
            when(node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, fun_ast, ast.scope, classTable, false, null, emit)
                is ASTVarDecl -> visitASTVarDecl(node, fun_ast, ast.scope, classTable, false, null, emit)
                is ASTBlockStmnt -> visitASTBlockStmnt(node, fun_ast, ast.scope, classTable, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, fun_ast, ast.scope, classTable, emit)
                is ASTNodeArray<*> -> {
                    if(node.is_proto_decl){
                        node.scope = ast.scope
                    }
                    visitASTNodeArray(node as ASTNodeArray<ASTNode>, fun_ast, ast.scope, classTable, emit)
                }
            }
        }

    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean, encl_class: ASTClassDeclStmnt?, emit: Emit) {
        ast.body.fun_scope = ast.body
        ast.body.higher_fun_scope = fun_ast

        if(scope.findSymbolNoParent(ast.name) != null){
            compilerError("Redefinition of function ${ast.name}", ast.loc)
        }
        if(scope.findSymbol(ast.name) != null){
            warning("Function ${ast.name} shadows higher variable\n", ast.loc)
        }

        val storage: Symbol.StorageType

        if(is_class_var){
            if(fun_ast != null){
                compilerError("Functions marked with is_class_var can't be in a function", null)
            }
            storage = Symbol.StorageType.CLASSFUNC
        } else {
            if(fun_ast == null){
                storage = Symbol.StorageType.GLBFUNC
            } else {
                storage = Symbol.StorageType.NESTFUNC
            }
        }

        val name = if(is_class_var) "${emit.getID(encl_class!!.name)}_${ast.getEmitName(ast.body)}" else emit.getID(ast.getEmitName(ast.body))
        val symbol = Symbol(name, Symbol.Mutability.IMUT, Type.fromASTType(ast.type, classTable, FunctionType.Binding.fromStorageType(storage)), storage, ast)

        if(storage == Symbol.StorageType.CLASSFUNC){
            val class_sym = classTable.findSymbol(encl_class!!.name)
            if(class_sym == null){
                compilerError("can't find class ${encl_class.name} in classTable", null)
            }
            symbol.of_class = (class_sym.type as ClassType)
        }

        scope.addSymbol(ast.name, symbol)

        /* emit header */
        val args = (symbol.type as FunctionType).args
        if(ast.body.higher_fun_scope != null){
            emit.write("static ")
        }
        (symbol.type as FunctionType).return_type!!.emitVarTypeDecl(emit)

        emit.write(" ${symbol.name}(void *${if (args.isNotEmpty()) ", " else ""}")

        for (i in 0.until(args.size)) {
            args[i].emitVarTypeDecl(emit)
            if (i < args.size - 1) {
                emit.write(", ")
            }
        }

        emit.write(");\n")

        /* add args to function scope */
        for(arg in ast.type.args){
            ast.body.setParentScope(scope)
            visitASTVarDecl(arg, ast.body, ast.body.scope, classTable, false, null, emit)
        }

        visitASTNodeArray(ast.body, ast.body, scope, classTable, emit)
    }

    fun visitASTVarDecl(ast: ASTVarDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean, encl_class: ASTClassDeclStmnt?, emit: Emit) {
        /* TODO: infer type */
        if(scope.findSymbolNoParent(ast.name) != null){
            compilerError("Redefinition of variable ${ast.name}", ast.loc)
        }
        if(scope.findSymbol(ast.name) != null){
            warning("Variable ${ast.name} shadows higher variable\n", ast.loc)
        }

        val storage: Symbol.StorageType

        if(is_class_var){
            if(fun_ast != null){
                compilerError("Variables marked with is_class_var can't be in a function", null)
            }
            storage = Symbol.StorageType.CLASSVAR
        } else {
            if(fun_ast == null){

                storage = Symbol.StorageType.GLOBAL
            } else {
                /* TODO: NONLOCAL */
                storage = Symbol.StorageType.LOCAL
            }
        }

        val symbol = Symbol(if(storage==Symbol.StorageType.GLOBAL) "__${ast.name}" else ast.name, Symbol.fromASTMut(ast.mutable), Type.fromASTType(ast.type, classTable, FunctionType.Binding.fromStorageType(storage)), storage, ast)


        if(storage == Symbol.StorageType.CLASSVAR){
            val class_sym = classTable.findSymbol(encl_class!!.name)
            if(class_sym == null){
                compilerError("can't find class ${encl_class.name} in classTable", null)
            }
            symbol.of_class = (class_sym.type as ClassType)
        }

        scope.addSymbol(ast.name, symbol)
    }

    fun visitASTBlockStmnt(ast: ASTBlockStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, emit: Emit) {
        if(ast is ASTForStmnt && ast.inital is ASTVarDecl) {
            visitASTVarDecl(ast.inital, fun_ast, scope, classTable, false, null, emit)
        }
        visitASTNodeArray(ast.getBlock(), fun_ast, scope, classTable, emit)
    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, emit: Emit) {
        ast.setParentScope(scope)

        for(field in ast.fields.nodes){
            visitASTVarDecl(field, fun_ast, ast.scope, classTable, true, ast, emit)
        }

        for(method in ast.methods.nodes){
            /* emit header */
            visitASTFuncDecl(method, fun_ast, ast.scope, classTable, true, ast, emit)
        }

        val cls = classTable.findSymbol(ast.name)
        if(cls == null || cls.type !is ClassType) {
            error("can't find class with name ${ast.name}")
        }
        val cons_type = (cls.type as ClassType).findConstructType()
        if(cons_type == null) {
            compilerError("class ${ast.name} does not have a constructor", ast.loc)
        }

        val func_type = FunctionType(cls.type, cons_type.args, FunctionType.Binding.GLOBAL)

        /* add constructor function */
        scope.addSymbol(ast.name, Symbol(
                emit.getID(ast.name),
                Symbol.Mutability.IMUT,
                func_type,
                Symbol.StorageType.GLBFUNC,
                fun_ast
        ))

        /* emit header */
        func_type.return_type!!.emitVarTypeDecl(emit)

        emit.write(" ${emit.getID(cls.type.getTypeName())}(void *${if (func_type.args.isNotEmpty()) ", " else ""}")

        for (i in 0.until(func_type.args.size)) {
            func_type.args[i].emitVarTypeDecl(emit)
            if (i < func_type.args.size - 1) {
                emit.write(", ")
            }
        }

        emit.write(");\n")

        /* add symbols from superclasses to scope (note: all CLASS or CLASSFUNC bound vars eventually just go through ClassType's hasField or hasFieldCall */
        fun addInheritedSyms(type: ClassType) {
            for ((name, sym) in type.table.table) {
                if(ast.scope.findSymbolNoParent(name) == null) {
                    sym.is_declared = true
                    sym.of_class = cls.type as ClassType
                    ast.scope.addSymbol(name, sym)
                }
            }
            if(type.superclass != null){
                addInheritedSyms(type.superclass)
            }
        }
        addInheritedSyms(cls.type as ClassType)

        /* add this reference */
        val sym = Symbol(
            "this",
            Symbol.Mutability.IMUT,
            cls.type,
            Symbol.StorageType.CLASS,
            fun_ast
            )
        sym.is_declared = true
        sym.of_class = cls.type as ClassType

        ast.scope.addSymbol("this", sym)
    }
}
package compiler

import ast.*

/* add headers for all class types */
fun astToClassNames (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable) {
    /* TODO: nested classes */
    for(node in ast.nodes) {
        if (node is ASTClassDeclStmnt) {
            var parent: Symbol? = null
            if (node.superclass != null) {
                parent = classTable.findSymbol(node.superclass)
                if(parent == null){
                    compilerError("Superclass ${node.superclass} of class ${node.name} is not defined", node.loc)
                }
            }
            val table = if (parent != null) (parent.type as ClassType).table else null
            val super_type = if (parent != null) (parent.type as ClassType) else null
            val type = ClassType(node.name, SymbolTable(table), super_type)
            type.table.parent = super_type?.table
            /* mutability is irelevant */
            /* TODO: namespacing */
            classTable.addSymbol(node.name, Symbol(node.name, Symbol.Mutability.IMUT, type, Symbol.StorageType.CLASS, node))
        }
        if (node is ASTNodeArray<*> && node.is_proto_decl){
            astToClassNames(node as ASTNodeArray<ASTNode>, classTable)
        }
    }
}

/* build type entries for all classes (needs to be seperate from astToClassNames for mutually recursive classes) */
fun astToClassTypes (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable) {
    for(node in ast.nodes) {
        if (node is ASTClassDeclStmnt) {
            val entry = classTable.findSymbol(node.name)
            if (entry == null) {
                compilerError("No class header in classTable for class ${node.name}", node.loc)
            } else {
                val type = (entry.type as ClassType)
                val table = type.table

                for (field in node.fields.nodes) {
                    val s = table.findSymbol(field.name)
                    val field_type = Type.fromASTType(field.type, classTable, FunctionType.Binding.CLASS)

                    if(s != null) {
                        if(s.type != field_type) {
                            compilerError("type of field ${field.name} ($field_type) doesn't match type declared in superclass (${s.type})", field.loc)
                        }
                        continue
                    }

                    val sym = Symbol(
                        field.name,
                        Symbol.fromASTMut(field.mutable),
                        field_type,
                        Symbol.StorageType.CLASSVAR,
                        field.type!!)
                    table.addSymbol(field.name, sym)

                }

                for (method in node.methods.nodes) {
                    val s = table.findSymbol(method.name)
                    val method_type = Type.fromASTType(method.type, classTable, FunctionType.Binding.CLASS)

                    if(s != null) {
                        if(s.type != method_type) {
                            compilerError("type of method ${method.name} ($method_type) doesn't match type declared in superclass (${s.type})", method.loc)
                        }
                        continue
                    }

                    val sym = Symbol(
                        method.name,
                        Symbol.Mutability.IMUT,
                        method_type,
                        Symbol.StorageType.CLASSFUNC,
                        method.type)
                    /* mutability is irrelevant */
                    table.addSymbol(method.name, sym)
                }

            }
        }
        if (node is ASTNodeArray<*> && node.is_proto_decl){
            astToClassTypes(node as ASTNodeArray<ASTNode>, classTable)
        }
    }
}

/* emit class shape declarations given a class table */
fun classTableEmitShapeDecl(emit: Emit, classTable: SymbolTable) {
    /* headers */
    emit.write("/* --- Class Struct Declarations --- */\n")
    for(key in classTable.getKeys()) {
        val sym = classTable.findSymbol(key)!!
        if(sym.type is ClassType) {
            (sym.type as ClassType).emitShapeDeclHeader(emit)
        }
    }
    emit.write("/* --- Class Struct Definitions --- */\n")
    /* bodies */
    val emitted = mutableListOf<ClassType>()
    for(key in classTable.getKeys()) {
        val sym = classTable.findSymbol(key)!!

        fun emitClass(c: ClassType, emit: Emit) {
            if(c in emitted){
                return
            }
            if(c.superclass != null){
                emitClass(c.superclass, emit)
            }
            c.emitShapeDecl(emit)
            emitted.add(c)
        }
        
        if(sym.type is ClassType) {
            emitClass(sym.type as ClassType, emit)
        }
    }

}


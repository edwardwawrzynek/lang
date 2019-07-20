package compiler

import ast.*

/* add headers for all class types */
fun astToClassNames (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable, namespace: Namespace?) {
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
            val name = namespace?.getName(node.name, DummyEmit()) ?: DummyEmit().getID(node.name)
            val type = ClassType(name, node.name, SymbolTable(table), super_type)
            type.table.parent = super_type?.table

            val ctable = if(namespace == null) classTable else namespace.table
            ctable.addSymbol(node.name, Symbol(node.name, Symbol.Mutability.IMUT, type, Symbol.StorageType.CLASS, node))

        } else if (node is ASTNodeArray<*> && node.is_proto_decl){
            astToClassNames(node as ASTNodeArray<ASTNode>, classTable, namespace)

        } else if (node is ASTNamespaceStmnt) {
            val ctable = if(namespace == null) classTable else namespace.table
            val newNamespace: Namespace
            val exists = ctable.findSymbolNoParent(node.name)
            if(exists != null){
                if(exists.type == null || exists.type !is Namespace) {
                    compilerError("namespace ${node.name}'s name conflicts with existing class ${node.name}", node.loc)
                } else {
                    newNamespace = exists.type as Namespace
                }
            } else {
                newNamespace = Namespace(namespace, node.name, SymbolTable(null))
            }
            ctable.addSymbol(node.name, Symbol(node.name, Symbol.Mutability.IMUT, newNamespace, Symbol.StorageType.NAMESPACE, node))
            astToClassNames(node.body, classTable, newNamespace)
        }
    }
}

/* build type entries for all classes (needs to be seperate from astToClassNames for mutually recursive classes) */
fun astToClassTypes (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable, namespace: Namespace?) {
    for(node in ast.nodes) {
        if (node is ASTClassDeclStmnt) {
            val entry = classTable.findSymbolByNamespaceName(namespace, node.name)
            if (entry == null) {
                compilerError("No class header in classTable for class ${node.name}", node.loc)
            } else {
                val type = (entry.type as ClassType)
                val table = type.table

                for (field in node.fields.nodes) {
                    val s = table.findSymbol(field.name)
                    val field_type = Type.fromASTType(field.type, classTable, FunctionType.Binding.CLASS, namespace)

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
                    val method_type = Type.fromASTType(method.type, classTable, FunctionType.Binding.CLASS, namespace)

                    if(s != null && method.name != "construct") {
                        if(s.type != method_type) {
                            compilerError("type of method ${method.name} ($method_type) doesn't match type declared in superclass (${s.type})", method.loc)
                        }
                        type.overridden_methods.add(method.name)
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
            astToClassTypes(node as ASTNodeArray<ASTNode>, classTable, namespace)
        }
        if(node is ASTNamespaceStmnt) {
            val child_namesp: Type?
            if(namespace == null) {
                child_namesp = classTable.findSymbol(node.name)?.type
            } else {
                child_namesp = namespace.table.findSymbol(node.name)?.type
            }
            if(child_namesp == null || child_namesp !is Namespace) {
                error("can't find namespace ${node.name}")
            }
            astToClassTypes(node.body, classTable, child_namesp)
        }
    }
}

/* emit class shape declarations given a class table */
fun classTableEmitShapeDecl(emit: Emit, classTable: SymbolTable, emitted: MutableList<ClassType>) {
    /* headers */
    emit.write("/* --- Class Struct Declarations --- */\n")
    for(key in classTable.getKeys()) {
        val sym = classTable.findSymbol(key)!!
        if(sym.type is ClassType) {
            (sym.type as ClassType).emitShapeDeclHeader(emit)
        }
        if(sym.type is Namespace) {
            classTableEmitShapeDecl(emit, (sym.type as Namespace).table, emitted)
        }
    }
    emit.write("/* --- Class Struct Definitions --- */\n")
    /* bodies */
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

/* emit class vtable instances */
fun classTableEmitVtableInstances(emit: Emit, classTable: SymbolTable) {
    emit.write("/* --- Class VTable Instances --- */\n")
    classTableEmitVtableHeaders(emit, classTable)
    emit.write("\n")
    classTableEmitVtableBodies(emit, classTable)

}

fun classTableEmitVtableHeaders(emit: Emit, classTable: SymbolTable) {
    for(key in classTable.getKeys()) {
        val sym = classTable.findSymbol(key)!!
        if(sym.type is ClassType) {
            (sym.type as ClassType).emitVtableInstanceHeader(emit)
        } else if(sym.type is Namespace) {
            classTableEmitVtableHeaders(emit, (sym.type as Namespace).table)
        }
    }
}

fun classTableEmitVtableBodies(emit: Emit, classTable: SymbolTable) {
    for(key in classTable.getKeys()) {
        val sym = classTable.findSymbol(key)!!
        if(sym.type is ClassType) {
            (sym.type as ClassType).emitVtableInstance(emit)
        } else if(sym.type is Namespace) {
            classTableEmitVtableBodies(emit, (sym.type as Namespace).table)
        }
    }
}

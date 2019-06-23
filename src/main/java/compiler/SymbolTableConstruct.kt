package compiler

import ast.*

/* add headers for all class types */
fun astToClassNames (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable) {
    /* TODO: nested classes */
    for(node in ast.nodes) {
        if (node is ASTClassDeclStmnt) {
            var parent: Symbol? = null
            if (node.superclass != null) {
                parent = classTable.findSymbol(node.superclass!!)
                if(parent == null){
                    error("Superclass ${node.superclass} of class ${node.name} is not defined", node.loc)
                }
            }
            val table = if (parent != null) (parent.type as ClassType).table else null
            val super_type = if (parent != null) (parent.type as ClassType) else null
            val type = ClassType(node.name, SymbolTable(table), super_type)
            /* mutability is irelevant */
            classTable.addSymbol(node.name, Symbol(node.name, Symbol.Mutability.IMUT, type))
        }
    }
}

/* build type entries for all classes (needs to be seperate from astToClassNames for mutually recursive classes) */
fun astToClassTypes (ast: ASTNodeArray<ASTNode>, classTable: SymbolTable) {
    /* TODO: nested classes */
    for(node in ast.nodes) {
        if (node is ASTClassDeclStmnt) {
            val entry = classTable.findSymbol(node.name)
            if (entry == null) {
                error("No class header in classTable for class ${node.name}", node.loc)
            } else {
                val table = (entry.type as ClassType).table

                for (field in node.fields.nodes) {

                    table.addSymbol(field.name, Symbol(
                            field.name,
                            Symbol.fromASTMut(field.mutable),
                            Type.fromASTType(field.type, classTable))
                    )
                }

                for (method in node.methods.nodes) {
                    /* mutability is irelevant */
                    table.addSymbol(method.name, Symbol(
                            method.name,
                            Symbol.Mutability.IMUT,
                            Type.fromASTType(method.type, classTable)
                    ))
                }

            }
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
    val emitted = mutableListOf<String>()
    for(key in classTable.getKeys()) {
        if(key in emitted){
            continue
        }
        val sym = classTable.findSymbol(key)!!

        fun emitClass(c: ClassType, emit: Emit) {
            if(c.superclass != null){
                emitClass(c.superclass, emit)
            }
            c.emitShapeDecl(emit)
            emitted.add(c.name)
        }
        
        if(sym.type is ClassType) {
            emitClass(sym.type as ClassType, emit)
        }
    }

}


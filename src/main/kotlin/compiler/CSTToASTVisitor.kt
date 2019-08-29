package compiler

import parser.*
import org.antlr.v4.runtime.*

import ast.*
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.ArrayList
import java.lang.Exception
import kotlin.system.exitProcess

class CSTToASTVisitor : LangBaseVisitor<ASTNode>() {

    override fun visitProgram(ctx: LangParser.ProgramContext): ASTNodeArray<ASTNode> {
        val nodes = mutableListOf<ASTNode>()
        for (stat in ctx.statement()) {
            val res = visitStatement(stat)
            if (res == null){
               //Nothing to do
            } else if (res is ASTNodeArray<*>) {
                nodes.addAll(res.nodes as MutableList<ASTNode>)
            } else {
                val n = visitStatement(stat)
                if(n != null) {
                    nodes.add(n)
                }
            }
        }

        return ASTNodeArray(nodes)
    }

    fun visitStatement(ctx: LangParser.StatementContext): ASTNode? {
        if (ctx is LangParser.IfStmntContext) {
            return ASTIfStmnt(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.cond), visitBlock(ctx.code))
        } else if (ctx is LangParser.ElseStmntContext) {
            return ASTElseStmnt(ASTFileLocation.fromToken(ctx.start), visitBlock(ctx.code))
        } else if (ctx is LangParser.ElseIfStmntContext) {
            return ASTElseIfStmnt(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.cond), visitBlock(ctx.code))
        } else if (ctx is LangParser.WhileStmntContext) {
            return ASTWhileStmnt(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.cond), visitBlock(ctx.code))
        } else if (ctx is LangParser.DoWhileStmntContext) {
            return ASTDoWhileStmnt(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.cond), visitBlock(ctx.code))
        } else if (ctx is LangParser.ForStmntContext) {
            val init: ASTNode?
            if (ctx.init.expr() != null) {
                init = visitExpr(ctx.init.expr())
            } else {
                init = visitVarDecl(ctx.init.varDecl()).nodes[0]
            }
            val res = ASTForStmnt(ASTFileLocation.fromToken(ctx.start), init, visitExpr(ctx.rep), visitExpr(ctx.end), visitBlock(ctx.code))
            return ASTNodeArray(mutableListOf(ASTNodeArray(mutableListOf(res))))
        } else if (ctx is LangParser.ReturnStmntContext) {
            val expr = if(ctx.`val` != null) visitExpr(ctx.`val`) else null
            return ASTReturnStmnt(ASTFileLocation.fromToken(ctx.start), expr)
        } else if (ctx is LangParser.ContinueStmntContext) {
            return ASTContinueStmnt(ASTFileLocation.fromToken(ctx.start))
        } else if (ctx is LangParser.BreakStmntContext) {
            return ASTBreakStmnt(ASTFileLocation.fromToken(ctx.start))
        } else if (ctx is LangParser.FuncDeclStmntContext) {
            return visitFuncDecl(ctx.function)
        } else if (ctx is LangParser.ClassDeclStmntContext) {
            val type: ASTClassDeclStmnt.Type
            if (ctx.classType.classType.type == LangParser.CLASS_CLASS) {
                type = ASTClassDeclStmnt.Type.CLASS
            } else if (ctx.classType.classType.type == LangParser.CLASS_OBJECT) {
                type = ASTClassDeclStmnt.Type.OBJECT
            } else if (ctx.classType.classType.type == LangParser.CLASS_STRUCT) {
                type = ASTClassDeclStmnt.Type.STRUCT
            } else {
                compilerError("no such class declaration type", ASTFileLocation.fromToken(ctx.start))
            }
            val name = ctx.classType.name.text
            val superclass: String?
            if (ctx.classType.parentClass != null) {
                superclass = ctx.classType.parentClass.text
            } else {
                superclass = null
            }
            val body = visitBlock(ctx.classType.body)
            val fields = ArrayList<ASTVarDecl>()
            val methods = ArrayList<ASTFuncDecl>()
            for (i in body.nodes.indices) {
                val n = body.nodes[i]
                if (n is ASTVarDecl) {
                    fields.add(n)
                } else if (n is ASTFuncDecl) {
                    methods.add(n)
                } else {
                    compilerError("only field and method declarations are allowed in a class", ASTFileLocation.fromToken(ctx.classType.body.statement(i).start))
                }
            }
            return ASTClassDeclStmnt(ASTFileLocation.fromToken(ctx.start), name, ASTNodeArray(fields), ASTNodeArray(methods), type, superclass)

        } else if (ctx is LangParser.ExprStmntContext) {
            return visitExpr(ctx.expr())

        } else if (ctx is LangParser.VarDeclStmntContext) {
            return visitVarDecl(ctx.decl)
        } else if (ctx is LangParser.DeclareProtoStmntContext){
            val res = visitBlock(ctx.protos)
            res.is_proto_decl = true
            return ASTNodeArray(mutableListOf(res))
        } else if (ctx is LangParser.NamespaceStmntContext) {
            return ASTNamespaceStmnt(ASTFileLocation.fromToken(ctx.start), ctx.name.text, visitBlock(ctx.cont))
        } else {
            println("No such statement context type")
            exitProcess(0)
        }
    }

    override fun visitFuncDecl(ctx: LangParser.FuncDeclContext): ASTNode {
        val type = visitFuncTypeWithBody(ctx.function.typeName)
        val body = visitBlock(ctx.function.code)
        return ASTFuncDecl(ASTFileLocation.fromToken(ctx.start), ctx.name.text, type, body)
    }

    private fun concatTypeName(list: MutableList<TerminalNode>): String {
        var res: String = ""
        for(i in 0.until(list.size)) {
            val l = list[i]
            res += l.text
            if(i < list.size -1) {
                res += "."
            }
        }
        return res
    }

    override fun visitTypeDecl(ctx: LangParser.TypeDeclContext): ASTType {
        /* handle array */
        if (ctx.arrayDecl() != null) {
            val length = -1

            if (ctx.ID() != null) {
                return ASTArrayType(ASTFileLocation.fromToken(ctx.start), concatTypeName(ctx.ID()), length)
            } else {
                /* handle function type */
                val funcType = visitFuncType(ctx.funcType())
                return ASTArrayFuncType(ASTFileLocation.fromToken(ctx.start), funcType.args, funcType.ret_type, length)
            }
        } else {
            return if (ctx.ID() != null) {
                ASTType(ASTFileLocation.fromToken(ctx.start), concatTypeName(ctx.ID()))
            } else {
                /* handle function type */
                visitFuncType(ctx.funcType())
            }
        }
    }

    override fun visitFuncArgVarType(ctx: LangParser.FuncArgVarTypeContext): ASTNodeArray<ASTVarDecl> {
        val decls = ArrayList<ASTVarDecl>()
        val type = visitTypeDecl(ctx.typeName)
        var mut = ASTVarDecl.VarMut.IMUT
        if (ctx.mut != null) {
            if (ctx.mut.text == "var") {
                mut = ASTVarDecl.VarMut.MUT
            } else if (ctx.mut.text == "val") {
                mut = ASTVarDecl.VarMut.IMUT
            }
        }
        for (i in 0 until ctx.ID().size) {
            val decl = ASTVarDecl(ASTFileLocation.fromToken(ctx.start), ctx.ID(i).text, type, null, mut)
            decls.add(decl)
        }

        return ASTNodeArray(decls)
    }

    override fun visitFuncType(ctx: LangParser.FuncTypeContext): ASTFuncType {
        val ret_type: ASTType?
        if (ctx.retType == null) {
            ret_type = null
        } else {
            ret_type = visitTypeDecl(ctx.retType)
        }
        val args = ArrayList<ASTVarDecl>()
        if (ctx.args != null) {
            for (i in 0 until ctx.args.funcArgVarType().size) {
                val t = visitFuncArgVarType(ctx.args.funcArgVarType(i))
                args.addAll(t.nodes)
            }
        }
        return ASTFuncType(ASTFileLocation.fromToken(ctx.start), args, ret_type)
    }

    override fun visitFuncTypeWithBody(ctx: LangParser.FuncTypeWithBodyContext): ASTFuncType {
        val ret_type: ASTType?
        if (ctx.retType == null) {
            ret_type = null
        } else {
            ret_type = visitTypeDecl(ctx.retType)
        }
        val args = ArrayList<ASTVarDecl>()
        if (ctx.args != null) {
            for (i in 0 until ctx.args.funcArgVarType().size) {
                val t = visitFuncArgVarType(ctx.args.funcArgVarType(i))
                args.addAll(t.nodes)
            }
        }
        return ASTFuncType(ASTFileLocation.fromToken(ctx.start), args, ret_type)
    }

    fun visitExpr(ctx: LangParser.ExprContext): ASTExpr {
        if (ctx is LangParser.ParenExprContext) {
/* parens don't do anything */
            return visitExpr(ctx.expr())

        } else if (ctx is LangParser.FuncExprContext) {
            val args = ArrayList<ASTExpr>()
            for (i in 0 until ctx.args.expr().size) {
                args.add(visitExpr(ctx.args.expr(i)))
            }
            return ASTFuncCallExpr(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.name), ASTNodeArray(args))

        } else if (ctx is LangParser.ArrayExprContext) {
            val array = visitExpr(ctx.varName)
            return ASTExprOp(ASTFileLocation.fromToken(ctx.start), ASTExprOp.ExprType.ARRAY, array, visitExpr(ctx.sub))

        } else if (ctx is LangParser.DotExprContext) {
            return ASTDotExpr(ASTFileLocation.fromToken(ctx.start), visitExpr(ctx.varName), visitExpr(ctx.sub))

        } else if (ctx is LangParser.PostfixExprContext) {
            val type: ASTExprOp.ExprType
            if (ctx.op.type == LangParser.OP_INC) {
                type = ASTExprOp.ExprType.POSTFIX_INC
            } else if (ctx.op.type == LangParser.OP_DEC) {
                type = ASTExprOp.ExprType.POSTFIX_DEC
            } else {
                compilerError("No such postfix operator", ASTFileLocation.fromToken(ctx.start))
            }
            return ASTExprOp(ASTFileLocation.fromToken(ctx.start), type, visitExpr(ctx.varName), null)

        } else if (ctx is LangParser.LambdaExprContext) {
            val type = visitFuncTypeWithBody(ctx.varName.typeName)
            val body = visitBlock(ctx.varName.code)
            return ASTLambdaExpr(ASTFileLocation.fromToken(ctx.start), type, body)

        } else if (ctx is LangParser.PrefixExprContext) {
            val type: ASTExprOp.ExprType
            when (ctx.op.type) {
                LangParser.OP_INC -> type = ASTExprOp.ExprType.PREFIX_INC
                LangParser.OP_DEC -> type = ASTExprOp.ExprType.PREFIX_DEC
                LangParser.OP_LNOT -> type = ASTExprOp.ExprType.LOGICAL_NOT
                LangParser.OP_BNOT -> type = ASTExprOp.ExprType.BINARY_NOT
                LangParser.OP_SUB -> type = ASTExprOp.ExprType.NEGATIVE
                LangParser.OP_ADD ->
                    //positive prefix operator is just identity function
                    return visitExpr(ctx.varName)
                else -> compilerError("No such prefix operator", ASTFileLocation.fromToken(ctx.start))
            }
            return ASTExprOp(ASTFileLocation.fromToken(ctx.start), type, visitExpr(ctx.varName), null)

        } else if (ctx is LangParser.InfixExprContext) {
            val type: ASTExprOp.ExprType
            when (ctx.op.type) {
                LangParser.OP_MUL -> type = ASTExprOp.ExprType.MULT
                LangParser.OP_DIV -> type = ASTExprOp.ExprType.DIV
                LangParser.OP_MOD -> type = ASTExprOp.ExprType.MOD
                LangParser.OP_ADD -> type = ASTExprOp.ExprType.ADD
                LangParser.OP_SUB -> type = ASTExprOp.ExprType.SUB
                LangParser.OP_LSH -> type = ASTExprOp.ExprType.LSHFT
                LangParser.OP_RSH -> type = ASTExprOp.ExprType.RSHFT
                LangParser.OP_LT -> type = ASTExprOp.ExprType.LT
                LangParser.OP_LTE -> type = ASTExprOp.ExprType.LTE
                LangParser.OP_GT -> type = ASTExprOp.ExprType.GT
                LangParser.OP_GTE -> type = ASTExprOp.ExprType.GTE
                LangParser.OP_EQ -> type = ASTExprOp.ExprType.EQ
                LangParser.OP_NEQ -> {
                    val expr = ASTExprOp(ASTFileLocation.fromToken(ctx.start), ASTExprOp.ExprType.LOGICAL_NOT,ASTExprOp(ASTFileLocation.fromToken(ctx.start), ASTExprOp.ExprType.EQ, visitExpr(ctx.left), visitExpr(ctx.right)), null)
                    return expr
                }
                LangParser.OP_BAND -> type = ASTExprOp.ExprType.BINARY_AND
                LangParser.OP_BOR -> type = ASTExprOp.ExprType.BINARY_OR
                LangParser.OP_BXOR -> type = ASTExprOp.ExprType.BINARY_XOR
                LangParser.OP_LAND -> type = ASTExprOp.ExprType.LOGICAL_AND
                LangParser.OP_LOR -> type = ASTExprOp.ExprType.LOGICAL_OR
                else -> compilerError("no such infix operator", ASTFileLocation.fromToken(ctx.start))
            }
            return ASTExprOp(ASTFileLocation.fromToken(ctx.start), type, visitExpr(ctx.left), visitExpr(ctx.right))

        } else if (ctx is LangParser.AssignmentExprContext) {
/* compound assignments are broken down into assignment to expr */
            val type: ASTExprOp.ExprType
            when (ctx.op.type) {
                LangParser.OP_ASG -> {
                    val left = visitExpr(ctx.left)
                    return ASTAssignExpr(ASTFileLocation.fromToken(ctx.start), left, visitExpr(ctx.right))
                }
                LangParser.OP_ADD_ASG -> type = ASTExprOp.ExprType.ADD
                LangParser.OP_SUB_ASG -> type = ASTExprOp.ExprType.SUB
                LangParser.OP_MUL_ASG -> type = ASTExprOp.ExprType.MULT
                LangParser.OP_DIV_ASG -> type = ASTExprOp.ExprType.DIV
                LangParser.OP_MOD_ASG -> type = ASTExprOp.ExprType.MOD
                LangParser.OP_LSH_ASG -> type = ASTExprOp.ExprType.LSHFT
                LangParser.OP_RSH_ASG -> type = ASTExprOp.ExprType.RSHFT
                LangParser.OP_BAND_ASG -> type = ASTExprOp.ExprType.BINARY_AND
                LangParser.OP_BOR_ASG -> type = ASTExprOp.ExprType.BINARY_OR
                LangParser.OP_BXOR_ASG -> type = ASTExprOp.ExprType.BINARY_XOR
                else -> compilerError("no such assignment operator", ASTFileLocation.fromToken(ctx.start))
            }
            val op_expr = ASTExprOp(ASTFileLocation.fromToken(ctx.start), type, visitExpr(ctx.left), visitExpr(ctx.right))
            val left_asg = visitExpr(ctx.left)
            return ASTAssignExpr(ASTFileLocation.fromToken(ctx.start), left_asg, op_expr)

        } else if (ctx is LangParser.LiteralExprContext) {
            if (ctx.literal().arrayLiteral() == null) {
                return ASTLiteralExpr(ASTFileLocation.fromToken(ctx.start), ctx.literal().text)
            } else {
                val lits = ArrayList<ASTExpr>()
                for (n in 0 until ctx.literal().arrayLiteral().expr().size) {
                    val l = ctx.literal().arrayLiteral().expr(n)
                    lits.add(visitExpr(l))
                }
                return ASTArrayLiteralExpr(ASTFileLocation.fromToken(ctx.start), lits)
            }

        } else if (ctx is LangParser.IdExprContext) {
            return ASTVarExpr(ASTFileLocation.fromToken(ctx.start), ctx.ID().text)
        }
        compilerError("unhandled expr type", ASTFileLocation.fromToken(ctx.start))
    }

    /* this does not properly initialize all fields, mut and init_val are overwritten by visitVarDecl */
    override fun visitVarType(ctx: LangParser.VarTypeContext): ASTNodeArray<ASTVarDecl> {
        val decls = ArrayList<ASTVarDecl>()
        val type: ASTType?
        if (ctx.typeName != null) {
            type = visitTypeDecl(ctx.typeName)
        } else {
            type = null
        }
        val mut = ASTVarDecl.VarMut.MUT
        for (i in 0 until ctx.ID().size) {
            val decl = ASTVarDecl(ASTFileLocation.fromToken(ctx.start), ctx.ID(i).text, type, null, mut)
            decls.add(decl)
        }

        return ASTNodeArray(decls)
    }

    override fun visitVarDecl(ctx: LangParser.VarDeclContext): ASTNodeArray<ASTVarDecl> {
        var mutable = ASTVarDecl.VarMut.MUT
        if(ctx.mut == null) {
            mutable = ASTVarDecl.VarMut.MUT
        } else if (ctx.mut.text == "var") {
            mutable = ASTVarDecl.VarMut.MUT
        } else if (ctx.mut.text == "val") {
            mutable = ASTVarDecl.VarMut.IMUT
        }

        val decls = visitVarType(ctx.typeName)

        /* handle initializers */
        if (ctx.init != null) {
            /* make sure number of initialized values matches number of variables */
            if (ctx.init.expr().size != ctx.typeName.ID().size) {
                compilerError("length of initilizer list has to match number of variables", ASTFileLocation.fromToken(ctx.init.expr(0).start))
            }
            for (i in 0 until ctx.init.expr().size) {
                decls.nodes[i].init_val = visitExpr(ctx.init.expr(i))
            }
        }

        /* set mutable */
        for (i in decls.nodes.indices) {
            decls.nodes[i].mutable = mutable
        }

        return decls
    }

    override fun visitBlock(ctx: LangParser.BlockContext): ASTNodeArray<ASTNode> {
        val l = mutableListOf<ASTNode>()
        for (i in 0 until ctx.statement().size) {
            val res = visitStatement(ctx.statement(i))
            if (res is ASTNodeArray<*>) {
                l.addAll(res.nodes as MutableList<ASTNode>)
            } else {
                if(res != null) {
                    l.add(res)
                }
            }
        }
        return ASTNodeArray(l)
    }

}

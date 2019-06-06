package compiler;

import parser.*;
import org.antlr.v4.runtime.*;

import ast.*;
import java.util.ArrayList;
import java.lang.Exception;

/* TODO: locations from source files in ast tree */
public class CSTToASTVisitor extends LangBaseVisitor<ASTNode> {

    public void error(String msg, ASTFileLocation loc){
        System.out.print(String.format("An error occurred in file '%s', line %d:%d:\n", loc.fileName, loc.line_num, loc.line_pos+1));

        loc.print();

        System.out.println(msg);
        System.exit(0);
    }

    public ASTNode visitProgram(LangParser.ProgramContext ctx) {
        var nodes = new ArrayList<ASTNode>();
        for(var stat: ctx.statement()){
            var res = visitStatement(stat);
            if(res instanceof ASTNodeArray){
                var res_array = (ASTNodeArray)(res);
                nodes.addAll(res_array.nodes);
            } else {
                nodes.add(visitStatement(stat));
            }
        }

        return new ASTNodeArray<ASTNode>(nodes);
    }

    public ASTNode visitStatement(LangParser.StatementContext ctx) {
        if (ctx instanceof LangParser.IfStmntContext){

        } else if (ctx instanceof LangParser.ElseStmntContext){

        } else if (ctx instanceof LangParser.ElseIfStmntContext){

        } else if (ctx instanceof LangParser.WhileStmntContext){

        } else if (ctx instanceof LangParser.DoWhileStmntContext){

        } else if (ctx instanceof LangParser.ForStmntContext){

        } else if (ctx instanceof LangParser.ReturnStmntContext){

        } else if (ctx instanceof LangParser.ContinueStmntContext){

        } else if (ctx instanceof LangParser.BreakStmntContext){

        } else if (ctx instanceof LangParser.FuncDeclStmntContext){
            var c = (LangParser.FuncDeclStmntContext) ctx;
            return visitFuncDecl(c.function);
        } else if (ctx instanceof LangParser.ClassDeclStmntContext){

        } else if (ctx instanceof LangParser.ExprStmntContext){
            var c = (LangParser.ExprStmntContext) ctx;
            return visitExpr(c.expr());

        } else if (ctx instanceof LangParser.BlockStmntContext){
            var c = (LangParser.BlockStmntContext) ctx;
            return visitBlock(c.code);
        } else if(ctx instanceof LangParser.VarDeclStmntContext){
            var c = (LangParser.VarDeclStmntContext)ctx;
            return visitVarDecl(c.decl);
        } 
        
        else {
            System.out.println("No such statement context type");
            System.exit(0);
        }

        return new ASTNode(ASTFileLocation.fromToken(ctx.start));
    }

    public ASTNode visitFuncDecl(LangParser.FuncDeclContext ctx) {
        ASTFuncType type = visitFuncType(ctx.function.typeName);
        ASTNodeArray<ASTNode> body = visitBlock(ctx.function.code);
        return new ASTFuncDecl(ASTFileLocation.fromToken(ctx.start), ctx.name.getText(), type, body);
    }

    public ASTType visitTypeDecl(LangParser.TypeDeclContext ctx){
        /* handle array */
        if(ctx.arrayDecl() != null){
            int length = -1;
            if(ctx.arrayDecl().size == null){
                length = -1;
            } else {
                try {
                    length = Integer.parseInt(ctx.arrayDecl().size.getText());
                } catch(NumberFormatException e){
                    var loc = ASTFileLocation.fromToken(ctx.arrayDecl().size);
                    error(String.format("'%s' is not a valid array size", ctx.arrayDecl().size.getText()), loc);
                }
            }
            if(ctx.ID() != null){
                return new ASTArrayType(ASTFileLocation.fromToken(ctx.start), ctx.ID().getText(), length);
            } else {
                /* handle function type */
                var funcType = visitFuncType(ctx.funcType());
                return new ASTArrayFuncType(ASTFileLocation.fromToken(ctx.start), funcType.args, funcType.ret_type, length);
            }
        } else {
            if(ctx.ID() != null){
                return new ASTType(ASTFileLocation.fromToken(ctx.start), ctx.ID().getText());
            } else {
                /* handle function type */
                return visitFuncType(ctx.funcType());
            }
        }
    }

    public ASTNodeArray<ASTVarDecl> visitFuncArgVarType(LangParser.FuncArgVarTypeContext ctx){
        var decls = new ArrayList<ASTVarDecl>();
        var type = visitTypeDecl(ctx.typeName);
        var mut = ASTVarDecl.VarMut.MUT;
        if(ctx.mut != null){
            if(ctx.mut.getText().equals("var")){
                mut = ASTVarDecl.VarMut.MUT;
            } else if (ctx.mut.getText().equals("val")){
                mut = ASTVarDecl.VarMut.IMUT;
            }
        }
        for(var i = 0; i < ctx.ID().size(); i++){
            var decl = new ASTVarDecl(ASTFileLocation.fromToken(ctx.start), ctx.ID(i).getText(), type, null, mut);
            decls.add(decl);
        }
        
        return new ASTNodeArray<ASTVarDecl>(decls);
    }

    public ASTFuncType visitFuncType(LangParser.FuncTypeContext ctx) {
        ASTType ret_type;
        if(ctx.retType == null){
            ret_type = null;
        } else {
            ret_type = visitTypeDecl(ctx.retType);
        }
        var args = new ArrayList<ASTVarDecl>();
        if(ctx.args != null){
            for(var i = 0; i < ctx.args.funcArgVarType().size(); i++){
                var t = visitFuncArgVarType(ctx.args.funcArgVarType(i));
                args.addAll(t.nodes);
            }
        }
        var type = new ASTFuncType(ASTFileLocation.fromToken(ctx.start), args, ret_type);
        return type;
    }

    public ASTExpr visitExpr(LangParser.ExprContext ctx) {
        if (ctx instanceof LangParser.ParenExprContext) {
            var c = (LangParser.ParenExprContext)ctx;
            /* parens don't do anything */
            return visitExpr(c.expr());

        } else if (ctx instanceof LangParser.FuncExprContext) {
            var c = (LangParser.FuncExprContext)ctx;
            var args = new ArrayList<ASTExpr>();
            for(var i = 0; i < c.args.expr().size(); i++){
                args.add(visitExpr(c.args.expr(i)));
            }
            return new ASTFuncCallExpr(ASTFileLocation.fromToken(c.start), visitExpr(c.name), new ASTNodeArray<ASTExpr>(args));

        } else if (ctx instanceof LangParser.ArrayExprContext) {
            var c = (LangParser.ArrayExprContext)ctx;
            var array = visitExpr(c.varName);
            return new ASTArrayExpr(ASTFileLocation.fromToken(c.start), array, visitExpr(c.sub));

        } else if (ctx instanceof LangParser.DotExprContext) {
            var c = (LangParser.DotExprContext)ctx;
            return new ASTDotExpr(ASTFileLocation.fromToken(c.start), visitExpr(c.varName), visitExpr(c.sub));

        } else if (ctx instanceof LangParser.PostfixExprContext) {
            var c = (LangParser.PostfixExprContext)ctx;
            ASTExprOp.ExprType type = ASTExprOp.ExprType.POSTFIX_INC;
            if(c.op.getType() == LangParser.OP_INC){
                type = ASTExprOp.ExprType.POSTFIX_INC;
            } else if (c.op.getType() == LangParser.OP_DEC){
                type = ASTExprOp.ExprType.POSTFIX_DEC;
            } else {
                error("No such postfix operator", ASTFileLocation.fromToken(c.start));
            }
            return new ASTExprOp(ASTFileLocation.fromToken(c.start), type, visitExpr(c.varName), null);

        } else if (ctx instanceof LangParser.LambdaExprContext) {
            var c = (LangParser.LambdaExprContext)ctx;
            ASTFuncType type = visitFuncType(c.varName.typeName);
            ASTNodeArray<ASTNode> body = visitBlock(c.varName.code);
            return new ASTLambdaExpr(ASTFileLocation.fromToken(c.start), type, body);

        } else if (ctx instanceof LangParser.PrefixExprContext) {
            var c = (LangParser.PrefixExprContext)ctx;
            ASTExprOp.ExprType type = ASTExprOp.ExprType.PREFIX_INC;
            switch(c.op.getType()){
                case LangParser.OP_INC:
                    type = ASTExprOp.ExprType.PREFIX_INC;
                    break;
                case LangParser.OP_DEC:
                    type = ASTExprOp.ExprType.PREFIX_DEC;
                    break;
                case LangParser.OP_LNOT:
                    type = ASTExprOp.ExprType.LOGICAL_NOT;
                    break;
                case LangParser.OP_BNOT:
                    type = ASTExprOp.ExprType.BINARY_NOT;
                    break;
                case LangParser.OP_SUB:
                    type = ASTExprOp.ExprType.NEGATIVE;
                    break;
                case LangParser.OP_ADD:
                    //positive prefix operator is just identity function
                    return visitExpr(c.varName);
                default:
                    error("No such prefix operator", ASTFileLocation.fromToken(c.start));
            }
            return new ASTExprOp(ASTFileLocation.fromToken(c.start), type, visitExpr(c.varName), null);

        } else if (ctx instanceof LangParser.InfixExprContext) {
            var c = (LangParser.InfixExprContext)ctx;
            ASTExprOp.ExprType type = ASTExprOp.ExprType.ADD;
            switch(c.op.getType()){
                case LangParser.OP_MUL:
                    type = ASTExprOp.ExprType.MULT;
                    break;
                case LangParser.OP_DIV:
                    type = ASTExprOp.ExprType.DIV;
                    break;
                case LangParser.OP_MOD:
                    type = ASTExprOp.ExprType.MOD;
                    break;
                case LangParser.OP_ADD:
                    type = ASTExprOp.ExprType.ADD;
                    break;
                case LangParser.OP_SUB:
                    type = ASTExprOp.ExprType.SUB;
                    break;
                case LangParser.OP_LSH:
                    type = ASTExprOp.ExprType.LSHFT;
                    break;
                case LangParser.OP_RSH:
                    type = ASTExprOp.ExprType.RSHFT;
                    break;
                case LangParser.OP_LT:
                    type = ASTExprOp.ExprType.LT;
                    break;
                case LangParser.OP_LTE:
                    type = ASTExprOp.ExprType.LTE;
                    break;
                case LangParser.OP_GT:
                    type = ASTExprOp.ExprType.GT;
                    break;
                case LangParser.OP_GTE:
                    type = ASTExprOp.ExprType.GTE;
                    break;
                case LangParser.OP_EQ:
                    type = ASTExprOp.ExprType.EQ;
                    break;
                case LangParser.OP_NEQ:
                    type = ASTExprOp.ExprType.NEQ;
                    break;
                case LangParser.OP_BAND:
                    type = ASTExprOp.ExprType.BINARY_AND;
                    break;
                case LangParser.OP_BOR:
                    type = ASTExprOp.ExprType.BINARY_OR;
                    break;
                case LangParser.OP_BXOR:
                    type = ASTExprOp.ExprType.BINARY_XOR;
                    break;
                case LangParser.OP_LAND:
                    type = ASTExprOp.ExprType.LOGICAL_AND;
                    break;
                case LangParser.OP_LOR:
                    type = ASTExprOp.ExprType.LOGICAL_OR;
                    break;
                default:
                    error("no such infix operator", ASTFileLocation.fromToken(c.start));
            }
            return new ASTExprOp(ASTFileLocation.fromToken(c.start), type, visitExpr(c.left), visitExpr(c.right));

        } else if (ctx instanceof LangParser.AssignmentExprContext) {
            var c = (LangParser.AssignmentExprContext)ctx;
            /* compound assignments are broken down into assignment to expr */
            var type = ASTExprOp.ExprType.ADD;
            switch(c.op.getType()){
                case LangParser.OP_ASG:
                    var left = visitExpr(c.left);
                    return new ASTAssignExpr(ASTFileLocation.fromToken(c.start), left, visitExpr(c.right));
                case LangParser.OP_ADD_ASG:
                    type = ASTExprOp.ExprType.ADD;
                    break;
                case LangParser.OP_SUB_ASG:
                    type = ASTExprOp.ExprType.SUB;
                    break;
                case LangParser.OP_MUL_ASG:
                    type = ASTExprOp.ExprType.MULT;
                    break;
                case LangParser.OP_DIV_ASG:
                    type = ASTExprOp.ExprType.DIV;
                    break;
                case LangParser.OP_MOD_ASG:
                    type = ASTExprOp.ExprType.MOD;
                    break;
                case LangParser.OP_LSH_ASG:
                    type = ASTExprOp.ExprType.LSHFT;
                    break;
                case LangParser.OP_RSH_ASG:
                    type = ASTExprOp.ExprType.RSHFT;
                    break;
                case LangParser.OP_BAND_ASG:
                    type = ASTExprOp.ExprType.BINARY_AND;
                    break;
                case LangParser.OP_BOR_ASG:
                    type = ASTExprOp.ExprType.BINARY_OR;
                    break;
                case LangParser.OP_BXOR_ASG:
                    type = ASTExprOp.ExprType.BINARY_XOR;
                    break;
                default:
                    error("no such assignment operator", ASTFileLocation.fromToken(c.start));
            }
            var op_expr = new ASTExprOp(ASTFileLocation.fromToken(c.start), type, visitExpr(c.left), visitExpr(c.right));
            var left_asg = visitExpr(c.left);
            return new ASTAssignExpr(ASTFileLocation.fromToken(c.start), left_asg, op_expr);

        } else if (ctx instanceof LangParser.LiteralExprContext) {
            var c = (LangParser.LiteralExprContext)ctx;
            if(c.literal().arrayLiteral() == null){
                return new ASTLiteralExpr(ASTFileLocation.fromToken(c.start), c.literal().getText());
            } else {
                var lits = new ArrayList<ASTLiteralExpr>();
                for(var n = 0; n < c.literal().arrayLiteral().expr().size(); n++){
                    var l = c.literal().arrayLiteral().expr(n);
                    lits.add(new ASTLiteralExpr(ASTFileLocation.fromToken(l.start), l.getText()));
                }
                return new ASTArrayLiteralExpr(ASTFileLocation.fromToken(c.start), lits);
            }

        } else if (ctx instanceof  LangParser.IdExprContext) {
            var c = (LangParser.IdExprContext)ctx;
            return new ASTVarExpr(ASTFileLocation.fromToken(c.start), c.ID().getText());
        }
        error("unhandled expr type", ASTFileLocation.fromToken(ctx.start));
        return null;
    }

    /* this does not properly initialize all fields, mut and init_val are overwritten by visitVarDecl */
    public ASTNodeArray<ASTVarDecl> visitVarType(LangParser.VarTypeContext ctx){
        var decls = new ArrayList<ASTVarDecl>();
        ASTType type;
        if(ctx.typeName != null) {
            type = visitTypeDecl(ctx.typeName);
        } else {
            type = null;
        }
        var mut = ASTVarDecl.VarMut.MUT;
        for(var i = 0; i < ctx.ID().size(); i++){
            var decl = new ASTVarDecl(ASTFileLocation.fromToken(ctx.start), ctx.ID(i).getText(), type, null, mut);
            decls.add(decl);
        }
        
        return new ASTNodeArray<ASTVarDecl>(decls);
    }

    public ASTNodeArray<ASTVarDecl> visitVarDecl(LangParser.VarDeclContext ctx) {
        var mutable = ASTVarDecl.VarMut.MUT;
        if(ctx.mut.getText().equals("var")){
            mutable = ASTVarDecl.VarMut.MUT;
        } else if (ctx.mut.getText().equals("val")){
            mutable = ASTVarDecl.VarMut.IMUT;
        }

        var decls = visitVarType(ctx.typeName);

        /* handle initializers */
        if(ctx.init != null){
            /* make sure number of initialized values matches number of variables */
            if(ctx.init.expr().size() != ctx.typeName.ID().size()){
                error("length of initilizer list has to match number of variables", ASTFileLocation.fromToken(ctx.init.expr(0).start));
            }
            for(var i = 0; i < ctx.init.expr().size(); i++){
                decls.nodes.get(i).init_val = visitExpr(ctx.init.expr(i));
            }
        }

        /* set mutable */
        for(var i = 0; i < decls.nodes.size(); i++){
            decls.nodes.get(i).mutable = mutable;
        }

        return decls;
    }

    public ASTNodeArray<ASTNode> visitBlock(LangParser.BlockContext ctx){
        ArrayList<ASTNode> l = new ArrayList<ASTNode>();
        for(var i = 0; i < ctx.statement().size(); i++){
            var res = visitStatement(ctx.statement(i));
            if(res instanceof ASTNodeArray){
                l.addAll(((ASTNodeArray)res).nodes);
            } else {
                l.add(res);
            }
        }
        return new ASTNodeArray<ASTNode>(l);
    }

}

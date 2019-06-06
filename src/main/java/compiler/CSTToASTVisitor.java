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

    public ASTExpr visitExpr(LangParser.ExprContext ctx){
        /* TODO: proper type switch */
        return new ASTExpr(ASTFileLocation.fromToken(ctx.start));
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

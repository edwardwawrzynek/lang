import org.antlr.v4.runtime.*;

import ast.*;
import java.util.ArrayList;
import java.lang.Exception;

/* TODO: locations from source files in ast tree */
public class CSTToASTVisitor extends LangBaseVisitor<ASTNode> {

    public void error(String msg){
        System.out.println(msg);
        System.exit(0);
    }

    public ASTNode visitProgram(LangParser.ProgramContext ctx) {
        var nodes = new ArrayList<ASTNode>();
        for(var stat: ctx.statement()){
            nodes.add(visitStatement(stat));
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

        } else if (ctx instanceof LangParser.BlockStmntContext){

        } else {
            System.out.println("No such statement context type");
            System.exit(0);
        }

        return new ASTNode();
    }

    public ASTNode visitFuncDecl(LangParser.FuncDeclContext ctx) {
        ASTFuncType type = visitFuncType(ctx.function.typeName);
        ASTNodeArray<ASTNode> body = visitBlock(ctx.function.code);
        return new ASTFuncDecl(ctx.name.getText(), type, body);

    }

    public ASTType visitTypeDecl(LangParser.TypeDeclContext ctx){
        /* handle array */
        if(ctx.arrayDecl() != null){
            int length = -1;
            if(ctx.arrayDecl().size == null){
                length = -1;
            } else {
                try {
                    length = Integer.parseInt(ctx.arrayDecl().getText());
                } catch(NumberFormatException e){
                    error(String.format("'%s' is not a valid array size"));
                }
            }
            if(ctx.ID() != null){
                return new ASTArrayType(ctx.ID().getText(), length);
            } else {
                /* handle function type */
                var funcType = visitFuncType(ctx.funcType());
                return new ASTArrayFuncType(funcType.args, funcType.ret_type, length);
            }
        } else {
            if(ctx.ID() != null){
                return new ASTType(ctx.ID().getText());
            } else {
                /* handle function type */
                return visitFuncType(ctx.funcType());
            }
        }
    }

    public ASTNodeArray<ASTVarDecl> visitFuncArgVarType(LangParser.FuncArgVarTypeContext ctx){
        var decls = new ArrayList<ASTVarDecl>();
        var type = visitTypeDecl(ctx.typeName);
        for(var i = 0; i < ctx.ID().size(); i++){
            var decl = new ASTVarDecl(ctx.ID(i).getText(), type, null, ASTVarDecl.VarMut.MUT);
        }
        
        return new ASTNodeArray<ASTVarDecl>(decls);
    }

    public ASTFuncType visitFuncType(LangParser.FuncTypeContext ctx) {
        ASTType ret_type;
        if(ctx.retType == null){
            ret_type = new ASTType(null);
        } else {
            ret_type = new ASTType(ctx.retType.toString());
        }
        var args = new ArrayList<ASTVarDecl>();
        for(var i = 0; i < ctx.args.funcArgVarType().size(); i++){
            var t = visitFuncArgVarType(ctx.args.funcArgVarType(i));
            args.addAll(t.nodes);
        }
        var type = new ASTFuncType(args, ret_type);
        return type;
    }

    public ASTNodeArray<ASTNode> visitBlock(LangParser.BlockContext ctx){
        ArrayList<ASTNode> l = new ArrayList<ASTNode>();
        return new ASTNodeArray<ASTNode>(l);
    }

}
import org.antlr.v4.runtime.*;

import ast.*;
import java.util.ArrayList;
import java.lang.Exception;

public class CSTToASTVisitor extends LangBaseVisitor<ASTNode> {
    public ASTNode visitProgram(LangParser.ProgramContext ctx) {
        var nodes = new ArrayList<ASTNode>();
        for(var stat: ctx.statement()){
            nodes.add(visitStatement(stat));
        }

        return new ASTNodeArray(nodes);
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
        var name = ctx.name.getText();
        System.out.println(name);
        System.out.println(ctx.function);
        return new ASTNode();

    }
}
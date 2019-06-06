package ast;

public class ASTFuncCallExpr extends ASTExpr {
    ASTExpr func;
    ASTNodeArray<ASTExpr> args;

    public ASTFuncCallExpr(ASTFileLocation loc, ASTExpr func, ASTNodeArray<ASTExpr> args){
        super(loc);
        this.func = func;
        this.args = args;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTFuncCallExpr: (function, args)");
        func.print(i+1);
        args.print(i+1);
    }
}
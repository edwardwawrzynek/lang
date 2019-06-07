package ast;

public class ASTReturnStmnt extends ASTNode {
    public ASTExpr val;

    public ASTReturnStmnt(ASTFileLocation loc, ASTExpr val){
        super(loc);
        this.val = val;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTReturnStmnt:");
        val.print(i+1);
    }
}
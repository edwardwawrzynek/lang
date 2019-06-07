package ast;

public class ASTDoWhileStmnt extends ASTNode {
    ASTExpr cond;
    ASTNodeArray<ASTNode> code;

    public ASTDoWhileStmnt (ASTFileLocation loc, ASTExpr cond, ASTNodeArray<ASTNode> code){
        super(loc);
        this.cond = cond;
        this.code = code;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTDoWhileStmnt: (cond, code)");
        cond.print(i+1);
        code.print(i+1);
    }
}
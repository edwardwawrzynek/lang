package ast;

public class ASTIfStmnt extends ASTNode {
    public ASTExpr cond;
    public ASTNodeArray<ASTNode> code;

    public ASTIfStmnt(ASTFileLocation loc, ASTExpr cond, ASTNodeArray<ASTNode> code){
        super(loc);
        this.cond = cond;
        this.code = code;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTIfStmnt: (cond, code)");
        cond.print(i+1);
        code.print(i+1);
    }
}
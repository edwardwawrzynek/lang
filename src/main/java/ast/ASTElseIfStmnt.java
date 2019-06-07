package ast;

public class ASTElseIfStmnt extends ASTNode {
    public ASTExpr cond;
    public ASTNodeArray<ASTNode> code;

    public ASTElseIfStmnt(ASTFileLocation loc, ASTExpr cond, ASTNodeArray<ASTNode> code){
        super(loc);
        this.cond = cond;
        this.code = code;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTElseIfStmnt: (cond, code)");
        cond.print(i+1);
        code.print(i+1);
    }
}
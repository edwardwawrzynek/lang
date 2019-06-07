package ast;

public class ASTForStmnt extends ASTNode {
    ASTNode inital;
    ASTExpr cond;
    ASTExpr end;
    ASTNodeArray<ASTNode> code;

    public ASTForStmnt(ASTFileLocation loc, ASTNode initial, ASTExpr cond, ASTExpr end, ASTNodeArray<ASTNode> code) {
        super(loc);
        this.inital = initial;
        this.cond = cond;
        this.end = end;
        this.code = code;
    }

    public void print(int i) {
        printIndent(i);
        System.out.println("ASTForStmnt: (initial, cond, end, code)");
        inital.print(i+1);
        cond.print(i+1);
        end.print(i+1);
        code.print(i+1);
    }
}
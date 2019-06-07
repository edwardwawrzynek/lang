package ast;

public class ASTBreakStmnt extends ASTNode {
    public ASTBreakStmnt(ASTFileLocation loc){
        super(loc);
    }

    public void print(int i) {
        printIndent(i);
        System.out.println("ASTBreakStmnt");
    }
}
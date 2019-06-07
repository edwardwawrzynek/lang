package ast;

public class ASTContinueStmnt extends ASTNode {
    public ASTContinueStmnt(ASTFileLocation loc){
        super(loc);
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTContinueStmnt");
    }
}
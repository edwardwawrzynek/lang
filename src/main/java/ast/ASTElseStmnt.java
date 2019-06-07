package ast;

public class ASTElseStmnt extends ASTNode {
    public ASTNodeArray<ASTNode> code;

    public ASTElseStmnt(ASTFileLocation loc, ASTNodeArray<ASTNode> code){
        super(loc);
        this.code = code;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTElseStmnt: ");
        code.print(i+1);
    }
}
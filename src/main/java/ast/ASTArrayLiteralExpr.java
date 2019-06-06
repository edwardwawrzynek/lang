package ast;

import java.util.List;

public class ASTArrayLiteralExpr extends ASTLiteralExpr {
    List<ASTLiteralExpr> lits;

    public ASTArrayLiteralExpr(ASTFileLocation loc, List<ASTLiteralExpr> lits){
        super(loc, null);
        this.lits = lits;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTArrayLiteralExpr:");
        for(var n = 0; n < lits.size(); n++){
            lits.get(n).print(i+1);
        }
    }
}
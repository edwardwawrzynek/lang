package ast;

import java.util.List;

public class ASTArrayLiteral extends ASTLiteral {
    List<ASTLiteral> lits;

    public ASTArrayLiteral(ASTFileLocation loc, List<ASTLiteral> lits){
        super(loc, null);
        this.lits = lits;
    }
}
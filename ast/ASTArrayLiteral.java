package ast;

import java.util.List;

public class ASTArrayLiteral extends ASTLiteral {
    List<ASTLiteral> lits;

    public ASTArrayLiteral(List<ASTLiteral> lits){
        super(null);
        this.lits = lits;
    }
}
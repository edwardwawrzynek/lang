package ast;

import java.util.List;

public class ASTArrayFuncType extends ASTFuncType {
    int length;

    public ASTArrayFuncType(List<ASTVarDecl> args, ASTType ret_type, int length){
        super(args, ret_type);
        this.length = length;
    }
}
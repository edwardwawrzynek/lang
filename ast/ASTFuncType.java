package ast;

import java.util.List;

public class ASTFuncType extends ASTType{

    public List<ASTVarDecl> args;
    public ASTType ret_type;

    public ASTFuncType(List<ASTVarDecl> args, ASTType ret_type){
        super(null);
        this.args = args;
        this.ret_type = ret_type;
    }

}
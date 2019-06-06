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

    public void print(int i){
        printIndent(i);
        System.out.println("ASTFuncType: (ret_type, args[])");
        if(ret_type != null){
            ret_type.print(i+1);
        } else {
            printIndent(i+1);
            System.out.println("null");
        }
        for(var p = 0; p < args.size(); p++){
            args.get(p).print(i+1);
        }
    }

}
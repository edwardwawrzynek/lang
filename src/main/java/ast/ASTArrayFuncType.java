package ast;

import java.util.List;

public class ASTArrayFuncType extends ASTFuncType {
    int length;

    public ASTArrayFuncType(List<ASTVarDecl> args, ASTType ret_type, int length){
        super(args, ret_type);
        this.length = length;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTArrayFuncType: (ret_type, args[])");
        ret_type.print(i+1);
        for(var p = 0; p < args.size(); p++){
            args.get(p).print(i+1);
        }
    }
}
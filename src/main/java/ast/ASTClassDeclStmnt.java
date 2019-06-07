package ast;

public class ASTClassDeclStmnt extends ASTNode {
    public enum Type {
        CLASS, OBJECT, STRUCT
    }
    public ASTNodeArray<ASTVarDecl> fields;
    public ASTNodeArray<ASTFuncDecl> methods;
    public Type type;
    public String superclass;
    public String name;

    public ASTClassDeclStmnt(ASTFileLocation loc, String name, ASTNodeArray<ASTVarDecl> fields, ASTNodeArray<ASTFuncDecl> methods, Type type, String superclass){
        super(loc);
        this.name = name;
        this.fields = fields;
        this.methods = methods;
        this.type = type;
        this.superclass = superclass;
    }

    public void print(int i) {
        printIndent(i);
        System.out.println("ASTClassDeclStmnt: (name, superclass, type, fields, methods)");
        printIndent(i+1);
        System.out.println(name);
        printIndent(i+1);
        System.out.println(superclass);
        printIndent(i+1);
        System.out.println(type);
        fields.print(i+1);
        methods.print(i+1);
    }

}
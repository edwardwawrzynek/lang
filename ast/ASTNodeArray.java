package ast;

import ast.ASTNode;
import java.util.List;

public class ASTNodeArray extends ASTNode {
    List<ASTNode> nodes;
    public ASTNodeArray(List<ASTNode> nodes){
        this.nodes = nodes;
    }
}
package compiler;

import parser.*;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String args[]) throws Exception{
        ANTLRFileStream in = new ANTLRFileStream(args[0]);
        LangLexer lexer = new LangLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        LangParser.ProgramContext tree = parser.program();
        CSTToASTVisitor visitor = new CSTToASTVisitor();
        visitor.visitProgram(tree).print(0);
    }
}
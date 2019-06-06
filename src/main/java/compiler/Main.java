package compiler;

import parser.*;
import org.antlr.v4.runtime.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static String fileName;
    public static void main(String args[]) throws Exception{
        var fileInput = new BufferedReader(new FileReader("test1.txt"));
        var in= CharStreams.fromReader(fileInput);
        fileName = "test1.txt";
        LangLexer lexer = new LangLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        LangParser.ProgramContext tree = parser.program();
        CSTToASTVisitor visitor = new CSTToASTVisitor();
        visitor.visitProgram(tree).print(0);
    }

}
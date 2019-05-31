all:
	antlr4 -no-listener -visitor Lang.g4
	javac *.java */*.java
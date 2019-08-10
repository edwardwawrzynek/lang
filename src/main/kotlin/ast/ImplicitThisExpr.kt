package ast

import compiler.ClassType

class ImplicitThisExpr(loc: ASTFileLocation, val type: ClassType): ASTExpr(loc) {

}
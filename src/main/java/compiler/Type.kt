package compiler

/* represents the type of an object */
open class Type

/* Type of a class (names of fields + methods are part of type) */
data class ClassType(var table: SymbolTable) : Type()

/* names of args are not part of type - they are part of scope for code */
data class FunctionType(var return_type: Type, var args: List<Type>) : Type()

/* array type */
data class ArrayType(var type: Type): Type()

/* primative void type */
class VoidType: Type()

/* primative string type */
class StringType : Type()

/* primative int type */
class IntType : Type()
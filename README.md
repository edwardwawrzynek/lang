## Passes
[x] Lexer/Parser (text -> CST)
[x] AST Construct (CST -> AST)
[x] Class + Function Type + Variable Symbol Table Construction (Infered types kept null)
    [x] Class Name Symbol Table Construction (type null)
    [x] Class type symbol table construction
    [x] Function + Variable Type Construction
[ ] Type Inference
[ ] Type Resolving/Checking
[ ] Transform Operator Overrides (AST -> AST)
[ ] Closure Handling / Free variables (AST -> AST)
[x] Generate Class Descriptions (Class Tables -> Output)
[ ] Generate Function Code (AST -> Output)

## Symbol Tables Needed:
- Class name symbol table
- Global Var and function tables
- Local var and function tables

## TODO/NOTES
- TODO: Namespaces (packages, also nested classes, etc)
- NOTE: For loops need to be emitted in their own c scope if a variable is declared in the initial condition
- TODO: keep namespace names, etc, in name entry in symbol tables (not key, name in value)



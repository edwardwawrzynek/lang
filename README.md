## Passes
- [x] Lexer/Parser (text -> CST)
- [x] AST Construct (CST -> AST)
- [x] Class + Function Type + Variable Symbol Table Construction (Infered types kept null)
    - [x] Class Name Symbol Table Construction (type null)
    - [x] Class type symbol table construction
    - [x] Function + Variable Type Construction
- [x] Type Inference
- [ ] Type Resolving/Checking
- [ ] Transform Operator Overrides (AST -> AST)
- [ ] Closure Handling / Free variables (AST -> AST)
[x] Generate Class Descriptions (Class Tables -> Output)
- [x] Generate Function Code (AST -> Output)

## Symbol Tables Needed:
- Class name symbol table
- Global Var and function tables
- Local var and function tables

## TODO/NOTES
- TODO: make inheritance lookup symbols in parent table, use existing entries if overriding functions or vars
- TODO: custom code to handle declare_proto (now just needs to handle global vars, functions handled)
- TODO: Namespaces (packages, also nested classes, etc)
- TODO: keep namespace names, etc, in name entry in symbol tables (not key, name in value)

## Op Overriding Notes
### Arrays
`+` returns the result of concatenating two arrays of the same type together
```
var msg: []string = "hello, "
msg += "world!"
print(msg) #-> "hello, world!\n"
```

`<<` returns the result of appending an element to an array
```
var msg: []string = "hello"
print(msg << '!') #-> "hello!"
```



[]: google.com
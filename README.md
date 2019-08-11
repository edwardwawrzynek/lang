## Features
- [x] Variables
    - [x] Global Vars
    - [x] Local Vars
    - [x] Type Inference
- [x] Global Funcs
- [x] Arrays
    - [ ] Complete builtin functions
- [x] Basic Math
    - [x] Math Assign
- [ ] Nested Funcs and Closure Conversion
    - [ ] Class Closure Conversion
- [x] Classes
    - [x] Inheritance
    - [x] Polymorphism
    - [x] this reference
    - [ ] super references
    - [ ] Operator Overloading
- [ ] Garbage Collection
    - [ ] Objetcs
    - [ ] Arrays
    - [ ] Closures
- [ ] Exception Handling
    - [ ] Stack Trace?
- [ ] Namespaces/Modules (some refactoring?)
    - [ ] Imports
    - [ ] Auto Header Generation
- [ ] Generics
    - [ ] Boxed Types
    - [ ] Type Coercion
    - [ ] Generics

## TODO/NOTES
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
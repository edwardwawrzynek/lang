/* --- Class Struct Declarations --- */
struct __ClassA;
typedef struct __ClassA __ClassA;
struct __ClassA_vtable;
struct __ClassA_array_type {
	unsigned int len;
	__ClassA** vals;
};

struct __ClassB;
typedef struct __ClassB __ClassB;
struct __ClassB_vtable;
struct __ClassB_array_type {
	unsigned int len;
	__ClassB** vals;
};

/* --- Class Struct Definitions --- */
struct __ClassB {
	struct __ClassB_vtable* _vtable;
	__ClassA* b;
	struct __int_array_type* c;
};
struct __ClassB_vtable {
	struct vtable_head _header;
	int (*add)(void*, int, int);
};

struct __ClassA {
	__ClassB _super;
	int a;
	__ClassB* b;
	struct __ClassA_array_type* c;
};
struct __ClassA_vtable {
	struct __ClassB_vtable _vtable_super;
	int (*method)(void*, int, __ClassB*, struct __ClassA_array_type*);
};


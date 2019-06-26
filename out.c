/* --- Class Struct Declarations --- */
struct __Person;
typedef struct __Person __Person;
struct __Person_vtable;
struct __Person_array_type {
	unsigned int len;
	__Person** vals;
};

/* --- Class Struct Definitions --- */
struct __Person {
	struct __Person_vtable* _vtable;
	__string * name;
	int age;
};
struct __Person_vtable {
	struct vtable_head _header;
};


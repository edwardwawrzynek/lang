struct __ClassA;
typedef struct __ClassA __ClassA;

struct __ClassB;
typedef struct __ClassB __ClassB;

struct __ClassB {
	__ClassA* b;
	struct __int_array_type * c;
};

struct __ClassB_array_type {
	unsigned int len;
	__ClassB** vals;
};

struct __ClassA {
	__ClassB _super;
	int a;
	__ClassB* b;
	struct __ClassA_array_type * c;
};

struct __ClassA_array_type {
	unsigned int len;
	__ClassA** vals;
};


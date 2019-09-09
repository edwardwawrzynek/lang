#ifndef _LANG_OBJECT_H
#define _LANG_OBJECT_H

#include "core/core.h"

struct __Object;
struct __Object_vtable;
struct __Object {
	struct __Object_vtable* _vtable;
};
struct __Object_vtable {
	struct _lang_vtable_head _header;
	void (*destruct)(void*);
	bool (*_op_equals)(void*, struct __Object*);
	long (*to_hash)(void*);
	_lang_array* (*to_string)(void*);
};

extern struct __Object_vtable __Object_vtable_inst;

void __Object_destruct(void *);
void __Object_construct(void *);
long __Object_to_hash(void *);
_lang_array* __Object_to_string(void *);
bool __Object__op_equals(void *, struct __Object*);
struct __Object* __Object(void *);

#endif
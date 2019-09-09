#include "core/object.h"

/**
 * class Object implementation
 * generated and modified by compiler
 * TODO: garbage collection description
 */

struct __Object_vtable __Object_vtable_inst = {
.destruct = &__Object_destruct,
._op_equals = &__Object__op_equals,
.to_hash = &__Object_to_hash,
.to_string = &__Object_to_string,
._header = {
/* TODO: gc_desk */
.parent_vtable = NULL,
},
};

void __Object_construct(void *_data) {
	/* nothing to do */
}

void __Object_destruct(void *_data) {
	/* nothing to do */
}

long __Object_to_hash(void *_data) {
return (long)(_data);
}

_lang_array* __Object_to_string(void *_data) {
return (_lang_array*)(_lang_make_string("Object"));
}

bool __Object__op_equals(void *_data, struct __Object* other) {
return _data == other;
}

struct __Object* __Object(void * _data) {
	struct __Object* _obj = _lang_gc_alloc(sizeof(struct __Object));
	((struct __Object *)_obj)->_vtable = (struct __Object_vtable *)&__Object_vtable_inst;
	__Object_construct(_obj);
	return _obj;
}

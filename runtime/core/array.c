#include "core/core.h"
#include <string.h>
#include <stdlib.h>
#include <stdarg.h>

_lang_array _lang_empty_array = {.len = 0, .vals = NULL};

/* is_pointer is needed for garbage collection */
static _lang_array * _lang_array_new(bool is_pointer) {
	_lang_array * res = _lang_gc_alloc(sizeof(_lang_array));
	/* TODO: gc_desk */
	return res;
}

/* Make a []char from a c string */
_lang_array * _lang_make_string(char * msg) {
    _lang_array * res = _lang_array_new(false);

    size_t len = strlen(msg);
    char * array_body = _lang_gc_alloc(len);

    memcpy(array_body, msg, len);

    res->len = len;
    res->vals = array_body;

    return res;
}

/* combine two arrays */
_lang_array * _lang_array_cat(_lang_array * a0, _lang_array * a1, size_t elem_size, bool is_pointer) {
	_lang_array * res = _lang_array_new(is_pointer);

	size_t len = a0->len + a1->len;
	void * body = _lang_gc_alloc(len * elem_size);
	memcpy(body, a0->vals, a0->len * elem_size);
	memcpy(body + a0->len * elem_size, a1->vals, a1->len * elem_size);

	res->vals = body;
	res->len = len;

	return res;
}

/* contains all but type specifics for _lang_array_add */
static _lang_array * _lang_array_add(_lang_array * a0, size_t elem_size, void * elem, bool is_pointer) {
	_lang_array * res = _lang_array_new(is_pointer);

	size_t len = a0->len + 1;
	void * body = _lang_gc_alloc(len*elem_size);
	memcpy(body, a0->vals, a0->len * elem_size);
	memcpy(body + a0->len * elem_size, elem, elem_size);

	res->vals = body;
	res->len = len;

	return res;

}

/* add element to array */
_lang_array * _lang_array_add_char(_lang_array * a0, char e) {
	return _lang_array_add(a0, sizeof(e), &e, false);
}

_lang_array * _lang_array_add_bool(_lang_array * a0, bool e) {
	return _lang_array_add(a0, sizeof(e), &e, false);
}

_lang_array * _lang_array_add_int(_lang_array * a0, int e) {
	return _lang_array_add(a0, sizeof(e), &e, false);
}

_lang_array * _lang_array_add_long(_lang_array * a0, long e) {
	return _lang_array_add(a0, sizeof(e), &e, false);
}

_lang_array * _lang_array_add_pointer(_lang_array * a0, void * e) {
	return _lang_array_add(a0, sizeof(e), &e, true);
}

/* make an array from an arbitrary number of elements */
#define make_lang_make_array(type, va_arg_type, func_name, is_ptr)  \
_lang_array * func_name(size_t elems, ...) {						\
	va_list args;													\
	va_start(args, elems);											\
																	\
	_lang_array * res = _lang_array_new(is_ptr);					\
																	\
	void * body = _lang_gc_alloc(elems * sizeof(type));				\
																	\
	for(int i = 0; i < elems; i++) {								\
		type arg = va_arg(args, va_arg_type);						\
		memcpy(body + i*sizeof(type), &arg, sizeof(type));			\
	}																\
																	\
	res->vals = body;												\
	res->len = elems;												\
	va_end(args);													\
	return res;														\
}

make_lang_make_array(char, int, _lang_make_array_char, false)
make_lang_make_array(int, int, _lang_make_array_int, false)
make_lang_make_array(long, long, _lang_make_array_long, false)
make_lang_make_array(bool, int, _lang_make_array_bool, false)
make_lang_make_array(void *, void *, _lang_make_array_pointer, true)

/* return array without the element at specified position */
_lang_array * _lang_array_remove_at(_lang_array * a, size_t pos, size_t elem_size, bool is_pointer) {
	_lang_array * res = _lang_array_new(is_pointer);

	void * body = _lang_gc_alloc((a->len - 1) * elem_size);

	memcpy(body, a->vals, pos*elem_size);
	memcpy(body + pos*elem_size, a->vals + (pos+1)*elem_size, (a->len - (pos + 1))*elem_size);

	res->vals = body;
	res->len = a->len - 1;

	return res;
}
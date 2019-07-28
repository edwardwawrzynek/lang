#include "core.h"
#include <string.h>
#include <stdlib.h>

_lang_array _lang_empty_array = {.len = 0, .vals = NULL};

/* Allocate a section of memory
   TODO: actual garbage collection */
void * _lang_gc_alloc(size_t size){
    return malloc(size);
}

/* Make a []char from a c string */
_lang_array * _lang_make_string(char * msg) {
    _lang_array * res = _lang_gc_alloc(sizeof(_lang_array));

    size_t len = strlen(msg);
    char * array_body = _lang_gc_alloc(len);

    memcpy(array_body, msg, len);

    res->len = len;
    res->vals = array_body;

    return res;
}

/* combine two arrays */
_lang_array * _lang_array_cat(_lang_array * a0, _lang_array * a1) {
	_lang_array * res = _lang_gc_alloc(sizeof(_lang_array));

	size_t len = a0->len + a1->len;
	void * body = _lang_gc_alloc(len);
	memcpy(body, a0->vals, a0->len);
	memcpy(body + a0->len, a1->vals, a1->len);

	res->vals = body;
	res->len = len;

	return res;
}

/* contains all but type specifics for _lang_array_add */
static _lang_array * _lang_array_add(_lang_array * a0, size_t elem_size, void * elem) {
	_lang_array * res = _lang_gc_alloc(sizeof(_lang_array));

	size_t len = a0->len + elem_size;
	void * body = _lang_gc_alloc(len);
	memcpy(body, a0->vals, a0->len);
	memcpy(body + a0->len, elem, elem_size);

	res->vals = body;
	res->len = len;

	return res;

}

/* add element to array */
_lang_array * _lang_array_add_char(_lang_array * a0, char e) {
	return _lang_array_add(a0, sizeof(e), &e);
}

_lang_array * _lang_array_add_bool(_lang_array * a0, bool e) {
	return _lang_array_add(a0, sizeof(e), &e);
}

_lang_array * _lang_array_add_int(_lang_array * a0, int e) {
	return _lang_array_add(a0, sizeof(e), &e);
}

_lang_array * _lang_array_add_long(_lang_array * a0, long e) {
	return _lang_array_add(a0, sizeof(e), &e);
}

_lang_array * _lang_array_add_pointer(_lang_array * a0, void * e) {
	return _lang_array_add(a0, sizeof(e), &e);
}
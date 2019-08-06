#ifndef _LANG_ARRAY_H
#define _LANG_ARRAY_H

#include "core/core.h"

/* Array Type */
typedef struct {
    /* number of entries in the array */
    size_t len;
    /* size of each element in the array */
    size_t elem_size;
    /* actual data in the array will need to be casted to pointer to type when used (int array cats vals to int*, Object to Object**) */
    void * vals;
} _lang_array;

/* Make a lang_array from a c string */
_lang_array * _lang_make_string(char *);

/* make an empty array */
_lang_array * _lang_array_make_empty(bool is_pointer, size_t elem_size);

/* add element to array */
_lang_array * _lang_array_cat(_lang_array * a0, _lang_array * a1, bool);
_lang_array * _lang_array_add_char(_lang_array *, char);
_lang_array * _lang_array_add_bool(_lang_array *, bool);
_lang_array * _lang_array_add_int(_lang_array *, int);
_lang_array * _lang_array_add_long(_lang_array *, long);
_lang_array * _lang_array_add_pointer(_lang_array *, void *);

/* make an array from a set of elements */
_lang_array * _lang_make_array_char(size_t, ...);
_lang_array * _lang_make_array_int(size_t, ...);
_lang_array * _lang_make_array_long(size_t, ...);
_lang_array * _lang_make_array_bool(size_t, ...);
_lang_array * _lang_make_array_pointer(size_t, ...);

_lang_array * _lang_array_remove_at(_lang_array * a, size_t pos, bool is_pointer);

#endif
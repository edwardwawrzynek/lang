#ifndef _LANG_ARRAY_H
#define _LANG_ARRAY_H

#include "core/core.h"

/* Array Type */
typedef struct {
    /* number of entries in the array */
    size_t len;
    /* actual data in the array will need to be casted to pointer to type when used (int array cats vals to int*, Object to Object**) */
    void * vals;
} _lang_array;

/* Empty Array Value */
extern _lang_array _lang_empty_array;

/* Array Functions */
_lang_array * _lang_make_string(char *);
_lang_array * _lang_array_cat(_lang_array *, _lang_array *);
_lang_array * _lang_array_add_char(_lang_array *, char);
_lang_array * _lang_array_add_bool(_lang_array *, bool);
_lang_array * _lang_array_add_int(_lang_array *, int);
_lang_array * _lang_array_add_long(_lang_array *, long);
_lang_array * _lang_array_add_pointer(_lang_array *, void *);

#endif
#include "core.h"
#include <string.h>
#include <stdlib.h>

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
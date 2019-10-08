#ifndef _LANG_GC_H
#define _LANG_GC_H

#include "core/core.h"

/**
 * The Garbage Collection systems needs a way to know what parts of
 * objects are data, pointers, or pointers to arrays
 * packing space is listed as data, as the gc will ignore data anyway */

enum _lang_gc_type {
	OBJECT,			/* normal gc type, a mix of data and pointers */
	ARRAY_DATA,		/* _lang_array, where vals is a pointer to some kind of data */
	ARRAY_POINTERS, /* _lang_array, wehere vals is a pointer to array of pointers to objects */
	CLOSURE,		/* _lang_closure */
};

struct _lang_gc_desk {
    /* Type of object */
    enum _lang_gc_type type;
    /* array of booleans indicating if each pointer aligned value in the object is data or a pointer */
    /* this only matters for type OBJECT (and CLOSURE?) - the rest are defined by other elements */
    bool * is_pointer;
    /* size of the object (applicable only to OBJECT) in bytes. Length of is_pointer is size/sizeof(void *)*/
	size_t size;

};

/* Allocate memory for use by program */
void * _lang_gc_alloc(size_t);
/* Allocate memory for use by c method, sets a basic gc_desk */
void * _lang_gc_alloc_internal(size_t);
/* Free memory alloc'd by _lang_gc_alloc_internal */
void _lang_gc_free_internal(void * data);
/* Allocate space for gc descriptions (never freed/collected) */
void * _lang_gc_calloc_gc_desk_space(size_t size);

#endif
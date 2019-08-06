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
    /* TODO */
    /* Notes:
        - We can probably assume pointers will all be the same size and have the same alignment
        - Structs with pointers will probably have the same alignment as each other, desc may just be on pointer size level
            - Objects of ending with data smaller pointer size (ex. 16 bit int) may present difficulties
                - A length flag may solve this
                    - gc_malloc will probably have to return slots aligned to machine word size values (or just hard 64 bits), so length may not be an issue - object size is based on pointer-size dec
        - Array type structs may not need gc_desk themselves, pointers to them can just be of a signle type (problem: array structs as roots, add_root or similair will probably have to specify type, may complicate)
    */

};

/* Core functions (see core.c) */
void * _lang_gc_alloc(size_t);

#endif
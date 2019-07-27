/****
Main Runtime Header
Included everything necessary for the compiler to produce a working program
Mostly just memory management at this point
****/

#ifndef _LANG_CORE_H
#define _LANG_CORE_H

#include <stddef.h>

/* Array Type */
typedef struct {
    /* number of entries in the array */
    size_t len;
    /* actual data in the array will need to be casted to pointer to type when used (int array cats vals to int*, Object to Object**) */
    void * vals;
} _lang_array;

/* Closure Type */
typedef struct {
	/* function pointer */
	void * func;
	/* pointer to gc-managed struct containing the data passed to the function */
	void * data;
} _lang_closure;

/**
 * The Garbage Collection systems needs a way to know what parts of
 * objects are data, pointers, or pointers to arrays
 * packing space is listed as data, as the gc will ignore data anyway */
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

/* Upper most vtable in all classes hierarchies */
struct _lang_vtable_head {
    /* Garbage Collection description of object */
    struct _lang_gc_desk gc;
    /* Pointer to vtable of parent class
     * because each class uses the same unique vtable,
     * runtime type checking is done based on an object's vtable pointer
     * parent allows for (somewhat inefficient) hierarchy checks */
     void * parent_vtable;
};

/* Core functions (see core.c) */
void * _lang_gc_alloc(size_t size);
_lang_array * _lang_make_string(char * msg);

#endif
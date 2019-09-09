/****
Main Runtime Header
Included everything necessary for the compiler to produce a working program
Mostly just memory management at this point
****/

#ifndef _LANG_CORE_H
#define _LANG_CORE_H

#include <stddef.h>
#include <stdbool.h>
#include <string.h>

#include "core/array.h"
#include "core/gc.h"

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

/* Closure Type */
typedef struct {
	/* function pointer */
	void * func;
	/* pointer to gc-managed struct containing the data passed to the function */
	void * data;
} _lang_closure;

extern void * _lang_temp_this;

void _lang_init();

#endif
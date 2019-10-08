#include "core/core.h"
#include <string.h>
#include <stdlib.h>


/* Allocate a section of memory
   TODO: actual garbage collection */
void * _lang_gc_alloc(size_t size){
    return malloc(size);
}

/**
 * Allocate memory to be used as part of an object's garbage collection description
 * Should never be collected (nor freed) */
 void * _lang_gc_calloc_gc_desk_space(size_t size) {
 	return calloc(size, 1);
 }

/**
 * Used by internal lang methods to get memory that will be thrown away before we hit
 * lang_gc_alloc
 * Must be freed explicitly with _lang_gc_free_internal */
void * _lang_gc_alloc_internal(size_t size) {
	/* TODO: set a gc_desk that is just data, and add this to roots */
	/* Should return memory, not header */
	return malloc(size);
}

void _lang_gc_free_internal(void * data) {
	/* subtract from pointer to get full header */
	/* TODO: probably just remove a root here and let normal gc take care of it */
	free(data);
}
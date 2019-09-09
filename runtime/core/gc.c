#include "core/core.h"
#include <string.h>
#include <stdlib.h>

void * _lang_temp_this;

/* Allocate a section of memory
   TODO: actual garbage collection */
void * _lang_gc_alloc(size_t size){
    return malloc(size);
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
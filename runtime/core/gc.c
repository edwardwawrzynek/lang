#include "core/core.h"
#include <string.h>
#include <stdlib.h>

/* Allocate a section of memory
   TODO: actual garbage collection */
void * _lang_gc_alloc(size_t size){
    return malloc(size);
}
#include "core/core.h"
#include <string.h>
#include <stdlib.h>

void * _lang_temp_this;

/* Allocate a section of memory
   TODO: actual garbage collection */
void * _lang_gc_alloc(size_t size){
    return malloc(size);
}
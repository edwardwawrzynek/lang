#include <stddef.h>
#include <stdint.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* Prototype of basic runtime defs */

/* Array Type */
struct array_type {
    /* number of entries in the array */
    unsigned int len;
    /* actual data in the array will need to be casted to pointer to type when used (int array cats vals to int*, Object to Object**) */
    void * vals;
};

/**
 * The Garbage Collection systems needs a way to know what parts of
 * objects are data, pointers, or pointers to arrays
 * packing space is listed as data, as the gc will ignore data anyway */
struct gc_desk {
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

struct vtable_head {
    /* Garbage Collection description of object */
    struct gc_desk gc;
    /* Pointer to vtable of parent class
     * because each class uses the same unique vtable,
     * runtime type checking is done based on an object's vtable pointer
     * parent allows for (somewhat inefficient) hierarchy checks */
     void * parent_vtable;
};

/* basic runtime ops */
void __printNumber(void * _data, int msg) {
    printf("%d\n", msg);
}

void * gc_alloc(size_t size){
    return malloc(size);
}

struct array_type * makeString(char * msg) {
    struct array_type * res = gc_alloc(sizeof(struct array_type));
    res->len = strlen(msg);
    char * str = gc_alloc(res->len);
    res->vals = (void *)str;
    for(size_t i = 0; i < res->len; i++){
        str[i] = msg[i];
    }
}
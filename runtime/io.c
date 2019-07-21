#include <stdio.h>
#include "core.h"
#include "io.h"
/* Input/Output functions */

/* Print a string to stdout */
void __print(void * _data, _lang_array * msg) {
    fwrite((char *)(msg->vals), 1, msg->len, stdout);
}
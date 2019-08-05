#ifndef _LANG_IO_H
#define _LANG_IO_H

#include "core/core.h"
/* Print a string to stdout */
void __print(void * _data, _lang_array * msg);
void __putc(void * _data, char c);
void __printNumber(void * _data, long n);

#endif
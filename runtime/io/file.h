#ifndef _LANG_FILE_H
#define _LANG_FILE_H

#include "core/core.h"
#include "core/object.h"
#include "core/array.h"
#include <stdio.h>

struct __io__File;
struct __io__File_vtable;
extern struct __io__File_vtable __io__File_vtable_inst;

struct __io__File {
	struct __Object _super;
	FILE * _cfile;
};
struct __io__File_vtable {
	struct __Object_vtable _vtable_super;
	void (*putc)(void*, char);
	void (*print)(void*, _lang_array*);
	void (*println)(void*, _lang_array*);
	_lang_array* (*read)(void*, long);
	void (*flush)(void*);
	char (*getc)(void*);
	_lang_array* (*readln)(void*);
	void (*close)(void*);
};

void __io__File_construct(void *, _lang_array*, _lang_array*);
void __io__File_destruct(void *);
void __io__File_putc(void *, char);
void __io__File_print(void *, _lang_array*);
void __io__File_println(void *, _lang_array*);
char __io__File_getc(void *);
_lang_array* __io__File_read(void *, long);
_lang_array* __io__File_readln(void *);
void __io__File_flush(void *);
void __io__File_close(void *);
_lang_array* __io__File_to_string(void *);
struct __io__File* __io__File(void *, _lang_array*, _lang_array*);

extern struct __io__File* __io__stdout;
extern struct __io__File* __io__stdin;
extern struct __io__File* __io__stderr;

void _lang_io_stdstreams_init();

#endif
#include "io/file.h"
#include <assert.h>

/* TODO: implement expections:
FileNotFound
Write on Readonly, Read on write only, etc */
/* TODO:
implement seeking */

/* io.stdin, io.stdout, io.stderr */
struct __io__File _lang_io_stdout = {
._cfile = NULL,
._super = {
	._vtable = (struct __Object_vtable *)(&__io__File_vtable_inst)
}
};

struct __io__File _lang_io_stdin = {
._cfile = NULL,
._super = {
	._vtable = (struct __Object_vtable *)(&__io__File_vtable_inst)
}
};

struct __io__File _lang_io_stderr = {
._cfile = NULL,
._super = {
	._vtable = (struct __Object_vtable *)(&__io__File_vtable_inst)
}
};

struct __io__File* __io__stdout = &_lang_io_stdout;
struct __io__File* __io__stdin = &_lang_io_stdin;
struct __io__File* __io__stderr = &_lang_io_stderr;

/* initialize std file streams */
void _lang_io_stdstreams_init() {
	_lang_io_stdout._cfile = stdout;
	_lang_io_stdin._cfile = stdin;
	_lang_io_stderr._cfile = stderr;
}

/* io.File class */
void __io__File_construct(void *_data, _lang_array* path, _lang_array* mode) {
	/* open file */
	char * path_str = _lang_char_array_to_string(path);
	char * mode_str = _lang_char_array_to_string(mode);
	((struct __io__File *)(_data))->_cfile = fopen(path_str, mode_str);
	_lang_gc_free_internal(path_str);
	_lang_gc_free_internal(mode_str);
	/* TODO: check _cfile for NULL, raise error */
	assert(((struct __io__File *)(_data))->_cfile != NULL);
}

void __io__File_destruct(void *_data) {
	__io__File_close(_data);
}

void __io__File_putc(void *_data, char c) {
	fputc(c, ((struct __io__File *)(_data))->_cfile);
}

void __io__File_print(void *_data, _lang_array* s) {
	fwrite(s->vals, s->elem_size, s->len, ((struct __io__File *)(_data))->_cfile);
}

void __io__File_println(void *_data, _lang_array* s) {
	__io__File_print(_data, s);
	__io__File_putc(_data, '\n');
}

char __io__File_getc(void *_data) {
	return fgetc(((struct __io__File *)(_data))->_cfile);
}

_lang_array* __io__File_read(void *_data, long len) {
	_lang_array * res = _lang_array_make_empty(false, 1);
	char * data = _lang_gc_alloc(len);
	res->vals = data;
	res->len = len;
	fread(data, 1, len, ((struct __io__File *)(_data))->_cfile);
	return res;
}

_lang_array* __io__File_readln(void *_data) {
	/* TODO: implement */
	assert(false);
	return (_lang_array*)(_lang_make_string("hello\n"));
}

void __io__File_flush(void *_data) {
	fflush(((struct __io__File *)(_data))->_cfile);
}

void __io__File_close(void *_data) {
	fclose(((struct __io__File *)(_data))->_cfile);
}

_lang_array* __io__File_to_string(void *_data) {
return (_lang_array*)(_lang_make_string("File"));
}

struct __io__File* __io__File(void * _data, _lang_array* arg0, _lang_array* arg1) {
	struct __io__File* _obj = _lang_gc_alloc(sizeof(struct __io__File));
	((struct __Object *)_obj)->_vtable = (struct __Object_vtable *)&__io__File_vtable_inst;
__io__File_construct(_obj,  arg0,  arg1);
	return _obj;
}

struct __io__File_vtable __io__File_vtable_inst = {
.putc = &__io__File_putc,
.print = &__io__File_print,
.println = &__io__File_println,
.read = &__io__File_read,
.flush = &__io__File_flush,
.getc = &__io__File_getc,
.readln = &__io__File_readln,
.close = &__io__File_close,
._vtable_super = {
.destruct = &__io__File_destruct,
._op_equals = &__Object__op_equals,
.to_hash = &__Object_to_hash,
.to_string = &__io__File_to_string,
._header = {
/* TODO: gc_desk */
.parent_vtable = &__Object_vtable_inst,
},
},
};
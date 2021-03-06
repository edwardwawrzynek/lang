#include <stdio.h>
#include "core/core.h"
#include "io/io.h"
#include "io/file.h"
/* Input/Output functions */

void _lang_io_init() {
	_lang_io_stdstreams_init();
}

/*
void __print(void * _data, _lang_array * msg) {
    fwrite((char *)(msg->vals), 1, msg->len, stdout);
}

void __putc(void * _data, char c) {
	putchar(c);
}

void __printNumber(void * _data, long n) {
	printf("%li", n);
}

char buf[256];

_lang_array * __readLine(void * _data) {
	_lang_array * res = _lang_gc_alloc(sizeof(_lang_array));

	size_t pos = 0;

	while(true) {
		char c = fgetc(stdin);
		if(c != EOF && c != '\n' && pos < 255) {
			buf[pos++] = c;
		} else {
			_lang_array * body = _lang_gc_alloc(pos);
			memcpy(body, buf, pos);
			res->vals = body;
			res->len = pos;
			break;
		}
	}

	return res;
}
*/
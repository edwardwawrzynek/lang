#include <stdio.h>
#include "core/core.h"
#include "io/io.h"
/* Input/Output functions */

/* Print a string to stdout */
void __print(void * _data, _lang_array * msg) {
    fwrite((char *)(msg->vals), 1, msg->len, stdout);
}

/* TODO: variable length */
char buf[256];

/* read a line from stdin */
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
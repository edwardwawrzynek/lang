#include "core/core.h"
#include "io/io.h"

/* init stuff that needs to be called before program execution (memory management, io, etc) */
void _lang_init() {
	_lang_io_init();
}
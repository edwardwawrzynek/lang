#include "core/math.h"
#include <stdlib.h>

double __math__sqrt(void * _data, double val) {
	return sqrt(val);
}

long __math__rand(void * _data) {
	return rand();
}

double __math__rand_double(void * _data) {
	return rand() / (RAND_MAX + 1.0);
}
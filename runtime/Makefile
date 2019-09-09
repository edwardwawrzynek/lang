TARGET = liblangruntime.a

CC = gcc
CFLAGS = -g -Wall -fPIC -I.

OBJS = core/array.o core/gc.o core/core.o io/io.o core/object.o io/file.o
DEPS = core/array.h core/gc.h core/core.h io/io.h core/object.h io/file.h

.PHONY: all clean

all: $(TARGET)

%.o: %.cpp $(DEPS)
	$(CC) $(CFLAGS) -c -o $@ $<

$(TARGET): $(OBJS)
	ar rcs $(TARGET) $(OBJS)

clean:
	rm -f $(OBJS) $(TARGET)

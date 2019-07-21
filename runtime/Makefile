TARGET = liblangruntime.a

CC = gcc
CFLAGS = -g -Wall -fPIC

OBJS = core.o io.o
DEPS = core.h io.h

.PHONY: all clean

all: $(TARGET)

%.o: %.cpp $(DEPS)
	$(CC) $(CFLAGS) -c -o $@ $<

$(TARGET): $(OBJS)
	ar rcs $(TARGET) $(OBJS)

clean:
	rm -f $(OBJS) $(TARGET)
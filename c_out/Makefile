TARGET = out

CC = gcc
CFLAGS = -g -Wall -I ../runtime/
LDFLAGS = -llangruntime -L../runtime/ -lm

OBJS = out.o
DEPS =

.PHONY: all clean

all: $(TARGET)

%.o: %.cpp $(DEPS)
	$(CC) $(CFLAGS) -c -o $@ $<

$(TARGET): $(OBJS)
	$(CC) -o $(TARGET) $(OBJS) $(LDFLAGS)

clean:
	rm -f $(OBJS) $(TARGET)

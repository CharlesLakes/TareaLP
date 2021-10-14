compile: simulacion.o Animal.o
	gcc simulacion.o Animal.o -o main.o -Wall
Animal.o: Animal.c Animal.h
	gcc -c Animal.c -Wall
simulacion.o: simulacion.c Animal.h
	gcc -c simulacion.c -Wall
clear:
	rm simulacion.o Animal.o main.o
leaks: main.o
	valgrind --leak-check=yes ./main.o
run-dev:
	make clear && make compile && make leaks

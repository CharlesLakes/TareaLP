Nombre: Carlos Lagos
Rol: 202073571-9

Para usar el Makefile se tiene que instalar make con:
    apt-get install make
Con esto instalado para compilar se usa:
    make compile
Y para ejecutar se puede usar:
    make run
O tambien:
    ./main.o

Si se quiere borrar todos los ejecutables se puede hacer con:
    make clear

Si se quiere obtener los leaks de memoria se tiene que instalar valgrind con:
    apt-get install valgrind
y usar:
    make leaks


En el caso de no poder instalar make se puede compilar con:
    gcc simulacion.c Animal.c -o main.o -Wall
y para ejecutar:
    ./main.o
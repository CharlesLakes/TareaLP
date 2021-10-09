#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Animal.h"

int main(){
    srand(time(NULL));
    Animal a;
    CrearAnimal(&a);
    MostrarAnimal(&a);
    return 0;
}
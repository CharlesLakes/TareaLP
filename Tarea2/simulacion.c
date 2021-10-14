#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Animal.h"

void BorrarMundo(Animal **Mundo){
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            Borrar(&(Mundo[i][j]));
        }
        free(Mundo[i]);
    }
    free(Mundo);
    
}

void MostrarMundo(Animal **Mundo){
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[i][j].fuerza != NULL && Mundo[i][j].velocidad != NULL && Mundo[i][j].resistencia != NULL){
                printf("(");
                auxImprimirTipo(Mundo[i][j].tipo_fuerza,Mundo[i][j].fuerza);
                printf(",");
                auxImprimirTipo(Mundo[i][j].tipo_velocidad,Mundo[i][j].velocidad);
                printf(",");
                auxImprimirTipo(Mundo[i][j].tipo_resistencia,Mundo[i][j].resistencia);
                printf(") ");
            }else printf("()");   
        }
        printf("\n");
    }
}

Animal** CrearMundo(){
    Animal **Mundo = (Animal **)malloc(sizeof(Animal *)*SIZE);
    for(int i = 0; i < SIZE; i++){
        Mundo[i] = (Animal *)malloc(sizeof(Animal)*SIZE);
        for(int j = 0; j < SIZE; j++){
            Mundo[i][j].fuerza = NULL;
            Mundo[i][j].velocidad = NULL;
            Mundo[i][j].resistencia = NULL;
        }
    }
    
    return Mundo;
}

int main(){
    Animal **Mundo = CrearMundo();
    MostrarMundo(Mundo);
    BorrarMundo(Mundo);
    return 0;
}
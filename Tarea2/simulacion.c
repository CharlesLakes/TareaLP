#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Animal.h"


void BorrarMundo(Animal **Mundo){
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[i][j].fuerza != NULL && Mundo[i][j].velocidad != NULL && Mundo[i][j].resistencia != NULL)
                Borrar(&(Mundo[i][j]));
        }
        free(Mundo[i]);
    }
    free(Mundo);
    
}

void MostrarMundo(Animal **Mundo){
    printf("Lista animales de el mundo");
    printf("Cordenada\t(fuerza,velocidad,resistencia)\n");
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[i][j].fuerza != NULL && Mundo[i][j].velocidad != NULL && Mundo[i][j].resistencia != NULL){
                printf("(%d,%d)\t",i,j);
                printf("(");
                auxImprimirTipo(Mundo[i][j].tipo_fuerza,Mundo[i][j].fuerza);
                printf(",");
                auxImprimirTipo(Mundo[i][j].tipo_velocidad,Mundo[i][j].velocidad);
                printf(",");
                auxImprimirTipo(Mundo[i][j].tipo_resistencia,Mundo[i][j].resistencia);
                printf(")\n");
            };   
        }
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

void AvanzarIteracion(Animal** Mundo){
    
};

void Menu(){
    int flag = 1, opcion;
    Animal** Mapa = CrearMundo();

    printf(" -- Menu -- \n");
    do{
        printf("1. Crear un animal\n");
        printf("2. Avanzar iteración\n");
        printf("3. Mostrar mundo\n");
        printf("4. Terminar\n");
        printf("-> ");
        scanf("%d",&opcion);
        if(0 >= opcion && opcion >= 4){
            printf("Opción erroena.\n");
        }else if(opcion == 1){
            int x,y;
            printf("Ingresa las cordenadas. (x en [0,1000]), y en [0,1000]\n");
            printf("x: ");
            scanf("%d",&x);
            printf("y: ");
            scanf("%d",&y);
            CrearAnimal(&(Mapa[y][x]));
        }else if(opcion == 2){
            AvanzarIteracion(Mapa);
        }else if(opcion == 3){
            MostrarMundo(Mapa);
        }else{
            flag = 0;
        };
        

    } while (flag);

    BorrarMundo(Mapa);
}
    
    

int main(){
    srand(time(NULL));
    Menu();
    return 0;
}
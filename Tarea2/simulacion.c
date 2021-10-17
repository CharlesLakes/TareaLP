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
    printf("Lista animales de el mundo\n");
    printf("Cordenada\t(fuerza,velocidad,resistencia)\n");
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[i][j].fuerza != NULL && Mundo[i][j].velocidad != NULL && Mundo[i][j].resistencia != NULL){
                printf("(%d,%d):\t",j,i);
                MostrarAnimal(&(Mundo[i][j]));
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

void Colision(Animal* inicio, Animal* destino, Animal* hijo){
    Animal temp = *inicio;
    inicio->fuerza = NULL;
    inicio->velocidad = NULL;
    inicio->resistencia = NULL;

    Reproducir(&temp,destino,hijo);
    ComerOHuir(&temp,destino);

    if(temp.fuerza != NULL && temp.velocidad != NULL && temp.resistencia != NULL)
        *destino = temp;
    
}

void ProcesarHijo(Animal hijo, Animal** Mundo, Animal** NuevoMundo, int x , int y){
    if(Mundo[y][(x  - 1)%SIZE].fuerza == NULL && NuevoMundo[y][(x  - 1)%SIZE].fuerza == NULL)
        NuevoMundo[y][(x  - 1)%SIZE] = hijo;
    
    else if(Mundo[(y + 1)%SIZE][x].fuerza == NULL  && NuevoMundo[(y + 1)%SIZE][x].fuerza == NULL){
        NuevoMundo[(y + 1)%SIZE][x] = hijo;
    }
    else if(Mundo[y][(x  + 1)%SIZE].fuerza == NULL && NuevoMundo[y][(x  + 1)%SIZE].fuerza == NULL )
        NuevoMundo[y][(x + 1)%SIZE] = hijo;
    else if(Mundo[(y - 1)%SIZE][x].fuerza == NULL && NuevoMundo[(y - 1)%SIZE][x].fuerza == NULL )
        NuevoMundo[(y - 1)%SIZE][x] = hijo;
    else{
        Borrar(&hijo);
    }
}   

void LimpiarMundo(Animal** Mundo){
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            Mundo[j][i].fuerza = NULL;
            Mundo[j][i].velocidad = NULL;
            Mundo[j][i].resistencia = NULL;
        }
    }
}

void AvanzarIteracion(Animal **Mundo, Animal **NuevoMundo){
    AUX_MUNDO = Mundo;
    AUX_NUEVOMUNDO = NuevoMundo;
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[i][j].fuerza != NULL && Mundo[i][j].velocidad != NULL && Mundo[i][j].resistencia != NULL){
                int mov = rand() % 4;
                /*printf("(%d,%d)\n",i,j);
                int mov;
                printf("Opcion: ");
                scanf("%d",&mov);*/
                Animal hijo;
                

                if(mov == 0){
                    aux_y = (i + 1)%SIZE;
                    aux_x = j;
                }else if(mov == 1){
                    aux_y = (i - 1)%SIZE;
                    aux_x = j;
                }else if(mov == 2){
                    aux_y = i;
                    aux_x = (j + 1)%SIZE;
                    
                }else if(mov == 3){
                    aux_y = i;
                    aux_x = (j - 1)%SIZE;
                }

                if(aux_x < 0) aux_x = SIZE + aux_x;
                if(aux_y < 0) aux_y = SIZE + aux_y;
                //printf("d: (%d,%d)\n",aux_x,aux_y);

                if(NuevoMundo[aux_y][aux_x].fuerza != NULL && NuevoMundo[aux_y][aux_x].velocidad != NULL && NuevoMundo[aux_y][aux_x].resistencia != NULL){
                    Colision(&(Mundo[i][j]),&(NuevoMundo[aux_y][aux_x]),&hijo);
                    ProcesarHijo(hijo,Mundo,NuevoMundo,aux_x,aux_y);
                }else{
                    NuevoMundo[aux_y][aux_x] = Mundo[i][j];

                    Mundo[i][j].fuerza = NULL;
                    Mundo[i][j].resistencia = NULL;
                    Mundo[i][j].velocidad = NULL;
                };
            }
        }
    }
    LimpiarMundo(Mundo);
};

void Menu(){
    int flag = 1, opcion;
    Animal **temp;
    Animal **Mundo = CrearMundo();
    Animal **MundoTemporal = CrearMundo();
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
            do{
                printf("Ingresa las cordenadas. (x en [0,1000]), y en [0,1000]\n");
                printf("x: ");
                scanf("%d",&x);
                printf("y: ");
                scanf("%d",&y);
                if(Mundo[y][x].fuerza != NULL)
                    printf("Lugar ocupado.\n");
            } while (Mundo[y][x].fuerza != NULL);
            CrearAnimal(&(Mundo[y][x]));
        }else if(opcion == 2){
            AvanzarIteracion(Mundo,MundoTemporal);
            temp = Mundo;
            Mundo = MundoTemporal;
            MundoTemporal = temp;
        }else if(opcion == 3){
            MostrarMundo(Mundo);
        }else{
            flag = 0;
        };
        

    } while (flag);

    BorrarMundo(Mundo);
    BorrarMundo(MundoTemporal);


}
    
    

int main(){
    srand(time(NULL));
    Menu();
    return 0;
}
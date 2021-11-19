#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Animal.h"

/*****
* int auxiliarAsignacionDeCallbacks
******
* La funcion le piede al usuario que funcion se debe usar para el animal
******
* Input:
* Animal *a: puntero animal
* elementoCallback* listaCallbacks: lista de las funciones
* Animal *hijo: puntero animal (hijo)
******
* Returns:
* int, la seleccion de el usuario
*****/
int auxiliarAsignacionDeCallbacks(Animal *a,elementoCallback* listaCallbacks,int largo){
    int select;
    do{
        for(int i = 0; i < largo; i++) 
            printf("%d. %s\n",i + 1, listaCallbacks[i].nombre); 
        printf("-> ");
        scanf("%d",&select);
        if(select < 1 || select > largo) printf("Entrada erronea.\nEscribelo nuevamente.\n\n");
    } while (select < 1 || select > largo);
    return select - 1;
}

/*****
* void* CopiarMemoriaDeTipo
******
* La funcion copia el valor de la memoria de un atributo a otro
* usando una diferente memoria de heap
******
* Input:
* char tipo: es un caracter que indica el tipo de el valor
* void *valor: punero void que apunta a la direccion de memoria que guarda el valor
******
* Returns:
* void*, la nueva direccion de memoria
*****/

void* CopiarMemoriaDeTipo(char tipo, void *valor){
    void* atributo;
    if(tipo == 'e'){
        int *temp = (int *)malloc(sizeof(int));
        *temp = *((int *) valor);
        atributo = temp;
    }else if(tipo == 'c'){
        char *temp = (char *)malloc(sizeof(char));
        *temp = *((char *) valor);
        atributo = temp;
    }else if(tipo == 'f'){
        float *temp = (float *)malloc(sizeof(float));
        *temp = *((float *) valor);
        atributo = temp;
    }; 
    return atributo; 
};

/*****
* void* auxiliarAsignacionDeTipo
******
* La funcion le pide al usuario el valor de el atrbuto dependiendo de el tipo
******
* Input:
* char tipo: es un caracter que indica el tipo de el valor
******
* Returns:
* void*, la direccion de memoria de el atributo
*****/
void* auxiliarAsignacionDeTipo(char tipo){
    void* atributo;
    if(tipo == 'e'){
        atributo = (void *)malloc(sizeof(int));
        scanf(" %d",(int *) atributo);
    }else if(tipo == 'c'){
        atributo = (void *)malloc(sizeof(char));
        scanf(" %c",(char *) atributo);
    }else if(tipo == 'f'){
        atributo = (void *)malloc(sizeof(float));
        scanf(" %f",(float *) atributo);
    }; 
    return atributo; 
}

/*****
* void auxImprimirTipo
******
* La funcion imprime el valor de un atributo dependiendo su tipo
******
* Input:
* char tipo: es un caracter que indica el tipo de el valor
* void *valor: punero void que apunta a la direccion de memoria que guarda el valor
******
* Returns:
* void, sin return
*****/
void auxImprimirTipo(char tipo, void* valor){
    if(tipo == 'e')
        printf("%d",*((int *) valor));
    else if(tipo == 'c')
        printf("%c",*((char *) valor));
    else if(tipo == 'f')
        printf("%f",*((float *) valor));
};

/*****
* void auxImprimirTipo
******
* La funcion imprime el valor de un atributo dependiendo su tipo
******
* Input:
* char tipo: es un caracter que indica el tipo de el valor
* void *valor: punero void que apunta a la direccion de memoria que guarda el valor
******
* Returns:
* void, sin return
*****/
int AtributoANumero(char tipo, void *valor){
    if(tipo == 'e') 
        return *((int *) valor);
    if(tipo == 'f')
        return (int) (*((float *) valor) + 0.5);
    if(tipo == 'c')
        return ((int) *((char *) valor))/4; 
    return 0;
};

/*****
* void BorrarMundo
******
* La funcion borra el mundo y los animales en el y sus memoerias respectivas
******
* Input:
* Animal **Mundo: Es un punteros de punteros Animal (lista de listas de animales)
******
* Returns:
* void, sin return
*****/
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

/*****
* void MostrarMundo
******
* La funcion muestra los animales de el mundo por pantalla
******
* Input:
* Animal **Mundo: Es un punteros de punteros Animal (lista de listas de animales)
******
* Returns:
* void, sin return
*****/
void MostrarMundo(Animal **Mundo){
    printf("Lista animales de el mundo\n");
    printf("Cordenada\t(fuerza,velocidad,resistencia)\n");
    for(int j = 0; j < SIZE; j++){
        for(int i = 0; i < SIZE; i++){
            if(Mundo[j][i].fuerza != NULL && Mundo[j][i].velocidad != NULL && Mundo[j][i].resistencia != NULL){
                printf("(%d,%d):\t\n",i,j);
                MostrarAnimal(&(Mundo[j][i]));
            };   
        }
    }
}


/*****
* Animal** CrearMundo
******
* La funcion crear con memoria dinamica el mundo es decir una lista de listas
******
* Input:
******
* Returns:
* Animal**, puntero de punteros animal el cual contiene el mundo
*****/
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

/*****
* Animal** ProcesarHijo
******
* La funcion coloca al hijo producido en su casilla correspondiente 
* si esta ocupada muere
******
* Input:
* Animal hijo: es el hijo generado
* Animal** NuevoMundo: puntero de punteros Animal (lista de listas Animal)
* int x: Cordenada x
* int y: Cordenada y
******
* Returns:
* Animal**, puntero de punteros animal el cual contiene el mundo
*****/
void ProcesarHijo(Animal hijo, Animal** NuevoMundo, int x , int y){
    if(NuevoMundo[y][(SIZE + (x  - 1)%SIZE)%SIZE].fuerza == NULL)
        NuevoMundo[y][(SIZE + (x  - 1)%SIZE)%SIZE] = hijo;
    else if(NuevoMundo[(SIZE + (y - 1)%SIZE)%SIZE][x].fuerza == NULL)
        NuevoMundo[(SIZE + (y - 1)%SIZE)%SIZE][x] = hijo;
    else if(NuevoMundo[y][(SIZE + (x  + 1)%SIZE)%SIZE].fuerza == NULL )
        NuevoMundo[y][(SIZE + (x  + 1)%SIZE)%SIZE] = hijo;
    else if(NuevoMundo[(SIZE + (y + 1)%SIZE)%SIZE][x].fuerza == NULL )
        NuevoMundo[(SIZE + (y + 1)%SIZE)%SIZE][x] = hijo;
    else{
        Borrar(&hijo);
    }
}   

/*****
* void Colision
******
* La funcion reliza el comportamiento tras colisionar
* reporoduce a los animales y ejecuta comerohuir
* ademas coloca al hijo en su ubicacion respectica
******
* Input:
* Animal hijo: es el hijo generado
* Animal** NuevoMundo: puntero de punteros Animal (lista de listas Animal)
* int x: Cordenada x
* int y: Cordenada y
******
* Returns:
* Animal**, puntero de punteros animal el cual contiene el mundo
*****/
void Colision(Animal* inicio, Animal* destino, Animal** NuevoMundo, int x , int y){
    Animal hijo;
    Animal temp = *inicio;

    inicio->fuerza = NULL;
    inicio->velocidad = NULL;
    inicio->resistencia = NULL;

    Reproducir(&temp,destino,&hijo);
    ProcesarHijo(hijo,NuevoMundo,x,y);
    ComerOHuir(&temp,destino);

    if(temp.fuerza != NULL && temp.velocidad != NULL && temp.resistencia != NULL)
        *destino = temp;
    
}

/*****
* void LimpiarMundo
******
* Limpia el mundo sin borrar los animales
******
* Input:
* Animal** Mundo: puntero de punteros Animal (lista de listas Animal)
******
* Returns:
* void, sin returns
*****/
void LimpiarMundo(Animal** Mundo){
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            Mundo[j][i].fuerza = NULL;
            Mundo[j][i].velocidad = NULL;
            Mundo[j][i].resistencia = NULL;
        }
    }
}

/*****
* void AvanzarIteracion
******
* La funcion Muevo los animales y detecta las colisiones
******
* Input:
* Animal **Mundo: puntero de punteros Animal (lista de listas Animal) representa al mundo actual
* Animal **NuevoMundo: puntero de punteros Animal (lista de listas Animal) representa al mundo temporal
******
* Returns:
* void, sin returns
*****/
void AvanzarIteracion(Animal **Mundo, Animal **NuevoMundo){
    AUX_MUNDO = Mundo;
    AUX_NUEVOMUNDO = NuevoMundo;
    for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            if(Mundo[j][i].fuerza != NULL && Mundo[j][i].velocidad != NULL && Mundo[j][i].resistencia != NULL){
                int mov = rand() % 4;
                /*printf("(%d,%d)\n",i,j);
                int mov;
                printf("Opcion: ");
                scanf("%d",&mov);*/

                

                if(mov == 0){
                    aux_x = (i + 1)%SIZE;
                    aux_y = j;
                }else if(mov == 1){
                    aux_x = (i - 1)%SIZE;
                    aux_y = j;
                }else if(mov == 2){
                    aux_x = i;
                    aux_y = (j + 1)%SIZE;
                    
                }else if(mov == 3){
                    aux_x = i;
                    aux_y = (j - 1)%SIZE;
                }

                if(aux_x < 0) aux_x = SIZE + aux_x;
                if(aux_y < 0) aux_y = SIZE + aux_y;
                //printf("d: (%d,%d)\n",aux_x,aux_y);

                if(NuevoMundo[aux_y][aux_x].fuerza != NULL && NuevoMundo[aux_y][aux_x].velocidad != NULL && NuevoMundo[aux_y][aux_x].resistencia != NULL){
                    Colision(&(Mundo[j][i]),&(NuevoMundo[aux_y][aux_x]),NuevoMundo,aux_x,aux_y);
                }else{
                    NuevoMundo[aux_y][aux_x] = Mundo[j][i];

                    Mundo[j][i].fuerza = NULL;
                    Mundo[j][i].resistencia = NULL;
                    Mundo[j][i].velocidad = NULL;
                };
            }
        }
    }
    LimpiarMundo(Mundo);
};


/*****
* void Menu
******
* La funcion ejectuta el menu para que el usuario interactue con el programa
******
* Input:
******
* Returns:
* void, sin returns
*****/
void Menu(){
    int flag = 1, opcion;
    Animal **temp;
    Animal **Mundo = CrearMundo();
    Animal **MundoTemporal = CrearMundo();
    printf(" -- Menu -- \n");
    do{
        printf("1. Crear un animal.\n");
        printf("2. Avanzar iteración.\n");
        printf("3. Mostrar mundo.\n");
        printf("4. Cerrar programa.\n");
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
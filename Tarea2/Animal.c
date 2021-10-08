#include "Animal.h"
#include <stdio.h>
#include <stdlib.h>

void ReproduccionSimple(Animal* a1 ,Animal* a2 ,Animal* hijo){};
void ReproduccionCruzada(Animal* a1 ,Animal* a2 ,Animal* hijo){printf("xd\n");};
void ComerSiempre(Animal* a1 ,Animal* a2){};
void HuirSiempre(Animal* a1 ,Animal* a2){};
void ComerAleatorio(Animal* a1 ,Animal* a2){};

typedef struct elementoReproduccionOComerHuir{
    char* nombre;
    void (*reproduccion)(Animal*, Animal*, Animal*);
    void (*comerHuir)(Animal*, Animal*);
}elementoCallback;

elementoCallback reproducciones[] = {
    {"ReproduccionSimple",ReproduccionSimple,NULL},
    {"ReproduccionCruzada",ReproduccionCruzada,NULL}
};

elementoCallback funsComerOHuir[] = {
    {"ComerSiempre",NULL,ComerSiempre},
    {"HuirSiempre",NULL,HuirSiempre},
    {"ComerAleatorio",NULL,ComerAleatorio}

};



void* auxiliarTipo(char tipo){
    void* atributo;
    if(tipo == 'e'){
        atributo = (void *)calloc(1,sizeof(int));
        scanf(" %d",(int *) atributo);
    }else if(tipo == 'c'){
        atributo = (void *)calloc(1,sizeof(char));
        scanf(" %c",(char *) atributo);
    }else if(tipo == 'f'){
        atributo = (void *)calloc(1,sizeof(float));
        scanf(" %f",(float *) atributo);
    }; 
    return atributo; 
}

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

void CrearAnimal(Animal* a){
    int pos;
    Animal* nuevo = (Animal *)calloc(1,sizeof(Animal));

    printf("Tipo de fuerza: ");
    scanf(" %c",&(nuevo->tipo_fuerza));
    printf("Valor de fuerza: ");
    nuevo->fuerza = auxiliarTipo(nuevo->tipo_fuerza);
    printf("\n");

    printf("Tipo de velocidad: ");
    scanf(" %c",&(nuevo->tipo_velocidad));
    printf("Valor de velocidad: ");
    nuevo->velocidad = auxiliarTipo(nuevo->tipo_velocidad);
    printf("\n");

    printf("Tipo de resitencia: ");
    scanf(" %c",&(nuevo->tipo_resistencia));
    printf("Valor de resitencia: ");
    nuevo->velocidad = auxiliarTipo(nuevo->tipo_resistencia);
    printf("\n");

    printf("Funciones de reproducción: \n");
    pos = auxiliarAsignacionDeCallbacks(nuevo,reproducciones,sizeof(reproducciones)/sizeof(elementoCallback));
    nuevo->reproduccion = reproducciones[pos].reproduccion;

    printf("Funciones de comer o huir: \n");
    pos = auxiliarAsignacionDeCallbacks(nuevo,funsComerOHuir,sizeof(funsComerOHuir)/sizeof(elementoCallback));
    nuevo->comerHuir = funsComerOHuir[pos].comerHuir;

    a = nuevo;
};


void Borrar(Animal* a){
    free(a);
};
#include "Animal.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


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

    printf("Tipo de fuerza: ");
    scanf(" %c",&(a->tipo_fuerza));
    printf("Valor de fuerza: ");
    a->fuerza = auxiliarAsignacionDeTipo(a->tipo_fuerza);
    printf("\n");

    printf("Tipo de velocidad: ");
    scanf(" %c",&(a->tipo_velocidad));
    printf("Valor de velocidad: ");
    a->velocidad = auxiliarAsignacionDeTipo(a->tipo_velocidad);
    printf("\n");

    printf("Tipo de resitencia: ");
    scanf(" %c",&(a->tipo_resistencia));
    printf("Valor de resitencia: ");
    a->resistencia = auxiliarAsignacionDeTipo(a->tipo_resistencia);
    printf("\n");

    printf("Funciones de reproducción: \n");
    pos = auxiliarAsignacionDeCallbacks(a,reproducciones,sizeof(reproducciones)/sizeof(elementoCallback));
    a->reproduccion = reproducciones[pos].reproduccion;

    printf("Funciones de comer o huir: \n");
    pos = auxiliarAsignacionDeCallbacks(a,funsComerOHuir,sizeof(funsComerOHuir)/sizeof(elementoCallback));
    a->comerHuir = funsComerOHuir[pos].comerHuir;
};


void Borrar(Animal* a){
    free(a);
};


void auxImprimirTipo(char tipo, void* valor){
    if(tipo == 'e')
        printf("%d",*((int *) valor));
    else if(tipo == 'c')
        printf("%c",*((char *) valor));
    else if(tipo == 'f')
        printf("%f",*((float *) valor));
};

void MostrarAnimal(Animal *a){
    printf("fuerza: ");
    auxImprimirTipo(a->tipo_fuerza,a->fuerza);
    printf("\n");

    printf("velocidad: ");
    auxImprimirTipo(a->tipo_velocidad,a->velocidad);
    printf("\n");
    
    printf("resistencia: ");
    auxImprimirTipo(a->tipo_resistencia,a->resistencia);
    printf("\n");
};

void Reproducir(Animal* a1, Animal* a2, Animal* hijo){
    int resultado = rand() % 2;
    if(resultado){
        printf("Se usara la función de reproducción del primer animal.\n");
        a2->reproduccion(a1,a2,hijo);
    }else{
        printf("Se usara la función de reproducción del segundo animal.\n");
        a1->reproduccion(a1,a2,hijo);
    }

};

void ComerOHuir(Animal* a1, Animal* a2){
    int resultado = rand() % 2;
    if(resultado){
        printf("Se usara la función de comer o huir del primer animal.\n");
        a2->comerHuir(a1,a2);
    }else{
        printf("Se usara la función de comer o huir del segundo animal.\n");
        a1->comerHuir(a1,a2);
    }
};

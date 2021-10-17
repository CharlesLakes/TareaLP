#include "Animal.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


/*****
* void CrearAnimal
******
* La funcion crea un animal pidiendole al usuario las caracteristicas de el animal
******
* Input:
* Animal *a: puntero animal
******
* Returns:
* void, sin return
*****/
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

/*****
* void Borrar
******
* La funcion borra el animal y las memorias dinamicas respectivas
******
* Input:
* Animal *a: puntero animal
******
* Returns:
* void, sin return
*****/
void Borrar(Animal* a){
    free(a->fuerza);
    free(a->velocidad);
    free(a->resistencia);
    
    a->fuerza = NULL;
    a->velocidad = NULL;
    a->resistencia = NULL;
};



/*****
* void MostrarAnimal
******
* La funcion muestra los atributos del animal por pantalla
******
* Input:
* Animal *a: puntero animal
******
* Returns:
* void, sin return
*****/
void MostrarAnimal(Animal *a){
    printf("\tfuerza: ");
    auxImprimirTipo(a->tipo_fuerza,a->fuerza);
    printf("\n");

    printf("\tvelocidad: ");
    auxImprimirTipo(a->tipo_velocidad,a->velocidad);
    printf("\n");
    
    printf("\tresistencia: ");
    auxImprimirTipo(a->tipo_resistencia,a->resistencia);
    printf("\n");
};

void Reproducir(Animal* a1, Animal* a2, Animal* hijo){
    int resultado = rand() % 2;
    if(resultado){
        printf("Se usara la función de reproducción del Animal.\n");
        MostrarAnimal(a1);
        a1->reproduccion(a1,a2,hijo);
    }else{
        printf("Se usara la función de reproducción del Aniaml:\n");
        MostrarAnimal(a1);
        a2->reproduccion(a2,a1,hijo);
    }

};

void ComerOHuir(Animal* a1, Animal* a2){
    int resultado = rand() % 2;
    if(resultado){
        printf("Se usara la función de comer o huir del animal:\n");
        MostrarAnimal(a1);
        a1->comerHuir(a1,a2);
    }else{
        printf("Se usara la función de comer o huir del animal:\n");
        MostrarAnimal(a1);
        a2->comerHuir(a2,a1);
    }
};





int Comparar(Animal* a1, Animal* a2){
    int balanceador = 0;
    if(AtributoANumero(a1->tipo_fuerza,a1->fuerza) > AtributoANumero(a2->tipo_fuerza,a2->fuerza))
        balanceador++;
    else balanceador--;

    if(AtributoANumero(a1->tipo_resistencia,a1->resistencia) > AtributoANumero(a2->tipo_resistencia,a2->resistencia))
        balanceador++;
    else balanceador--;

    if(AtributoANumero(a1->tipo_velocidad,a1->velocidad) > AtributoANumero(a2->tipo_velocidad,a2->velocidad))
        balanceador++;
    else balanceador--;

    return balanceador <= 0;

};




void ReproduccionSimple(Animal* a1 ,Animal* a2 ,Animal* hijo){
    if(!Comparar(a1,a2)){
        *hijo = *a1;
        hijo->fuerza = CopiarMemoriaDeTipo(hijo->tipo_fuerza,a1->fuerza);
        hijo->velocidad = CopiarMemoriaDeTipo(hijo->tipo_velocidad,a1->velocidad);
        hijo->resistencia = CopiarMemoriaDeTipo(hijo->tipo_resistencia,a1->resistencia);
    }else{
        *hijo = *a2;
        hijo->fuerza = CopiarMemoriaDeTipo(hijo->tipo_fuerza,a2->fuerza);
        hijo->velocidad = CopiarMemoriaDeTipo(hijo->tipo_velocidad,a2->velocidad);
        hijo->resistencia = CopiarMemoriaDeTipo(hijo->tipo_resistencia,a2->resistencia);
    }

}

void ReproduccionCruzada(Animal* a1, Animal* a2, Animal* hijo){
    Animal  *temp1, *temp2;

    if(!Comparar(a1,a2)){
        temp1 = a1;
        temp2 = a2;
    }else{
        temp1 = a2;
        temp2 = a1;
    }

    hijo->tipo_fuerza = temp1->tipo_fuerza;
    hijo->fuerza = CopiarMemoriaDeTipo(temp1->tipo_fuerza,temp1->fuerza);

    hijo->tipo_velocidad = temp1->tipo_velocidad;
    hijo->velocidad = CopiarMemoriaDeTipo(temp1->tipo_velocidad,temp1->velocidad);

    hijo->tipo_resistencia = temp2->tipo_resistencia;
    hijo->resistencia = CopiarMemoriaDeTipo(temp2->tipo_resistencia,temp2->resistencia);

    hijo->reproduccion = temp1->reproduccion;
    hijo->comerHuir = temp2->comerHuir;
    
    
};


void ComerSiempre(Animal* a1 ,Animal* a2){
    if(AtributoANumero(a1->tipo_fuerza,a1->fuerza) > AtributoANumero(a2->tipo_resistencia,a2->resistencia)){
        Borrar(a2);
        return;
    }
    Borrar(a1);
    return;
};

void HuirSiempre(Animal* a1 ,Animal* a2){
    if(AtributoANumero(a1->tipo_velocidad,a1->velocidad) > AtributoANumero(a2->tipo_velocidad,a2->velocidad)){
        int x = aux_x, y = aux_y;
        Animal* temp;

        if(AUX_MUNDO[y][(x  - 1)%SIZE].fuerza == NULL && AUX_NUEVOMUNDO[y][(x  - 1)%SIZE].fuerza == NULL)
            temp = &(AUX_NUEVOMUNDO[y][(x - 1)%SIZE]);
        else if(AUX_MUNDO[(y - 1)%SIZE][x].fuerza == NULL && AUX_NUEVOMUNDO[(y - 1)%SIZE][x].fuerza)
            temp = &(AUX_NUEVOMUNDO[(y - 1)%SIZE][x]);
        else if(AUX_MUNDO[y][(x  + 1)%SIZE].fuerza == NULL && AUX_NUEVOMUNDO[y][(x  + 1)%SIZE].fuerza)
            temp = &(AUX_NUEVOMUNDO[y][(x + 1)%SIZE]);
        else if(AUX_MUNDO[(y + 1)%SIZE][x].fuerza == NULL && AUX_NUEVOMUNDO[(y + 1)%SIZE][x].fuerza == NULL)
            temp = &(AUX_NUEVOMUNDO[(y + 1)%SIZE][x]);
        
        if(temp != NULL){
            *temp = *a1;
        }else{
            Borrar(a1);
        }
        
        return;
    }
    Borrar(a1);

};

void ComerAleatorio(Animal* a1 ,Animal* a2){
    char tipo_a1, tipo_a2;
    void *valor_a1, *valor_a2;
    int numero;

    numero = rand() % 3;
    if(numero == 0){
        tipo_a1 = a1->tipo_fuerza;
        valor_a1 = a1->fuerza;
    }else if(numero == 1){
        tipo_a1 = a1->tipo_velocidad;
        valor_a1 = a1->velocidad;
    }else if(numero == 2){
        tipo_a1 = a1->tipo_resistencia;
        valor_a1 = a1->resistencia;
    }

    numero = rand() % 3;
    if(numero == 0){
        tipo_a2 = a2->tipo_fuerza;
        valor_a2 = a2->fuerza;
    }else if(numero == 1){
        tipo_a2 = a2->tipo_velocidad;
        valor_a2 = a2->velocidad;
    }else if(numero == 2){
        tipo_a2 = a2->tipo_resistencia;
        valor_a2 = a2->resistencia;
    }

    if(AtributoANumero(tipo_a1,valor_a1) > AtributoANumero(tipo_a2,valor_a2)){
        Borrar(a2);
        return;
    }
    Borrar(a1);

};

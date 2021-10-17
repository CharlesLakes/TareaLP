#ifndef Animal_H_
#define Animal_H_

typedef struct Animal{
    void *fuerza;
    char tipo_fuerza;
    void *velocidad;
    char tipo_velocidad;
    void *resistencia;
    char tipo_resistencia;
    void (*reproduccion)(struct Animal*, struct Animal*, struct Animal*);
    void (*comerHuir)(struct Animal*, struct Animal*);
}Animal;

typedef struct elementoReproduccionOComerHuir{
    char* nombre;
    void (*reproduccion)(Animal*, Animal*, Animal*);
    void (*comerHuir)(Animal*, Animal*);
}elementoCallback;

elementoCallback reproducciones[] = {
    {"ReproduccionSimple",ReproduccionSimple,0},
    {"ReproduccionCruzada",ReproduccionCruzada,0}
};

elementoCallback funsComerOHuir[] = {
    {"ComerSiempre",0,ComerSiempre},
    {"HuirSiempre",0,HuirSiempre},
    {"ComerAleatorio",0,ComerAleatorio}

};

// Animal

void CrearAnimal(Animal* a);
void Borrar(Animal* a);
void MostrarAnimal(Animal* a);
void Reproducir(Animal* a1, Animal* a2, Animal* hijo);
void ComerOHuir(Animal* a1, Animal* a2);
int Comparar(Animal* a1, Animal* a2);
void ReproduccionSimple(Animal* a1 ,Animal* a2 ,Animal* hijo);
void ReproduccionCruzada(Animal* a1 ,Animal* a2 ,Animal* hijo);
void ComerSiempre(Animal* a1 ,Animal* a2);
void HuirSiempre(Animal* a1 ,Animal* a2);
void ComerAleatorio(Animal* a1 ,Animal* a2);


// Auxiliares 

void auxImprimirTipo(char tipo, void* valor);
int AtributoANumero(char tipo, void *valor);
void* CopiarMemoriaDeTipo(char tipo, void *valor);
void* auxiliarAsignacionDeTipo(char tipo);
int auxiliarAsignacionDeCallbacks(Animal *a,elementoCallback* listaCallbacks,int largo);





#define SIZE 1000
Animal** AUX_MUNDO;
Animal** AUX_NUEVOMUNDO;
int aux_x, aux_y;

#endif

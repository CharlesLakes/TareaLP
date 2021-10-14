#ifndef Animal_H_
#define Animal_H_

#define SIZE 1000

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

void auxImprimirTipo(char tipo, void* valor);


#endif

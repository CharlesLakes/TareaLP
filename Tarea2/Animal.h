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

void CrearAnimal(Animal* a);
void Borrar(Animal* a);
void MostrarAnimal(Animal* a);
void Reproducir(Animal* a1, Animal* a2);
void ComerOHuir(Animal* a1, Animal* a2);
int Comparar(Animal* a1, Animal* a2);


#endif
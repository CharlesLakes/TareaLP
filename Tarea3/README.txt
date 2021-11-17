Nombre: Carlos Lagos
Rol:  202073571-9

Para usar el Makefile se tiene que instalar make con:
    apt-get install make
Con esto instalado para compilar se usa:
    make compile
Y para ejecutar se puede ejecutar:
    make run

En caso de no tener instalado make puede compilarlo:
    javac Main.java
y ejecutarlo con:
    java Main

Si deseas eliminar los .class lo puedes hacer con:
    make clear

Mas infromacion:
Se creo el el subpaquete thelegendofmorio/utils.
Para crear un AuxScanner estatico, esto para poder usar de forma mas
comoda el Scanner y no tener erores al instanciar muchos Scanners.
package thelegendofmorio.utils;

import java.util.Scanner;

public class AuxScanner {
    /**
     * Esto es definido como auxiliar 
     * para no tener problemas al tener instanciados
     * muchos scanners y cerrarlos
     * Ademas el editor me salia una alerta si no colocaba un close
     * entonces esta es la forma mas ordenada.
     */
    public static Scanner input = new Scanner(System.in);
}

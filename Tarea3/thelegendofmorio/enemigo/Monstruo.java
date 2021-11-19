package thelegendofmorio.enemigo;

import thelegendofmorio.jugador.*;
import java.util.Scanner;
import thelegendofmorio.utils.AuxScanner;

public class Monstruo implements Enemigo{
    private int vida, dano;

    /**Monstruo
     * Es el constructor de la clase monstruo, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param vida vida por defecto de el monstruo.
     * @param dano dano de el mosntruo.
     */
    public Monstruo(int vida, int dano){
        this.vida = vida;
        this.dano = dano;
    }

    
    /** combate
     * Hace que el monstruo combata con un jugador entregado
     * como parametro en un duelo por turnos.
     * La funcion se acaba cuando el Jugador o el monstruo muere
     * 
     * @param j Objeto Jugador
     */
    public void combate(Jugador j){
        Scanner input = AuxScanner.input;
        boolean flag = true;

        while(flag){
            System.out.println("¿Quieres realizar un ataque o un hechizo?");
            System.out.println("1. Ataque.\n2.Hechizo.");
            System.out.print("Respuesta: ");
            int opt;

            do{
                opt = input.nextInt();
                input.nextLine();
                if(opt != 1 && opt != 2)
                    System.out.println("Opcion erronea.");
            }while(opt != 1 && opt != 2);

            if(opt == 1)
                this.setVida(this.getVida() - j.ataque() > 0 ? this.getVida() - j.ataque() : 0);
            else if(opt == 2)
                this.setVida(this.getVida() - j.hechizo() > 0 ? this.getVida() - j.hechizo() : 0);
        
            if(this.vida > 0)
                j.setVida(j.getVida() - this.getDano() > 0 ? j.getVida() - this.getDano() : 0 );

            flag = j.getVida() > 0 && this.getVida() > 0;
        }
    }


    //setters
    /** setVid
     * Le asigna un valor a la vida.
     * 
     * @param vida int con la vida.
     */
    public void setVida(int vida){
        this.vida = vida;
    }
    
    /** setDano
     * Le asigna un valor al dano.
     * 
     * @param dano int con el dano.
     */
    public void setDano(int dano){
        this.dano = dano;
    }

    //getters
    /** getVida
     * Devuelve el valor de la vida;
     * 
     * @return int vida.
     */
    public int getVida(){
        return this.vida;
    }
    
    /** getDano
     * Devielve el valor de el dano.
     * 
     * @return int dano.
     */
    public int getDano(){
        return this.dano;
    }
}

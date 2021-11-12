package thelegendofmorio.enemigo;

import thelegendofmorio.jugador.*;
import java.util.Scanner;
import thelegendofmorio.utils.AuxScanner;

public class Jefe_Final implements Enemigo {
    private String nombre;
    private int vida, dano_base, vida_inicial;

    /**
    * Jefe_Final 
    * Es el constructor de la clase jefe final, la cual es llamada al ser intanciado
    * el objeto.
    *
    * @param nombre Es un string que contiene el nombre de el jefe final.
    * @param vida Es la vida por defecto de el jefe final. 
    * @param dano_base Es el dano_base de el jefe final, independiente de su fase.
    */
    public Jefe_Final(String nombre, int vida, int dano_base){
        this.nombre = nombre;
        this.vida = vida;
        this.vida_inicial = vida;
        this.dano_base = dano_base;
    }

    
    /** 
     * combate
     * Hace que el jefe final combata con un jugador entregado
     * como parametro en un duelo por turnos.
     * La funcion se acaba cuando el Jugador o el jefe final muere
     * 
     * @param j Objeto Jugador
     */
    public void combate(Jugador j){
        Scanner input = AuxScanner.input;
        boolean flag = true;
        int fase_actual = (float) this.getVidaInicial() / 2 < this.getVida() ? 2 : 1;

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
                j.setVida(j.getVida() - (this.getDanoBase() + 2*fase_actual) > 0 ? 
                    j.getVida() - (this.getDanoBase() + 2*fase_actual) : 0 );

            flag = j.getVida() > 0 && this.getVida() > 0;
            fase_actual = (float) this.getVidaInicial() / 2 < this.getVida() ? 2 : 1;
        }
    }

    
    /** 
     * combate
     * Le asigna un valor a nombre.
     * 
     * @param nombre String con el nombre.
     */
    public void combate(String nombre){
        this.nombre = nombre;
    }

    //setters
    /** setVida
     * Le asigna un valor a la vida.
     * 
     * @param vida int con la vida.
     */
    public void setVida(int vida){
        this.vida = vida;
    }
    
    /** setDanoBase
     * Le asigna un valor al dano_base.
     * 
     * @param dano_base int con el dano base.
     */
    public void setDanoBase(int dano_base){
        this.dano_base = dano_base;
    }
    
    /** setVidaInicial
     * Le asigna un valor a la vida_inicial.
     * 
     * @param vida_inicial int con la vida inicial.
     */
    public void setVidaInicial(int vida_inicial){
        this.vida_inicial = vida_inicial;
    }

    //getters
    /** getNombr
     * Devuelve el valor de el nombre.
     * 
     * @return String nombre.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /** getVida
     * Devuelve el valor de la vida.
     * 
     * @return int vida.
     */
    public int getVida(){
        return this.vida;
    }
    
    /** getDanoBase
     * Devuelve el valor de el dano base.
     * 
     * @return int dano_base.
     */
    public int getDanoBase(){
        return this.dano_base;
    }
    
    /** getVidaInicial
     * Devuelve el valor de la vida inicial.
     * 
     * @return int vida_inicial.
     */
    public int getVidaInicial(){
        return this.vida_inicial;
    }
}

package thelegendofmorio.enemigo;

import thelegendofmorio.jugador.*;
import java.util.Scanner;

public abstract class Jefe_Final {
    private String nombre;
    private int vida, dano_base, vida_inicial;

    public Jefe_Final(String nombre, int vida, int dano_base){
        this.nombre = nombre;
        this.vida = vida;
        this.vida_inicial = vida;
        this.dano_base = dano_base;
    }

    public void combate(Jugador j){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int fase_actual = (float) this.getVidaInicial() / 2 < this.getVida() ? 2 : 1;

        while(flag){
            System.out.println("¿Quieres realizar un ataque o un hechizo?");
            System.out.println("1. Ataque.\n2.Hechizo.");
            System.out.print("Respuesta: ");
            int opt;

            do{
                opt = input.nextInt();
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

    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setDanoBase(int dano_base){
        this.dano_base = dano_base;
    }
    public void setVidaInicial(int vida_inicial){
        this.vida_inicial = vida_inicial;
    }

    //getters
    public String getNombre(){
        return this.nombre;
    }
    public int getVida(){
        return this.vida;
    }
    public int getDanoBase(){
        return this.dano_base;
    }
    public int getVidaInicial(){
        return this.vida_inicial;
    }
}

package thelegendofmorio.enemigo;

import thelegendofmorio.jugador.*;
import java.util.Scanner;

public class Monstruo implements Enemigo{
    private int vida, dano;

    public Monstruo(int vida, int dano){
        this.vida = vida;
        this.dano = dano;
    }

    public void combate(Jugador j){
        Scanner input = new Scanner(System.in);
        boolean flag = true;

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
                j.setVida(j.getVida() - this.getDano() > 0 ? j.getVida() - this.getDano() : 0 );

            flag = j.getVida() > 0 && this.getVida() > 0;
        }
    }


    //setters
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setDano(int dano){
        this.dano = dano;
    }

    //getters
    public int getVida(){
        return this.vida;
    }
    public int getDano(){
        return this.dano;
    }
}

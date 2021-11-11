package thelegendofmorio.jugador;

import thelegendofmorio.mision.*;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class Jugador {
    private String nombre;
    private int vida, xp, fuerza , inteligencia, energia, mana;
    private int vida_maxima, energia_maxima, mana_maxima;
    private ArrayList<Mision> lista_misiones;

    public Jugador(int vida,int xp,int fuerza,int inteligencia,int energia,int mana,ArrayList<Mision> lista_misiones){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre: ");

        this.nombre = input.nextLine();
        this.vida = vida;
        this.xp = xp;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.energia = energia;
        this.mana = mana;
        this.lista_misiones = new ArrayList<Mision>();

        input.close();
    }

    public abstract int ataque();
    public abstract int hechizo();
    public abstract void subir_experiencia(int xp);

    

    // setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setXp(int xp){
        this.xp = xp;
    }
    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }
    public void setInteligencia(int inteligencia){
        this.inteligencia = inteligencia;
    }
    public void setEnergia(int energia){
        this.energia = energia;
    }
    public void setMana(int mana){
        this.mana = mana;
    }
    public void setVidaMaxima(int vida_maxima){
        this.vida_maxima = vida_maxima;
    }
    public void setEnergiaMaxima(int energia_maxima){
        this.energia_maxima = energia_maxima;
    }
    public void setManaMaxima(int mana_maxima){
        this.mana_maxima = mana_maxima;
    }
    public void setListaMisiones(ArrayList<Mision> lista_misiones){
        this.lista_misiones = lista_misiones;
    }

    // getters
    public String getNombre(){
        return this.nombre;
    }
    public int getVida(){
        return this.vida;
    }
    public int getXp(){
        return this.xp;
    }
    public int getFuerza(){
        return this.fuerza;
    }
    public int getInteligencia(){
        return this.inteligencia;
    }
    public int getEnergia(){
        return this.energia;
    }
    public int getMana(){
        return this.mana;
    }
    public int getVidaMaxima(){
        return this.vida_maxima;
    }
    public int getEnergiaMaxima(){
        return this.energia_maxima;
    }
    public int getManaMaxima(){
        return this.mana_maxima;
    }
    public ArrayList<Mision> getListaMisiones(){
        return this.lista_misiones;
    }
    public int getNivel(){
        int[] limites_xp = {10,25,50,100,200,350,600,900};
        for(int i = 0; i < limites_xp.length; i++){
            if(this.xp < limites_xp[i])
                return i + 1;
        }
        return 8;
    }
}

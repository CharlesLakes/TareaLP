package thelegendofmorio.jugador;

import thelegendofmorio.mision.*;
import java.util.ArrayList;


public abstract class Jugador {
    private String nombre;
    private int vida, xp, fuerza , inteligencia, energia, mana;
    private int vida_maxima, energia_maxima, mana_maxima, pos;
    private ArrayList<Mision> lista_misiones;

    public Jugador(String nombre,int vida,int xp,int fuerza,int inteligencia,int energia,int mana){
        this.nombre = nombre;
        this.vida = vida;
        this.xp = xp;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.energia = energia;
        this.mana = mana;
        this.lista_misiones = new ArrayList<Mision>();

    }

    
    

    
    /** 
     * Devuelve el ataque que ejerce el jugador
     * 
     * @return int ataque que ejerce el jugador.
     */
    public abstract int ataque();
    
    

    
    /** 
     * Devuelve el ataque que ejerce el hechizo
     * 
     * @return int ataque que ejerce el hechizo.
     */
    public abstract int hechizo();
    
    

    
    /** 
     * Sube la experiencia de el jugador y si sube de nivel
     * sube los atributos correspondientes
     * 
     * @param xp int de la experencia que se le da al jugador.
     */
    public abstract void subir_experiencia(int xp);

    

    // setters
    /** 
     * Le asigna un valor a nombre.
     * 
     * @param nombre String con el nombre.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /** 
     * Le asigna un valor a vida.
     * 
     * @param vida int con la vida.
     */
    public void setVida(int vida){
        this.vida = vida;
    }
    
    /** 
     * Le asigna un valor a xp.
     * 
     * @param xp int con el xp.
     */
    public void setXp(int xp){
        this.xp = xp;
    }
    
    /** 
     * Le asigna un valor a fuerza.
     * 
     * @param fuerza int con la fuerza.
     */
    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }
    
    /** 
     * Le asigna un valor a inteligencia.
     * 
     * @param inteligencia int con la inteligencia.
     */
    public void setInteligencia(int inteligencia){
        this.inteligencia = inteligencia;
    }
    
    /** 
     * Le asigna un valor a energia.
     * 
     * @param energia int con la energia.
     */
    public void setEnergia(int energia){
        this.energia = energia;
    }
    
    /** 
     * Le asigna un valor a mana.
     * 
     * @param mana int con el mana.
     */
    public void setMana(int mana){
        this.mana = mana;
    }
    
    /** 
     * Le asigna un valor a vida_maxima.
     * 
     * @param vida_maxima int con la vida_maxima.
     */
    public void setVidaMaxima(int vida_maxima){
        this.vida_maxima = vida_maxima;
    }
    
    /** 
     * Le asigna un valor a energia_maxima.
     * 
     * @param energia_maxima int con la energia_maxima.
     */
    public void setEnergiaMaxima(int energia_maxima){
        this.energia_maxima = energia_maxima;
    }
    
    /** 
     * Le asigna un valor a mana_maxima.
     * 
     * @param mana_maxima int con la mana_maxima.
     */
    public void setManaMaxima(int mana_maxima){
        this.mana_maxima = mana_maxima;
    }
    
    /** 
     * Le asigna un valor a lista_misiones.
     * 
     * @param lista_misiones ArrayList<Mision> con la lista_misiones.
     */
    public void setListaMisiones(ArrayList<Mision> lista_misiones){
        this.lista_misiones = lista_misiones;
    }
    
    /** 
     * Le asigna un valor a pos.
     * 
     * @param pos int con la pos.
     */
    public void setPos(int pos){
        this.pos = pos;
    }

    
    // getters
    /** 
     * Devielve el valor de el nombre.
     * 
     * @return String nombre.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /** 
     * Devielve el valor de la vida.
     * 
     * @return int vida.
     */
    public int getVida(){
        return this.vida;
    }
    
    /** 
     * Devielve el valor de el xp.
     * 
     * @return int xp.
     */
    public int getXp(){
        return this.xp;
    }
    
    /** 
     * Devielve el valor de la fuerza.
     * 
     * @return int fuerza.
     */
    public int getFuerza(){
        return this.fuerza;
    }
    
    /** 
     * Devielve el valor de la inteligencia.
     * 
     * @return int inteligencia.
     */
    public int getInteligencia(){
        return this.inteligencia;
    }
    
    /** 
     * Devielve el valor de la energia.
     * 
     * @return int energia.
     */
    public int getEnergia(){
        return this.energia;
    }
    
    /** 
     * Devielve el valor de el mana.
     * 
     * @return int mana.
     */
    public int getMana(){
        return this.mana;
    }
    
    /** 
     * Devielve el valor de la vida_maxima.
     * 
     * @return int vida_maxima.
     */
    public int getVidaMaxima(){
        return this.vida_maxima;
    }
    
    /** 
     * Devielve el valor de la energia_maxima.
     * 
     * @return int energia_maxima.
     */
    public int getEnergiaMaxima(){
        return this.energia_maxima;
    }
    
    /** 
     * Devielve el valor de la mana_maxima.
     * 
     * @return int mana_maxima.
     */
    public int getManaMaxima(){
        return this.mana_maxima;
    }
    
    /** 
     * Devielve el valor de la pos.
     * 
     * @return int pos.
     */
    public int getPos(){
        return this.pos;
    }
    
    /** 
     * Devuele la lista lista_misiones.
     * 
     * @return ArrayList<Mision> lista_misiones.
     */
    public ArrayList<Mision> getListaMisiones(){
        return this.lista_misiones;
    }
    
    /** 
     * Devuelve el nivel dependiendo de la experiencia.
     * 
     * @return int nivel
     */
    public int getNivel(){
        int[] limites_xp = {10,25,50,100,200,350,600,900};
        for(int i = 0; i < limites_xp.length; i++){
            if(this.xp < limites_xp[i])
                return i + 1;
        }
        return 8;
    }
}

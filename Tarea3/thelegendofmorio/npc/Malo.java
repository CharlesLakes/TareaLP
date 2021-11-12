package thelegendofmorio.npc;

import thelegendofmorio.jugador.*;

public class Malo extends NPC{
    private int cantidad_energia;
    private int cantidad_mana;

    public Malo(String nombre, int cantidad_energia, int cantidad_mana){
        super(nombre);
        this.cantidad_energia = cantidad_energia;
        this.cantidad_mana = cantidad_mana;
    }

    public void interaccion(Jugador j){
        if(j.getEnergia() - this.getCantidadEnergia() < 0)
            j.setEnergia(0);
        else
            j.setEnergia(j.getEnergia() - this.getCantidadEnergia());
        
        if(j.getMana() - this.getCantidadMana() < 0)
            j.setMana(0);
        else
            j.setMana(j.getMana() - this.getCantidadMana());
    }

    //setters
    public void setCantidadEnergia(int cantidad_energia){
        this.cantidad_energia = cantidad_energia;
    }
    public void setCantidadMana(int cantidad_mana){
        this.cantidad_mana = cantidad_mana;
    }

    //getters
    public int getCantidadEnergia(){
        return this.cantidad_energia;
    }
    public int getCantidadMana(){
        return this.cantidad_mana;
    }
}

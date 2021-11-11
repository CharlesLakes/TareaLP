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
        if(j.getEnergia() - this.cantidad_energia < 0)
            j.setEnergia(0);
        else
            j.setEnergia(j.getEnergia() - this.cantidad_energia);
        
        if(j.getMana() - this.cantidad_mana < 0)
            j.setMana(0);
        else
            j.setMana(j.getMana() - this.cantidad_mana);
    }
}

package thelegendofmorio.npc;
import thelegendofmorio.jugador.*;

public class Bueno extends NPC{
    private String atributo;
    private int cantidad;

    public Bueno(String nombre, String atributo, int cantidad){
        super(nombre);
        this.atributo = atributo;
        this.cantidad = cantidad;
    }

    public void interaccion(Jugador j){
        System.out.println(this.getNombre() + ": Creo que necesitas un poco de ayuda te subire " + String.valueOf(this.cantidad) + " a tu " + this.atributo + "!!!!");
        if(this.atributo == "vida"){
            j.setVida((j.getVida() + this.cantidad <= j.getVidaMaxima())? j.getVida() + this.cantidad : j.getVidaMaxima());
            return;
        }
        if(this.atributo == "xp"){
            j.setXp(j.getXp() + this.cantidad);
            return;
        }
        if(this.atributo == "energia"){
            j.setEnergia((j.getEnergia() + this.cantidad <= j.getEnergiaMaxima())? j.getEnergia() + this.cantidad : j.getEnergiaMaxima());
            return;
        }
        if(this.atributo == "mana"){
            j.setMana((j.getMana() + this.cantidad <= j.getManaMaxima())? j.getMana() + this.cantidad : j.getManaMaxima());
            return;
        }

    }
}

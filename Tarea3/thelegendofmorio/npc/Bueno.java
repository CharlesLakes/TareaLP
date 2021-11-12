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
        System.out.println(this.getNombre() + ": Creo que necesitas un poco de ayuda te subire " + String.valueOf(this.getCantidad()) + " a tu " + this.getAtributo() + "!!!!");
        if(this.getAtributo() == "vida"){
            j.setVida((j.getVida() + this.getCantidad() <= j.getVidaMaxima())? j.getVida() + this.getCantidad() : j.getVidaMaxima());
            return;
        }
        if(this.getAtributo() == "xp"){
            j.subir_experiencia(this.getCantidad());
            return;
        }
        if(this.getAtributo() == "energia"){
            j.setEnergia((j.getEnergia() + this.getCantidad() <= j.getEnergiaMaxima())? j.getEnergia() + this.getCantidad() : j.getEnergiaMaxima());
            return;
        }
        if(this.getAtributo() == "mana"){
            j.setMana((j.getMana() + this.getCantidad() <= j.getManaMaxima())? j.getMana() + this.getCantidad() : j.getManaMaxima());
            return;
        }

    }

    //setters
    public void setAtributo(String atributo){
        this.atributo = atributo;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    //getters
    public String getAtributo(){
        return this.atributo;
    }
    public int getCantidad(){
        return this.cantidad;
    }
}

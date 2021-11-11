package thelegendofmorio.npc;
import thelegendofmorio.jugador.*;

public abstract class NPC {
    private String nombre;

    public NPC(String nombre){
        this.nombre = nombre;
    }

    public abstract void interaccion(Jugador j);


    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // getters    
    public String getNombre(){
        return this.nombre;
    }
}

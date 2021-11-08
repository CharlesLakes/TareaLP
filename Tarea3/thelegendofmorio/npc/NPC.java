package thelegendofmorio.npc;
import thelegendofmorio.jugador.*;

public abstract class NPC {
    private String nombre;

    public NPC(String nombre){
        this.nombre = nombre;
    }

    public abstract void interaccion(Jugador j);


    // getters    
    public String getNombre(){
        return this.nombre;
    }
}

package thelegendofmorio.npc;
import thelegendofmorio.jugador.*;

public abstract class NPC {
    private String nombre;

    public NPC(String nombre){
        this.nombre = nombre;
    }

    
    /** 
     * @param nombre
     */
    public abstract void interaccion(Jugador j);


    //setters
    /** 
     * Le asigna un valor a nombre.
     * 
     * @param nombre String con el nombre.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // getters 
    /**
     * Devuelve el valor de el nombre.
     *  
     * @return String con el nombre.
     */
    public String getNombre(){
        return this.nombre;
    }
}

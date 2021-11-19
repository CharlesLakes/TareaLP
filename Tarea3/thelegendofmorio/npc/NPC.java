package thelegendofmorio.npc;
import thelegendofmorio.jugador.*;

public abstract class NPC {
    private String nombre;

    /**NPC
     * Es el constructor de la clase NPC, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param nombre String con el nombre de el npc
     */
    public NPC(String nombre){
        this.nombre = nombre;
    }

    
    /** interaccion
     * Hace que el NPC bueno le mejore un atrubuto al jugador 
     * al interaccionar con el.
     * 
     * @param j Objeto con el jugador
     */
    public abstract void interaccion(Jugador j);


    //setters
    /** setNombre
     * Le asigna un valor a nombre.
     * 
     * @param nombre String con el nombre.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // getters 
    /**getNombre
     * Devuelve el valor de el nombre.
     *  
     * @return String con el nombre.
     */
    public String getNombre(){
        return this.nombre;
    }
}

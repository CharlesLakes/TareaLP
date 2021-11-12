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

    
    /** 
     * Hace que el NPC bueno le mejore un atrubuto al jugador 
     * al interaccionar con el.
     * 
     * @param j Objeto jugador.
     */
    public void interaccion(Jugador j){
        System.out.println(this.getNombre() + ": Creo que necesitas un poco de ayuda te subire " + String.valueOf(this.getCantidad()) + " a tu " + this.getAtributo() + "!!!!");
        if(this.getAtributo().equals("vida")){
            j.setVida((j.getVida() + this.getCantidad() <= j.getVidaMaxima())? j.getVida() + this.getCantidad() : j.getVidaMaxima());
            return;
        }
        if(this.getAtributo().equals("xp")){
            j.subir_experiencia(this.getCantidad());
            return;
        }
        if(this.getAtributo().equals("energia")){
            j.setEnergia((j.getEnergia() + this.getCantidad() <= j.getEnergiaMaxima())? j.getEnergia() + this.getCantidad() : j.getEnergiaMaxima());
            return;
        }
        if(this.getAtributo().equals("mana")){
            j.setMana((j.getMana() + this.getCantidad() <= j.getManaMaxima())? j.getMana() + this.getCantidad() : j.getManaMaxima());
            return;
        }

    }

    //setters
    /** 
     * Le asigna un valor a atributo.
     * 
     * @param atributo String con al atributo.
     */
    public void setAtributo(String atributo){
        this.atributo = atributo;
    }
    
    /** 
     * Le asigna un valor a cantidad.
     * 
     * @param cantidad int con la cantidad.
     */
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    //getters
    /** 
     * Devielve el valor de el atributo.
     * 
     * @return int atributo.
     */
    public String getAtributo(){
        return this.atributo;
    }
    
    /** 
     * Devielve el valor de la cantidad.
     * 
     * @return int cantidad.
     */
    public int getCantidad(){
        return this.cantidad;
    }
}

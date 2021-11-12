package thelegendofmorio.tierra;

import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;
import thelegendofmorio.jugador.*;

public abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;
    private String tipo_enemigo;

    

    public abstract boolean accion(Jugador j);

    /**Tierra
     * Es el constructor de la clase Tierra, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param probabilidad_enemigo flaot con al probabilidad de encontrar al enemigo
     * @param monstruo Monstruo con la instancia de el monstruo a combatir
     * @param jefe_final Jefe_Final con al instancia de el jefe a combatir
     * @param npc Npc con la instancia de el npc a interatuar
     * @param tipo_enemigo String con el tipo de enemgio
     */
    public Tierra(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
        if(tipo_enemigo.equals("Monstruo"))
            this.monstruo = monstruo;
        else if(tipo_enemigo.equals("Jefe_Final"))
            this.jefe_final = jefe_final;
        this.tipo_enemigo = tipo_enemigo;
        this.npc = npc;
    }

    
    /** existeNPC
     * La funcion verifica si existe el NPC.
     * 
     * @return boolean true si existe el npc y false si no existe
     */
    public boolean existeNPC(){
        return !npc.getNombre().equals("");
    }
    
     //setters
    /** setProbabilidadEnemigo
     * Le asigna el valor a probabilidad_enemigo.
     * 
     * @param probabilidad_enemigo float 
     */
    public void setProbabilidadEnemigo(float probabilidad_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
    } 
    
    /** setMonstruo
     * Le asgina el valor a monstruo.
     * 
     * @param monstruo Monstruo
     */
    public void setMonstruo(Monstruo monstruo){
        this.monstruo = monstruo;
    }  
    
    /** setJefeFina
     * Le asigna el valor a jefe_final.
     * 
     * @param jefe_final Jefe_Final 
     */
    public void setJefeFinal(Jefe_Final jefe_final){
        this.jefe_final = jefe_final;
    }
    
    /** setNpc
     * le asgina el valor a npc.
     * 
     * @param npc NPC
     */
    public void setNpc(NPC npc){
        this.npc = npc;
    }
    
    /** setTipoEnemigo
     * Le asigna el valor a tipo_enemigo.
     * 
     * @param tipo_enemigo String
     */
    public void setTipoEnemigo(String tipo_enemigo){
        this.tipo_enemigo = tipo_enemigo;
    }
    
      
    
    /** getProbabilidadEnemigo
     * Devuelve el valor de la probabilidad_enemigo.
     * 
     * @return float probabilidad_enemigo
     */
    //getters
    public float getProbabilidadEnemigo(){
        return this.probabilidad_enemigo;
    }  
    
    /** getMonstruo
     * Devuelve el valor de el monstruo.
     * 
     * @return Monstruo monstruo
     */
    public Monstruo getMonstruo(){
        return this.monstruo;
    }  
    
    /** getJefeFinal
     * Devuelve el valor de jefe_final.
     * 
     * @return Jefe_Final jefe_final
     */
    public Jefe_Final getJefeFinal(){
        return this.jefe_final;
    }
    
    /** getNpc
     * Devuelve el valor de NPC.
     * 
     * @return NPC npc
     */
    public NPC getNpc(){
        return this.npc;  
    }
    
    /** getTipoEnemigo
     * Devuelve el valor de tipo_enemigo.
     * 
     * @return String tipo_enemigo
     */
    public String getTipoEnemigo(){
        return this.tipo_enemigo;
    }
    

}

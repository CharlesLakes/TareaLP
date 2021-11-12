package thelegendofmorio.tierra;

import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;
import thelegendofmorio.jugador.*;

public abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;
    private boolean existeNPC;
    private String tipo_enemigo;

    
    /** 
     * @param probabilidad_enemigo
     * @param monstruo
     * @param jefe_final
     * @param npc
     * @param tipo_enemigo
     * @param existeNPC
     * @return boolean
     */
    public abstract boolean accion(Jugador j);


    public Tierra(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo,boolean existeNPC){
        this.probabilidad_enemigo = probabilidad_enemigo;
        if(tipo_enemigo.equals("Monstruo"))
            this.monstruo = monstruo;
        else if(tipo_enemigo.equals("Jefe_Final"))
            this.jefe_final = jefe_final;
        this.existeNPC = existeNPC;
        this.tipo_enemigo = tipo_enemigo;
        this.npc = npc;
    }

    
    /** 
     * @return boolean
     */
    public boolean existeNPC(){
        return !npc.getNombre().equals("");
    }
    
    
    /** 
     * @param probabilidad_enemigo
     */
    //setters
    public void setProbabilidadEnemigo(float probabilidad_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
    } 
    
    /** 
     * @param monstruo
     */
    public void setMonstruo(Monstruo monstruo){
        this.monstruo = monstruo;
    }  
    
    /** 
     * @param jefe_final
     */
    public void setJefeFinal(Jefe_Final jefe_final){
        this.jefe_final = jefe_final;
    }
    
    /** 
     * @param npc
     */
    public void setNpc(NPC npc){
        this.npc = npc;
    }
    
    /** 
     * @param tipo_enemigo
     */
    public void setTipoEnemigo(String tipo_enemigo){
        this.tipo_enemigo = tipo_enemigo;
    }
    
    /** 
     * @param existeNPC
     */
    public void setExisteNPC(boolean existeNPC){
        this.existeNPC = existeNPC;
    }
      
    
    /** 
     * @return float
     */
    //getters
    public float getProbabilidadEnemigo(){
        return this.probabilidad_enemigo;
    }  
    
    /** 
     * @return Monstruo
     */
    public Monstruo getMonstruo(){
        return this.monstruo;
    }  
    
    /** 
     * @return Jefe_Final
     */
    public Jefe_Final getJefeFinal(){
        return this.jefe_final;
    }
    
    /** 
     * @return NPC
     */
    public NPC getNpc(){
        return this.npc;  
    }
    
    /** 
     * @return String
     */
    public String getTipoEnemigo(){
        return this.tipo_enemigo;
    }
    
    /** 
     * @return boolean
     */
    public boolean getExisteNPC(){
        return this.existeNPC;
    }

}

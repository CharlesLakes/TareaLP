package thelegendofmorio.tierra;

import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;
import thelegendofmorio.jugador.*;

public abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    public abstract boolean accion(Jugador j);


    public Tierra(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc){
        this.probabilidad_enemigo = probabilidad_enemigo;
        this.monstruo = monstruo;
        this.jefe_final = jefe_final;
        this.npc = npc;
    }

    
    //setters
    public void setProbabilidadEnemigo(float probabilidad_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
    } 
    public void setMonstruo(Monstruo monstruo){
        this.monstruo = monstruo;
    }  
    public void setJefeFinal(Jefe_Final jefe_final){
        this.jefe_final = jefe_final;
    }
    public void setNpc(NPC npc){
        this.npc = npc;
    }
      
    //getters
    public float getProbabilidadEnemigo(){
        return this.probabilidad_enemigo;
    }  
    public Monstruo getMonstruo(){
        return this.monstruo;
    }  
    public Jefe_Final getJefeFinal(){
        return this.jefe_final;
    }
    public NPC getNpc(){
        return this.npc;
      
    }

}

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


    public Tierra(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo){
        this.probabilidad_enemigo = probabilidad_enemigo;
        if(tipo_enemigo.equals("Monstruo"))
            this.monstruo = monstruo;
        else if(tipo_enemigo.equals("Jefe_Final"))
            this.jefe_final = jefe_final;
        this.tipo_enemigo = tipo_enemigo;
        this.npc = npc;
    }

    public boolean existeNPC(){
        return !npc.getNombre().equals("");
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
    public void setTipoEnemigo(String tipo_enemigo){
        this.tipo_enemigo = tipo_enemigo;
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
    public String getTipoEnemigo(){
        return this.tipo_enemigo;
    }

}

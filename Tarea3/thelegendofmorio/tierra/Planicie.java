package thelegendofmorio.tierra;

import thelegendofmorio.jugador.*;
import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;

public class Planicie extends Tierra{
    public Planicie(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo,boolean existeNPC){
        super(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo,existeNPC);
    }

    public boolean accion(Jugador j){        
        if(this.getExisteNPC())
            this.getNpc().interaccion(j);

        if(this.getProbabilidadEnemigo() < Math.random())
            return true;


        if(this.getTipoEnemigo().equals("Monstruo"))
            this.getMonstruo().combate(j);
        else if(this.getTipoEnemigo().equals("Jefe_Final"))
            this.getJefeFinal().combate(j);
        
        if(j.getVida() == 0)
            return false;

        return true;

    }
}

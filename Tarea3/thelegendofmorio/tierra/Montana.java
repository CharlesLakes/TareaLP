package thelegendofmorio.tierra;

import thelegendofmorio.jugador.*;
import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;

public class Montana extends Tierra{
    public Montana(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo,boolean existeNPC){
        super(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo,existeNPC);
    }

    public boolean accion(Jugador j){
        if(j.getEnergia() == 0)
            return false;

        int energia = j.getEnergia() - 3;
        if(energia < 0){
            j.setVida(j.getVida() - energia > 0 ? j.getVida() - energia : 0);
            j.setEnergia(0);
        }else
            j.setEnergia(energia);
        
        if(j.getVida() == 0)
            return false;
            
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

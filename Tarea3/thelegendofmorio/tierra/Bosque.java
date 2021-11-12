package thelegendofmorio.tierra;

import thelegendofmorio.jugador.*;
import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;

public class Bosque extends Tierra{
    public Bosque(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo,boolean existeNPC){
        super(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo,existeNPC);
    }

    
    /** 
     * @param j
     * @return boolean
     */
    public boolean accion(Jugador j){
        if(j.getMana() == 0)
            return false;

        int mana = j.getMana() - 3;
        if(mana < 0){
            j.setVida(j.getVida() - mana > 0 ? j.getVida() - mana : 0);
            j.setMana(0);
        }else
            j.setMana(mana);
        
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

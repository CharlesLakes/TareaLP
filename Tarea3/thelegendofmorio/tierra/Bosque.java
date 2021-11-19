package thelegendofmorio.tierra;

import thelegendofmorio.jugador.*;
import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;

public class Bosque extends Tierra{
    /**Bosque
     * Es el constructor de la clase Bosque, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param probabilidad_enemigo flaot con al probabilidad de encontrar al enemigo
     * @param monstruo Monstruo con la instancia de el monstruo a combatir
     * @param jefe_final Jefe_Final con al instancia de el jefe a combatir
     * @param npc Npc con la instancia de el npc a interatuar
     * @param tipo_enemigo String con el tipo de enemgio
     */
    public Bosque(float probabilidad_enemigo,Monstruo monstruo,Jefe_Final jefe_final,NPC npc,String tipo_enemigo){
        super(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo);
    }

    
    /** accion
     * Ejecuta las acciones necesarias cuando se llega a una tierra
     * Como es bosque disminuye mana hasta llegar al lugar.
     * 
     * 
     * @param j Objeto Jugador
     * @return boolean true si el jugador sobrevive y false si murio
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
        
        if(this.existeNPC())
            this.getNpc().interaccion(j);

        if(this.getProbabilidadEnemigo() < Math.random())
            return true;

        System.out.println("Te encontraste con un " + this.getTipoEnemigo());

        if(this.getTipoEnemigo().equals("Monstruo"))
            this.getMonstruo().combate(j);
        else if(this.getTipoEnemigo().equals("Jefe_Final"))
            this.getJefeFinal().combate(j);
        
        if(j.getVida() == 0)
            return false;

        return true;

    }
}

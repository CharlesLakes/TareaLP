package thelegendofmorio.jugador;
import thelegendofmorio.mision.*;
import java.util.ArrayList;

public class Druida extends Jugador{
    public Druida(ArrayList<Mision> lista_misiones){
        super(15,0,5,5,5,5,lista_misiones);
    }

    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = (this.getFuerza() + this.getInteligencia())*Math.max(this.getEnergia()/3,this.getMana()/2)/3;
        this.setEnergia(this.getEnergia() - 3);
        return resultado;
    }

    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = (this.getFuerza() + this.getInteligencia())*Math.max(this.getEnergia()/2,this.getMana()/3)/3;
        this.setMana(this.getMana() - 3);
        return resultado;
    }

    public void subir_experiencia(int xp){
        int anterior_nivel = this.getNivel();
        this.setXp(this.getXp() + xp);
        if(anterior_nivel == this.getNivel()) return;

        this.setVidaMaxima(this.getVidaMaxima() + this.getNivel());
        this.setFuerza(this.getFuerza() + this.getNivel());
        this.setInteligencia(this.getInteligencia() + this.getNivel());
        this.setEnergiaMaxima(this.getEnergiaMaxima() + this.getNivel());
        this.setManaMaxima(this.getManaMaxima() + this.getNivel());

        this.setVida(this.getVidaMaxima());
        this.setEnergia(this.getEnergiaMaxima());
        this.setMana(this.getManaMaxima());
    }
}

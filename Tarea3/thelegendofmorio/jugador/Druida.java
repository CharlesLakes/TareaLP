package thelegendofmorio.jugador;
import thelegendofmorio.mision.*;
import java.util.ArrayList;

public class Druida extends Jugador{
    public Druida(String nombre,ArrayList<Mision> listo_misiones){
        super(nombre,15,0,5,5,5,5,listo_misiones);
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
        this.setXp(this.getXp() + xp);

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

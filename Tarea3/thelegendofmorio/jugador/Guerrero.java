package thelegendofmorio.jugador;
import thelegendofmorio.mision.*;
import java.util.ArrayList;

public class Guerrero extends Jugador{
    public Guerrero(String nombre,ArrayList<Mision> listo_misiones){
        super(nombre,20,0,9,1,10,2,listo_misiones);
    }

    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = this.getFuerza()*2 + this.getEnergia();
        this.setEnergia(this.getEnergia() - 5);
        return resultado;
    }

    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = this.getInteligencia()*this.getFuerza()/4 + this.getMana();
        this.setMana(this.getMana() - 3);
        return resultado;
    }

    public void subir_experiencia(int xp){
        this.setXp(this.getXp() + xp);

        this.setVidaMaxima(this.getVidaMaxima() + 3*this.getNivel());
        this.setFuerza(this.getFuerza() + 5*this.getNivel());
        this.setInteligencia(this.getInteligencia() + 1);
        this.setEnergiaMaxima(this.getEnergiaMaxima() + 2*this.getNivel());
        this.setManaMaxima(this.getManaMaxima() + 1);

        this.setVida(this.getVidaMaxima());
        this.setEnergia(this.getEnergiaMaxima());
        this.setMana(this.getManaMaxima());
    }
}

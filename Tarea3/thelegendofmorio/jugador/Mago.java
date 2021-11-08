package thelegendofmorio.jugador;
import thelegendofmorio.mision.*;
import java.util.ArrayList;

public class Mago extends Jugador{
    public Mago(String nombre,ArrayList<Mision> listo_misiones){
        super(nombre,10,0,3,10,6,15,listo_misiones);
    }

    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = this.getFuerza()*this.getInteligencia()/4 + this.getEnergia();
        this.setEnergia(this.getEnergia() - 3);
        return resultado;
    }

    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = this.getInteligencia()*this.getFuerza()/4 + this.getMana();
        this.setMana(this.getMana() - 5);
        return resultado;
    }

    public void subir_experiencia(){
        this.setVidaMaxima(this.getVidaMaxima() + 2*this.getNivel());
        this.setFuerza(this.getFuerza() + 1);
        this.setInteligencia(this.getInteligencia() + 3*this.getNivel());
        this.setEnergiaMaxima(this.getEnergiaMaxima() + 1);
        this.setManaMaxima(this.getManaMaxima() + 3*this.getNivel());
    }
}

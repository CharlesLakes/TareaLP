package thelegendofmorio.npc;

import thelegendofmorio.jugador.*;
import thelegendofmorio.mision.*;
import java.util.Scanner;
import thelegendofmorio.utils.AuxScanner;

public class Neutro extends NPC{
    private char requisito;
    private int valor, recompensa, ya_dio_mision;

    public Neutro(String nombre, char requisito, int valor, int recompensa){
        super(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = 0;
    }

    public void interaccion(Jugador j){
        if(this.getYaDioMision() == 1){
            System.out.println(this.getNombre() + ": ya te di mision, saludos.");
            return;
        }
        System.out.println(this.getNombre() + ": hola, ¿quieres cumplir esta mision? Deberas "
            + (this.getRequisito() == 'v' ? "llegar a" : "matar") + " " + String.valueOf(this.getValor())
            + " " + (this.getRequisito() == 'v' ? "del mundo" : "de monstruos") + " y recibirás " + String.valueOf(this.getRecompensa()) + " de xp");

        Scanner input = AuxScanner.input;
        input.nextLine();
        
        System.out.print("Respuesta (si o no): ");
        if(input.next().equals("si")){
            this.setYaDioMision(1);
            j.getListaMisiones().add(new Mision(this.getRequisito(), (this.getRequisito() == 'v' ? j.getPos() : 0) ,this.getValor(), this.getRecompensa()));
        }
    }


    //setters
    public void setRequisito(char requisito){
        this.requisito = requisito;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }
    public void setYaDioMision(int ya_dio_mision){
        this.ya_dio_mision = ya_dio_mision;
    }

    //getters
    public char getRequisito(){
        return this.requisito;
    }
    public int getValor(){
        return this.valor;
    }
    public int getRecompensa(){
        return this.recompensa;
    }
    public int getYaDioMision(){
        return this.ya_dio_mision;
    }
}

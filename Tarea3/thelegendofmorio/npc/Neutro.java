package thelegendofmorio.npc;

import thelegendofmorio.jugador.*;
import thelegendofmorio.mision.*;
import java.util.Scanner;

public class Neutro extends NPC{
    private char requisito;
    private int valor, recompensa, ya_dio_mision;

    public Neutro(String nombre, int valor, int recompensa){
        super(nombre);
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = 0;
    }

    public void interaccion(Jugador j){
        if(this.ya_dio_mision == 1){
            System.out.println(this.getNombre() + ": ya te di mision, saludos.");
            return;
        }
        System.out.println(this.getNombre() + ": hola, ¿quieres cumplir esta mision? Deberas "
            + (this.requisito == 'v' ? "llegar a" : "matar") + " " + String.valueOf(this.valor)
            + " " + (this.requisito == 'v' ? "del mundo" : "de monstruos") + " y recibirás " + this.recompensa + " de xp");

        Scanner input = new Scanner(System.in);
        
        System.out.print("Respuesta (si o no): ");
        if(input.next().equals("no")){
            input.close();
            return;
        }
        input.close();

        j.getListaMisiones().add(new Mision(this.requisito, this.valor, this.recompensa));
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

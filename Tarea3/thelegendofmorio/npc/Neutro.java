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

    
    /** 
     * Hace que el NPC bueno le mejore un atrubuto al jugador 
     * al interaccionar con el.
     * 
     * @param j Objeto jugador.
     */
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
    /** 
     * Le asigna un valor a requisito.
     * 
     * @param requisito char con el requisito.
     */
    public void setRequisito(char requisito){
        this.requisito = requisito;
    }
    
    /** 
     * Le asigna un valor a valor.
     * 
     * @param valor int con el valor.
     */
    public void setValor(int valor){
        this.valor = valor;
    }
    
    /** 
     * Le asigna un valor a recompensa.
     * 
     * @param recompensa int con la recompensa.
     */
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }
    
    /** 
     * Le asigna un valor a ya_dio_mision.
     * 
     * @param ya_dio_mision int con el ya_dio_mision.
     */
    public void setYaDioMision(int ya_dio_mision){
        this.ya_dio_mision = ya_dio_mision;
    }

    
    /** 
     * Devielve el valor de la requisito.
     * 
     * @return char requisito.
     */
    //getters
    public char getRequisito(){
        return this.requisito;
    }
    
    /** 
     * Devielve el valor de el valor.
     * 
     * @return int valor.
     */
    public int getValor(){
        return this.valor;
    }
    
    /** 
     * Devielve el valor de la recompensa.
     * 
     * @return int recompensa.
     */
    public int getRecompensa(){
        return this.recompensa;
    }
    
    /** 
     * Devielve el valor de el ya_dio_mision.
     * 
     * @return int ya_dio_mision.
     */
    public int getYaDioMision(){
        return this.ya_dio_mision;
    }
}

package thelegendofmorio.mision;

public class Mision {
    private char requisito;
    private int valor, cantidad, recompensa;

    public Mision(char requisito, int valor, int cantidad, int recompensa){
        this.requisito = requisito;
        this.valor = valor;
        this.cantidad = cantidad;
        this.recompensa = recompensa;
    }

    public boolean verificar_requisito(){
        return cantidad == valor;
    }

    //setters
    public void setRequisito(char requisito){
        this.requisito = requisito;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }

    //getters
    public char getRequisito(){
        return this.requisito;
    }
    public int getValor(){
        return this.valor;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public int getRecompensa(){
        return this.recompensa;
    }
}

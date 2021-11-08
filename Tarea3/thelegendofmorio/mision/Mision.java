package thelegendofmorio.mision;

public class Mision {
    private char requisito;
    private int valor, cantidad, recompensa;
    private boolean estado;

    public Mision(char requisito, int valor, int cantidad, int recompensa){
        this.requisito = requisito;
        this.valor = valor;
        this.cantidad = cantidad;
        this.recompensa = recompensa;
        this.estado = false;
    }

    public boolean verificar_requisito(){
        return true;
    }
}

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

    
    /** 
     * Verifica si el requisito de la mision se cumplio.
     * 
     * @return boolean true si el requsito se cumple y false si no se cumple.
     */
    public boolean verificar_requisito(){
        return cantidad == valor;
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
     * Le asigna un valor a cantidad.
     * 
     * @param cantidad int con la cantidad.
     */
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    /** 
     * Le asigna un valor a recompensa.
     * 
     * @param recompensa int con la recompensa.
     */
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }

    //getters
    /** 
     * Devielve el valor de el requisito.
     * 
     * @return char requisito.
     */
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
     * Devielve el valor de la cantidad.
     * 
     * @return int cantidad.
     */
    public int getCantidad(){
        return this.cantidad;
    }
    
    /** 
     * Devielve el valor de la recompensa.
     * 
     * @return int recompensa.
     */
    public int getRecompensa(){
        return this.recompensa;
    }
}

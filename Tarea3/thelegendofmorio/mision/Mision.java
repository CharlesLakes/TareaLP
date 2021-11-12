package thelegendofmorio.mision;

public class Mision {
    private char requisito;
    private int valor, cantidad, recompensa;

    /**Mision
     * Es el constructor de la clase Mision, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param requisito char con el requisito de la mision
     * @param valor int con el valor que tiene que conseguir el jugador
     * @param cantidad int al cantidad que lleva
     * @param recompensa int la recompensa por la mision
     */
    public Mision(char requisito, int valor, int cantidad, int recompensa){
        this.requisito = requisito;
        this.valor = valor;
        this.cantidad = cantidad;
        this.recompensa = recompensa;
    }

    
    /** verificar_requisito
     * Verifica si el requisito de la mision se cumplio.
     * 
     * @return boolean true si el requsito se cumple y false si no se cumple.
     */
    public boolean verificar_requisito(){
        return cantidad == valor;
    }

    //setters
    /** setRequisito
     * Le asigna un valor a requisito.
     * 
     * @param requisito char con el requisito.
     */
    public void setRequisito(char requisito){
        this.requisito = requisito;
    }
    
    /** setValor
     * Le asigna un valor a valor.
     * 
     * @param valor int con el valor.
     */
    public void setValor(int valor){
        this.valor = valor;
    }
    
    /** setCantidad
     * Le asigna un valor a cantidad.
     * 
     * @param cantidad int con la cantidad.
     */
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    /** setRecompensa
     * Le asigna un valor a recompensa.
     * 
     * @param recompensa int con la recompensa.
     */
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }

    //getters
    /** getRequisito
     * Devielve el valor de el requisito.
     * 
     * @return char requisito.
     */
    public char getRequisito(){
        return this.requisito;
    }
    
    /** getValor
     * Devielve el valor de el valor.
     * 
     * @return int valor.
     */
    public int getValor(){
        return this.valor;
    }
    
    /** getCantidad
     * Devielve el valor de la cantidad.
     * 
     * @return int cantidad.
     */
    public int getCantidad(){
        return this.cantidad;
    }
    
    /** getRecompen
     * Devielve el valor de la recompensa.
     * 
     * @return int recompensa.
     */
    public int getRecompensa(){
        return this.recompensa;
    }
}

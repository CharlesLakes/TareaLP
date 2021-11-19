package thelegendofmorio.jugador;


public class Guerrero extends Jugador{
    /**Guerrero
     * Es el constructor de la clase Guerrero, la cual es llamada al ser intanciado
    * el objeto.
     * 
     * @param nombre Es un string que contiene el nombre de el guerrero
     */
    public Guerrero(String nombre){
        super(nombre,20,0,9,1,10,2);
    }

    
    /** ataque
     * Devuelve el ataque que ejerce el guerrero
     * La que depende de la fuerza y energia.
     * 
     * @return int ataque que ejerce el guerrero.
     */
    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = this.getFuerza()*2 + this.getEnergia();
        this.setEnergia(this.getEnergia() - 5);
        return resultado;
    }

    
    /** hechizo
     * Devuelve el hechizo que ejerce el guerrero
     * La que depende de la manda, inteligencia, fuerza y mana.
     * 
     * @return int hechizo que ejerce el guerrero.
     */
    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = this.getInteligencia()*this.getFuerza()/4 + this.getMana();
        this.setMana(this.getMana() - 3);
        return resultado;
    }

    
    /** subir_experiencia
     * Sube la experiencia de el jugador y si sube de nivel
     * sube los atributos correspondientes
     * 
     * @param xp int de la experencia que se le da al jugador.
     */
    public void subir_experiencia(int xp){
        int anterior_nivel = this.getNivel();
        this.setXp(this.getXp() + xp);
        if(anterior_nivel == this.getNivel()) return;

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

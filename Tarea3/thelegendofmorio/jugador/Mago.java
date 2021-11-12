package thelegendofmorio.jugador;

public class Mago extends Jugador{
    /**Mago
     * Es el constructor de la clase Mago, la cual es llamada al ser intanciado
     * el objeto.
     * 
     * @param nombre String con el nombre de el mago
     */
    public Mago(String nombre){
        super(nombre,10,0,3,10,6,15);
    }

    
    /** ataque
     * Devuelve el ataque que ejerce el mago
     * La que depende de la energia, fuerza e inteligencia.
     * 
     * @return int ataque que ejerce el mago.
     */
    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = this.getFuerza()*this.getInteligencia()/4 + this.getEnergia();
        this.setEnergia(this.getEnergia() - 3);
        return resultado;
    }

    
    /** hechizo
     * Devuelve el ataque que ejerce el mago
     * La que depende de la mana, fuerza e inteligencia.
     * 
     * @return int ataque que ejerce el mago.
     */
    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = this.getInteligencia()*this.getFuerza()/4 + this.getMana();
        this.setMana(this.getMana() - 5);
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

        this.setVidaMaxima(this.getVidaMaxima() + 2*this.getNivel());
        this.setFuerza(this.getFuerza() + 1);
        this.setInteligencia(this.getInteligencia() + 3*this.getNivel());
        this.setEnergiaMaxima(this.getEnergiaMaxima() + 1);
        this.setManaMaxima(this.getManaMaxima() + 3*this.getNivel());

        this.setVida(this.getVidaMaxima());
        this.setEnergia(this.getEnergiaMaxima());
        this.setMana(this.getManaMaxima());
    }
}

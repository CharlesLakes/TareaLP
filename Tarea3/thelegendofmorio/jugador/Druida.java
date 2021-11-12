package thelegendofmorio.jugador;


public class Druida extends Jugador{
    public Druida(String nombre){
        super(nombre,15,0,5,5,5,5);
    }

    
    
    /** 
     * Devuelve el ataque que ejerce la Druida
     * La que depende de la fuerza, inteligencia, energia y mana.
     * 
     * @return int ataque que ejerce la druida.
     */
    public int ataque(){
        if(this.getEnergia() == 0) return 0;
        int resultado = (this.getFuerza() + this.getInteligencia())*Math.max(this.getEnergia()/3,this.getMana()/2)/3;
        this.setEnergia(this.getEnergia() - 3);
        return resultado;
    }

    
    /** 
     * Devuelve el hechizo que ejerce la Druida
     * Lo que depende de el mana, fuerza, inteligencia y energia.
     * 
     * @return int hechizo que ejerce la druida.
     */
    public int hechizo(){
        if(this.getMana() == 0) return 0;
        int resultado = (this.getFuerza() + this.getInteligencia())*Math.max(this.getEnergia()/2,this.getMana()/3)/3;
        this.setMana(this.getMana() - 3);
        return resultado;
    }

    
    /** 
     * Sube la experiencia de el jugador y si sube de nivel
     * sube los atributos correspondientes
     * 
     * @param xp int de la experencia que se le da al jugador.
     */
    public void subir_experiencia(int xp){
        int anterior_nivel = this.getNivel();
        this.setXp(this.getXp() + xp);
        if(anterior_nivel == this.getNivel()) return;

        this.setVidaMaxima(this.getVidaMaxima() + this.getNivel());
        this.setFuerza(this.getFuerza() + this.getNivel());
        this.setInteligencia(this.getInteligencia() + this.getNivel());
        this.setEnergiaMaxima(this.getEnergiaMaxima() + this.getNivel());
        this.setManaMaxima(this.getManaMaxima() + this.getNivel());

        this.setVida(this.getVidaMaxima());
        this.setEnergia(this.getEnergiaMaxima());
        this.setMana(this.getManaMaxima());
    }
}

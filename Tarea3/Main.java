import thelegendofmorio.jugador.*;
import thelegendofmorio.mision.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Mision> test = new ArrayList<Mision>();
        Jugador testJugador = new Druida(test);
        System.out.println("El nombre de la druida: "+testJugador.getNombre());
    }
}

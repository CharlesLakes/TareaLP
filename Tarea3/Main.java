import thelegendofmorio.jugador.*;
import thelegendofmorio.utils.AuxScanner;
import thelegendofmorio.tierra.*;



import thelegendofmorio.enemigo.*;
import thelegendofmorio.npc.*;

public class Main {
    

    
    /** tipoDeTierra
     * Le pide al usuario el tipo de tierra al usuario.
     * 1. Montana
     * 2. Planicie
     * 3. Bosque
     * 
     * @return int indice de la tierra elegida
     */
    public static int tipoDeTierra(){
        int opt;
        do{
            System.out.println("Tierras:\n1.Montana\n2.Planicie\n3.Bosque");
            System.out.print("Que tipo de tierras es (solo numero): ");

            opt = AuxScanner.input.nextInt();
            if(opt < 1 || opt > 3)
                System.out.println("Entrada invalida.");
        }while(opt < 1 || opt > 3);

        return opt;
    }

    
    /** probabilidadEnemigo
     * Le pide al usuario la probabilidad de que aprezca un enemio.
     * 
     * @return double la probabilidad entre [0,1]
     */
    public static double probabilidadEnemigo(){
        System.out.print("Probabilidad de que un enemigo aparezca: ");
        double r =  AuxScanner.input.nextDouble();
        AuxScanner.input.nextLine();
        return r;
    }

    
    /** tipoDeEnemigo(
     * Le pide al usario el tipo de enemigo.
     * 1. Monstruo
     * 2. Jefe Final
     * 
     * @return int es el indice de lo elegido por el jugador
     */
    public static int tipoDeEnemigo(){
        int opt;
        do{
            System.out.println("Enemigos:\n1.Monstruo\n2.Jefe Final");
            System.out.print("Que tipo de Monstruo es (solo numero): ");

            opt = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();
            if(opt < 1 || opt > 2)
                System.out.println("Entrada invalida.");
        }while(opt < 1 || opt > 2);

        return opt;
    }

    
    /** atributosMonstruo
     * Pide los atributos de el monstruo.
     * 
     * @return Monstruo Objeto Monstruo con los datos ingresados por el usuario
     */
    public static Monstruo atributosMonstruo(){
        System.out.print("Vida: ");
        int vida = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();

        System.out.print("Da??o: ");
        int dano = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();

        return new Monstruo(vida, dano);
    }

    
    /** atributosJefeFinal
     * Pide los atrubutos de el Jefe Final
     * 
     * @return Jefe_Final Objeto Jefe:final con los datos ingresador por el usuario
     */
    public static Jefe_Final atributosJefeFinal(){
        System.out.print("Nombre: ");
        String nombre = AuxScanner.input.nextLine();

        System.out.print("Vida: ");
        int vida = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();

        System.out.print("Da??o Base: ");
        int dano_base = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();

        return new Jefe_Final(nombre,vida,dano_base);
    }

    
    /** preguntarNPC
     * Le pregunta al usuario si existe un NPC.
     * 
     * @return boolean true si existe y false si no existe
     */
    public static boolean preguntarNPC(){
        String opt;
        do{
            System.out.print("Hay un npc (si o no): ");
            opt = AuxScanner.input.next();
            AuxScanner.input.nextLine();
            if(opt.equals("si") && opt.equals("no"))
                System.out.println("Entrada invalida.");
        }while(opt.equals("si") && opt.equals("no"));
        
        if(opt.equals("si"))
            return true;
        return false;
    }

    
    /** obtenerNPC
     * Le pide al usuario que tipo de NPC es y os atributos correspondientes.
     * 
     * @return NPC Objetno NPC con los datos ingresados por el usuario.
     */
    public static NPC obtenerNPC(){
        int opt;
        do{
            System.out.println("Enemigos:\n1.Bueno\n2.Malo\n3.Nuetro");
            System.out.print("Que tipo de NPC es (solo numero): ");

            opt = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();
            if(opt < 1 || opt > 3)
                System.out.println("Entrada invalida.");
        }while(opt < 1 || opt > 3);

        System.out.println("Si le asignas un nombre vacio el npc no existira.");
        System.out.print("Nombre: ");
        String nombre = AuxScanner.input.nextLine();

        if(opt == 1){
            System.out.print("Atributo (vida, xp, energia o mana): ");
            String atributo = AuxScanner.input.next();

            System.out.print("Cantidad: ");
            int cantidad = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();

            return new Bueno(nombre,atributo,cantidad);
        }
        if(opt == 2){
            System.out.print("Cantidad energia: ");
            int cantidad_energia = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();

            System.out.print("Cantidad mana: ");
            int cantidad_mana = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();

            return new Malo(nombre, cantidad_energia, cantidad_mana);
        }

        System.out.print("Requisito: ");
        char requisito = AuxScanner.input.next().charAt(0);
        AuxScanner.input.nextLine();

        System.out.print("Valor: ");
        int valor = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();
        
        System.out.print("Recompensa: ");
        int recompensa = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();

        return new Neutro(nombre, requisito, valor, recompensa);

    }

    
    /** obtenerJugador
     * Le pide al usuario los datos de el jugador
     * 
     * @return Jugador Objeto jugador con los datos ingresados por el usuario.
     */
    public static Jugador obtenerJugador(){
        System.out.print("Nombre de el jugador: ");
        String nombre = AuxScanner.input.nextLine();
        int opt;
        do{
            System.out.println("??De que clase eres?");
            System.out.println("1.Druida");
            System.out.println("2.Guerrero");
            System.out.println("3.Mago");
            System.out.print("Que clase es (solo numero): ");
            opt = AuxScanner.input.nextInt();
            AuxScanner.input.nextLine();
            if(opt < 1 || opt > 3)
                System.out.println("Entrada invalida.");
        }while(opt < 1 || opt > 3);

        if(opt == 1)
            return new Druida(nombre);

        if(opt == 2)
            return new Guerrero(nombre);
        return new Mago(nombre);

    }

    
    /** pedirPosInicial
     * Le pide al usuario la posicion inicial de el jugador.
     * 
     * @return int el valor de la posicion de el jugador
     */
    public static int pedirPosInicial(){
        System.out.print("Ingresa la posici??n inicial: ");
        return AuxScanner.input.nextInt();
    }

    
    /** generarMundo
     * Genera el mundo pidiendo al usuario los atributos correspondientes.
     * 
     * @param mundo[] Objeto tierra donde son guardados los atributos dados por el usuario
     */
    public static void generarMundo(Tierra mundo[]){
        for(int i = 0; i < mundo.length; i++){
            System.out.println("Posicion: "+String.valueOf(i + 1));
            int tipo_tierra = tipoDeTierra();
            float probabilidad_enemigo = (float) probabilidadEnemigo();
            String tipo_enemigo;
            Monstruo monstruo;
            Jefe_Final jefe_final;
            NPC npc;

            if(tipoDeEnemigo() == 1){
                tipo_enemigo = "Monstruo";
                monstruo = atributosMonstruo();
                jefe_final = new Jefe_Final("", 0, 0);
            }else{
                tipo_enemigo = "Jefe_Final";
                jefe_final = atributosJefeFinal();
                monstruo = new Monstruo(0, 0);
            }

            boolean existeNPC = preguntarNPC();

            if(existeNPC)
                npc = obtenerNPC();
            else
                npc = new Bueno("", "", 0);

            if(tipo_tierra == 1)
                mundo[i] = new Montana(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo);
            else if(tipo_tierra == 2)
                mundo[i] = new Planicie(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo);
            else   
                mundo[i] = new Bosque(probabilidad_enemigo, monstruo, jefe_final, npc, tipo_enemigo);
            
            System.out.println();
        }
    }

    
    /** menu
     * Menu de el programa el cual pregunta como se movera el jugador
     * Y notificara si se sigue el juego  no.
     * 
     * @param j Objeto jugdor el cual es el jugador creado por el usuario.
     * @param mundo[] 
     */
    public static void menu(Jugador j,Tierra mundo[]){
        boolean flag = true;
        int opt;

        while(flag){
            do{
                System.out.println("??Donde quieres ir?");
                System.out.println("1.Izquierda");
                System.out.println("2.Derecha");
                System.out.print("Direccion (solo numero): ");
                opt = AuxScanner.input.nextInt();
                AuxScanner.input.nextLine();
                if(opt != 1 && opt != 2)
                    System.out.println("Entrada invalida.");
            }while(opt != 1 && opt != 2);

            if(opt == 1)
                j.setPos((j.getPos() - 1) % mundo.length  >= 0 ? (j.getPos() - 1) % mundo.length : mundo.length + (j.getPos() - 1) % mundo.length);
            else
                j.setPos((j.getPos() + 1) % mundo.length);
            
            flag = mundo[j.getPos()].accion(j);

            if(flag && mundo[j.getPos()].getTipoEnemigo() == "Jefe_Final"){
                System.out.println("Mataste al jefe final.");
                flag = false;
            }else if(flag){
                for(int i = 0; i < j.getListaMisiones().size(); i++ ){
                    char requisito = j.getListaMisiones().get(i).getRequisito();
                    j.getListaMisiones().get(i).setCantidad(
                        requisito == 'v' ? j.getPos(): j.getListaMisiones().get(i).getCantidad() + 1
                    );
                }
                int p = 0;
                while(p < j.getListaMisiones().size()){
                    if(j.getListaMisiones().get(p).verificar_requisito()){
                        j.subir_experiencia(j.getListaMisiones().get(p).getRecompensa());
                        j.getListaMisiones().remove(p);
                    }else
                        p++;
                }
            }else{
                System.out.println("Moriste.");
            }

            
        }
    }

    
    /** main
     * Es donde se ejecuta el programa principal.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Ingresa el tama??o de el mundo: ");
        int tamano_mundo = AuxScanner.input.nextInt();
        AuxScanner.input.nextLine();
        
        Tierra mundo[] = new Tierra[tamano_mundo];
        generarMundo(mundo);

        Jugador j = obtenerJugador();
        j.setPos(tamano_mundo != 0 ? pedirPosInicial() % tamano_mundo: 0);

        menu(j, mundo);

        AuxScanner.input.close();
    }
}

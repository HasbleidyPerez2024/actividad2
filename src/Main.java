import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>(); //creamos un objeto de tipo arraylist de la clase Jugador
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("***** Menú principal ******");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Modificar jugador");
            System.out.println("5. Listar jugador");
            System.out.println("6. Salir");
            System.out.println("Digite una de las opciones ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    agregarJugador(jugadores, teclado);
                    break;

                case 2:
                    eliminarJugador(jugadores, teclado);
                    break;

                case 3:
                    buscarJugador(jugadores, teclado);
                    break;

                case 4:
                    modificarJugador(jugadores, teclado);
                    break;

                case 5:
                    listarJugador(jugadores);
                    break;

                case 6:
                    System.out.println("Usted esta saliendo del menú");

                default:
                    System.out.println("Ingrese una opción válida");
            }
        } while (opcion != 6);

        teclado.close();
    }

    //metodo para agregar un jugador
    public static void agregarJugador(ArrayList<Jugador> jugadores, Scanner teclado){
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa la posición del jugador: ");
        String posicion = teclado.nextLine();

        jugadores.add(new Jugador(nombre, posicion));
        System.out.println("Jugador agregado exitosamente");
        //se imprime la lista de jugadores con el nuevo jugador
        listarJugador(jugadores);
    }

    //metodo para eliminar un jugador
    public static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner teclado){
        System.out.println("Ingrese el id del jugador que desea eliminar: ");
        int id = teclado.nextInt();
        teclado.nextLine();


        Jugador jugadorAEliminar = null;
        //Se busca el jugador a eliminar
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                jugadorAEliminar = jugador;
            }
        }

        //Se confirma la eliminación
        System.out.println("Esta seguro que desea eliminar el jugador: " + jugadorAEliminar);
        String respuesta = teclado.nextLine();


        //Se elimina el jugador
        if (jugadorAEliminar != null && respuesta.equals("si")) {
            jugadores.remove(jugadorAEliminar);
            System.out.println("Jugador eliminado con éxito.");
            //Se lista los jugadores luego de eliminar
            listarJugador(jugadores);
        } else {
            System.out.println("Jugador no encontrado.");
        }

    }

    public static void buscarJugador(ArrayList<Jugador> jugadores, Scanner teclado){
        System.out.println("Ingrese el id del jugador que desea buscar");
        int id = teclado.nextInt();

        //Se busca el jugador
        for (Jugador jugador : jugadores){
            if (jugador.getId() == id){
                System.out.println("Jugador encontrado: " + jugador);
                return;
            }
        }

        System.out.println("Jugador no encontrado");
    }

    public static void modificarJugador(ArrayList<Jugador> jugadores, Scanner teclado){
        System.out.println("Ingrese el id del jugador que desea modificar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        //se pregunta si se desea modificar el nombre
        System.out.println("Desea modificar el nombre? ");
        String respuesta = teclado.nextLine();

        for (Jugador jugador : jugadores){
            //se modifica el nombre
            if (jugador.getId() == id && respuesta.equals("si")) {
                System.out.println("Ingrese el nuevo nombre del jugador ");
                String nuevoNombre = teclado.nextLine();
                jugador.setNombre(nuevoNombre);
                System.out.println("jugador modificado con exito");
                //se listan los jugadores
                listarJugador(jugadores);

            } else {
                if (jugador.getId() == id && respuesta.equals("no")){
                    //se pregunta si se desea modificar la posición
                    System.out.println("Desea modificar la posicion? ");
                    String resp = teclado.nextLine();

                    if (resp.equals("si")){
                        //se modifica la posicion
                        System.out.println("Ingrese la nueva posición del jugador");
                        String nuevaPosicion = teclado.nextLine();
                        jugador.setPosicion(nuevaPosicion);
                        System.out.println("jugador modificado con exito");
                        //Se listan los jugadores
                        listarJugador(jugadores);
                    }
                    else {
                        System.out.println("Jugador no encontrado");
                    }
                }
            }
        }
    }

    //metodo para listar los jugadores
    public static void listarJugador(ArrayList<Jugador> jugadores){
        if (jugadores.isEmpty()){
            System.out.println("No hay jugadores ingresados");
        }
        else {
            System.out.println("Jugadores ingresados: ");
            for (Jugador jugador : jugadores){
                System.out.println(jugador);
            }
        }
    }
}
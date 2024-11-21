
public class Jugador {

    private static int contId = 1; // esta es la variable que nos va ayudar a generar ids unicos
    private final int id;
    private String nombre;
    private String posicion;

    public Jugador(String nombre, String posicion) {
        this.id = contId++;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}

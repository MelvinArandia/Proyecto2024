package modelo;


public class Categoria {
    private String nombre;
    private ListaEnlazadaDobleEnlace tareas;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.tareas = new ListaEnlazadaDobleEnlace();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.agregarTarea(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareas.eliminarTarea(tarea);
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazadaDobleEnlace getTareas() {
        return tareas;
    }
}

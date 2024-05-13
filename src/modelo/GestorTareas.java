package modelo;

public class GestorTareas {
    private ListaEnlazadaDobleEnlace listaDeTareas;
    private Usuario usuario;

    public GestorTareas(Usuario usuario) {
        this.listaDeTareas = new ListaEnlazadaDobleEnlace();
        this.usuario = usuario;
    }

    public void agregarTarea(Tarea tarea) {
        listaDeTareas.agregarTarea(tarea);
       // GestorUsuarios.guardarTareas(usuario.getNombreUsuario(), listaDeTareas);
    }

    public void eliminarTarea(Tarea tarea) {
        listaDeTareas.eliminarTarea(tarea);
        GestorUsuarios.guardarTareas(usuario.getNombreUsuario(), listaDeTareas);
    }

    public void modificarTarea(Tarea tareaAntigua, Tarea tareaNueva) {
        listaDeTareas.modificarTarea(tareaAntigua, tareaNueva);
        GestorUsuarios.guardarTareas(usuario.getNombreUsuario(), listaDeTareas);
    }

    public void mostrarTareas() {
        listaDeTareas.mostrarTareas();
    }

    public ListaEnlazadaDobleEnlace filtrarTareas(String estado) {
        return listaDeTareas.filtrarTareas(estado);
    }
    
    public void setListaDeTareas(ListaEnlazadaDobleEnlace listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }
    
    public ListaEnlazadaDobleEnlace getListaDeTareas() {
        return listaDeTareas;
    }
}
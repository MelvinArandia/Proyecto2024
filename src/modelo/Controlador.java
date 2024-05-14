package modelo;

public class Controlador {
    private GestorUsuarios gestorUsuarios;
    private Usuario usuarioActual;
    private InterfazUsuario interfazUsuario;
    private GestorTareas gestorTareas;

    public Controlador() {
        this.gestorUsuarios = new GestorUsuarios();
    }

    //  configuración para establecer la interfaz de usuario
    public void setInterfazUsuario(InterfazUsuario interfazUsuario) {
        this.interfazUsuario = interfazUsuario;
    }

    //metodo para mostrar el nombre en el panel principal
    public String obtenerNombreUsuarioActual() {
        if (usuarioActual != null) {
            return usuarioActual.getNombre();
        } else {
            return "Registrando";
        }    }

    public void iniciarSesion(String nombreUsuario, String contraseña) {
        usuarioActual = gestorUsuarios.iniciarSesion(nombreUsuario, contraseña);
        if (usuarioActual != null) {
            interfazUsuario.mostrarPanelPrincipal(nombreUsuario);
        } else {
            interfazUsuario.mostrarMensaje("Inicio de sesión fallido. Verifica tus datos.");
        }
    }

    public void registrarUsuario(String nombre, String email, String nombreUsuario, String contraseña) {
        boolean registrado = gestorUsuarios.registrarUsuario(new UsuarioRegistrado(nombre, email, nombreUsuario, contraseña));
        if (registrado) {
            interfazUsuario.mostrarMensaje("Registro exitoso");
            interfazUsuario.mostrarPanelPrincipal(nombreUsuario);
        } else {
            interfazUsuario.mostrarMensaje("El usuario ya existe, elija otro nombre de usuario.");        }
    }

    public void mostrarPanelInicio() {
        interfazUsuario.mostrarPanelInicio();
    }
    public void agregarTarea(String titulo, String descripcion, String fechaLimite, String estado, int prioridad, String etiqueta) {
        Tarea nuevaTarea = new Tarea(titulo, descripcion, fechaLimite, estado, prioridad);
        gestorTareas.agregarTarea(nuevaTarea);
    }

    public void eliminarTarea(Tarea tarea) {
        gestorTareas.eliminarTarea(tarea);
    }

    public void modificarTarea(Tarea tareaAntigua, Tarea tareaNueva) {
        gestorTareas.modificarTarea(tareaAntigua, tareaNueva);
    }

    public void mostrarTareas() {
        gestorTareas.mostrarTareas();
    }

    public ListaEnlazadaDobleEnlace filtrarTareas(String estado) {
        return gestorTareas.filtrarTareas(estado);
    }

}


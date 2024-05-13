package modelo;


public class Usuario {
    private String nombre;
    private String email;
    private String nombreUsuario;
    private GestorTareas gestorTareas;
    private String contraseña;

    public Usuario(String nombre, String email, String nombreUsuario, String contraseña) {
    this.nombre = nombre;
    this.email = email;
    this.nombreUsuario = nombreUsuario; // Agregar esta línea
    this.gestorTareas = new GestorTareas(this);
    this.contraseña = contraseña;
}

    // Getters y Setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContraseña(){
        return contraseña;
    }

    public GestorTareas getAgenda() {
        return gestorTareas;
    }
}
package modelo;

public class UsuarioRegistrado extends Usuario {
    private String nombreUsuario;
    private String contraseña;

    public UsuarioRegistrado(String nombre, String email, String nombreUsuario, String contraseña) {
       super(nombre, email, nombreUsuario, contraseña); // Agregar nombreUsuario
    this.nombreUsuario = nombreUsuario;
    this.contraseña = contraseña;
}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
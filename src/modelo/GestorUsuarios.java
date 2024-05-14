package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GestorUsuarios {
    private static final String DIRECTORIO_USUARIOS = "usuarios/";

    public static boolean registrarUsuario(Usuario usuario) {
        String nombreArchivo = DIRECTORIO_USUARIOS + usuario.getNombreUsuario() + ".txt";
        File archivo = new File(nombreArchivo);

        try {
            if (!archivo.exists()) {
                archivo.getParentFile().mkdirs();
                archivo.createNewFile();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    writer.write(usuario.getNombre());
                    writer.newLine();
                    writer.write(usuario.getEmail());
                    writer.newLine();
                    writer.write(usuario.getNombreUsuario());
                    writer.newLine();
                    writer.write(usuario.getContraseña());
                }

                JOptionPane.showMessageDialog(null, "¡Registro exitoso! Bienvenido.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe. Por favor, elija otro nombre de usuario.");
                return false;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario: " + e.getMessage());
            return false;
        }
    }


    public static UsuarioRegistrado iniciarSesion(String nombreUsuario, String contraseña) {
        String nombreArchivo = DIRECTORIO_USUARIOS + nombreUsuario + ".txt";
        File archivo = new File(nombreArchivo);

        try {
            if (archivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String nombre = reader.readLine();
                    String email = reader.readLine();
                    String usuarioLeido = reader.readLine();
                    String contraseñaLeida = reader.readLine();

                    if (nombreUsuario.equals(usuarioLeido) && contraseña.equals(contraseñaLeida)) {
                        return new UsuarioRegistrado(nombre, email, nombreUsuario, contraseñaLeida);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }

        return null;
    }

    public static UsuarioRegistrado obtenerUsuario(String nombreUsuario) {
        String nombreArchivo = DIRECTORIO_USUARIOS + nombreUsuario + ".txt";
        File archivo = new File(nombreArchivo);

        try {
            if (archivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String nombre = reader.readLine();
                    String email = reader.readLine();
                    String usuarioLeido = reader.readLine();
                    String contraseña = reader.readLine();

                    if (nombreUsuario.equals(usuarioLeido)) {
                        return new UsuarioRegistrado(nombre, email, nombreUsuario, contraseña);
                    }
                }
            }// aqui no es 
        } catch (IOException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }

        return null;
    }
    public static void guardarTareas(String nombreUsuario, ListaEnlazadaDobleEnlace tareas) {
        String nombreArchivo = DIRECTORIO_USUARIOS + nombreUsuario + ".txt";
        File archivo = new File(nombreArchivo);

        try {
            if (archivo.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                    writer.newLine();
                    writer.write("--- Tareas ---");
                    writer.newLine();
                    Nodo actual = tareas.cabeza;
                    while (actual != null) {
                        writer.write(actual.tarea.getTitulo() + "," + actual.tarea.getDescripcion() + "," +
                                actual.tarea.getFechaLimite() + "," + actual.tarea.getEstado() + "," +
                                actual.tarea.getPrioridad() + "," + actual.tarea.getEtiqueta());
                        writer.newLine();
                        actual = actual.siguiente;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    public static ListaEnlazadaDobleEnlace obtenerTareas(String nombreUsuario) {
        ListaEnlazadaDobleEnlace tareas = new ListaEnlazadaDobleEnlace();
        String nombreArchivo = DIRECTORIO_USUARIOS + nombreUsuario + ".txt";
        File archivo = new File(nombreArchivo);

        try {
            if (archivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        if (linea.equals("--- Tareas ---")) {
                            while ((linea = reader.readLine()) != null) {
                                String[] datosTemp = linea.split(",");
                                if (datosTemp.length == 6) {
                                    String titulo = datosTemp[0];
                                    String descripcion = datosTemp[1];
                                    String fechaLimite = datosTemp[2];
                                    String estado = datosTemp[3];
                                    int prioridad = Integer.parseInt(datosTemp[4]);
                                    String etiqueta = datosTemp[5];
                                    Tarea tarea = new Tarea(titulo, descripcion, fechaLimite, estado, prioridad);
                                    tareas.agregarTarea(tarea);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al obtener las tareas: " + e.getMessage());
        }

        return tareas;
    }
   
}//aca tendria que estar
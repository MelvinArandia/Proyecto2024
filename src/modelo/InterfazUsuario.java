package modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazUsuario {

    private JFrame marco;
    private PanelInicio panelInicio;
    private PanelRegistro panelRegistro;
    private PanelPrincipal panelPrincipal;
    private Controlador controlador;

    public InterfazUsuario(Controlador controlador) {
        this.controlador = controlador;
        marco = new JFrame("Organizador de tareas");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(600, 600);

        panelInicio = new PanelInicio();
        panelRegistro = new PanelRegistro();
        panelPrincipal = new PanelPrincipal(controlador);
        // llamamos al metodo para configurar el controlador/ esto para el boton de atras
        panelRegistro.setControlador(controlador);

        panelInicio.addIniciarSesionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = panelInicio.getNombreUsuario();
                String contraseña = panelInicio.getContraseña();
                controlador.iniciarSesion(nombreUsuario, contraseña);
            }
        });

        panelInicio.addRegistrarseListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanelRegistro();
            }
        });


        panelRegistro.addRegistrarseListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = panelRegistro.getNombre();
                String email = panelRegistro.getEmail();
                String nombreUsuario = panelRegistro.getNombreUsuario();
                String contraseña = panelRegistro.getContraseña();
                controlador.registrarUsuario(nombre, email, nombreUsuario, contraseña);
            }
        });

        mostrarPanelInicio();
        marco.setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(marco, mensaje);
    }

    public void mostrarPanelInicio() {
        marco.getContentPane().removeAll();
        marco.getContentPane().add(panelInicio);
        marco.revalidate();
        marco.repaint();
    }

    public void mostrarPanelRegistro() {
        marco.getContentPane().removeAll();
        marco.getContentPane().add(panelRegistro);
        marco.revalidate();
        marco.repaint();
    }

    public void mostrarPanelPrincipal(String nombreUsuario) {
        marco.getContentPane().removeAll();
        panelPrincipal = new PanelPrincipal(controlador);
        marco.getContentPane().add(panelPrincipal);
        marco.revalidate();
        marco.repaint();
    }
}


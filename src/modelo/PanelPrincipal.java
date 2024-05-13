package modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelPrincipal extends JPanel {
    private JButton btnAgregarTarea;
    private JButton btnEliminarTarea;
    private JButton btnModificarTarea;
    private JButton btnMostrarTareas;
    private JButton btnFiltrarTareas;
    private JButton btnMostrarOcultar;
    private JPanel panelBotones;
    //private  JTextArea textoTarea;
    private Controlador controlador;

    public PanelPrincipal(Controlador controlador) {
        this.controlador = controlador;
        String nombreUsuario = controlador.obtenerNombreUsuarioActual();
        setLayout(new GridBagLayout());
        setBackground(new Color(0xccdbfd));

        btnMostrarOcultar = new JButton("|||");
        btnMostrarOcultar.setFont(new Font("Helvetica World", Font.PLAIN, 20));
        btnMostrarOcultar.setBackground(new Color(0xA9BBE0));
        btnMostrarOcultar.setForeground(new Color(0xffffff));
        btnMostrarOcultar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0xA9BBE0), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        btnMostrarOcultar.setFocusPainted(false);
        btnMostrarOcultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (panelBotones.isVisible()) {
                    panelBotones.setVisible(false);
                } else {
                    panelBotones.setVisible(true);
                }
            }
        });

        // barra desplegable y botones
        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        panelIzquierdo.setBackground(new Color(0xA9BBE0));
         // panel derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(0x9C9FED));

        // "mi organizador"
        JLabel lblOrganizador= new JLabel("Mi Organizador");
        lblOrganizador.setForeground(new Color(0x223662));
        lblOrganizador.setFont(new Font("Helvetica World", Font.PLAIN, 20));
        // para agregarlo a la pantalla
        GridBagConstraints gbcDerecho = new GridBagConstraints();
        gbcDerecho.gridx = 0;
        gbcDerecho.gridy = 0;
        gbcDerecho.weightx = 1;
        gbcDerecho.weighty = 1;
        gbcDerecho.fill = GridBagConstraints.BOTH;
        gbcDerecho.gridwidth = GridBagConstraints.REMAINDER;
        gbcDerecho.anchor = GridBagConstraints.NORTH;
        gbcDerecho.insets = new Insets(5, 5, 5, 5);
        add(lblOrganizador, gbcDerecho);

        // Imagen
        ImageIcon icono = new ImageIcon("C:/Users/Windows 10pro 2019/OneDrive/Documentos/Taller de Progra/Organizador_Tareas/imagenes/usuarioprin.png");
        Image imagen = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(imagen));

        JLabel lblNombreUsuario = new JLabel(nombreUsuario);
        lblNombreUsuario.setForeground(new Color(0xBF287E));
        lblNombreUsuario.setFont(new Font("Helvetica World", Font.PLAIN, 16));

        // Panel para los botones de acción
        panelBotones = new JPanel(new GridLayout(5, 1, 5, 5));
        panelBotones.setBackground(new Color(0xA9BBE0));

        // Inicializar botones de acción
        btnAgregarTarea = new JButton("Agregar Tarea");
        btnEliminarTarea = new JButton("Eliminar Tarea");
        btnModificarTarea = new JButton("Modificar Tarea");
        btnMostrarTareas = new JButton("Mostrar Tareas");
        btnFiltrarTareas = new JButton("Filtrar Tareas");

        // Establecer la apariencia de los botones
        aparienciaBotones(btnAgregarTarea);
        aparienciaBotones(btnEliminarTarea);
        aparienciaBotones(btnModificarTarea);
        aparienciaBotones(btnMostrarTareas);
        aparienciaBotones(btnFiltrarTareas);

        // Agregar botones al panel de botones
        panelBotones.add(btnAgregarTarea);
        panelBotones.add(btnEliminarTarea);
        panelBotones.add(btnModificarTarea);
        panelBotones.add(btnMostrarTareas);
        panelBotones.add(btnFiltrarTareas);

        // Añadimos los botones a la barra
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        panelIzquierdo.add(btnMostrarOcultar, gbc);
        gbc.gridy++;
        panelIzquierdo.add(lblImagen, gbc);
        gbc.gridy++;
        panelIzquierdo.add(lblNombreUsuario, gbc);
        gbc.gridy++;
        panelIzquierdo.add(panelBotones, gbc);

        // panel en el lado izquierdo al panel
        GridBagConstraints gbcPrincipal = new GridBagConstraints();
        gbcPrincipal.weightx = 1;
        gbcPrincipal.weighty = 1;
        gbcPrincipal.fill = GridBagConstraints.VERTICAL;
        gbcPrincipal.anchor = GridBagConstraints.WEST;
        add(panelIzquierdo, gbcPrincipal);

        // texto para agregar la tarea
        //textoTarea = new JTextArea(10, 20);
        //textoTarea.setBackground(new Color(0x878AD4));


        /*GridBagConstraints gbcAreaTexto = new GridBagConstraints();
        gbcAreaTexto.gridx = 0;
        gbcAreaTexto.gridy = 0;
        gbcAreaTexto.weightx = 0; // Expandir a los lados
        gbcAreaTexto.weighty = 0;
        gbcAreaTexto.insets = new Insets(5, 5, 5, 5);
        gbcAreaTexto.anchor = GridBagConstraints.CENTER;
        gbcAreaTexto.gridwidth = 1;
        gbcAreaTexto.gridheight = 1;

        add(textoTarea, gbcAreaTexto);

        textoTarea.setVisible(false);

        btnAgregarTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });*/

    }

    //  apariencia de los botones
    private void aparienciaBotones(JButton button) {
        button.setBackground(new Color(0xA9BBE0));
        button.setForeground(new Color(0x223662));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0xA9BBE0), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
    }

    // detecamos aciones del usuario mediante ActionListener en los botones
    public void addEliminarTareaListener(ActionListener listener) {
        btnEliminarTarea.addActionListener(listener);
    }

    public void addModificarTareaListener(ActionListener listener) {
        btnModificarTarea.addActionListener(listener);
    }

    public void addMostrarTareasListener(ActionListener listener) {
        btnMostrarTareas.addActionListener(listener);
    }

    public void addFiltrarTareasListener(ActionListener listener) {

    }
}


package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelRegistro extends JPanel {
    private JLabel lblNombre;
    private JLabel lblEmail;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTextField txtNombreUsuario;
    private JPasswordField txtContraseña;
    private JButton btnRegistrarse;
    private JButton btnAtras;

    public PanelRegistro() {
        setLayout(new GridBagLayout());
        setBackground(new Color(0xccdbfd));

        // Inicializar componentes
        lblNombre = new JLabel("Nombre:");
        lblEmail = new JLabel("Email:");
        lblNombreUsuario = new JLabel("Nombre de Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        txtNombre = new JTextField(15);
        txtEmail = new JTextField(15);
        txtNombreUsuario = new JTextField(15);
        txtContraseña = new JPasswordField(15);
        btnRegistrarse = new JButton("Registrarse");
        btnAtras = new JButton("Atrás");

        // Textos
        txtNombre.setBackground(new Color(0x9cadce));
        txtEmail.setBackground(new Color(0x9cadce));
        txtNombreUsuario.setBackground(new Color(0x9cadce));
        txtContraseña.setBackground(new Color(0x9cadce));

        txtNombre.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtNombreUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtContraseña.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        // Botones
        btnRegistrarse.setBackground(new Color(0x758ac8));
        btnAtras.setBackground(new Color(0x758ac8));

        btnRegistrarse.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x688db9), 1), // Borde con color de fondo
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Espacios alrededor del texto
        ));
        btnAtras.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x688db9), 1), // Borde con color de fondo
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Espacios alrededor del texto
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5,5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        add(lblNombre, gbc);
        gbc.gridx++;
        add(txtNombre, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(lblEmail, gbc);
        gbc.gridx++;
        add(txtEmail, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(lblNombreUsuario, gbc);
        gbc.gridx++;
        add(txtNombreUsuario, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(lblContraseña, gbc);
        gbc.gridx++;
        add(txtContraseña, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(btnRegistrarse, gbc);
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnAtras, gbc);

        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Notificar al controlador
            }
        });



    }

    public void setControlador(Controlador controlador) {
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.mostrarPanelInicio();
            }
        });
    }
    public void addRegistrarseListener(ActionListener listener) {
        btnRegistrarse.addActionListener(listener);
    }
    // Metodos para obtener los datos ingresados en el formulario de registro
    public String getNombre() {
        return txtNombre.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public String getNombreUsuario() {
        return txtNombreUsuario.getText();
    }

    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }
}

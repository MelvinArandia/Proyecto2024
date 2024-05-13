
package modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelInicio extends JPanel {
    private JLabel lblUsuario;
    private JLabel lblContraseña;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    public PanelInicio() {
        // diseño del panel
        setLayout(new GridBagLayout());
        setBackground(new Color(0xccdbfd));

        // Inicializacion

        lblUsuario = new JLabel("Usuario");
        txtUsuario = new JTextField(20);
        lblUsuario.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblContraseña = new JLabel("Contraseña");
        txtContraseña = new JPasswordField(20);
        lblContraseña.setFont(new Font("Open Sans", Font.PLAIN, 14));
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setFont(new Font("Open Sans", Font.PLAIN, 14));
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Open Sans", Font.PLAIN, 14));


        // icono de usuario
        ImageIcon iconoUsuario = new ImageIcon("C:/Users/Windows 10pro 2019/OneDrive/Documentos/Taller de Progra/Organizador_Tareas/imagenes/usuario.png");
        Image imagenRedimensionada = iconoUsuario.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        iconoUsuario.setImage(imagenRedimensionada);
        JLabel lblIconoUsuario = new JLabel((Icon) iconoUsuario);

        //textos
        txtUsuario.setBackground(new Color(0x9cadce));
        txtContraseña.setBackground(new Color(0x9cadce));

        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        txtContraseña.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x9cadce), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        //botones
        btnIniciarSesion.setBackground(new Color(0x5f75b4));
        btnRegistrarse.setBackground(new Color(0x5f75b4));

        btnIniciarSesion.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x688db9), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        btnRegistrarse.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0x688db9), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5,5, 5);

        gbc.anchor = GridBagConstraints.CENTER;//centrar botones
        add(lblIconoUsuario, gbc);
        gbc.gridy++;
        add(lblUsuario, gbc);
        gbc.gridy++;
        add(txtUsuario, gbc);
        gbc.gridy++;
        add(lblContraseña, gbc);
        gbc.gridy++;
        add(txtContraseña, gbc);
        gbc.gridy++;
        add(btnIniciarSesion, gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnRegistrarse, gbc);

    }
    // ActionListener a los botones
    public String getNombreUsuario() {
        return txtUsuario.getText();
    }

    public String getContraseña() {
        return new String(txtContraseña.getPassword());
    }
    public void addIniciarSesionListener(ActionListener listener) {
        btnIniciarSesion.addActionListener(listener);
    }
    public void addRegistrarseListener(ActionListener listener) {
        btnRegistrarse.addActionListener(listener);
    }


}

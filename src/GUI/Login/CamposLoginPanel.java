package Login;

import Utilities.*;
import java.awt.*;
import javax.swing.*;

public class CamposLoginPanel extends JPanel {
    private JTextField usuarioInput;
    private JPasswordField contrasenaInput;
    private TextoOutline iniciarSesionLabel;
    private TextoOutline usuarioLabel;
    private TextoOutline contrasenaLabel;

    public CamposLoginPanel() {
        setOpaque(false);
        setLayout(null); // Posicionamiento absoluto

        iniciarSesionLabel = crearIniciarSesionLabel();
        iniciarSesionLabel.setBounds(20, 10, 150, 30);
        add(iniciarSesionLabel);

        usuarioLabel = crearUsuarioLabel();
        usuarioLabel.setBounds(20, 60, 100, 20);
        add(usuarioLabel);

        usuarioInput = crearUsuarioInput();
        usuarioInput.setBounds(20, 85, 300, 25);
        add(usuarioInput);

        contrasenaLabel = crearContrasenaLabel();
        contrasenaLabel.setBounds(20, 120, 100, 20);
        add(contrasenaLabel);

        contrasenaInput = crearContrasenaInput();
        contrasenaInput.setBounds(20, 145, 300, 25);
        add(contrasenaInput);

        // Visualización de límites (para depuración)
        //DibujarLimites.dibujarLimites(this);
    }

    /**
     * * Crea y configura el JLabel "Inicia Sesión".
     *
     * @return instancia de TextoOutline configurada.
     */
    private TextoOutline crearIniciarSesionLabel() {
        Font font = new Font("Arial", Font.BOLD, 24);
        Color fillColor = Color.decode("#333333");
        Color outlineColor = Color.WHITE;
        String texto = "Inicia Sesión";
        TextoOutline label = new TextoOutline(texto, font, fillColor, outlineColor, 2f);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    /**
     * Crea y configura el JLabel "Usuario".
     *
     * @return instancia de TextoOutline configurada.
     */
    private TextoOutline crearUsuarioLabel() {
        Font font = new Font("Arial", Font.BOLD, 16);
        Color fillColor = Color.decode("#FFFFFF");
        Color outlineColor = Color.BLACK;
        String texto = "Usuario";
        TextoOutline label = new TextoOutline(texto, font, fillColor, outlineColor, 2f);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    /**
     * Crea y configura el campo de texto para el usuario.
     *
     * @return instancia de JTextField configurada.
     */
    private JTextField crearUsuarioInput() {
        usuarioInput = new JTextField();
        usuarioInput.setFont(new Font("Arial", Font.PLAIN, 14));
        usuarioInput.setBackground(Color.decode("#F4F4F4"));
        usuarioInput.setForeground(Color.BLACK);
        usuarioInput.setBorder(BorderFactory.createLineBorder(Color.decode("#B0B0B0")));
        // Asigna el texto de placeholder si OnFocusEventHelper está activo
        OnFocusEventHelper.setOnFocusText(usuarioInput, "  Ingrese su Usuario", Color.BLACK, null);
        return usuarioInput;
    }

    /**
     * Crea y configura el JLabel "Contraseña".
     *
     * @return instancia de TextoOutline configurada.
     */
    private TextoOutline crearContrasenaLabel() {
        Font font = new Font("Arial", Font.BOLD, 16);
        Color fillColor = Color.decode("#FFFFFF");
        Color outlineColor = Color.BLACK;
        String texto = "Contraseña";
        TextoOutline label = new TextoOutline(texto, font, fillColor, outlineColor, 2f);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    /**
     * Crea y configura el campo de contraseña.
     *
     * @return instancia de JPasswordField configurada.
     */
    private JPasswordField crearContrasenaInput() {
        contrasenaInput = new JPasswordField();
        contrasenaInput.setFont(new Font("Arial", Font.PLAIN, 14));
        contrasenaInput.setBackground(Color.decode("#F4F4F4"));
        contrasenaInput.setForeground(Color.BLACK);
        contrasenaInput.setBorder(BorderFactory.createLineBorder(Color.decode("#B0B0B0")));
        // Asigna el texto de placeholder si OnFocusEventHelper está activo
        OnFocusEventHelper.setOnFocusText(contrasenaInput, "**********", Color.BLACK, null);
        return contrasenaInput;
    }

    // Getters para acceder a los campos desde el LoginAdmin
    public JTextField getUsuarioInput() {
        return usuarioInput;
    }

    public JPasswordField getContrasenaInput() {
        return contrasenaInput;
    }
}

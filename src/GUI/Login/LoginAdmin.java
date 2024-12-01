package Login;

import Menu.RestauranteGUI;
import Utilities.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginAdmin {

    // --------------- Constantes ---------------
    private static final String IMAGE_PATH = "/resources/logo/mealBG.jpg"; // Ruta dentro del classpath
    private static final int TAM_X = 800;
    private static final int TAM_Y = 500;

    // --------------- Componentes de la Interfaz ---------------
    // JFrame
    private JFrame frame;

    // Imagen de fondo
    private Image backgroundImage;

    // Paneles personalizados
    private BarraCustom barraPanel;
    private EmpresaPanel empresaPanel;
    private CamposLoginPanel camposLoginPanel;

    // Botones
    private JButton botonLogin;
    private JButton botonVolver;
    private JButton aceptarButton;

    // Panel para el fondo
    private JPanel panelBG;

    // --------------- Componentes de UI adicionales ---------------
    // Panel inferior para botones
    private JPanel panelBotones;

    // Entradas de texto
    private JTextField usuarioInput;
    private JPasswordField contrasenaInput;

    // Etiquetas de VentanaEmergente
    private JLabel etiqueta;

    // --------------- Colores para el diseño ---------------
    private Color colorOriginal;
    private Color colorOscuro;
    private Color textoOriginal;
    private Color textoPresionado;

    // --------------- Objetos para manejo de eventos ---------------
    private JDialog dialogo;
    private Timer timer;

    // --------------- Constructor ---------------
    public LoginAdmin() {
        try {
            iniciarFrame();
            iniciarPanel();
            addComponents();
            frame.setUndecorated(true);
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar la interfaz de usuario.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1); // Salida temprana si ocurre un error crítico
        }
    }

    // --------------- Inicialización de la Ventana ---------------
    /**
     * Inicializa el JFrame principal con dimensiones fijas y sin posibilidad de redimensionarlo.
     */
    private void iniciarFrame() {
        frame = new JFrame("Login Admin");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(TAM_X, TAM_Y);
        frame.setResizable(false);         // Deshabilitar redimensionamiento
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setLayout(null);             // Usar posicionamiento absoluto
    }

    /**
     * Inicializa el JPanel con la imagen de fondo y establece un layout absoluto.
     */
    private void iniciarPanel() {
        try {
            // Cargar la imagen desde el classpath
            InputStream is = getClass().getResourceAsStream(IMAGE_PATH);
            if (is == null) {
                throw new FileNotFoundException("No se encontró la imagen de fondo en el classpath: " + IMAGE_PATH);
            }
            backgroundImage = ImageIO.read(is);

            // Crear un panel personalizado que dibuja la imagen de fondo
            panelBG = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (backgroundImage != null) {
                        // Dibujar la imagen escalada al tamaño del panel
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    } else {
                        System.out.println("backgroundImage es null durante el paintComponent.");
                    }
                }
            };
            panelBG.setLayout(null); // Posicionamiento absoluto
            panelBG.setBounds(0, 0, TAM_X, TAM_Y);
            frame.setContentPane(panelBG);
            frame.revalidate();
            frame.repaint();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al cargar la imagen de fondo: " + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1); // Salida temprana si ocurre un error crítico
        }
    }

    // --------------- Adición de Componentes ---------------
    /**
     * Añade los componentes de la interfaz al panel principal utilizando posicionamiento absoluto.
     */
    private void addComponents() {
        // Añadir BarraPersonalizada en la parte superior
        barraPanel = new BarraCustom(frame);
        barraPanel.setBounds(0, 0, TAM_X, 25);
        frame.getContentPane().add(barraPanel);

        // Añadir EmpresaLabel directamente
        empresaPanel = new EmpresaPanel();
        empresaPanel.setBounds(20, 30, 500, 140);
        frame.getContentPane().add(empresaPanel);

        // Añadir CamposLoginPanel
        camposLoginPanel = new CamposLoginPanel();
        camposLoginPanel.setBounds(20, 200, 350, 200);
        frame.getContentPane().add(camposLoginPanel);

        // Panel inferior para los botones
        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(null);
        panelBotones.setBounds(50, 400, 280, 50);

        // Añadir botones de Login y Volver
        botonLogin = new JButton("Login");
        pintarBoton(botonLogin);
        botonLogin.setBounds(20, 10, 100, 30);
        botonLogin.addActionListener(e -> handleLogin());
        panelBotones.add(botonLogin);

        botonVolver = new JButton("Volver");
        pintarBoton(botonVolver);
        botonVolver.setBounds(160, 10, 100, 30);
        botonVolver.addActionListener(e -> frame.dispose());
        panelBotones.add(botonVolver);

        frame.getContentPane().add(panelBotones);
        // Dibujar Límites (para debug)
        // DibujarLimites.dibujarLimites(empresaPanel);
        // DibujarLimites.dibujarLimites(camposLoginPanel);
        // DibujarLimites.dibujarLimites(panelBotones);
    }

    // Método para configurar botones con estilos y listeners
    private void pintarBoton(JButton boton) {
        boton.setBackground(Color.decode("#00509E"));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                boton.setBackground(colorOscuro);
                boton.setForeground(textoPresionado);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                boton.setBackground(colorOriginal);
                boton.setForeground(textoOriginal);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    // --------------- Manejo de Eventos ---------------
    /**
     * Maneja la lógica cuando se presiona el botón de "Login".
     */
    private void handleLogin() {
        try {
            // Obtener los campos desde CamposLoginPanel
            usuarioInput = camposLoginPanel.getUsuarioInput();
            contrasenaInput = camposLoginPanel.getContrasenaInput();

            // Verificar si los campos de usuario y contraseña no son nulos
            if (usuarioInput == null || contrasenaInput == null) {
                ventanaEmergente("Componentes de entrada no están inicializados", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String usuario = usuarioInput.getText().trim();
            String contrasena = new String(contrasenaInput.getPassword()).trim();

            // Verificar si los campos están vacíos
            if (usuario.isEmpty()) {
                ventanaEmergente("El campo de usuario está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                usuarioInput.requestFocus();
                return;
            }

            if (contrasena.isEmpty()) {
                ventanaEmergente("El campo de contraseña está vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                contrasenaInput.requestFocus();
                return;
            }

            // Lógica de autenticación
            if (!isValidCredentials(usuario, contrasena)) {
                ventanaEmergente("Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ventanaEmergente("Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            // Continuar el flujo del programa
            new RestauranteGUI().mostrarPanel("Administrador");
        } catch (Exception e) {
            // Manejar cualquier excepción inesperada durante el proceso de login
            ventanaEmergente("Error durante el proceso de inicio de sesión.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Muestra un JOptionPane que se cierra automáticamente después de 4 segundos
     * o al presionar el botón "Aceptar".
     *
     * @param mensaje Mensaje a mostrar.
     * @param titulo  Título del cuadro de diálogo.
     * @param tipo    Tipo de mensaje (por ejemplo, JOptionPane.ERROR_MESSAGE).
     */
    private void ventanaEmergente(String mensaje, String titulo, int tipo) {
        // Crear el diálogo manualmente
        dialogo = new JDialog(frame, titulo, true);                 // Crear un diálogo modal
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Permitir cerrar sin afectar otras ventanas
        dialogo.setLayout(null);                                    // Posicionamiento absoluto

        // Agregar el contenido del mensaje
        etiqueta = new JLabel(mensaje, SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 14));
        etiqueta.setBounds(50, 20, 200, 30);
        dialogo.add(etiqueta);

        // Botón de "Aceptar" para cerrar manualmente
        aceptarButton = new JButton("Aceptar");
        pintarBoton(aceptarButton);
        aceptarButton.setBounds(100, 60, 100, 30);
        aceptarButton.addActionListener(e -> dialogo.dispose());
        dialogo.add(aceptarButton);

        // Configuración visual del diálogo
        dialogo.setSize(300, 150);
        dialogo.setLocationRelativeTo(frame); // Centrar en la ventana principal

        // Temporizador para cerrar el diálogo después de 4 segundos
        timer = new Timer(4000, e -> dialogo.dispose());
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();

        // Mostrar el diálogo
        dialogo.setVisible(true);
    }

    /**
     * Método para validar las credenciales de usuario.
     * Puedes reemplazar esta lógica con la autenticación real según tus necesidades.
     *
     * @param usuario     El nombre de usuario ingresado.
     * @param contrasena  La contraseña ingresada.
     * @return true si las credenciales son válidas, false de lo contrario.
     */
    private boolean isValidCredentials(String usuario, String contrasena) {
        // Ejemplo simple de validación
        return usuario.equals("lol") && contrasena.equals("LOL");
    }

    // Getters para otros componentes si es necesario
    public JFrame getFrame() {
        return this.frame;
    }

    // --------------- Método Principal ---------------
    /**
     * Método principal para ejecutar la ventana de LoginAdmin.
     *//* 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginAdmin());
    } */
}

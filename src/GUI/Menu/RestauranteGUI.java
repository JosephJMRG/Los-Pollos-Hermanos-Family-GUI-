package Menu;

import Menu.Panels.*;
import java.awt.*;
import javax.swing.*;

public class RestauranteGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    // Paneles para cada rol
    private InicioPanel panelInicio;
    private MeseroPanel panelMesero;
    private CajeroPanel panelCajero;
    private AdministradorPanel panelAdministrador;

    // Constructor principal
    public RestauranteGUI() {
        // Crear paneles primero
        crearPaneles();

        // Inicializar la ventana
        inicializarVentana();

        // Hacer visible la ventana al final del constructor
        setVisible(true);
    }

    /**
     * Inicializa las configuraciones de la ventana.
     */
    private void inicializarVentana() {
        setTitle("Sistema de Restaurante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setMinimumSize(new Dimension(1024, 768));

        // Obtener el tamaño del área visible sin la barra de tareas
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle screenBounds = ge.getMaximumWindowBounds();
        Dimension screenSize = new Dimension(screenBounds.width, screenBounds.height);

        // Agregar panel principal al frame
        add(panelPrincipal);

        // Centrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Limitar el tamaño máximo de la ventana para que no exceda el tamaño de la pantalla
        setMaximumSize(screenSize);

        // Iniciar ventana maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Crea todos los paneles necesarios y los añade al panel principal.
     */
    private void crearPaneles() {
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Inicializar paneles específicos
        panelInicio = new InicioPanel(this);
        panelMesero = new MeseroPanel(this);
        panelCajero = new CajeroPanel(this);
        panelAdministrador = new AdministradorPanel(this, this);

        // Añadir paneles al panel principal
        panelPrincipal.add(panelInicio, "Inicio");
        panelPrincipal.add(panelMesero, "Mesero");
        panelPrincipal.add(panelCajero, "Cajero");
        panelPrincipal.add(panelAdministrador, "Administrador");
    }

    /**
     * Solicita una contraseña para el rol especificado.
     *
     * @param rol El rol para el cual se solicita la contraseña.
     * @return true si la contraseña es correcta, false en caso contrario.
     */
    public boolean pedirContrasena(String rol) {
        String contrasena = switch (rol) {
            case "Mesero" -> "123";
            case "Cajero" -> "123";
            case "Administrador" -> "123"; // Definida una contraseña para el administrador
            default -> null;
        };

        if (contrasena != null && !contrasena.isEmpty()) {
            String entrada = JOptionPane.showInputDialog(this, "Introduce la contraseña para " + rol + ":");
            if (entrada == null) { // Manejar caso de cancelación
                return false;
            }
            if (contrasena.equals(entrada)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta para " + rol + ".", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    /**
     * Muestra el panel especificado.
     *
     * @param nombrePanel El nombre del panel a mostrar.
     */
    public void mostrarPanel(String nombrePanel) {
        if (nombrePanel.equals("Administrador")) {
            // Si ya tienes el panel de Administrador en el cardLayout, simplemente lo mostramos.
            cardLayout.show(panelPrincipal, nombrePanel);
        } else {
            // Si no es el panel de Administrador, muestra el panel correspondiente en el CardLayout
            cardLayout.show(panelPrincipal, nombrePanel);
        }
    }
    
}

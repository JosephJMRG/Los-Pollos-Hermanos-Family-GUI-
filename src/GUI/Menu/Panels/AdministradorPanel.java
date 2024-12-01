package Menu.Panels;

import Menu.RestauranteGUI;
import Utilities.PanelConBorde;
import Utilities.PintarBoton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AdministradorPanel extends JPanel {

    // Declaración de paneles y botones
    private JPanel rolesPanel;
    private JPanel administradorActualPanel;
    private JPanel gestionUsuariosPanel;
    private JPanel configuracionPanel;
    private JPanel reportePanel;
    private JPanel ajustesSistemaPanel;

    private JButton botonVolver;
    private JButton botonGestionUsuarios;
    private JButton botonConfigurar;
    private JButton botonReportes;
    private JButton botonAjustes;

    private JFrame ventanaAdministrador; // Referencia a la ventana del administrador

    /**
     * Constructor de la clase AdministradorPanel.
     *
     * Este constructor configura el panel principal y llama a los métodos para
     * crear y añadir los subpaneles necesarios (roles, administración actual, etc.)
     *
     * @param gui Objeto de tipo RestauranteGUI que maneja la interfaz general de la aplicación.
     * @param ventanaAdministrador La ventana del administrador que se va a cerrar.
     */
    public AdministradorPanel(RestauranteGUI gui, JFrame ventanaAdministrador) {
        this.ventanaAdministrador = ventanaAdministrador; // Guardamos la referencia a la ventana

        configurarPanelPrincipal();
        rolesPanel(gui);
        administradorActualPanel();
        gestionUsuariosPanel();
        configuracionPanel();
        reportePanel();
        ajustesSistemaPanel();
        agregarPanelesAlPanelPrincipal();
    }

    /**
     * Configura el layout principal del panel.
     *
     * Este método establece el layout y el fondo para el panel principal, utilizando
     * MigLayout para la distribución de los componentes.
     */
    private void configurarPanelPrincipal() {
        setLayout(new net.miginfocom.swing.MigLayout("insets 5, gap 5", "[30%][40%][30%]", "[80px][grow][grow]"));
        setBackground(java.awt.Color.black);
    }

    /**
     * Configura el panel de roles para el administrador.
     *
     * Este método crea el panel donde se muestra el rol actual (Administrador)
     * y añade el botón "Volver" que permite regresar al panel principal.
     *
     * @param gui Objeto de tipo RestauranteGUI para manejar la navegación entre panels.
     */
    private void rolesPanel(RestauranteGUI gui) {
        // Crear el panel de roles usando el método de PanelConBorde
        rolesPanel = PanelConBorde.crearPanelConBorde("Administrador");

        // Crear el botón "Volver" y asignarle acción
        botonVolver = new JButton("Volver");
        PintarBoton.pintarBoton(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana del Administrador (pero no terminar el programa)
                ventanaAdministrador.dispose();
                // Regresar al panel de Inicio en RestauranteGUI
                gui.mostrarPanel("Inicio");
            }
        });

        // Añadir el botón al rolesPanel
        rolesPanel.add(botonVolver, "wrap, align center");
    }

    /**
     * Configura el panel del administrador actual.
     *
     * Este panel es donde se puede mostrar información relevante sobre el administrador
     * actual, como su nombre o configuraciones asociadas.
     */
    private void administradorActualPanel() {
        // Crear el panel del administrador actual usando el método de PanelConBorde
        administradorActualPanel = PanelConBorde.crearPanelConBorde("Administrador Actual");
    }

    /**
     * Configura el panel de gestión de usuarios.
     *
     * Este panel se utiliza para gestionar los usuarios del sistema, donde se pueden
     * agregar o eliminar usuarios, asignar roles, etc.
     */
    private void gestionUsuariosPanel() {
        // Crear el panel de gestión de usuarios usando el método de PanelConBorde
        gestionUsuariosPanel = PanelConBorde.crearPanelConBorde("Gestión de Usuarios");

        // Crear el botón para gestionar usuarios
        botonGestionUsuarios = new JButton("Gestionar Usuarios");
        PintarBoton.pintarBoton(botonGestionUsuarios);
        botonGestionUsuarios.addActionListener(e -> System.out.println("Gestionando usuarios"));

        // Añadir el botón al panel de gestión de usuarios
        gestionUsuariosPanel.add(botonGestionUsuarios, "wrap, align center");
    }

    /**
     * Configura el panel de configuración del sistema.
     *
     * Este panel proporciona opciones para ajustar configuraciones del sistema
     * y realizar tareas administrativas a nivel de configuración.
     */
    private void configuracionPanel() {
        // Crear el panel de configuración usando el método de PanelConBorde
        configuracionPanel = PanelConBorde.crearPanelConBorde("Configuración");

        // Crear el botón para configurar el sistema
        botonConfigurar = new JButton("Configurar Sistema");
        PintarBoton.pintarBoton(botonConfigurar);
        botonConfigurar.addActionListener(e -> System.out.println("Configurando el sistema"));

        // Añadir el botón al panel de configuración
        configuracionPanel.add(botonConfigurar, "wrap, align center");
    }

    /**
     * Configura el panel de reportes y estadísticas.
     *
     * Este panel permite ver los reportes del sistema, como estadísticas de usuarios,
     * ventas, o cualquier otro tipo de reporte generado.
     */
    private void reportePanel() {
        // Crear el panel de reportes usando el método de PanelConBorde
        reportePanel = PanelConBorde.crearPanelConBorde("Reportes y Estadísticas");

        // Crear el botón para ver reportes
        botonReportes = new JButton("Ver Reportes");
        PintarBoton.pintarBoton(botonReportes);
        botonReportes.addActionListener(e -> System.out.println("Mostrando reportes"));

        // Añadir el botón al panel de reportes
        reportePanel.add(botonReportes, "wrap, align center");
    }

    /**
     * Configura el panel de ajustes del sistema.
     *
     * Este panel permite acceder a los ajustes avanzados del sistema.
     * El administrador puede realizar modificaciones a la configuración del sistema aquí.
     */
    private void ajustesSistemaPanel() {
        // Crear el panel de ajustes usando el método de PanelConBorde
        ajustesSistemaPanel = PanelConBorde.crearPanelConBorde("Ajustes del Sistema");

        // Crear el botón para modificar ajustes
        botonAjustes = new JButton("Ajustes de Sistema");
        PintarBoton.pintarBoton(botonAjustes);
        botonAjustes.addActionListener(e -> System.out.println("Ajustes del sistema"));

        // Añadir el botón al panel de ajustes
        ajustesSistemaPanel.add(botonAjustes, "wrap, align center");
    }

    /**
     * Añade todos los subpaneles al panel principal.
     *
     * Este método organiza y añade todos los paneles secundarios al panel principal
     * usando el layout `MigLayout` para colocar cada uno en su posición correspondiente.
     */
    private void agregarPanelesAlPanelPrincipal() {
        // Añadir los subpaneles al panel principal con sus respectivas posiciones
        add(rolesPanel, "cell 0 0, growx, h 80!");
        add(administradorActualPanel, "cell 2 0, growx, h 80!");

        add(gestionUsuariosPanel, "cell 0 1, grow");
        add(reportePanel, "cell 1 0 1 3, grow");
        add(configuracionPanel, "cell 2 1, grow");

        add(ajustesSistemaPanel, "cell 0 2, grow");
    }
}

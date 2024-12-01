package Menu.Panels;

import Menu.RestauranteGUI;
import Utilities.PanelConBorde;
import Utilities.PintarBoton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class MeseroPanel extends JPanel {

    // Paneles principales
    private JPanel rolesPanel;
    private JPanel meseroActualPanel;
    private JPanel descripcionPlatosPanel;
    private JPanel anotacionesClientePanel;
    private JPanel seleccionPlatosPanel;
    private JPanel boletaPedidoActualPanel;
    private JPanel descuentosPanel;

    // Componentes del Panel de Roles
    private JButton botonVolver;

    // Componentes del Panel de Mesero Actual
    private JComboBox<String> seleccionMeseroActualComboBox;

    // Componentes del Panel de Descripción de Platos
    private JScrollPane descripcionplatosScrollPanel;

    // Componentes del Panel de Anotaciones del Cliente
    private JTextArea preferenciasClienteTextArea;
    private JScrollPane sugerenciasClienteScrollPanel;

    // Componentes del Panel de Selección de Platos
    private JPanel panelBotonesPlatos;
    private JButton platoBoton;
    private JScrollPane platoScrollPanel;

    // Componentes del Panel de Boleta Pedido Actual
    private JTextArea boletaActualTextArea;
    private JScrollPane boletaActualScrollPanel;

    // Componentes del Panel de Descuentos
    private JTextArea descuentosTextArea;
    private JScrollPane descuentosScrollPane;

    /**
     * Constructor de MeseroPanel.
     * Inicializa y configura todos los paneles relacionados con la vista del mesero.
     *
     * @param gui La instancia de RestauranteGUI para la navegación entre paneles.
     */
    public MeseroPanel(RestauranteGUI gui) {
        configurarPanelPrincipal();
        rolesPanel(gui);
        meseroActualPanel();
        descripcionPlatosPanel();
        anotacionesClientePanel();
        seleccionPlatosPanel();
        boletaPedidoActualPanel();
        descuentosPanel();
        agregarPanelesAlPanelPrincipal();
    }

    /**
     * Configura el panel principal con un layout específico.
     */
    private void configurarPanelPrincipal() {
        setLayout(new MigLayout("insets 5, gap 5", "[30%][40%][30%]", "[80px][300px,grow][grow]"));
        setBackground(Color.BLACK);
    }

    /**
     * Configura el panel de roles con un botón "Volver" que regresa a la vista principal.
     *
     * @param gui La instancia de RestauranteGUI para la navegación entre paneles.
     */
    private void rolesPanel(RestauranteGUI gui) {
        rolesPanel = PanelConBorde.crearPanelConBorde("Rol Mesero");

        // Crear el botón "Volver"
        botonVolver = new JButton("Volver");
        PintarBoton.pintarBoton(botonVolver);
        botonVolver.addActionListener(e -> gui.mostrarPanel("Inicio"));

        // Añadir el botón al rolesPanel
        rolesPanel.add(botonVolver, "wrap, align center");
    }

    /**
     * Configura el panel para seleccionar el mesero actual desde un JComboBox.
     */
    private void meseroActualPanel() {
        meseroActualPanel = PanelConBorde.crearPanelConBorde("Mesero Actual");

        seleccionMeseroActualComboBox = new JComboBox<>();
        seleccionMeseroActualComboBox.addItem("mesero 1");
        seleccionMeseroActualComboBox.addItem("mesero 2");
        seleccionMeseroActualComboBox.addItem("mesero 3");

        meseroActualPanel.add(seleccionMeseroActualComboBox, "grow, pushx, pushy");
    }

    /**
     * Configura el panel que muestra las descripciones de los platos disponibles.
     * Se agrega un JScrollPane para permitir el desplazamiento del contenido.
     */
    private void descripcionPlatosPanel() {
        descripcionPlatosPanel = PanelConBorde.crearPanelConBorde("Descripción de Platos");

        JPanel panelDescripcion = new JPanel();
        panelDescripcion.setLayout(new MigLayout("wrap 1", "center", "center"));
        panelDescripcion.setOpaque(false);

        // Esto es un "debug" para el scrollPanel. Será reemplazado con la conexión de la base de datos
        for (int i = 1; i <= 15; i++) {
            JLabel descripcionPlato = new JLabel("Plato " + i + ": Descripción larga del plato con muchos detalles.");
            descripcionPlato.setFont(new Font("Arial", Font.PLAIN, 16));
            descripcionPlato.setForeground(Color.black);
            panelDescripcion.add(descripcionPlato);
        }

        descripcionplatosScrollPanel = new JScrollPane(panelDescripcion);

        descripcionPlatosPanel.add(descripcionplatosScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel para mostrar las anotaciones del cliente, con un JTextArea
     * que permite mostrar las preferencias o anotaciones.
     */
    private void anotacionesClientePanel() {
        anotacionesClientePanel = PanelConBorde.crearPanelConBorde("Anotaciones del Cliente");

        preferenciasClienteTextArea = new JTextArea();
        preferenciasClienteTextArea.setColumns(30);
        preferenciasClienteTextArea.setLineWrap(true);
        preferenciasClienteTextArea.setWrapStyleWord(true);
        preferenciasClienteTextArea.setEditable(false);

        preferenciasClienteTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        preferenciasClienteTextArea.setForeground(Color.BLACK);
        preferenciasClienteTextArea.setBackground(Color.WHITE);

        sugerenciasClienteScrollPanel = new JScrollPane(preferenciasClienteTextArea);
        anotacionesClientePanel.add(sugerenciasClienteScrollPanel, "grow, pushx,pushy");
    }

    /**
     * Configura el panel para la selección de platos, añadiendo botones para cada plato.
     */
    private void seleccionPlatosPanel() {
        seleccionPlatosPanel = PanelConBorde.crearPanelConBorde("Selección de Platos");

        panelBotonesPlatos = new JPanel();
        panelBotonesPlatos.setLayout(new MigLayout("wrap 5", "[grow, fill]"));

        String[] platoBoton = {"Plato 1 - $10.000", "Plato 2 - $12.000", "Plato 3 - $8.500", "Plato 4 - $5.400", "Plato 1 - $10.000", "Plato 2 - $12.000", "Plato 3 - $8.500", "Plato 4 - $5.400", "Plato 1 - $10.000", "Plato 2 - $12.000", "Plato 3 - $8.500", "Plato 4 - $5.400"};

        for (String plato : platoBoton) {
            String platoSaltoDeLinea = plato.replace(" - ", "\n");
            crearBotonPlato(platoSaltoDeLinea, panelBotonesPlatos);
        }

        platoScrollPanel = new JScrollPane(panelBotonesPlatos);
        platoScrollPanel.setPreferredSize(new Dimension(500, 300));

        seleccionPlatosPanel.add(platoScrollPanel, "grow, push");
    }

    /**
     * Configura el panel para mostrar la boleta del pedido actual.
     */
    private void boletaPedidoActualPanel() {
        boletaPedidoActualPanel = PanelConBorde.crearPanelConBorde("Boleta Pedido Actual");

        boletaActualTextArea = new JTextArea();
        boletaActualTextArea.setColumns(30);
        boletaActualTextArea.setLineWrap(true);
        boletaActualTextArea.setWrapStyleWord(true);
        boletaActualTextArea.setEditable(false);

        boletaActualTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        boletaActualTextArea.setForeground(Color.BLACK);
        boletaActualTextArea.setBackground(Color.WHITE);

        boletaActualScrollPanel = new JScrollPane(boletaActualTextArea);
        boletaPedidoActualPanel.add(boletaActualScrollPanel, "grow, pushx,pushy");
    }

    /**
     * Configura el panel que muestra los descuentos aplicados al pedido.
     */
    private void descuentosPanel() {
        descuentosPanel = PanelConBorde.crearPanelConBorde("Detalles Descuentos");

        descuentosTextArea = new JTextArea();
        descuentosTextArea.setColumns(30);
        descuentosTextArea.setLineWrap(true);
        descuentosTextArea.setWrapStyleWord(true);
        descuentosTextArea.setEditable(false);

        descuentosTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descuentosTextArea.setForeground(Color.BLACK);
        descuentosTextArea.setBackground(Color.WHITE);

        descuentosScrollPane = new JScrollPane(descuentosTextArea);
        descuentosPanel.add(descuentosScrollPane, "grow, pushx,pushy");
    }

    /**
     * Crea un botón para representar un plato en el panel de selección de platos.
     *
     * @param platoNombre El nombre del plato que se mostrará en el botón.
     * @param panel El panel donde se añadirá el botón.
     */
    private void crearBotonPlato(String platoNombre, JPanel panel) {
        platoBoton = new JButton("<html>" + platoNombre.replace("\n", "<br>") + "</html>");
        platoBoton.setPreferredSize(new Dimension(200, 150));
        platoBoton.setMinimumSize(new Dimension(100, 75));
        platoBoton.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        platoBoton.addActionListener(e -> System.out.println("Botón presionado: " + platoNombre));

        panel.add(platoBoton, "grow, push, height 150!, width 200!");
    }

    /**
     * Añade todos los paneles al panel principal.
     */
    private void agregarPanelesAlPanelPrincipal() {
        add(rolesPanel, "cell 0 0, growx, h 80!");
        add(meseroActualPanel, "cell 2 0, growx, h 80!");
        add(descripcionPlatosPanel, "cell 0 1, grow");
        add(seleccionPlatosPanel, "cell 1 0 1 3, grow");
        add(boletaPedidoActualPanel, "cell 2 1, grow");
        add(anotacionesClientePanel, "cell 0 2, grow");
        add(descuentosPanel, "cell 2 2, grow");
    }
}

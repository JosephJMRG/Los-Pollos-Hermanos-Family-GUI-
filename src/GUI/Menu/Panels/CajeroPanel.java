package Menu.Panels;

import Menu.RestauranteGUI;
import Utilities.PanelConBorde;
import Utilities.PintarBoton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

public class CajeroPanel extends JPanel {

    // Paneles principales
    private JPanel cajeroPanel;
    private JPanel cajeroActualPanel;
    private JPanel menuPlatosPanel;
    private JPanel personalizacionPedidosPanel;
    private JPanel gestionPedidosPanel;
    private JPanel boletasPanel;
    private JPanel descuentosYPromocionesPanel;

    // Componentes de Cajero Panel
    private JButton botonVolver;

    // Componentes de Cajero Actual Panel
    private JTextArea cajeroActualTextArea;
    private JScrollPane cajeroActualScrollPanel;

    // Componentes de Menú Platos Panel
    private JTextArea menuPlatosTextArea;
    private JScrollPane menuPlatosScrollPanel;

    // Componentes de Personalización Pedidos Panel
    private JTextArea personalizacionTextArea;
    private JScrollPane personalizacionScrollPanel;

    // Componentes de Gestión Pedidos Panel
    private JTextArea gestionPedidosTextArea;
    private JScrollPane gestionPedidosScrollPanel;

    // Componentes de Boletas Panel
    private JTextArea boletasTextArea;
    private JScrollPane boletasScrollPanel;

    // Componentes de Descuentos y Promociones Panel
    private JTextArea descuentosTextArea;
    private JScrollPane descuentosScrollPanel;

    /**
     * Constructor de CajeroPanel.
     * Configura el panel y los subpaneles dentro del panel principal.
     *
     * @param gui La instancia de RestauranteGUI que se usará para la navegación entre paneles.
     */
    public CajeroPanel(RestauranteGUI gui) {
        configurarPanelPrincipal();
        cajeroPanel(gui);
        cajeroActualPanel();
        menuPlatosPanel();
        personalizacionPedidosPanel();
        gestionPedidosPanel();
        boletasPanel();
        descuentosYPromocionesPanel();
        agregarPanelesAlPanelPrincipal();
    }

    /**
     * Configura el layout del panel principal.
     * Se utiliza MigLayout para distribuir los subpaneles.
     */
    private void configurarPanelPrincipal() {
        setLayout(new MigLayout("insets 5, gap 5",
                                "[30%][40%][30%]", //
                                "[80px][300px,grow][grow]"));
        setBackground(Color.BLACK);
    }

    /**
     * Configura el panel de "Rol Cajero" y añade el botón "Volver".
     *
     * @param gui La instancia de RestauranteGUI para navegar a otros paneles.
     */
    private void cajeroPanel(RestauranteGUI gui) {
        cajeroPanel = PanelConBorde.crearPanelConBorde("Rol Cajero"); // Usando la clase PanelConBorde

        // Crear el botón "Volver"
        botonVolver = new JButton("Volver");
        PintarBoton.pintarBoton(botonVolver);
        botonVolver.addActionListener(e -> gui.mostrarPanel("Inicio"));

        // Añadir el botón al cajeroPanel
        cajeroPanel.add(botonVolver, "wrap, align center");
    }

    /**
     * Configura el panel de "Cajero Actual" y añade un área de texto con el nombre del cajero activo.
     */
    private void cajeroActualPanel() {
        cajeroActualPanel = PanelConBorde.crearPanelConBorde("Cajero Actual"); // Usando la clase PanelConBorde

        // Componente de Cajero Actual Panel
        cajeroActualTextArea = new JTextArea("Cajero activo: John Doe");
        cajeroActualTextArea.setEditable(false);
        cajeroActualTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        cajeroActualTextArea.setForeground(Color.BLACK);
        cajeroActualTextArea.setBackground(Color.WHITE);

        cajeroActualScrollPanel = new JScrollPane(cajeroActualTextArea);
        cajeroActualPanel.add(cajeroActualScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel del "Menú de Platos" y añade un área de texto con la lista de platos.
     */
    private void menuPlatosPanel() {
        menuPlatosPanel = PanelConBorde.crearPanelConBorde("Menú de Platos"); // Usando la clase PanelConBorde

        // Componente de Menú Platos Panel
        menuPlatosTextArea = new JTextArea("1. Plato A - $10.000\n2. Plato B - $12.000");
        menuPlatosTextArea.setEditable(false);
        menuPlatosTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        menuPlatosTextArea.setForeground(Color.BLACK);
        menuPlatosTextArea.setBackground(Color.WHITE);

        menuPlatosScrollPanel = new JScrollPane(menuPlatosTextArea);
        menuPlatosPanel.add(menuPlatosScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel de "Personalización de Pedidos" y añade un área de texto para ingresar detalles.
     */
    private void personalizacionPedidosPanel() {
        personalizacionPedidosPanel = PanelConBorde.crearPanelConBorde("Personalización Pedidos"); // Usando la clase PanelConBorde

        // Componente de Personalización Pedidos Panel
        personalizacionTextArea = new JTextArea("Ingrese personalización de pedido...");
        personalizacionTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        personalizacionTextArea.setForeground(Color.BLACK);
        personalizacionTextArea.setBackground(Color.WHITE);

        personalizacionScrollPanel = new JScrollPane(personalizacionTextArea);
        personalizacionPedidosPanel.add(personalizacionScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel de "Gestión de Pedidos" y añade un área de texto con los pedidos.
     */
    private void gestionPedidosPanel() {
        gestionPedidosPanel = PanelConBorde.crearPanelConBorde("Gestión de Pedidos"); // Usando la clase PanelConBorde

        // Componente de Gestión Pedidos Panel
        gestionPedidosTextArea = new JTextArea("Pedido #1: Plato A\nPedido #2: Plato B");
        gestionPedidosTextArea.setEditable(false);
        gestionPedidosTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        gestionPedidosTextArea.setForeground(Color.BLACK);
        gestionPedidosTextArea.setBackground(Color.WHITE);

        gestionPedidosScrollPanel = new JScrollPane(gestionPedidosTextArea);
        gestionPedidosPanel.add(gestionPedidosScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel de "Boletas del Día" y añade un área de texto con las boletas generadas.
     */
    private void boletasPanel() {
        boletasPanel = PanelConBorde.crearPanelConBorde("Boletas del Día"); // Usando la clase PanelConBorde

        // Componente de Boletas Panel
        boletasTextArea = new JTextArea("Boleta 1: $22.000\nBoleta 2: $30.000");
        boletasTextArea.setEditable(false);
        boletasTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        boletasTextArea.setForeground(Color.BLACK);
        boletasTextArea.setBackground(Color.WHITE);

        boletasScrollPanel = new JScrollPane(boletasTextArea);
        boletasPanel.add(boletasScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Configura el panel de "Descuentos y Promociones" y añade un área de texto con las promociones.
     */
    private void descuentosYPromocionesPanel() {
        descuentosYPromocionesPanel = PanelConBorde.crearPanelConBorde("Descuentos y Promociones"); // Usando la clase PanelConBorde

        // Componente de Descuentos y Promociones Panel
        descuentosTextArea = new JTextArea("Descuento del 10% en pedidos mayores a $20.000");
        descuentosTextArea.setEditable(false);
        descuentosTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descuentosTextArea.setForeground(Color.BLACK);
        descuentosTextArea.setBackground(Color.WHITE);

        descuentosScrollPanel = new JScrollPane(descuentosTextArea);
        descuentosYPromocionesPanel.add(descuentosScrollPanel, "grow, pushx, pushy");
    }

    /**
     * Añade todos los subpaneles al panel principal con las restricciones de MigLayout.
     */
    private void agregarPanelesAlPanelPrincipal() {
        add(cajeroPanel, "cell 0 0, growx, h 80!");
        add(cajeroActualPanel, "cell 2 0, growx, h 80!");
        add(menuPlatosPanel, "cell 0 1, grow");
        add(gestionPedidosPanel, "cell 1 0 1 3, grow"); // Span de 3 filas
        add(boletasPanel, "cell 2 1, grow");
        add(personalizacionPedidosPanel, "cell 0 2, grow");
        add(descuentosYPromocionesPanel, "cell 2 2, grow");
    }
}

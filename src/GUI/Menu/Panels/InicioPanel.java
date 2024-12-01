package Menu.Panels;

import Menu.RestauranteGUI;
import Utilities.PanelConBorde; // Importamos la clase PanelConBorde
import Utilities.PintarBoton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class InicioPanel extends JPanel {

    // Componentes del Panel Principal
    private RestauranteGUI gui;
    private JLabel contenido;

    // Componentes del Panel de Roles
    private JPanel contenedorCentral;
    private JPanel panelBotones;

    // Componentes del Panel de Contenido
    private JPanel panelBienvenida;
    private JPanel panelInformacion;
    private JPanel panelEstado;

    // Componentes del Panel de Botones de Roles
    private JButton botonMesero;
    private JButton botonCajero;
    private JButton botonAdministrador;

    // Componentes de Informacion del sistema
    private JLabel info1;
    private JLabel info2;

    // Componentes de Estado del Sistema
    private JLabel estado1;
    private JLabel estado2;

    /**
     * Constructor de InicioPanel.
     * Configura el panel principal con un diseño de MigLayout y agrega los componentes.
     *
     * @param gui La instancia de RestauranteGUI para la navegación entre paneles.
     */
    public InicioPanel(RestauranteGUI gui) {
        this.gui = gui;

        // Configuración de MigLayout para el panel principal
        setLayout(new MigLayout("fill", "[grow]", "[]20[grow]20[grow]"));
        setBackground(Color.BLACK);
        setOpaque(true);

        // Contenedor central con MigLayout
        contenedorCentral = new JPanel(new MigLayout("gap 10px, fill", "[pref!][grow]", "[grow]"));
        contenedorCentral.setOpaque(false); // Transparente para ver fondo

        // Panel de botones de roles
        panelBotones = panelBotonesRoles();
        contenedorCentral.add(panelBotones, "cell 0 0, aligny top");

        // Panel de contenido con borde (Bienvenido al sistema)
        panelBienvenida = PanelConBorde.crearPanelConBorde("Bienvenido");
        panelBienvenida.setLayout(new MigLayout("align center, wrap", "grow", "grow"));
        panelBienvenida.setOpaque(false);

        contenido = new JLabel("Bienvenido al sistema. Selecciona un menú.");
        contenido.setFont(new Font("Arial", Font.PLAIN, 24));
        contenido.setForeground(Color.WHITE);
        contenido.setHorizontalAlignment(JLabel.CENTER);

        panelBienvenida.add(contenido, "align center, grow");
        contenedorCentral.add(panelBienvenida, "cell 1 0, grow");

        // Panel de información general (nuevo)
        panelInformacion = PanelConBorde.crearPanelConBorde("Información General:");
        panelInformacion.setLayout(new MigLayout("fill, insets 10"));
        panelInformacion.setOpaque(false);

        info1 = new JLabel("Estado del Sistema: Operativo");
        info1.setFont(new Font("Arial", Font.PLAIN, 14));
        info1.setForeground(Color.WHITE);
        panelInformacion.add(info1, "span, wrap");

        info2 = new JLabel("Usuarios Conectados: 12");
        info2.setFont(new Font("Arial", Font.PLAIN, 14));
        info2.setForeground(Color.WHITE);
        panelInformacion.add(info2, "span, wrap");

        // Añadir panelInformacion al contenedor principal
        add(panelInformacion, "grow, wrap");

        // Panel de estado del sistema (nuevo)
        panelEstado = PanelConBorde.crearPanelConBorde("Estado del Sistema");
        panelEstado.setLayout(new MigLayout("fill, insets 10"));
        panelEstado.setOpaque(false);

        estado1 = new JLabel("Operación: Estable");
        estado1.setFont(new Font("Arial", Font.PLAIN, 14));
        estado1.setForeground(Color.WHITE);
        panelEstado.add(estado1, "span, wrap");

        estado2 = new JLabel("Última Actualización: 10 minutos atrás");
        estado2.setFont(new Font("Arial", Font.PLAIN, 14));
        estado2.setForeground(Color.WHITE);
        panelEstado.add(estado2, "span, wrap");

        // Añadir panelEstado al contenedor principal
        add(panelEstado, "grow, wrap");

        // Añadir el contenedor central al panel principal
        add(contenedorCentral, "grow");
    }

    /**
     * Crea y configura el panel de botones de roles (Mesero, Cajero, Administrador).
     * Cada botón cambia el contenido y navega a diferentes paneles.
     *
     * @return El panel que contiene los botones de roles.
     */
    private JPanel panelBotonesRoles() {
        // Configuración de MigLayout para el panel de botones con tamaño fijo
        panelBotones = new JPanel(new MigLayout("w 300!, wrap 1", "[grow]", "[][][]20[grow]"));
        panelBotones.setBackground(Color.BLACK);

        // Usamos PanelConBorde para darle borde con título
        panelBotones = PanelConBorde.crearPanelConBorde("Roles");

        // Botón Mesero
        botonMesero = new JButton("Mesero");
        PintarBoton.pintarBoton(botonMesero);
        botonMesero.addActionListener(e -> {
            if (!gui.pedirContrasena("Mesero")) {
                contenido.setText("Bienvenido al sistema. Selecciona un menú.");
                return;
            }
            contenido.setText("Menú de Mesero");
            gui.mostrarPanel("Mesero");
        });
        panelBotones.add(botonMesero, "growx, wrap 10px");

        // Botón Cajero
        botonCajero = new JButton("Cajero");
        PintarBoton.pintarBoton(botonCajero);
        botonCajero.addActionListener(e -> {
            if (!gui.pedirContrasena("Cajero")) {
                contenido.setText("Bienvenido al sistema. Selecciona un menú.");
                return;
            }
            contenido.setText("Menú de Cajero");
            gui.mostrarPanel("Cajero");
        });
        panelBotones.add(botonCajero, "growx, wrap 10px");

        // Botón Administrador
        botonAdministrador = new JButton("Administrador");
        PintarBoton.pintarBoton(botonAdministrador);
        botonAdministrador.addActionListener(e -> { new Login.LoginAdmin(); });
        panelBotones.add(botonAdministrador, "growx");

        return panelBotones;
    }

    /**
     * Obtiene el JLabel que contiene el mensaje de bienvenida o información adicional.
     *
     * @return El JLabel con el contenido del mensaje.
     */
    public JLabel getContenido() {
        return contenido;
    }
}

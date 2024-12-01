package Utilities;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class PanelConBorde {

    /**
     * Crea un panel con un borde personalizado y un título centrado en la parte superior.
     *
     * Este método se utiliza para crear paneles con bordes estilizados y un título centrado,
     * utilizando la fuente y el color especificado.
     *
     * @param titulo El título que se mostrará en el panel.
     * @return Un JPanel con el borde y título configurados.
     */
    public static JPanel crearPanelConBorde(String titulo) {
        // Crear y configurar el panel con borde y título
        JPanel panel = new JPanel(new MigLayout("wrap 1", "center", "center"));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createCompoundBorder(
            // Borde externo: Título con borde alrededor
            BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), // Línea blanca alrededor del panel
                                             titulo,                                      // Texto que se mostrará como título
                                             TitledBorder.CENTER,                         // Centrar el título horizontalmente
                                             TitledBorder.TOP,                            // Posicionar el título en la parte superior
                                             new Font("Arial", Font.BOLD, 16),            // Fuente del título: Arial, negrita, tamaño 16
                                             Color.WHITE                                  // Color del texto del título
                                             ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10))); // Espaciado interno

        return panel;
    }
}

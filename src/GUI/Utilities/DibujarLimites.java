package Utilities;

import java.awt.*;
import javax.swing.*;

/**
 * Utilidad para dibujar bordes alrededor de los componentes de un contenedor
 * y del propio contenedor.
 */
public class DibujarLimites {

    /**
     * Establece bordes visibles alrededor del contenedor y de todos sus componentes.
     * Útil para depuración y reorganización del layout.
     *
     * @param container El contenedor cuyos bordes deben ser dibujados.
     */
    public static void dibujarLimites(Container container) {
        // Aplicar borde al contenedor mismo si es un JComponent
        if (container instanceof JComponent) {
            ((JComponent)container).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }

        // Aplicar borde a cada componente hijo que sea un JComponent
        for (Component comp : container.getComponents()) {
            if (comp instanceof JComponent) {
                ((JComponent)comp).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        // Repaint para actualizar la visualización
        container.repaint();
    }
}

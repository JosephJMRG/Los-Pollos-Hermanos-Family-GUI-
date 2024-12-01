package Utilities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PintarBoton {

    public static void pintarBoton(JButton boton) {
        boton.setBackground(Color.decode("#00509E"));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(true); // Mostrar fondo
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            Color colorOriginal = boton.getBackground();
            Color colorOscuro = colorOriginal.brighter();
            Color textoOriginal = boton.getForeground();
            Color textoPresionado = Color.BLACK;

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
}

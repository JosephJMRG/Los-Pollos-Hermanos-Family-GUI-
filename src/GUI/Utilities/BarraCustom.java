package Utilities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BarraCustom extends JPanel {
    private JFrame frame;
    private int posX = 0, posY = 0;

    public BarraCustom(JFrame frame) {
        this.frame = frame;
        setBackground(Color.decode("#002F6C"));
        setPreferredSize(new Dimension(frame.getWidth(), 25));
        setLayout(new BorderLayout());

        // Panel para el título alineado a la izquierda
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelTitulo.setBackground(Color.decode("#002F6C"));

        JLabel titulo = new JLabel("Login"); // Restaurado el texto del título
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.CENTER);

        // Panel para los botones alineados a la derecha
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelBotones.setBackground(Color.decode("#002F6C"));

        // Botón Minimizar
        JButton botonMinimizar = crearBoton("—");
        botonMinimizar.setToolTipText("Minimizar");
        botonMinimizar.addActionListener(e -> frame.setState(JFrame.ICONIFIED));
        panelBotones.add(botonMinimizar);

        // Botón Cerrar con colores originales
        JButton botonCerrar = crearBotonCerrar();
        panelBotones.add(botonCerrar);

        add(panelBotones, BorderLayout.EAST);

        // Añadir funcionalidad de arrastre
        agregarFuncionArrastre();
    }

    /**
     * Crea un botón personalizado con el texto especificado.
     *
     * @param texto El texto del botón.
     * @return El JButton creado.
     */
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.decode("#002F6C"));
        boton.setBorderPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setPreferredSize(new Dimension(45, 25));
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);

        boton.addMouseListener(new MouseAdapter() {
            Color colorOriginal = boton.getBackground();
            Color colorHover = colorOriginal.brighter();
            Color colorPressed = colorOriginal.darker();

            @Override
            public void mouseEntered(MouseEvent evt) {
                boton.setBackground(colorHover);
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                boton.setBackground(colorOriginal);
                boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                boton.setBackground(colorPressed);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                boton.setBackground(colorHover);
            }
        });

        return boton;
    }

    /**
     * Crea el botón de cerrar con colores personalizados.
     *
     * @return El JButton creado para cerrar la aplicación.
     */
    private JButton crearBotonCerrar() {
        JButton botonCerrar = new JButton("X");
        botonCerrar.setFocusPainted(false);
        botonCerrar.setForeground(Color.WHITE);
        botonCerrar.setBackground(Color.decode("#8B0000")); // Color original
        botonCerrar.setBorderPainted(false);
        botonCerrar.setFont(new Font("Arial", Font.BOLD, 14));
        botonCerrar.setPreferredSize(new Dimension(45, 25));
        botonCerrar.setContentAreaFilled(true);
        botonCerrar.setOpaque(true);

        botonCerrar.addMouseListener(new MouseAdapter() {
            Color colorOriginal = botonCerrar.getBackground();
            Color colorHover = colorOriginal.brighter();
            Color colorPressed = colorOriginal.darker();

            @Override
            public void mouseEntered(MouseEvent evt) {
                botonCerrar.setBackground(colorHover);
                botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                botonCerrar.setBackground(colorOriginal);
                botonCerrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                botonCerrar.setBackground(colorPressed);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                botonCerrar.setBackground(colorHover);
            }
        });

        botonCerrar.addActionListener(e -> System.exit(0));
        return botonCerrar;
    }

    /**
     * Añade la funcionalidad para arrastrar la ventana.
     */
    private void agregarFuncionArrastre() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Opcional: Puedes implementar alguna acción al hacer clic simple o doble
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                frame.setLocation(x - posX, y - posY);
            }
        });
    }
}

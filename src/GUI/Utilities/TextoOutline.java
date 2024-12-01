package Utilities;

import java.awt.*;
import java.awt.Shape;
import java.awt.font.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

/**
 * Clase personalizada que extiende JLabel para dibujar texto con contorno,
 * soportando múltiples líneas separadas por '\n'.
 */
public class TextoOutline extends JLabel {
    private Font font;
    private Color fillColor;
    private Color outlineColor;
    private float strokeWidth;
    private String[] lines;

    /**
     * Constructor de TextoOutline.
     *
     * @param text         El texto a mostrar
     * @param font         La fuente del texto.
     * @param fillColor    El color de relleno del texto.
     * @param outlineColor El color del contorno del texto.
     * @param strokeWidth  Grosor del contorno.
     */
    public TextoOutline(String text, Font font, Color fillColor, Color outlineColor, float strokeWidth) {
        super("");
        this.font = font;
        this.fillColor = fillColor;
        this.outlineColor = outlineColor;
        this.strokeWidth = strokeWidth;
        setOpaque(false); // Fondo transparente

        // Configurar la fuente
        setFont(this.font);

        // Establecer la alineación horizontal y vertical
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.CENTER);

        // Dividir el texto en líneas usando '\n'
        this.lines = text.split("\n");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setFont(font);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        FontRenderContext frc = g2d.getFontRenderContext();
        int lineHeight = g2d.getFontMetrics().getHeight();

        // Calcular la altura total del texto
        int totalTextHeight = lines.length * lineHeight;

        // Calcular el punto de inicio y padding dinámicamente basado en la alineación
        int y = (getHeight() - totalTextHeight) / 2 + g2d.getFontMetrics().getAscent(); // Centrar verticalmente

        for (String line : lines) {
            TextLayout tl = new TextLayout(line, font, frc);
            Rectangle bounds = tl.getPixelBounds(null, 0, 0);
            int textWidth = bounds.width;

            // Determinar el padding izquierdo basado en la alineación horizontal
            int leftPadding;
            switch (getHorizontalAlignment()) {
            case LEFT:
                leftPadding = 0; // Sin padding, alinear a la izquierda
                break;
            case CENTER:
                leftPadding = (getWidth() - textWidth) / 2;
                break;
            case RIGHT:
                leftPadding = getWidth() - textWidth;
                break;
            default:
                leftPadding = 0;
            }

            AffineTransform transform = AffineTransform.getTranslateInstance(leftPadding, y);
            Shape shape = tl.getOutline(transform);

            // Dibujar contorno
            g2d.setColor(outlineColor);
            g2d.setStroke(new BasicStroke(strokeWidth));
            g2d.draw(shape);

            // Rellenar texto
            g2d.setColor(fillColor);
            g2d.fill(shape);

            y += lineHeight;
        }

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        // Retornar el tamaño preferido establecido en el constructor
        return super.getPreferredSize();
    }
}

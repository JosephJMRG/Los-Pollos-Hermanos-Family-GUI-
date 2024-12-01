package Login;

import Utilities.*;
import java.awt.*;
import javax.swing.*;

public class EmpresaPanel extends JPanel {
    private TextoOutline empresaLabel;

    public EmpresaPanel() {
        setOpaque(false); // Para que se vea la imagen de fondo
        setLayout(null);  // Posicionamiento absoluto

        // Crear y añadir el TextoOutline para la empresa
        empresaLabel = crearEmpresaLabel();
        empresaLabel.setBounds(0, 0, 500, 140);
        add(empresaLabel);

        // Visualización de límites (para depuración)
        //DibujarLimites.dibujarLimites(this);
    }

    /**
     * Crea y configura el TextoOutline para mostrar el nombre de la empresa.
     *
     * @return instancia de TextoOutline configurada.
     */
    private TextoOutline crearEmpresaLabel() {
        Font font = new Font("Arial", Font.BOLD, 58);
        Color fillColor = Color.WHITE;
        Color outlineColor = Color.BLACK;
        String texto = "Los Pollos\nHermanos Family";
        TextoOutline label = new TextoOutline(texto, font, fillColor, outlineColor, 2f);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    // Getters y Setters si son necesarios
    public TextoOutline getEmpresaLabel() {
        return empresaLabel;
    }

    public void setEmpresaLabel(TextoOutline empresaLabel) {
        this.empresaLabel = empresaLabel;
    }
}

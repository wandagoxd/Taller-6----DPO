package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel {
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando
     * imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante() {
        // Configura el layout del panel: 3 filas, 1 columna [cite: 112]
        setLayout(new GridLayout(3, 1, 5, 5));

        // Configura la etiqueta para el nombre [cite: 113]
        labNombre = new JLabel("Nombre: ");

        // Configura la etiqueta para la calificación [cite: 114]
        labCalificacion = new JLabel("Calificación: ");

        // Configura el checkbox para indicar si ya se visitó o no [cite: 115]
        chkVisitado = new JCheckBox("Visitado");
        chkVisitado.setEnabled(false); // Se deshabilita para que sea solo de visualización

        // Organiza los elementos en el panel agregándolos en orden vertical
        add(labNombre);
        add(labCalificacion);
        add(chkVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por
     * separado.
     * 
     * @param nombre
     * @param calificacion
     * @param visitado
     */
    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado) {
        // Actualiza el texto del nombre [cite: 113]
        labNombre.setText("Nombre: " + nombre);

        // Busca el ícono correspondiente y lo asigna a la etiqueta de calificación
        // [cite: 114]
        ImageIcon iconoStars = buscarIconoCalificacion(calificacion);
        labCalificacion.setIcon(iconoStars);

        // Actualiza el estado del checkbox de visitado [cite: 115]
        chkVisitado.setSelected(visitado);
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * 
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante(Restaurante r) {
        this.actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que
     * muestra la calificación
     * 
     * @param calificacion La calificación del restaurante, que debe ser un numero
     *                     entre 1 y 5.
     * @return Una imagen a la que corresponde la calificación
     */
    private ImageIcon buscarIconoCalificacion(int calificacion) {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon(imagen);
    }
}
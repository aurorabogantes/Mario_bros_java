package vista;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagenes {

    public static Image cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (IOException excepcion) {
            System.err.println("No se pudo cargar la imagen: " + ruta);
            return null;
        }
    }

    public static Image escalarImagen(Image imagen, int ancho, int alto) {
        if (imagen != null)
            return imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); //imagen con nuevo tamaño
        return null;
    }
}

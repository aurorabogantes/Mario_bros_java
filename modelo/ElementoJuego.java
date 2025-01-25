package modelo;

import java.awt.Image;


public interface ElementoJuego {
    void mover();
    int getPosicionX();
    int getPosicionY();
    int getAncho();
    int getAlto();
    Image getImagen();
}

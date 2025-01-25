package vista;

import modelo.ElementoJuego;
import java.awt.Image;

public class Enemigo implements ElementoJuego {
    private int posicionXInicial;
    private int posicionYInicial;
    private int posicionX;
    private int posicionY;
    private int ancho;
    private int alto;
    private Image imagenNormal;
    private Image imagenAplastado;
    private boolean aplastado;

    public Enemigo(int posicionX, int posicionY, Image imagenNormal, Image imagenAplastado, int ancho, int alto) {
        this.posicionXInicial = posicionX;
        this.posicionYInicial = posicionY;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        this.imagenNormal = imagenNormal;
        this.imagenAplastado = imagenAplastado;
        this.aplastado = false;
    }
    @Override
    public void mover() {
        if (!aplastado)
            posicionX -= 1; // Mueve el Goomba hacia la izquierda
    }

    public void aplastar() {
        aplastado = true;
    }

    public void reiniciar() {
        this.posicionX = posicionXInicial; // Reinicia la posición X al valor inicial
        this.posicionY = posicionYInicial; // Reinicia la posición Y al valor inicial
        this.aplastado = false; // Reinicia el estado de aplastado
    }
    @Override
    public int getPosicionX() {
        return posicionX;
    }
    @Override
    public int getPosicionY() {
        return posicionY;
    }

    @Override
    public int getAncho() {
        return ancho;
    }

    @Override
    public int getAlto() {
        return alto;
    }

    @Override
    public Image getImagen() {
        return aplastado ? imagenAplastado : imagenNormal;
    }

    public boolean estaAplastado() {
        return aplastado;  
    }
}

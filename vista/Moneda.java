package vista;


import modelo.ElementoJuego;
import java.awt.Image;


public class  Moneda implements ElementoJuego {
    private int posicionX;
    private int posicionY;
    private int ancho;
    private int alto;
    private Image imagen;

    public Moneda(int posicionX, int posicionY, Image imagen, int ancho, int alto) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = imagen;
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
        return imagen;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
 
        
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
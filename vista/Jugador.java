package vista;

import vista.Imagenes;
import modelo.ElementoJuego;
import java.awt.Image;

public class Jugador implements ElementoJuego{
    private int posicionX;
    private int posicionY;
    private int ancho;
    private int alto;
    private int velocidadX;
    private int velocidadY;
    private boolean saltando;
    private boolean muerto;
    private int vidas;
    private int monedas;
    private Image imagenNormal;
    private Image imagenMuerto;

    public Jugador(int posicionX, int posicionY, Image imagenNormal, Image imagenMuerto) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = 60;
        this.alto = 60;
        this.imagenNormal = imagenNormal;
        this.imagenMuerto = imagenMuerto;
        this.muerto = false;
        this.saltando = false;
        this.velocidadX = 0;
        this.velocidadY = 0;
        this.vidas = 3;  // Inicializa con 3 vidas
        this.monedas = 0;
    }
    @Override
    public void mover() {
        if (!muerto) {
            posicionX += velocidadX;
            if (saltando) {
                posicionY += velocidadY;
                velocidadY += 1; // Gravedad

                if (posicionY > 450) { // Suelo
                    posicionY = 450;
                    saltando = false;
                    velocidadY = 0;
                }
            }
        }
    }

    public void moverIzquierda() {
        if (!muerto)
            velocidadX = -5;
    }

    public void moverDerecha() {
        if (!muerto)
            velocidadX = 5;
    }

    public void detener() {
        velocidadX = 0;
    }

    public void saltar() {
        if (!muerto && !saltando) {
            saltando = true;
            velocidadY = -15; // Velocidad de salto
        }
    }

    public void morir() {
        if (!muerto) {
            muerto = true;
            imagenNormal = imagenMuerto;
            vidas--;
        }
    }

    public void reiniciarPosicion() {
        this.posicionX = 100;
        this.posicionY = 450;
        this.velocidadX = 0;
        this.velocidadY = 0;
        this.saltando = false;
        this.muerto = false;
        this.imagenNormal = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/mario.png");  // Restaurar la imagen normal
    }

    public void reiniciarVidas() {
        this.vidas = 3;  // Reinicia las vidas a 3
    }

    public void reiniciarMonedas() {
        this.monedas = 0;  // Reinicia el contador de monedas a 0
    }

    public void incrementarMonedas() {
        monedas++;
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
        return imagenNormal;
    }

    public boolean estaMuerto() {
        return muerto;
    }

    public int getMonedas() {
        return monedas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }
}

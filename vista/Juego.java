package vista;

import vista.Imagenes;
import java.awt.Image;

public class Juego {
    private Jugador jugador;
    private Nivel nivelActual;
    private int partidasJugadas;
    private int partidasGanadas;
    private boolean juegoTerminado;
    private boolean juegoGanado;
    private Image imagenMarioNormal;
    private Image imagenMarioMuerto;
    private Image imagenGameOver;
    private Image imagenGanaste;

    public Juego() {
        this.imagenMarioNormal = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/mario.png");
        this.imagenMarioMuerto = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/mariomuerto.png");
        this.imagenGameOver = Imagenes.escalarImagen(Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/gameover.png"), 300, 200);
        this.imagenGanaste = Imagenes.escalarImagen(Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/ganaste.png"), 300, 200);
        this.jugador = new Jugador(100, 450, imagenMarioNormal, imagenMarioMuerto);
        this.nivelActual = new Nivel();
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.juegoTerminado = false;
        this.juegoGanado = false;
    }

    public void iniciarJuego() {
        this.jugador.reiniciarPosicion();
        this.jugador.reiniciarMonedas();  // Reiniciar contador de monedas
        this.jugador.reiniciarVidas();  // Reiniciar las vidas a 3
        this.nivelActual.reiniciarEnemigos();
        this.nivelActual.generarMonedas();  // Regenerar monedas al reiniciar el nivel
        this.juegoTerminado = false;
        this.juegoGanado = false;
    }

    public void incrementarPartidasJugadas() {
        partidasJugadas++;
    }

    public void incrementarPartidasGanadas() {
        partidasGanadas++;
    }

    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    public boolean juegoGanado() {
        return juegoGanado;
    }

    public void setJuegoGanado(boolean juegoGanado) {
        this.juegoGanado = juegoGanado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public Image getGameOverImagen() {
        return imagenGameOver;
    }

    public Image getGanasteImagen() {
        return imagenGanaste;
    }
}

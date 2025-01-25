package controlador;

import vista.Jugador;
import vista.Enemigo;
import vista.Moneda;
import modelo.Nodo;
import vista.VistaJuego;
import vista.Juego;

import javax.swing.Timer;
import javax.swing.JOptionPane;

public class ControladorJuego {
    private Juego juego;
    private VistaJuego vista;
    private Timer temporizador;
    private boolean dialogoMostrado;

    public ControladorJuego(Juego juego, VistaJuego vista) {
        this.juego = juego;
        this.vista = vista;
        this.dialogoMostrado = false;
    }

    public void iniciarNuevaPartida() {
        juego.incrementarPartidasJugadas();  // Incrementar partidas aquí

        juego.setJuegoTerminado(false);
        juego.setJuegoGanado(false);
        juego.getJugador().reiniciarPosicion();
        juego.getJugador().reiniciarMonedas();  // Reiniciar contador de monedas
        juego.getJugador().reiniciarVidas();  // Reiniciar las vidas a 3
        juego.getNivelActual().reiniciarEnemigos();
        juego.getNivelActual().generarMonedas();  // Regenerar monedas
        dialogoMostrado = false;

        iniciarJuego();
    }

    public void iniciarJuego() {
        vista.setFocusable(true);
        vista.requestFocusInWindow();

        temporizador = new Timer(30, evento -> { //actualizar el juego 30 veces por segundo
            juego.getJugador().mover();
            verificarColisiones();
            verificarVictoria();
            juego.getNivelActual().actualizar();
            vista.actualizarPantalla();
        });
        temporizador.start();
    }

    private void verificarColisiones() {
        Jugador jugador = juego.getJugador();

        Nodo nodoEnemigo = juego.getNivelActual().getEnemigos().getElemento();
        boolean colisionDetectada = false;

        while (nodoEnemigo != null) {
            Enemigo enemigo = (Enemigo) nodoEnemigo.getDato();
            if (!enemigo.estaAplastado() && colisionaCon(jugador, enemigo)) {
                if (jugador.getPosicionY() + jugador.getAlto() - 10 < enemigo.getPosicionY()) {
                    enemigo.aplastar();
                    jugador.setVelocidadY(-10);
                } else {
                    if (!colisionDetectada && !dialogoMostrado) {
                        dialogoMostrado = true;
                        jugador.morir();
                        vista.actualizarPantalla();
                        detenerJuegoTemporalmente(); //pausa el juego antes de detener el ciclo
                        detenerCicloDeJuego();
                        mostrarDialogoVida();
                    }
                    return;
                }
            }
            nodoEnemigo = nodoEnemigo.getSiguiente();
        }

        Nodo nodoMoneda = juego.getNivelActual().getMonedas().getElemento();
        Nodo auxiliar = null;

        while (nodoMoneda != null) {
            Moneda moneda = (Moneda) nodoMoneda.getDato();
            if (colisionaCon(jugador, moneda)) {
                jugador.incrementarMonedas();
                if (auxiliar == null)
                    juego.getNivelActual().getMonedas().setElemento(nodoMoneda.getSiguiente());
                else
                    auxiliar.setSiguiente(nodoMoneda.getSiguiente());
            } else
                auxiliar = nodoMoneda;
            nodoMoneda = nodoMoneda.getSiguiente();
        }
    }

    private void detenerCicloDeJuego() {
        if (temporizador != null) {
            temporizador.stop();
        }
    }

    private void detenerJuegoTemporalmente() {
        try {
            Thread.sleep(500); //pausar el juego 0,5 segundos.
        } catch (InterruptedException excepcion) {
            excepcion.printStackTrace();
        }
    }

    private boolean colisionaCon(Jugador jugador, Moneda moneda) {
        return jugador.getPosicionX() < moneda.getPosicionX() + moneda.getAncho() &&
               jugador.getPosicionX() + jugador.getAncho() > moneda.getPosicionX() &&
               jugador.getPosicionY() < moneda.getPosicionY() + moneda.getAlto() &&
               jugador.getPosicionY() + jugador.getAlto() > moneda.getPosicionY();
    }

    private boolean colisionaCon(Jugador jugador, Enemigo enemigo) {
        return jugador.getPosicionX() < enemigo.getPosicionX() + enemigo.getAncho() &&
               jugador.getPosicionX() + jugador.getAncho() > enemigo.getPosicionX() &&
               jugador.getPosicionY() < enemigo.getPosicionY() + enemigo.getAlto() &&
               jugador.getPosicionY() + jugador.getAlto() > enemigo.getPosicionY();
    }

    private void mostrarDialogoVida() {
        Jugador jugador = juego.getJugador();
        if (jugador.getVidas() > 0) {
            JOptionPane.showMessageDialog(null,
                "Te quedan " + jugador.getVidas() + " vidas. Reiniciando el nivel.",
                "Perdiste una vida",
                JOptionPane.INFORMATION_MESSAGE); //mostrar el dialogo/informacion

            reiniciarJuego();
        } else
            mostrarGameOver();
    }

    private void reiniciarJuego() {
        juego.getJugador().reiniciarPosicion();
        juego.getNivelActual().reiniciarEnemigos();
        juego.getNivelActual().generarMonedas();  // Regenerar monedas
        dialogoMostrado = false;
        vista.setFocusable(true);
        vista.requestFocusInWindow();
        iniciarJuego();  // Aquí se reinicia sin incrementar el contador
    }

    private void mostrarGameOver() {
        detenerCicloDeJuego();
        JOptionPane.showMessageDialog(null,
            "Game Over. Has perdido todas tus vidas.",
            "Game Over",
            JOptionPane.INFORMATION_MESSAGE);

        volverAlMenuPrincipal();
    }

    private void verificarVictoria() {
        Jugador jugador = juego.getJugador();
        if (jugador.getPosicionX() > 1000) {
            if (!juego.juegoGanado()) {
                juego.setJuegoGanado(true);
                detenerCicloDeJuego();
                JOptionPane.showMessageDialog(null,
                    "¡Felicidades! Has ganado la partida.",
                    "Victoria",
                    JOptionPane.INFORMATION_MESSAGE);

                juego.incrementarPartidasGanadas();
                volverAlMenuPrincipal();
            }
        }
    }

    private void volverAlMenuPrincipal() {
        vista.mostrarMenu();
    }
}

package controlador;

import modelo.ListaEnlazada;
import modelo.ElementoJuego;
import modelo.Nodo;

public class Ordenador {
    public static void ordenarPorPosicionX(ListaEnlazada elementos) {
        boolean huboIntercambio;
        do {
            Nodo actual = elementos.getElemento();
            huboIntercambio = false;
            while (actual != null && actual.getSiguiente() != null) {
                ElementoJuego elementoActual = actual.getDato();
                ElementoJuego siguienteElemento = actual.getSiguiente().getDato();
                if (elementoActual.getPosicionX() > siguienteElemento.getPosicionX()) {
                    // Intercambiar los elementos
                    ElementoJuego temporal = actual.getDato();
                    actual.setDato(siguienteElemento);
                    actual.getSiguiente().setDato(temporal);
                    huboIntercambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (huboIntercambio);
    }
}

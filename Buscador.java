package controlador;

import modelo.ListaEnlazada;
import modelo.ElementoJuego;
import modelo.Nodo;

public class Buscador {
    public static ElementoJuego buscarPorPosicion(ListaEnlazada elementos, int posicionX, int posicionY) {
        Nodo actual = elementos.getElemento();
        while (actual != null) {
            ElementoJuego elemento = actual.getDato();
            if (elemento.getPosicionX() == posicionX && elemento.getPosicionY() == posicionY)
                return elemento; // Se encontró el elemento
            actual = actual.getSiguiente();
        }
        return null; // No se encontró el elemento
    }
}

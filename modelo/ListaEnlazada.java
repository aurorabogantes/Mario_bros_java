package modelo;

import modelo.Nodo;

public class ListaEnlazada {
    private Nodo elemento;

    public ListaEnlazada() {
        this.elemento = null;
    }

    public Nodo getElemento() {
        return elemento;
    }

    public void setElemento(Nodo elemento) {
        this.elemento = elemento;
    }

    public void agregar(ElementoJuego dato) {
        if (elemento == null)
            elemento = new Nodo(dato);
        else {
            Nodo actual = elemento;
            while (actual.getSiguiente() != null)
                actual = actual.getSiguiente();
            actual.setSiguiente(new Nodo(dato));
        }
    }

    public void eliminar(ElementoJuego dato) {
        if (elemento == null) 
            return;

        if (elemento.getDato().equals(dato)) {
            elemento = elemento.getSiguiente();
            return;
        }

        Nodo actual = elemento;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(dato)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
            actual = actual.getSiguiente();
        }
    }
}

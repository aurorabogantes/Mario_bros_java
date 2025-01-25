package modelo;

public class Nodo {
    private ElementoJuego dato;
    private Nodo siguiente;

    public Nodo(ElementoJuego dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public ElementoJuego getDato() {
        return dato;
    }

    public void setDato(ElementoJuego dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

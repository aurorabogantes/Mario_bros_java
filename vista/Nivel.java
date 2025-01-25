package vista;

import vista.Moneda;
import vista.Imagenes;
import vista.Enemigo;
import modelo.ListaEnlazada;
import java.awt.Image;
import modelo.Nodo;

public class Nivel {
    private ListaEnlazada enemigos;
    private ListaEnlazada monedas;

    public Nivel() {
        this.enemigos = new ListaEnlazada();
        this.monedas = new ListaEnlazada();
        generarEnemigos();
        generarMonedas();
    }

    public void generarEnemigos() {
        Image imagenGoomba = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/goomba.png");
        Image imagenGoombaAplastado = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/goomba_aplastado.png");

        int posicionXGoomba = 400; // Posición X del Goomba
        int posicionYGoomba = 450; // Posición Y del Goomba

        Enemigo goomba = new Enemigo(posicionXGoomba, posicionYGoomba, imagenGoomba, imagenGoombaAplastado, 60, 60);
        agregarEnemigo(goomba);
    }

    public void generarMonedas() {
        Image imagenMoneda = Imagenes.cargarImagen("C:/Users/auror/OneDrive/Documentos/NetBeansProjects/MarioBros/src/resources/moneda.png");
        this.monedas = new ListaEnlazada();  // Reiniciar la lista de monedas cada vez

        for (int i = 0; i < 5; i++) {
            int posicionXMoneda = 600 + i * 100; // Posición X de la moneda, después del Goomba
            int posicionYMoneda = 420; // Posición Y de la moneda

            Moneda moneda = new Moneda(posicionXMoneda, posicionYMoneda, imagenMoneda, 20, 20);
            monedas.agregar(moneda);
        }
    }

    public ListaEnlazada getEnemigos() {
        return enemigos;
    }

    public ListaEnlazada getMonedas() {
        return monedas;
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.agregar(enemigo);
    }

    public void reiniciarEnemigos() {
        Nodo nodoEnemigo = enemigos.getElemento();
        while (nodoEnemigo != null) {
            Enemigo enemigo = (Enemigo) nodoEnemigo.getDato();
            enemigo.reiniciar(); // Reinicia la posición y estado de cada enemigo
            nodoEnemigo = nodoEnemigo.getSiguiente();
        }
    }

    public void actualizar() {
        Nodo nodoEnemigo = enemigos.getElemento();
        while (nodoEnemigo != null) {
            Enemigo enemigo = (Enemigo) nodoEnemigo.getDato(); 
            enemigo.mover();
            nodoEnemigo = nodoEnemigo.getSiguiente();
        }

        Nodo nodoMoneda = monedas.getElemento();
        while (nodoMoneda != null) {
            Moneda moneda = (Moneda) nodoMoneda.getDato();
            nodoMoneda = nodoMoneda.getSiguiente();
        }
    }
}

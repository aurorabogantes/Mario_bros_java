package controlador;

import modelo.Nodo;

public class ContadorRecursivo {
    public static int contarElementos(Nodo nodo) {
        if (nodo == null) 
            return 0;
        return 1 + contarElementos(nodo.getSiguiente());
    }
}

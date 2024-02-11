package Extras4_Parcial;

import Class.ArbolBinario;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class Parcial {

    public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min) {
        ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
        if (!ab.esVacio()) {
            //resolver(ab, min, camino);
            resolver2(ab, min, camino);
        }
        return camino;
    }

    //PREORDEN
    private boolean resolver(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> camino) {
        boolean ok = false;
        camino.agregarFinal(ab.getDato());
        if (ab.getDato() % 2 == 0) {
            min--;
        }
        if (!ab.esHoja()) {
            if ((ab.tieneHijoIzquierdo()) && (!ok)) {
                ok = resolver(ab.getHijoIzquierdo(), min, camino);
                if (!ok) {
                    camino.eliminarEn(camino.tamanio());
                }
            }
            if ((ab.tieneHijoDerecho()) && (!ok)) {
                ok = resolver(ab.getHijoDerecho(), min, camino);
                if (!ok) {
                    camino.eliminarEn(camino.tamanio());
                }
            }
        } else {
            if (min <= 0) {
                ok = true;
            }
        }
        return ok;
    }

    //POSORDEN
    private boolean resolver2 (ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> camino) {
        boolean ok = false;
        if (ab.getDato() % 2 == 0) {
            min--;
        }
        if (!ab.esHoja()) {
            if ((ab.tieneHijoIzquierdo()) && (!ok)) {
                ok = resolver2(ab.getHijoIzquierdo(), min, camino);
            }
            if ((ab.tieneHijoDerecho()) && (!ok)) {
                ok = resolver2(ab.getHijoDerecho(), min, camino);
            }
            if (ok) {
                camino.agregarInicio(ab.getDato());
            }
        } else {
            if (min <= 0) {
                ok = true;
                camino.agregarInicio(ab.getDato());
            }
        }
        return ok;
    }  /**
     *                       1
     *                   2       3
     *                13   5    6
     *                    9 16  
     */     
}

package Caminos.RamaMasLejana;

import Class.ArbolBinario;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class HojaMasLejanaBin {

    public ListaGenerica<Integer> hojaMasLejana(ArbolBinario<Integer> a) {
        ListaGenerica<Integer> camFinal = new ListaEnlazadaGenerica<>();
        if (!a.esVacio()) {
            ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
            resolver(a, camAct, camFinal);
        }
        return camFinal;
    }

    //PREORDEN
    private void resolver(ArbolBinario<Integer> a, ListaGenerica<Integer> camAct, ListaGenerica<Integer> camFinal) {
        
        camAct.agregarFinal(a.getDato());

        if (!a.esHoja()) {
            if (a.tieneHijoIzquierdo()) {
                resolver(a.getHijoIzquierdo(), camAct, camFinal);
                //camAct.eliminarEn(camAct.tamanio());
            }
            if (a.tieneHijoDerecho()) {
                resolver(a.getHijoDerecho(), camAct, camFinal);
                //camAct.eliminarEn(camAct.tamanio());
            }
        } else {
            if (camAct.tamanio() > camFinal.tamanio()) {
                camFinal.comenzar();
                while (!camFinal.fin()) {
                    camFinal.eliminar(camFinal.proximo());
                }
                camAct.comenzar();
                while (!camAct.fin()) {
                    camFinal.agregarFinal(camAct.proximo());
                }
            }
        }
        camAct.eliminarEn(camAct.tamanio());
    }
}

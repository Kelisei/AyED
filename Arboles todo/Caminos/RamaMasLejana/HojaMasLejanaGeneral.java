package Caminos.RamaMasLejana;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class HojaMasLejanaGeneral {

    public ListaGenerica<Integer> resolver(ArbolGeneral<Integer> arbol) {
        ListaGenerica<Integer> camino = new ListaEnlazadaGenerica();
        if (!arbol.esVacio()) {
            ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica();
            resolver(arbol, camAct, camino);
        }
        return camino;
    }
    //PREORDEN
    private void resolver(ArbolGeneral<Integer> a, ListaGenerica<Integer>camAct, ListaGenerica<Integer> camFin) {
        camAct.agregarFinal(a.getDato());
        if (!a.esHoja()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            while (!h.fin()){
                resolver(h.proximo(),camAct, camFin);
                //camAct.eliminarEn(camAct.tamanio());
            }
        } else {
            if (camAct.tamanio()>camFin.tamanio()) {
                camFin.comenzar();
                while (!camFin.fin()) {
                    camFin.eliminar(camFin.proximo());
                }
                camAct.comenzar();
                while (!camAct.fin()) {
                    camFin.agregarFinal(camAct.proximo());
                }
            }
        }
        camAct.eliminarEn(camAct.tamanio());
    }
}

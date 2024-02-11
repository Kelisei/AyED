package Caminos.PesoCaminoMasLejano;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class PesoCaminoMasLejanoGeneral {
    
    public ListaGenerica<Integer> resolver(ArbolGeneral<Integer> arbol) {
        ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
        if (!arbol.esVacio()) {
            ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
            resolver(arbol,camino,camAct, 0,-9999 );
        }
        return camino;
    }
    
    private int resolver(ArbolGeneral<Integer> a,ListaGenerica<Integer> camFin,ListaGenerica<Integer> camAct, int suma, int max) {
        camAct.agregarFinal(a.getDato());
        suma += a.getDato();
        if (!a.esHoja()){
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            while (!h.fin()) {
                max = resolver(h.proximo(), camFin, camAct, suma, max);
            }
        } else {
            if ((camAct.tamanio()>camFin.tamanio())||(camAct.tamanio()==camFin.tamanio())&&(suma>max)) {
                camFin.comenzar();
                max=suma;
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
        return max;
    }
}

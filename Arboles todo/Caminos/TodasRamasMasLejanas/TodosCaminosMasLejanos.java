package Caminos.TodasRamasMasLejanas;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class TodosCaminosMasLejanos {

    public ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> arbol) {
        ListaGenerica<ListaGenerica<Integer>> caminos = new ListaEnlazadaGenerica();
        if (!arbol.esVacio()) {
            int hMax = arbol.altura();
            System.out.println("altura max" + hMax);
            caminos = resolver(arbol, 0, hMax);
        }
        return caminos;
    }

    private ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> a, int nivel, int hMax) {
        ListaGenerica<ListaGenerica<Integer>> caminos = new ListaEnlazadaGenerica<>();
        if (!a.esHoja()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            while (!h.fin()) {
                ListaGenerica<ListaGenerica<Integer>> aux = resolver(h.proximo(),nivel+1,hMax);
                aux.comenzar();
                while (!aux.fin()) {
                    caminos.agregarInicio(aux.proximo());
                }
            }
            caminos.comenzar();
            while (!caminos.fin()) {
                caminos.proximo().agregarInicio(a.getDato());
            }
        } else if (nivel == hMax) {
            ListaGenerica<Integer> camino = new ListaEnlazadaGenerica<>();
            camino.agregarInicio(a.getDato());
            caminos.agregarInicio(camino);
        }
        return caminos;
    }
}
/*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22 - 200
                15 -26 - 224 - 287      |     |
                                      (-69)  269
 */

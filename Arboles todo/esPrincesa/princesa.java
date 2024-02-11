/* Dado un árbol general compuesto por personajes,
donde puede haber dragones, princesas y otros, se
denominan nodos accesibles a aquellos nodos tales
que a lo largo del camino del nodo raíz del árbol
hasta el nodo (ambos inclusive) no se encuentra
ningún dragón.
Implementar un método que devuelva una lista con un camino desde la raíz a una
Princesa sin pasar por un Dragón –sin necesidad de ser el más cercano a la raíz-.
Asuma que existe al menos un camino accesible.
 */
package esPrincesa;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class princesa {

    public ListaGenerica<String> esPrincesa(ArbolGeneral<String> a) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
        if (!a.esVacio()) {
            esPrincesa(a,camino);
        }
        return camino;
    }

    //PREORDEN
    private boolean esPrincesa(ArbolGeneral<String> a, ListaGenerica<String> camAct) {
        boolean cumple = false;

        if (!a.getDato().equals("dragon")) {
            camAct.agregarFinal(a.getDato());
            if (a.getDato().equals("princesa")) {
                cumple = true;
            }
            if ((!a.esHoja()) && (!cumple)) {
                ListaGenerica<ArbolGeneral<String>> h = a.getHijos();
                h.comenzar();
                while ((!h.fin()) && (!cumple)) {
                    cumple = esPrincesa(h.proximo(), camAct);
                }
            }
            if (!cumple) {
                camAct.eliminarEn(camAct.tamanio());
            }
        }
        return cumple;
    }
}

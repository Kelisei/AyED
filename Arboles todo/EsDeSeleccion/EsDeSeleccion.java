package EsDeSeleccion;

import Class.ArbolGeneral;
import Class.ColaGenerica;
import Class.ListaGenerica;

public class EsDeSeleccion {

    public boolean esDeSeleccion(ArbolGeneral<Integer> arbol) {
        boolean ok = true;
        ArbolGeneral<Integer> valorHijo;
        Integer min;
        if (!arbol.esVacio()) {
            ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
            ArbolGeneral<Integer> aux;
            cola.encolar(arbol);
            while ((!cola.esVacia()) && (ok)) {
                aux = cola.desencolar();
                if (aux.tieneHijos()) {
                    min = Integer.MAX_VALUE;
                    ListaGenerica<ArbolGeneral<Integer>> h = aux.getHijos();
                    h.comenzar();
                    while ((!h.fin()) && (ok)) {
                        valorHijo = h.proximo();
                        if (aux.getDato() > valorHijo.getDato()) {
                            ok = false;
                        } else {
                            cola.encolar(valorHijo);
                            min = Math.min(valorHijo.getDato(), min);
                        }
                    }
                    if (!aux.getDato().equals(min)) {
                        ok = false;
                    }
                }
            }
        } else {
            ok = false;
        }
        return ok;
    }
}

/**
 * Se recibe una lista de caracteres que forma una palabra, por ejm. [c, a, s, a] y un arbol que contiene letras,
 * se debe retornar true si es que existe un camino en el arbol que forme la palabra recibida
 */
package BuscarSiExisteConListaString;

import Class.ArbolGeneral;
import Class.ListaGenerica;

public class Existe {

    public boolean resolver(ArbolGeneral<Character> a, ListaGenerica<Character> secuencia) {
        boolean cumple = false;
        if (!a.esVacio()) {
            cumple = resolver2(a, secuencia, 1);
        }
        return cumple;
    }

    private boolean resolver2(ArbolGeneral<Character> a, ListaGenerica<Character> secuencia, int indice) {
        boolean cumple = false;
        if (indice <= secuencia.tamanio()) { //cambiamos el >=
            Character car = secuencia.elemento(indice);
            if (car.equals(a.getDato())) {
                if (secuencia.tamanio() == indice) {
                    cumple = true;
                } else if ((!a.esHoja()) && (!cumple)) {
                    ListaGenerica<ArbolGeneral<Character>> h = a.getHijos();
                    h.comenzar();
                    while ((!h.fin()) && (!cumple)) {
                        cumple = resolver2(h.proximo(), secuencia, indice+1);
                    }
                }
            }
        }
        return cumple;
    }
}

/** Ejercicio
 * Implemente en la clase Parcial un método que reciba un árbol general de enteros y retorne una lista con
 * los valores que se encuentran en un rango de valores recibido por parámetro. Para cada valor, retornar el
 * nivel en el que se encuentra.
 * El rango de valores es cerrado, por lo cual, si el elemento del árbol es igual a uno de los extremos,
 * también se lo debe incluir en el resultado. Considerar que el árbol podría estar vacío, que ningún
 * elemento del árbol o todos los elementos del árbol podrían cumplir la condición. Realice un recorrido
 * en postorden.
 * El método debe tener la siguiente firma, por lo cual, siempre debe retornar una lista, ya sea que haya o
 * no elementos para retornar.
 * resolver(int menor, int mayor, ArbolGeneral<Integer> arbol) Para el siguiente
 * árbol, si los valores son 5 y 10, la lista debería contener los elementos 6
 * nivel 2, 5 nivel 1, 10 nivel 2. (En postorden). Para el siguiente árbol, si
 * valor es 20 y 100, la lista debería ser vacía. Para el siguiente árbol, si
 * valor es -9 y 20, la lista debería contener todos los elementos del árbol: 2
 * nivel 2, -7 nivel 1, 6 nivel 2, -2 nivel 0, -3 nivel 2, 5 nivel 1, 11 nivel
 * 2, 4 nivel 1, -9 nivel 2, 10 nivel 2. (En postorden).
 */
package Ejercicio7;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class Parcial {

    public ListaGenerica<Datos> resolver(int menor, int mayor, ArbolGeneral<Integer> arbol) {
        ListaGenerica<Datos> res = new ListaEnlazadaGenerica<>();
        if (!arbol.esVacio()) {
            resolver(menor, mayor, arbol, 0, res);
        }
        return res;
    }

    public class Datos {

        private Integer dato;
        private Integer nivel;

        public Datos(Integer d, int nivel) {
            this.dato = d;
            this.nivel = nivel;
        }

        public Integer getDato() {
            return dato;
        }

        public Integer getNivel() {
            return nivel;
        }

        @Override
        public String toString() {
            return "Datos: " + dato + ", en el nivel: " + nivel;
        }
    }

    //(En postorden)
    private void resolver(int min, int max, ArbolGeneral<Integer> a, int nivel, ListaGenerica<Datos> lista) {
        if (!a.esHoja()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            while (!h.fin()) {
                resolver(min, max, h.proximo(), nivel + 1, lista);
            }
            if ((a.getDato() >= min) && (a.getDato() <= max)) {
                Datos d = new Datos(a.getDato(), nivel);
                lista.agregarFinal(d);
            }
        } else {
            if ((a.getDato() >= min) && (a.getDato() <= max)) {
                Datos d = new Datos(a.getDato(), nivel);
                lista.agregarFinal(d);
            }
        }
    }
}

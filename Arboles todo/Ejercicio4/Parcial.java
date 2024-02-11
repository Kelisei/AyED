package Ejercicio4;

import Class.ArbolGeneral;
import Class.ListaGenerica;

public class Parcial {

    public Integer resolver(ArbolGeneral<Integer> arbol) { //recorrido INORDEN
        Integer nodos = null;
        if (!arbol.esVacio()) {
            Datos datos = new Datos();
            resolver(arbol, datos);
            nodos = datos.calculo();
        }
        return nodos;
    }

    private class Datos {

        private int positivos = 0;
        private int negativos = 0;

        public int getPositivos() {
            return positivos;
        }

        public int getNegativos() {
            return negativos;
        }

        public void setPositivos() {
            this.positivos++;
        }

        public void setNegativos() {
            this.negativos++;
        }

        public int calculo() {
            if ((getPositivos() + getNegativos()) % 2 == 0) {
                return getPositivos();
            } else {
                return getNegativos();
            }
        }
    }

    public void resolver(ArbolGeneral<Integer> a, Datos datos) { //recorrido INORDEN        Integer nodos = null;
        if (!a.esHoja()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            resolver(h.proximo(), datos);
            if (a.getDato() % 2 == 0) {
                datos.setPositivos();
            } else {
                datos.setNegativos();
            }
            while (!h.fin()) {
                resolver(h.proximo(), datos);
            }
        } else {
            if (a.getDato() % 2 == 0) {
                datos.setPositivos();
            } else {
                datos.setNegativos();
            }
        }
    }
}

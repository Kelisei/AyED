package Class;

public class RecorridosAG {

//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.  
    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica();
        if (!a.esVacio()) {
            imparPreOrden(a, n, l);
        }
        return l;
    }

    private void imparPreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
        if ((a.getDato() % 2 == 1) && (a.getDato() > n)) {
            l.agregarFinal(a.getDato());
        }
        ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            imparPreOrden(hijos.proximo(), n, l);
        }
    }

//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido en inorden.
    public ListaGenerica< Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica();
        if (!a.esVacio()) {
            imparInOrden(a, n, l);
        }
        return l;
    }

    private void imparInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica l) {
        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            imparInOrden(hijos.proximo(), n, l);
            if ((a.getDato() % 2 == 1) && (a.getDato() > n)) {
                l.agregarFinal(a.getDato());
            }
            while (!hijos.fin()) {
                imparPreOrden(hijos.proximo(), n, l);
            }
        } else {
            if ((a.getDato() % 2 == 1) && (a.getDato() > n)) {
                l.agregarFinal(a.getDato());
            }
        }
    }

//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros recorrido en postorden.
    public ListaGenerica< Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        if (!a.esVacio()) {
            imparPosOrden(a, n, l);
        }
        return l;
    }

    private void imparPosOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica l) {
        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                imparPosOrden(hijos.proximo(), n, l);
            }
        }
        if ((a.getDato() % 2 == 1) && (a.getDato() > n)) {
            l.agregarFinal(a.getDato());
        }
    }

//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” pasados como parámetros, recorrido por niveles.
    public ListaGenerica< Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> l = new ListaEnlazadaGenerica<>();
        if (!a.esVacio()) {
            porNiveles(a, n, l);
    
        }
        return l;
    }

    private void porNiveles(ArbolGeneral<Integer> arbol, Integer n, ListaGenerica l) {
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        ArbolGeneral<Integer> aux;
        cola.encolar(arbol);
        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if ((aux.getDato() % 2 == 1) && (aux.getDato() > n)) {
                l.agregarFinal(aux.getDato());
            }
            if (aux.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                }
            }
        }
    }

    
//    private void porNivelesNull(ArbolGeneral<Integer> arbol, Integer n, ListaGenerica l) {
//        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
//        ArbolGeneral<Integer> aux;
//        cola.encolar(arbol);
//        cola.encolar(null);
//        while (!cola.esVacia()) {
//            aux = cola.desencolar();
//            if (aux != null) {
//                if ((aux.getDato() % 2 == 1) && (aux.getDato() > n)) {
//                    l.agregarFinal(aux.getDato());
//                    System.out.println(aux.getDato());
//                }
//                if (aux.tieneHijos()) {
//                    ListaGenerica<ArbolGeneral<Integer>> hijos = aux.getHijos();
//                    hijos.comenzar();
//                    while (!hijos.fin()) {
//                        cola.encolar(hijos.proximo());
//                    }
//                }
//            } else if(!cola.esVacia()){
//                cola.encolar(null);
//                System.out.println("fin lvl");
//            }
//        }
//    }
}

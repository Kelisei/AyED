package Class;

public class ArbolGeneral<T> {

    private T dato;
    private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
        if (hijos == null) {
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
        } else {
            this.hijos = hijos;
        }
    }

    public ArbolGeneral() {  //CREO ESTE CONSTRUCTOR PARA PODER REALIZAR ARBOLES VACIOS EJ6
    }
    public ArbolGeneral(T dato) {
        this.dato = dato;
    }

    public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
        this(dato);
        if (hijos == null) {
            this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
        } else {
            this.hijos = hijos;
        }
    }

    public ListaGenerica<ArbolGeneral<T>> getHijos() {
        return this.hijos;
    }

    public void agregarHijo(ArbolGeneral<T> unHijo) {

        this.getHijos().agregarFinal(unHijo);
    }

    public boolean esHoja() {

        return !this.tieneHijos();
    }

    public boolean tieneHijos() {
        return !this.hijos.esVacia();
    }

    public boolean esVacio() {

        return this.dato == null && !this.tieneHijos();
    }

    public void eliminarHijo(ArbolGeneral<T> hijo) {
        if (this.tieneHijos()) {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            if (hijos.incluye(hijo)) {
                hijos.eliminar(hijo);
            }
        }
    }

    /**
     * RECORRDIDOS DEL ARBOL (SOLO IMPRESION DE NODOS);
     */
    public void preOrden() {   // R I D
        if (!this.esVacio()) {
            System.out.print(" " + this.getDato());
            if (this.tieneHijos()) {
                ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    hijos.proximo().preOrden();
                }
            }
        } else {
            System.out.println("**Arbol Vacio**");
        }
    }

    public void inOrden() {
        if (!this.esVacio()) {
            if (this.tieneHijos()) {
                ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
                hijos.comenzar();
                hijos.proximo().inOrden();
            }
            System.out.print(" " + this.getDato());
            if (this.tieneHijos()) {
                while (!hijos.fin()) {
                    hijos.proximo().inOrden();
                }
            }
        } else {
            System.out.println("**Arbol Vacio**");
        }
    }

    public void posOrden() {
        if (!this.esVacio()) {
            if (this.tieneHijos()) {
                ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    hijos.proximo().posOrden();
                }
            }
            System.out.print(" " + this.getDato());
        } else {
            System.out.println("**Arbol Vacio**");
        }
    }

    public void porNiveles() {
        if (!this.esVacio()) {
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
            ArbolGeneral<T> aux;
            cola.encolar(this);
            cola.encolar(null);
            System.out.println("*******************");
            while (!cola.esVacia()) {
                aux = cola.desencolar();
                if (aux!=null) {
                    System.out.print(" "+aux.getDato());
                    if (aux.tieneHijos()) {
                        ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
                        hijos.comenzar();
                        while (!hijos.fin()) {
                            cola.encolar(hijos.proximo());
                        }
                    }
                } else if (!cola.esVacia()) {
                    System.out.println("");   
                    System.out.println("*******************");
                    cola.encolar(null);
                }
            }
        }
    }

    /**
     * EJERCIO 4 IMPLEMENTE LOS SIG MODULOS
     */
//a) public int altura(): int devuelve la altura del árbol, es decir, 
//     la longitud del camino más largo desde el nodo raíz hasta una hoja.
    public int altura() {
        if (this.esHoja()) {
            return 0;
        } else {
            int max = -9999;
            ListaGenerica<ArbolGeneral<T>> h = this.getHijos();
            h.comenzar();
            while (!h.fin()) {
                max = Math.max(h.proximo().altura(), max);
            }
            return 1 + max;
        }
    }

//b) public int nivel(T dato) devuelve la profundidad o nivel del dato en el árbol.
//     El nivel de un nodo es la longitud del único camino de la raíz al nodo.
    public int nivel(T dato) {
        int nivel = 0;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
        ArbolGeneral<T> aux;
        cola.encolar(this);
        cola.encolar(null);
        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                if (aux.getDato() == dato) {
                    return nivel;
                } else if (aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                nivel++;
                cola.encolar(null);
            }
        }
        return -1;
    }
//c) public int ancho(): int la amplitud (ancho) de un árbol se define como la cantidad
//     de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.

    public int ancho() {
        int max = -999;
        if (!this.esVacio()) {
            int cont = 0;
            ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
            ArbolGeneral<T> aux;
            cola.encolar(this);
            cola.encolar(null);
            while (!cola.esVacia()) {
                aux = cola.desencolar();
                if (aux != null) {
                    cont++;
                    if (aux.tieneHijos()) {
                        ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
                        hijos.comenzar();
                        while (!hijos.fin()) {
                            cola.encolar(hijos.proximo());
                        }
                    }
                } else {
                    max = Math.max(max, cont);
                    if (!cola.esVacia()) {
                        cont = 0;
                        cola.encolar(null);
                    }
                }
            }
        }
        return max;
    }
///////////////////////////////////////////////////////////////////////////////////
    public Boolean esAncestro(T a, T b) {
        ArbolGeneral<T> ancestro = new ArbolGeneral<>();
        if (!this.esVacio()) {
            ancestro = buscarNodo(this, a);
            if (!ancestro.esVacio()) {
                ancestro = buscarNodo(ancestro, b);
            }
        }
        return !ancestro.esVacio();
    }
    
    private ArbolGeneral<T> buscarNodo(ArbolGeneral<T> arbol, T dato) {
        ArbolGeneral<T> aux = new ArbolGeneral<>();
        if (arbol.getDato().equals(dato)) {
            return arbol;
        } else {
            if (arbol.tieneHijos()) {
                ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    aux = buscarNodo(hijos.proximo(), dato);
                    if (!aux.esVacio()) {
                        return aux;
                    }
                }
            }
        }
        return aux;
    }


}

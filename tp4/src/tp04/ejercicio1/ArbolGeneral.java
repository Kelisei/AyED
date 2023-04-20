package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp4.ColaGenerica;

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

    public ListaEnlazadaGenerica<T> preOrden() {
        return null;
    }

    public Integer altura() {
        if (this.esHoja()) {
            return 0;
        } else {
            ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
            hijos.comenzar();
            int max = 0;
            while (!hijos.fin()) {
                ArbolGeneral<T> hijo = hijos.proximo();
                if (hijo.altura() > max) {
                    max = hijo.altura();
                }
            }
            return max + 1;
        }
    }

    public Integer nivel(T dato) {
        // falta implementar
        int nivel = 0;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica();
        ArbolGeneral<T> arbol = null;
        cola.encolar(this);
        cola.encolar(null);
        boolean encontrado = false;
        while ((!cola.esVacia()) && (!encontrado)) {
            arbol = cola.desencolar();
            if (arbol != null) {
                if (arbol.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
                System.out.println("DATO:" + arbol.getDato());
                T datoActual = arbol.getDato();
                if (datoActual != null && datoActual.equals(dato)) {
                    encontrado = true;
                }
            } else if (!cola.esVacia()) {
                nivel++;
                cola.encolar(null);
                System.out.println("NIVEL:" + nivel);
            }
        }
        if (encontrado) {
            return nivel;
        } else {
            return -1;
        }
    }

    public Integer ancho() {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica();
        ArbolGeneral<T> arbol = null;
        cola.encolar(this);
        cola.encolar(null);
        int ancho = -1;
        int anchoNivel = 0;
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                ListaGenerica<ArbolGeneral<T>> hijos = arbol.hijos;
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                }
                anchoNivel++;
            } else{
                if(!cola.esVacia()){
                   cola.encolar(null);
                }
                ancho = Math.max(ancho, anchoNivel);
                anchoNivel = 0;
            }
        }
        return ancho;
    }

}

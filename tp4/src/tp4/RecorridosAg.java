/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp4;

import tp02.ejercicio2.*;
import tp04.ejercicio1.*;

public class RecorridosAg {

    /*
    Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido en preorden.
     */
    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, int n) {
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica();
        numerosImparesMayoresQuePreOrden(listaImpares, a, n);
        return listaImpares;
    }

    private void numerosImparesMayoresQuePreOrden(ListaGenerica<Integer> lista, ArbolGeneral<Integer> a, int n) {
        if (!a.esVacio()) {
            if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                lista.agregarFinal(a.getDato());
            }
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                numerosImparesMayoresQuePreOrden(lista, hijos.proximo(), n);
            }
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica();
        numerosImparesMayoresQueInOrden(listaImpares, a, n);
        return listaImpares;
    }

    private void numerosImparesMayoresQueInOrden(ListaGenerica<Integer> lista, ArbolGeneral<Integer> a, Integer n) {
        if (!a.esVacio()) {
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                numerosImparesMayoresQueInOrden(lista, hijos.proximo(), n);
                if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                    lista.agregarFinal(a.getDato());
                }
                while (!hijos.fin()) {
                    numerosImparesMayoresQueInOrden(lista, hijos.proximo(), n);
                }
            } else {
                if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                    lista.agregarFinal(a.getDato());
                }
            }
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica();
        numerosImparesMayoresQuePostOrden(listaImpares, a, n);
        return listaImpares;
    }

    private void numerosImparesMayoresQuePostOrden(ListaGenerica<Integer> lista, ArbolGeneral<Integer> a, Integer n) {
        if (!a.esVacio()) {
            if (a.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    numerosImparesMayoresQuePostOrden(lista, hijos.proximo(), n);
                }
            }
            if ((a.getDato() % 2 != 0) && (a.getDato() > n)) {
                lista.agregarFinal(a.getDato());
            }
        }
    }

    public ListaGenerica< Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
        ListaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica();
        ArbolGeneral<Integer> arbol = null;
        if (!a.esVacio()) {
            ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica();
            cola.encolar(a);
            while (!cola.esVacia()) {
                arbol = cola.desencolar();
                if (!arbol.esVacio()) {
                    if (arbol.tieneHijos()) {
                        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
                        hijos.comenzar();
                        while (!hijos.fin()) {
                            cola.encolar(hijos.proximo());
                        }
                    }
                    if ((arbol.getDato() % 2 != 0) && (arbol.getDato() > n)) {
                        listaImpares.agregarFinal(arbol.getDato());
                    }
                }
            }
        }
        return listaImpares;
    }
    /*  
    b) Si ahora tuviera que implementar estos métodos en la clase ArbolGeneral <T>, que
    modificaciones haría tanto en la firma como en la implementación de los mismos?
    RTA: mas que nada habría que cambiar el hecho de que se traiga como parametro un arbol, 
    directamente usaria this, pero no so es mucha modificacion.
     */
}

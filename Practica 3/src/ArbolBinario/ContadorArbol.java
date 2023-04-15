/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

import ArbolBinario.*;

/**
 *
 * @author frank
 */
public class ContadorArbol {

    ArbolBinario<Integer> arbol;

    public ContadorArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ArbolBinario<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaEnlazadaGenerica<Integer> numerosParesInOrden() {
        ListaEnlazadaGenerica<Integer> inOrden = new ListaEnlazadaGenerica();
        numerosParesInOrden(inOrden, this.arbol);
        return inOrden;
    }

    private void numerosParesInOrden(ListaEnlazadaGenerica<Integer> lista, ArbolBinario<Integer> arbol) {
        if (!arbol.esVacio()) {
            if (arbol.getDato() % 2 == 0) {
                lista.agregarFinal(arbol.getDato());
            }
            if (arbol.tieneHijoIzquierdo()) {
                numerosParesInOrden(lista, arbol.getHijoIzquierdo());
            }
            if (arbol.tieneHijoDerecho()) {
                numerosParesInOrden(lista, arbol.getHijoDerecho());
            }
        }
    }

    public ListaEnlazadaGenerica<Integer> numerosParesPostOrden() {
        ListaEnlazadaGenerica<Integer> inOrden = new ListaEnlazadaGenerica();
        numerosParesPostOrden(inOrden, this.arbol);
        return inOrden;
    }

    private void numerosParesPostOrden(ListaEnlazadaGenerica<Integer> lista, ArbolBinario<Integer> arbol) {
        if (!arbol.esVacio()) {
            if (arbol.tieneHijoIzquierdo()) {
                numerosParesInOrden(lista, arbol.getHijoIzquierdo());
            }
            if (arbol.tieneHijoDerecho()) {
                numerosParesInOrden(lista, arbol.getHijoDerecho());
            }
            if (arbol.getDato() % 2 == 0) {
                lista.agregarFinal(arbol.getDato());
            }
        }
    }
}

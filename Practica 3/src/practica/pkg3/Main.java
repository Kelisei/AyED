/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica.pkg3;

import ArbolBinario.*;

/**
 *
 * @author frank
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void recorrido(ArbolBinario arbol) {
        if (arbol != null) {
            System.out.println(arbol.getDato());
            if (arbol.getHijoDerecho() != null) {
                System.out.println("Hijo derecho del nodo:" + arbol.getDato());
                recorrido(arbol.getHijoDerecho());
            }
            if (arbol.getHijoIzquierdo() != null) {
                System.out.println("Hijo izquierdo del nodo:" + arbol.getDato());
                recorrido(arbol.getHijoIzquierdo());
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ArbolBinario<Integer> arbol = new ArbolBinario<>(11);
        ArbolBinario<Integer> nodo = new ArbolBinario(32);
        arbol.agregarHijoDerecho(nodo);
        nodo = new ArbolBinario();
        arbol.getHijoDerecho().agregarHijoDerecho(nodo);
        nodo = new ArbolBinario();
        arbol.getHijoDerecho().agregarHijoIzquierdo(nodo);
        nodo = new ArbolBinario(69);
        arbol.agregarHijoIzquierdo(nodo);
        recorrido(arbol);
        System.out.println(arbol.contarHojas());
        
        
        /*
        System.out.println(arbol.contarHojas());
        recorrido(arbol);
        System.out.println("");
        recorrido(arbol.espejo());
        System.out.println("");
        recorrido(arbol);
        arbol.entreNiveles(0, 2);
        
        ContadorArbol ca = new ContadorArbol(arbol);
        ListaEnlazadaGenerica<Integer> listaIn = ca.numerosParesInOrden();
        while(!listaIn.fin()){
            System.out.println(listaIn.proximo());
        }
        
        ContadorArbol ca2 = new ContadorArbol(arbol);
        ListaEnlazadaGenerica<Integer> listaPost = ca2.numerosParesInOrden();
        while(!listaPost.fin()){
            System.out.println(listaPost.proximo());
        }
         
        RedBinariaLlena red = new RedBinariaLlena(arbol);
        System.out.println(red.retardoReenvio());
        
        ProfundidadDeArbolBinario sex = new ProfundidadDeArbolBinario(arbol);
        System.out.println(sex.sumaElementosProfundidad(2));
        */
    }
}

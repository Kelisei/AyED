/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

/**
 *
 * @author frank
 */
public class ProfundidadDeArbolBinario {

    ArbolBinario<Integer> arbol;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        ArbolBinario<Integer> arbol = null;
        ColaGenerica<ArbolBinario> cola = new ColaGenerica();
        int nivel = 0;
        cola.encolar(this.arbol);
        cola.encolar(null);
        int sumatoria = 0;
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null && nivel <= p) {
                if (nivel == p) {
                    sumatoria += arbol.getDato();
                }
                if (arbol.tieneHijoDerecho()) {
                    cola.encolar(arbol.getHijoDerecho());
                }
                if (arbol.tieneHijoIzquierdo()) {
                    cola.encolar(arbol.getHijoIzquierdo());
                }
            } else if (!cola.esVacia()) {
                System.out.println("Nivel:" + ++nivel);
                cola.encolar(null);
            }
        }
        return sumatoria;
    }
}

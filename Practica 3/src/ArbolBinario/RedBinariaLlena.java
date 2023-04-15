/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

/**
 *
 * @author frank
 */
public class RedBinariaLlena {

    ArbolBinario<Integer> arbol;

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    /*retardoReenvio():int*/
    public int retardoReenvio() {
        return retardoReenvio(arbol);
    }

    private int retardoReenvio(ArbolBinario<Integer> arbol) {
        if (arbol.esVacio()) {
            return 0;
        } else {
            if (arbol.esHoja()) {
                return arbol.getDato();
            } else {
                return arbol.getDato() + Math.max(retardoReenvio(arbol.getHijoDerecho()), retardoReenvio(arbol.getHijoIzquierdo()));
            }
        }
    }

}

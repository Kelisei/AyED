package Ejercicio1_2_3;

import Class.ArbolGeneral;
import Class.ListaGenerica;

public class BuscadorDeArbol {
    private ArbolGeneral <Integer> arbol;

    public BuscadorDeArbol(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }
    public Integer buscarMayorEnPostOrden(){
        Integer max = null;
        if (!this.arbol.esVacio()){
            max = resolver(arbol);
        }
        return max;
    }
    private Integer resolver(ArbolGeneral <Integer> a){
        Integer max = -1;
        if (a.tieneHijos()){
            ListaGenerica <ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()){
                max = Math.max (max, resolver(hijos.proximo()));
            }
        }
        return Math.max(max,a.getDato());
    }
}


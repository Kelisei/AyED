/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

import tp02.ejercicio2.*;
import tp04.ejercicio1.*;

/**
 *
 * @author frank
 */
public class RedDeAguaPotable {

    private ArbolGeneral<Casa> casas;

    public RedDeAguaPotable(ArbolGeneral<Casa> casas) {
        this.casas = casas;
    }

    public double minimoCaudal(double caudal) {
        if(casas != null){
            Casa casa = casas.getDato(); // obtener objeto casa
            casa.setCaudal(caudal); // establecer el valor del caudal en la casa
            casas.setDato(casa); // establecer el objeto casa modificado en la lista de casas
            return calcularMinimo(casas, caudal);
        } else return -1;
    }

    private double calcularMinimo(ArbolGeneral<Casa> arbol, double caudal) {
        if (arbol.esVacio()) {
            return 0;
        } else if (arbol.esHoja()) {
            return arbol.getDato().getCaudal();
        } else {
            ListaGenerica<ArbolGeneral<Casa>> hijos = arbol.getHijos();
            double minCaudal = Double.MAX_VALUE;
            while(!hijos.fin()){
                ArbolGeneral<Casa> aux = hijos.proximo();
                Casa dato = aux.getDato();
                dato.setCaudal(caudal/hijos.tamanio());
                aux.setDato(dato);
                minCaudal = Math.min(minCaudal, calcularMinimo(aux, (caudal/hijos.tamanio())));
            }
            return minCaudal;
        }
    }
}

package tp4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import tp04.ejercicio1.ArbolGeneral;
import tp02.ejercicio2.*;
/**
 *
 * @author frank
 */
public class AnalizadorArbol {
    public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol){
        int max = -1;
        int totalNivel = 0;
        int nodos = 0;
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica();
        ArbolGeneral<AreaEmpresa> a = null;
        cola.encolar(arbol);
        cola.encolar(null);
        while(!cola.esVacia()){
            a = cola.desencolar();
            if(a != null){
                nodos++;
                totalNivel += a.getDato().getTardanza();
                ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = a.getHijos();
                while(!hijos.fin()){
                    cola.encolar(hijos.proximo());
                }
            } else {
                if(!cola.esVacia()){
                    cola.encolar(null);
                }
                max = Math.max(max, totalNivel/nodos);
                nodos = 0;
                totalNivel = 0;
            }
        }
        return max;
    }
}

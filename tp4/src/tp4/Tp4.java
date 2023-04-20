/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp4;

import tp04.ejercicio1.*;
import tp02.ejercicio2.*;

/**
 *
 * @author frank
 */
public class Tp4 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here  
        
        ArbolGeneral<Integer> arbol = new ArbolGeneral(11);
        arbol.agregarHijo(new ArbolGeneral(32));
        arbol.agregarHijo(new ArbolGeneral(42));
        arbol.agregarHijo(new ArbolGeneral(36));
        arbol.agregarHijo(new ArbolGeneral(12));
        arbol.agregarHijo(new ArbolGeneral(5));
        
        RecorridosAg xd = new RecorridosAg();
        /*
        ListaGenerica l = xd.numerosImparesMayoresQuePreOrden(arbol, 2);
        l.comenzar();
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
        */
        System.out.println("");
        ListaGenerica l = xd.numerosImparesMayoresQueInOrden(arbol, 2);
        l.comenzar();
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
        System.out.println("");
        /*
        l = xd.numerosImparesMayoresQuePostOrden(arbol, 2);
        l.comenzar();
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
        System.out.println("");
        l = xd.numerosImparesMayoresQuePorNiveles(arbol, 2);
        l.comenzar();
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
        */
        System.out.println(arbol.nivel(-1));
        System.out.println("Ancho:"+arbol.ancho());
    }
    
}

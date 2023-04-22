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
        System.out.println(arbol.esAncestro(11, 11));
        
        ArbolGeneral<Casa> casas = new ArbolGeneral(new Casa("X"));
        ArbolGeneral<Casa> subArbolY = new ArbolGeneral(new Casa("Y"));
        subArbolY.agregarHijo(new ArbolGeneral(new Casa("Z")));
        subArbolY.agregarHijo(new ArbolGeneral(new Casa("W")));
        subArbolY.agregarHijo(new ArbolGeneral(new Casa("Z")));
        subArbolY.agregarHijo(new ArbolGeneral(new Casa("W")));
        casas.agregarHijo(subArbolY);
        casas.agregarHijo(new ArbolGeneral(new Casa("Z")));
        casas.agregarHijo(new ArbolGeneral(new Casa("W")));
        RedDeAguaPotable red = new RedDeAguaPotable(casas);
        System.out.println(red.minimoCaudal(25));
    }
    
}

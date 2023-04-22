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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalizadorArbol anal = new AnalizadorArbol();
        ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral(new AreaEmpresa("s",00));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",50)));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",75)));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",125)));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",200)));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",300)));
        arbol.agregarHijo(new ArbolGeneral(new AreaEmpresa("s",550)));
        System.out.println(anal.devolverMaximoPromedio(arbol));
    }
}

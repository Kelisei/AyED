
package Ejercicio7;

import Class.ArbolDePrueba;
import Class.ListaGenerica;
import Ejercicio7.Parcial.Datos;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArbolDePrueba p = new ArbolDePrueba();
        Parcial parcial = new Parcial();
        ListaGenerica<Datos> lista = parcial.resolver(14,200,p.getArbol());
        lista.comenzar();
        while (!lista.fin()) {
            
            System.out.println(lista.proximo().toString());
        }
        
        
    }
    
}
   /*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22 - 200
                15 -26 - 224 - 287      |     |
                                      (-69)  269
        */

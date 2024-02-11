/*Ejercicio 8
Implemente en la clase Parcial que tiene como variable de instancia un ArbolGeneral<Integer> ,el
método:
ListaEnlazadaGenerica<Integer> resolver()
Que retorna una lista con los elementos de la frontera del árbol con valor par.
Se define como frontera de un árbol general, a las hojas del árbol recorridas de izquierda a
derecha.
Por Ejemplo, para el siguiente árbol
- resolver() devuelve una lista de enteros con 2, 6 y 4.
 */
package Ejercicio8;

import Class.ArbolDePrueba;
import Class.ListaEnlazadaGenerica;

public class Ejercicio8 {

    public static void main(String[] args) {
        
        
        ArbolDePrueba a = new ArbolDePrueba();
        Parcial p = new Parcial(a.getArbol());
        ListaEnlazadaGenerica<Integer> lista = p.resolver();
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
     /*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22 - 200
                15 -26 - 224 - 287
        */
}

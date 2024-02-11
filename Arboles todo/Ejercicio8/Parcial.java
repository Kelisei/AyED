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

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class Parcial {
    private ArbolGeneral<Integer> arbol;

    public Parcial(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public ListaEnlazadaGenerica<Integer> resolver(){
        ListaEnlazadaGenerica<Integer> lista =new ListaEnlazadaGenerica<>();
        if (!this.arbol.esVacio()) {
            resolver(this.arbol, lista);
        }
        return lista;
    }
    
    
    private void resolver(ArbolGeneral<Integer> a, ListaEnlazadaGenerica<Integer> lista){ //INORDEN
        
        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            resolver(h.proximo(), lista);
            if ((a.esHoja())&&(a.getDato()%2==0)) {
                lista.agregarFinal(a.getDato());
            }
            while (!h.fin()) {
                resolver(h.proximo(), lista);
            }
        }else{
            if ((a.esHoja())&&(a.getDato()%2==0)) {
                lista.agregarFinal(a.getDato());
            }
        }
    } 
}

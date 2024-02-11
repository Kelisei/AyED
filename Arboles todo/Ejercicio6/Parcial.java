/**Ejercicio 6
Implemente en la clase Parcial un método que reciba un árbol general de enteros y retorne una lista
con los valores mayores a un valor recibido por parámetro. Para cada valor, retornar el nivel en el que se
encuentra. Considerar que el árbol podría estar vacio, que ningún elemento del árbol o todos los
elementos del árbol podrían cumplir la condición. Realice un recorrido inorden.
El método debe tener la siguiente firma:
    resolver(int valor, ArbolGeneral<Integer> arbol)
Para el siguiente árbol, si valor es 5, la lista debería contener los elementos:
6 nivel 2, 11 nivel 2, 10 nivel 2. .
Para el siguiente árbol, si valor es 11, la lista debería ser vacía.
Para el siguiente árbol, si valor es -10, la lista debería contener todos los elementos del árbol:
2 nivel 2, -7 nivel 1, 6 nivel 2, -2 nivel 0, -3 nivel 2, 5 nivel 1, 11 nivel 2, 4 nivel 1, -9 nivel 2, 10 nivel 2 (En
Inorden).
 */


package Ejercicio6;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;


public class Parcial {
    private class Datos{
        private int dato;
        private int nivel;

        public Datos(int d,int n) {
            this.dato = d;
            this.nivel = n ;
        }
        
        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }
        @Override
        public String toString() {
            return "dato: " + dato + ", nivel: " + nivel;
        }
        
    }
    
    public ListaGenerica<Datos> resolver(int valor, ArbolGeneral<Integer> arbol){
        ListaGenerica<Datos> lista = new ListaEnlazadaGenerica<>();
        if (!arbol.esVacio()) {
            resolver(valor,arbol,lista,0);
        }
        mostarLista(lista);
        return lista;
    }
    //(En inorden)
    private void resolver(int v, ArbolGeneral<Integer> a, ListaGenerica<Datos> lista,int niv){
        if (!a.esHoja()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            resolver(v, h.proximo(), lista, niv+1);
            if (a.getDato()>v) {
                Datos d = new Datos(a.getDato(), niv);
                lista.agregarFinal(d);
            }
            while (!h.fin()) {
                resolver(v, h.proximo(), lista, niv+1);
            }
        }else{
            if (a.getDato()>v) {
                Datos d = new Datos(a.getDato(), niv);
                lista.agregarFinal(d);
            }
        }
    }
    public void mostarLista(ListaGenerica<Datos> lista){
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo().toString());
        }
    }
}

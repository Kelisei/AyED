/**Implementar en la clase Parcial el método:
resolver (ArbolGeneral<Integer> arbol, Integer min, Integer max): Integer
El cual retorna el promedio de los elementos del arbol, solo considerando aquellos que se encuentran en
el rango min y max indicado. Realice un recorrido en inorden.
Dado el siguiente árbol general, considerando min=6 y max=12, los elementos a considerar son:
10, 11, 6, 12, 8, 9 (En inorden). La suma da 56. Y dado que son 6 números, el promedio es 9. 
 */

package Ejercicio5;

import Class.ArbolGeneral;
import Class.ListaGenerica;

public class Parcial {
    public Integer resolver (ArbolGeneral<Integer> arbol, Integer min, Integer max){
        Integer prom = null;
        if (!arbol.esVacio()) {
            Datos dato = new Datos();
            resolver(arbol,min,max,dato);
            prom=dato.calcular();
        }
        return prom;
    }
    private class Datos {
        private int sumas =0;
        private int cant = 0;

        public int getSumas() {
            return sumas;
        }
        public void setSumas(int sumas){
            this.sumas += sumas;
            this.setCant();
        }
        public int getCant() {
            return cant;
        }
        public void setCant() {
            this.cant ++;
        }        
        public int calcular(){
            return (int)(this.sumas/this.cant);
        }
    }
    public void resolver (ArbolGeneral<Integer> a, Integer min, Integer max, Datos d){//Realice un recorrido en inorden.
        
        if (a.tieneHijos()) {
            ListaGenerica<ArbolGeneral<Integer>> h = a.getHijos();
            h.comenzar();
            resolver(h.proximo(),min,max,d);
            if ((a.getDato()<=max)&&(a.getDato()>=min)) {
                d.setSumas(a.getDato());
            }
            while (!h.fin()) {
                resolver(h.proximo(),min,max,d);
            }
        }else{
            if ((a.getDato()<=max)&&(a.getDato()>=min)) {
                d.setSumas(a.getDato());
            }
        }
    }
}

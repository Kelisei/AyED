/*Ejercicio 5
El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde
cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el
mensaje.
Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10.
Por lo tanto, debe devolver 16.
a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol)
Donde AreaEmpresa es una clase que representa a un área de la empresa mencionada y que
contiene la identificación de la misma representada con un String y una tardanza de transmisión de
mensajes interna representada con int.
 */
package Extras1;

import Class.ArbolGeneral;
import Class.ColaGenerica;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class AnalizadorArbol {

    private ArbolGeneral<AreaEmpresa> arbolin;

    public AnalizadorArbol() {
        AreaEmpresa emp1 = new AreaEmpresa("M", 14);
        AreaEmpresa emp2 = new AreaEmpresa("J", 13);
        AreaEmpresa emp3 = new AreaEmpresa("K", 25);
        AreaEmpresa emp4 = new AreaEmpresa("L", 10);
        AreaEmpresa emp5 = new AreaEmpresa("A", 4);
        AreaEmpresa emp6 = new AreaEmpresa("B", 7);
        AreaEmpresa emp7 = new AreaEmpresa("C", 5);
        AreaEmpresa emp8 = new AreaEmpresa("D", 6);
        AreaEmpresa emp9 = new AreaEmpresa("E", 10);
        AreaEmpresa emp10 = new AreaEmpresa("F", 18);
        AreaEmpresa emp11 = new AreaEmpresa("G", 9);
        AreaEmpresa emp12 = new AreaEmpresa("H", 12);
        AreaEmpresa emp13 = new AreaEmpresa("I", 19);

        ArbolGeneral<AreaEmpresa> a10 = new ArbolGeneral(emp11);
        ArbolGeneral<AreaEmpresa> a11 = new ArbolGeneral(emp12);
        ArbolGeneral<AreaEmpresa> a12 = new ArbolGeneral(emp13);
        ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos4 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (1)
        hijos4.agregarFinal(a10);
        hijos4.agregarFinal(a11);
        hijos4.agregarFinal(a12);

        ArbolGeneral<AreaEmpresa> a7 = new ArbolGeneral(emp8);
        ArbolGeneral<AreaEmpresa> a8 = new ArbolGeneral(emp9);
        ArbolGeneral<AreaEmpresa> a9 = new ArbolGeneral(emp10);
        ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos3 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (3)
        hijos3.agregarFinal(a7);
        hijos3.agregarFinal(a8);
        hijos3.agregarFinal(a9);

        ArbolGeneral<AreaEmpresa> a4 = new ArbolGeneral(emp5);
        ArbolGeneral<AreaEmpresa> a5 = new ArbolGeneral(emp6);
        ArbolGeneral<AreaEmpresa> a6 = new ArbolGeneral(emp7);
        ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos2 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (5)
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);

        ArbolGeneral<AreaEmpresa> a1 = new ArbolGeneral(emp2, hijos2);
        ArbolGeneral<AreaEmpresa> a2 = new ArbolGeneral(emp3, hijos4);
        ArbolGeneral<AreaEmpresa> a3 = new ArbolGeneral(emp4, hijos3);
        ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (7)
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        ArbolGeneral<AreaEmpresa> a = new ArbolGeneral(emp1, hijos);  //RAIZ
        this.arbolin = a;
    }

    public class AreaEmpresa {

        private String nombre;
        private int delay;

        public AreaEmpresa(String nombre, int delay) {
            this.nombre = nombre;
            this.delay = delay;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getRetardo() {
            return delay;
        }

        public void setRetardo(int retardo) {
            this.delay = retardo;
        }
    }

    public int devolverMaximoPromedio() {
        int suma = 0, elem = 0, prom = 0;
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        ArbolGeneral<AreaEmpresa> aux = null;
        cola.encolar(this.arbolin);
        cola.encolar(null);
        while (!cola.esVacia()) {
            aux = cola.desencolar();
            if (aux != null) {
                elem++;
                suma += aux.getDato().getRetardo();
                if (aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<AreaEmpresa>> h = aux.getHijos();
                    h.comenzar();
                    while (!h.fin()) {
                        cola.encolar(h.proximo());
                    }
                }
            } else {
                prom = Math.max(prom, (suma / elem));
                if (!cola.esVacia()) {
                    elem = 0;
                    suma = 0;
                    cola.encolar(null);
                }
            }
        }
        return prom;
    }
}

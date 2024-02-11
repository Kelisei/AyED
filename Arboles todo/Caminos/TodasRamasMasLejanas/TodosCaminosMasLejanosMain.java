package Caminos.TodasRamasMasLejanas;

import Caminos.RamaMasLejana.HojaMasLejanaGeneral;
import Class.ArbolDePrueba;
import Class.ListaGenerica;

public class TodosCaminosMasLejanosMain {

    public static void main(String[] args) {
        ArbolDePrueba a = new ArbolDePrueba();
        TodosCaminosMasLejanos t = new TodosCaminosMasLejanos();

        ListaGenerica<ListaGenerica<Integer>> caminos = t.resolver(a.getArbol());
        caminos.comenzar();
        System.out.println("TAMANIO LISTA "+ caminos.tamanio());
        int centinela = 1;
        //MAIN
        while (!caminos.fin()) {
            System.out.println("camino " + centinela++);
            ListaGenerica<Integer> camino = caminos.proximo();
            camino.comenzar();
            while (!camino.fin()) {
                System.out.println(camino.proximo());
            }
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

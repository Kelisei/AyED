package Caminos.RamaMasLejana;

import Class.ArbolDePrueba;
import Class.ListaGenerica;

public class HojaMasLejanaMain {

    public static void main(String[] args) {

        ArbolDePrueba a = new ArbolDePrueba();
        HojaMasLejanaGeneral h = new HojaMasLejanaGeneral();

        ListaGenerica<Integer> camino = h.resolver(a.getArbol());
        camino.comenzar();

        while (!camino.fin()) {
            System.out.println(camino.proximo());
        }

    }
/*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22 - 200
                15 -26 - 224 - 287       |    |
                                        -69  269  
        */
}

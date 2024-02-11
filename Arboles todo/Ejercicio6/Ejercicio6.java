package Ejercicio6;

import Class.ArbolDePrueba;

public class Ejercicio6 {

    public static void main(String[] args) {
        ArbolDePrueba<Integer> ap = new ArbolDePrueba<>();
        
        Parcial p = new Parcial();
        p.resolver(0, ap.getArbol());
        
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

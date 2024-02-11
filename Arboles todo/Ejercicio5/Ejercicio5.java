package Ejercicio5;

import Class.ArbolDePrueba;

public class Ejercicio5 {
    public static void main(String[] args) {

        ArbolDePrueba arbolin= new ArbolDePrueba();
        Parcial p =new Parcial();
        System.out.println("El promedio es: " + p.resolver(arbolin.getArbol(), 0,100));
        

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

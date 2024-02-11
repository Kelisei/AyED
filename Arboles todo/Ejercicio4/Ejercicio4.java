package Ejercicio4;

import Class.ArbolDePrueba;
import Ejercicio1_2_3.BuscadorDeArbol;

public class Ejercicio4 {

    
    public static void main(String[] args) {
       ArbolDePrueba a = new ArbolDePrueba();
        
       Parcial p = new Parcial();
        System.out.println("Cantidad de nodos: "+ p.resolver(a.getArbol()));
        
    }
    
}

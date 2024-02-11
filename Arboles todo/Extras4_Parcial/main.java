package Extras4_Parcial;

import Class.ArbolBinarioDePrueba;
import Class.ListaGenerica;

public class main {
    public static void main(String[] args) {
        ArbolBinarioDePrueba a = new ArbolBinarioDePrueba();
        
        Parcial p = new Parcial();
        ListaGenerica<Integer> lista= p.resolver(a.getArbol(), 3);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
    
}

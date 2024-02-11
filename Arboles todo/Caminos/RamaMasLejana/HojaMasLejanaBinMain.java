package Caminos.RamaMasLejana;

import Class.ArbolBinarioDePrueba;
import Class.ListaGenerica;

public class HojaMasLejanaBinMain {

    public static void main(String[] args) {
        
        ArbolBinarioDePrueba a = new ArbolBinarioDePrueba();
        HojaMasLejanaBin h = new HojaMasLejanaBin();
        
        a.mostrarArbol(a.getArbol());
        
        ListaGenerica<Integer> l= h.hojaMasLejana(a.getArbol());
        l.comenzar();
        while (!l.fin()) {
            System.out.println(l.proximo());
        }
         /**
     *                       1
     *                   2       3
     *                13   5    6
     *                    9 16  
     */ 
        
        
    }
    
}

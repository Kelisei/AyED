
package Caminos.PesoCaminoMasLejano;

import Caminos.RamaMasLejana.HojaMasLejanaBin;
import Class.ArbolBinarioDePrueba;
import Class.ListaGenerica;

public class PesoCaminoMasLejanoBinMain {

    public static void main(String[] args) {
               
        ArbolBinarioDePrueba a = new ArbolBinarioDePrueba();
        PesoCaminoMasLejanoBin h = new PesoCaminoMasLejanoBin();
        
        ListaGenerica<Integer> l= h.resolver(a.getArbol());
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

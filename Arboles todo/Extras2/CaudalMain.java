/*
 */
package Extras2;

import Class.ArbolDePruebaDouble;

/**
 *
 * @author Felipe
 */
public class CaudalMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolDePruebaDouble a = new ArbolDePruebaDouble();
        RedDeAguaPotable r = new RedDeAguaPotable(a.getArbol());
        System.out.println("El min caudal " + r.minimoCaudal(1000));
    }
    
}


package MonoDistante;

import Class.ArbolBinarioDePrueba;

public class MonoDistanteMain {

    public static void main(String[] args) {
       monoDistanteClass m=new monoDistanteClass();
        ArbolBinarioDePrueba a = new ArbolBinarioDePrueba();
        System.out.println("Es monodistante? "+ m.esMonodistante(a.getArbol() ,20));
    }
    
}  /**
     *                       1
     *                   2       3
     *                13   4    6
     *                    9 16  
     */     

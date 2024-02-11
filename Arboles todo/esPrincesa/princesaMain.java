/*
 */
package esPrincesa;

import Class.ArbolGeneral;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

/**
 *
 * @author Felipe
 */
public class princesaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolGeneral<String>a1 =new ArbolGeneral<>("Scooby");
        ArbolGeneral<String>a2 =new ArbolGeneral<>("dragon");
        ArbolGeneral<String>b1 =new ArbolGeneral<>("tweety");
        ArbolGeneral<String>b2 =new ArbolGeneral<>("princesa");
        ListaGenerica<ArbolGeneral<String>> l = new ListaEnlazadaGenerica();
        ListaGenerica<ArbolGeneral<String>> lista2 = new ListaEnlazadaGenerica();
        l.agregarFinal(a1);
        l.agregarFinal(a2);
        lista2.agregarFinal(b1);
        lista2.agregarFinal(b2);
        ArbolGeneral<String>a3 =new ArbolGeneral<>("Animal Cid",lista2);
        l.agregarFinal(a3);
        ArbolGeneral<String>r =new ArbolGeneral<>("coyote",l);
        
        princesa p= new princesa();
        ListaGenerica<String> lista= p.esPrincesa(r);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
    
}

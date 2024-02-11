package Ejercicio1_2_3;


import Class.ArbolBinario;
import Class.ArbolDePrueba;

public class EjFranjaCOCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolDePrueba a = new ArbolDePrueba();
        
        BuscadorDeArbol b = new BuscadorDeArbol(a.getArbol());
        
        System.out.println("El Mayor Es: " + b.buscarMayorEnPostOrden());
        
        
        ArbolBinario<Integer> ab = new ArbolBinario<>(55);
        ArbolBinario<Integer> ramaI1=new ArbolBinario(2);
        ramaI1.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
        ramaI1.agregarHijoDerecho(new ArbolBinario<Integer>(5));
        
        ArbolBinario<Integer> ramaD1=new ArbolBinario(3);
        ramaD1.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
        ramaD1.agregarHijoDerecho(new ArbolBinario<Integer>(7));
        ab.agregarHijoIzquierdo(ramaI1);
        ab.agregarHijoDerecho(ramaD1);
     
        BuscadorDeArbol2 b2 = new BuscadorDeArbol2 (ab);
        System.out.println("El dato"+ b2.buscar());
    }
    
}

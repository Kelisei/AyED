


package Class;


public class ArbolBinarioDePrueba {

    /**
     *                       1
     *                   2       3
     *                13   5    6
     *                    9 16  
     */                     
    private ArbolBinario<Integer> arbol;
    
    public ArbolBinarioDePrueba() {
        ArbolBinario<Integer> a = new ArbolBinario<>(1);
        ArbolBinario<Integer> hI = new ArbolBinario<>(2);
        hI.agregarHijoIzquierdo(new ArbolBinario<>(13));
        ArbolBinario<Integer> a1 = new ArbolBinario<>(5);
        ArbolBinario<Integer> a2 = new ArbolBinario<>(9);
        ArbolBinario<Integer> a3 = new ArbolBinario<>(16);
        a1.agregarHijoIzquierdo(a2);
        a1.agregarHijoDerecho(a3);
        hI.agregarHijoDerecho(a1);
        ArbolBinario<Integer> hD = new ArbolBinario<>(3);
        hD.agregarHijoIzquierdo(new ArbolBinario<>(6));
        a.agregarHijoIzquierdo(hI);
        a.agregarHijoDerecho(hD);
        
        this.arbol = a;
    }

    public ArbolBinario<Integer> getArbol() {
        return arbol;
    }
    
    public void mostrarArbol(ArbolBinario<Integer> a){
        
        if (a.tieneHijoIzquierdo()) {
            mostrarArbol(a.getHijoIzquierdo());
        }
        System.out.println(a.getDato());
        if (a.tieneHijoDerecho()) {
            mostrarArbol(a.getHijoDerecho());
        }
    }
   
    
}

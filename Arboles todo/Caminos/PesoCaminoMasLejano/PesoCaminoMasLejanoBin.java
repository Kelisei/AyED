package Caminos.PesoCaminoMasLejano;

import Class.ArbolBinario;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class PesoCaminoMasLejanoBin {
    public ListaGenerica<Integer> resolver (ArbolBinario<Integer> a){   
            ListaGenerica<Integer> camFin = new ListaEnlazadaGenerica<>();
            if (!a.esVacio()) {
                ListaGenerica<Integer> camAct = new ListaEnlazadaGenerica<>();
                resolver(a,camAct,camFin,0,-9999);
                
        }
    return camFin;
    }
    
    //PREORDEN
    private int resolver (ArbolBinario<Integer>a, ListaGenerica<Integer>camAct, ListaGenerica<Integer>camFin,int suma, int max){
        
        camAct.agregarFinal(a.getDato());
        suma += a.getDato();
        if (!a.esHoja()) {
            if (a.tieneHijoIzquierdo()) {
               max= resolver(a.getHijoIzquierdo(), camAct, camFin,suma,max);
            }
            if (a.tieneHijoDerecho()) {
               max= resolver(a.getHijoDerecho(), camAct, camFin, suma,max);
            }            
        }else{
            if ((camAct.tamanio()>camFin.tamanio())||((camAct.tamanio()==camFin.tamanio()) && (suma>max))) {
                max= suma;
                camFin.comenzar();
                while (!camFin.fin()) {
                    camFin.eliminar(camFin.proximo());
                }
                camAct.comenzar();
                while (!camAct.fin()) {
                    camFin.agregarFinal(camAct.proximo());
                }
             }
            }
        camAct.eliminarEn(camAct.tamanio());
        return max;
    }
}

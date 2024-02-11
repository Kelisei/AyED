package Extras3AgenteChapman;

import Class.ArbolBinario;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class MensajeCodificado {
    private ArbolBinario<Character> a;

    public MensajeCodificado(ArbolBinario<Character> a) {
        this.a = a;
    }
    
    public ListaGenerica<Character> descifrarCodigo(ListaGenerica<String>secuencias){
        ListaGenerica<Character> res = new ListaEnlazadaGenerica<>();
        if (!this.a.esVacio()) {
            secuencias.comenzar();
            while (!secuencias.fin()) {
                res.agregarFinal(descifrarCodigo(secuencias.proximo(),this.a));
            }
        }
        return res;
    }
    
    private Character descifrarCodigo(String cod , ArbolBinario<Character>a ){   
        if (a.esHoja()) {
            return a.getDato();
        }else {
            if (cod.charAt(0)=='0') {
               return descifrarCodigo(cod.substring(1),a.getHijoIzquierdo());
            }else{
               return descifrarCodigo(cod.substring(1), a.getHijoDerecho());
            }
        }
    }
    
    
}
    
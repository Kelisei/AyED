package Extras3AgenteChapman;

import Class.ArbolBinario;
import Class.ListaEnlazadaGenerica;
import Class.ListaGenerica;

public class MensajeCifradoMain {

    public static void main(String[] args) {
        
        ArbolBinario<Character> a = new ArbolBinario<>();
        ArbolBinario<Character> a1 = new ArbolBinario<>();
        a.agregarHijoIzquierdo(a1);
        ArbolBinario<Character> a2 = new ArbolBinario<>();
        a1.agregarHijoIzquierdo(a2);
        a2.agregarHijoIzquierdo(new ArbolBinario<>('C'));
        a2.agregarHijoDerecho( new ArbolBinario<>('S'));
        
        ArbolBinario<Character> a5 = new ArbolBinario<>();
        a.agregarHijoDerecho(a5);
        ArbolBinario<Character> a7 = new ArbolBinario<>();
        a5.agregarHijoIzquierdo(a7);
        ArbolBinario<Character> a8 = new ArbolBinario<>();
        a5.agregarHijoDerecho(a8);
        ArbolBinario<Character> a9 = new ArbolBinario<>();
        a7.agregarHijoIzquierdo(a9);
        a7.agregarHijoDerecho( new ArbolBinario<>('E'));
        
        ArbolBinario<Character> a10 = new ArbolBinario<>();
        a9.agregarHijoIzquierdo(a10);
        a9.agregarHijoDerecho( new ArbolBinario<>('R'));
        a10.agregarHijoIzquierdo( new ArbolBinario<>('A'));
        a10.agregarHijoDerecho( new ArbolBinario<>('G'));
        a8 .agregarHijoIzquierdo( new ArbolBinario<>('D'));
        ArbolBinario<Character> a11 = new ArbolBinario<>();
        a8.agregarHijoDerecho(a11);
        a11.agregarHijoDerecho(new ArbolBinario<>('O'));
        
        MensajeCodificado m = new MensajeCodificado(a);
        ListaGenerica<String> lista = new ListaEnlazadaGenerica<>();
        lista.agregarFinal("101");
        lista.agregarFinal("001");
        lista.agregarFinal("10001");
        lista.agregarFinal("1111");
        lista.agregarFinal("1001");
        lista.agregarFinal("110");
        lista.agregarFinal("1111");
        ListaGenerica<Character> mensaje = m.descifrarCodigo(lista);
        while (!mensaje.fin()) {
            System.out.print(mensaje.proximo()+" ");
        }
    }

}

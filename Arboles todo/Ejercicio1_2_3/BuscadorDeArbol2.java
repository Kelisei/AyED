


package Ejercicio1_2_3;

import Class.ArbolBinario;



public class BuscadorDeArbol2{
    ArbolBinario <Integer> a;

    public BuscadorDeArbol2(ArbolBinario<Integer> arbolito){
        this.a = arbolito;
    }
    
    private class Datos{
        private int profundidad =0;
        private int dato =0;

        public int getDato(){
            return this.dato;
        }
        public int getProfundidad(){
            return this.profundidad;
        }
        public void setDato(Integer a){
            this.dato = a;
            
        }
        public void setProfundidad(Integer a){
            this.profundidad = a;
        }
    }

    public Integer buscar(){
        Integer nodo =-1;
        if (! this.a.esVacio()){
            Datos dato = new Datos();
            buscar(this.a,dato,0);
            nodo = dato.getDato();
        }
        return nodo; 
    }

    public void buscar(ArbolBinario <Integer> a, Datos dato, Integer nivel){
        if (!a.esHoja()){
            if (a.tieneHijoIzquierdo()){
               buscar(a.getHijoIzquierdo(),dato, nivel+1);
            }       
            if (a.tieneHijoDerecho()){
               buscar (a.getHijoDerecho(),dato,nivel+1);
            }
        }
        if (dato.getProfundidad()<= nivel){
            dato.setProfundidad(nivel);
            dato.setDato(a.getDato());
        }
                
    }
}

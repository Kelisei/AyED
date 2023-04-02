/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesHechas;

import ClasesPrehechas.ListaEnlazadaGenerica;

/**
 *
 * @author frank
 */
public class PilaGenerica<T> {
    private ListaEnlazadaGenerica<T> datos;
    
    public PilaGenerica(){
        datos = new ListaEnlazadaGenerica<>();
    }
    
    public void apilar(T elem){
        datos.agregarFinal(elem);
    }
    public T desapilar(){
        if (datos.esVacia()){
            return null;
        }
        T elem = datos.elemento(datos.tamanio());
        datos.eliminarEn(datos.tamanio());
        return elem;
    }
    
    public T tope(){
        return datos.elemento(datos.tamanio());
    }
    
    public boolean esVacia(){
        return datos.esVacia();
    }
    
    
}

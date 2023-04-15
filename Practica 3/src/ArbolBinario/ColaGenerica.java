/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;
/**
 *
 * @author frank
 * @param <T>
 */
public class ColaGenerica<T> {
    private ListaEnlazadaGenerica<T> datos;

    public ColaGenerica() {
        datos = new ListaEnlazadaGenerica<>();
    }
    public void encolar(T elem){
        datos.agregarFinal(elem);
    }
    public T desencolar(){
        if (datos.esVacia()){
            return null;
        }
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;
    }
    public T tope(){
        if (datos.esVacia()){
            return null;
        }
        return datos.elemento(datos.tamanio());
    }
    public boolean esVacia(){
        return this.datos.esVacia();
    }
}

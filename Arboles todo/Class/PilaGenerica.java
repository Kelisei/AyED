/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author 2216197255
 */
public class PilaGenerica<T> {

    private ListaEnlazadaGenerica<T> dato = new ListaEnlazadaGenerica<>();

    public PilaGenerica() {
    }

    public void apilar(T elem) {
        dato.agregarInicio(elem);
    }

    public boolean esVacia() {
        return dato.esVacia();
    }

    public T desapilar() {
        if (!dato.esVacia()){
            T elem = dato.elemento(1);
            dato.eliminarEn(1);
            return elem;
        }
        return null;
    }

    public T tope() {
        if (!dato.esVacia()) {
            return dato.elemento(1);
        } else {
            return null;
        }
    }
}

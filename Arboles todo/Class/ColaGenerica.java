package Class;

public class ColaGenerica<T> {

    ListaEnlazadaGenerica<T> dato= new ListaEnlazadaGenerica<>();

    public ColaGenerica() {
    }

    public void encolar(T elem) {
        dato.agregarFinal(elem);
    }

    public T desencolar() {
        if (!dato.esVacia()) {
            T elem = dato.elemento(1);
            dato.eliminarEn(1);
            return elem;
        }
        return null;
    }

    public T tope() {
        if (dato.esVacia()) {
            return null;
        } else {
            return dato.elemento(dato.tamanio());
        }
    }

    public boolean esVacia() {
        return dato.esVacia();
    }
}

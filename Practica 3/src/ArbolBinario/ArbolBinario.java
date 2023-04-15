package ArbolBinario;

public class ArbolBinario<T> {

    private T dato;
    private ArbolBinario<T> hijoIzquierdo;
    private ArbolBinario<T> hijoDerecho;
    public ArbolBinario() {
        super();
    }

    public ArbolBinario(T dato) {
        this.dato = dato;
    }

    /*
	 * getters y setters
	 * 
     */
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Preguntar antes de invocar si tieneHijoIzquierdo()
     *
     * @return
     */
    public ArbolBinario<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public ArbolBinario<T> getHijoDerecho() {
        return this.hijoDerecho;

    }

    public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
        this.hijoIzquierdo = hijo;
    }

    public void agregarHijoDerecho(ArbolBinario<T> hijo) {
        this.hijoDerecho = hijo;
    }

    public void eliminarHijoIzquierdo() {
        this.hijoIzquierdo = null;
    }

    public void eliminarHijoDerecho() {
        this.hijoDerecho = null;
    }

    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

    }

    @Override
    public String toString() {
        return this.getDato().toString();
    }

    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }

    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    public int contarHojas() {
        if (this == null) {
            return 0;
        } else {
            if (this.esHoja()) {
                return 1;
            } else {
                int total = 0;
                if (this.tieneHijoDerecho()) {
                    total += this.hijoDerecho.contarHojas();
                }
                if (this.tieneHijoIzquierdo()) {
                    total += this.hijoIzquierdo.contarHojas();
                }
                return total;
            }
        }
    }

    //IMPORTANTE: USAR AUXILIARES CUANDO ESPEJAMOS EL ARBOL (HACER LOS CAMBIOS SOBRE EL THIS DEL ARBOL ESPEJA EL ARBOL EN SI)
    public ArbolBinario<T> espejo() {
        if (!this.esVacio()) {
            ArbolBinario aux = new ArbolBinario(this.dato);
            if (!this.esHoja()) {
                if (this.hijoDerecho != null) {
                    aux.agregarHijoIzquierdo(this.hijoDerecho.espejo());
                }
                if (this.hijoIzquierdo != null) {
                    aux.agregarHijoDerecho(this.hijoIzquierdo.espejo());
                }
            }
            return aux;
        } else {
            return this;
        }
    }

    public void entreNiveles(int n, int m) {
        if(n <= m){
            ArbolBinario<T> arbol = null;
            ColaGenerica<ArbolBinario> cola = new ColaGenerica();
            int nivel = 0;
            cola.encolar(this);
            cola.encolar(null);
            while(!cola.esVacia()){
                arbol = cola.desencolar();
                if(arbol != null && nivel <= m){
                    if(nivel >= n && nivel < m){
                        System.out.println(arbol.getDato());
                    }
                    if (arbol.tieneHijoDerecho()){
                         cola.encolar(arbol.hijoDerecho);
                    }
                    if(arbol.tieneHijoIzquierdo()){
                        cola.encolar(arbol.hijoIzquierdo);
                    }
                } else if (!cola.esVacia()){
                    System.out.println("Nivel:"+ ++nivel);
                    cola.encolar(null);
                }
            }
        }
    }
    
    
}

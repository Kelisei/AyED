package Class;


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

    /**
     * estemodulo del arbol esta mas legible que el que dejamos abajo, ambos
     * hacen lo mismo
     */
    public ArbolBinario<T> espejo() {
        if (!this.esVacio()) {
            ArbolBinario<T> aux = new ArbolBinario<>(this.getDato());
            if (this.tieneHijoDerecho()) {
                aux.agregarHijoIzquierdo(this.hijoDerecho);
                aux.getHijoIzquierdo().espejo();
            }
            if (this.tieneHijoIzquierdo()) {
                aux.agregarHijoDerecho(this.hijoIzquierdo.espejo());
            }
            return aux;
        } else {
            return null;
        }
    }

    public void entreNiveles(int n, int m) {
        if (n < 0) {
            System.out.println("No se puede mostrar datos");
        } else {
            System.out.println("********Impresion en nivel*******");
            ArbolBinario<T> a = null;
            ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
            int contador = 0;
            cola.encolar(this);
            cola.encolar(null);
            while (!cola.esVacia()) {
                a = cola.desencolar();
                if ((a != null) && (contador >= n) && (contador <= m)) {
                    System.out.println("dato: " + a.getDato());
                    if (a.tieneHijoIzquierdo()) {
                        cola.encolar(a.getHijoIzquierdo());
                    }
                    if (a.tieneHijoDerecho()) {
                        cola.encolar(a.getHijoDerecho());
                    }
                } else if (!cola.esVacia()) {
                    contador ++;
                    System.out.println("********fin nivel: "+contador+"*******");
                    cola.encolar(null);
                }
            }
        }
    }

    public void preOrden() {
        System.out.println(" dato: " + this.dato);
        if (this.tieneHijoIzquierdo()) {
            this.hijoIzquierdo.preOrden();
        }
        if (this.tieneHijoDerecho()) {
            this.hijoDerecho.preOrden();
        }
    }

    public void inOrden() {
        if (this.tieneHijoIzquierdo()) {
            this.hijoIzquierdo.inOrden();
        }
        System.out.println(" dato: " + this.dato);
        if (this.tieneHijoDerecho()) {
            this.hijoDerecho.inOrden();
        }
    }

    public void posOrden() {
        if (this.tieneHijoIzquierdo()) {
            this.hijoIzquierdo.posOrden();
        }
        if (this.tieneHijoDerecho()) {
            this.hijoDerecho.posOrden();
        }
        System.out.println(" dato: " + this.dato);
    }
    
    private Integer alturaMaxArbol(ArbolBinario<Integer> a){
        int rd=0 , ri =0;
        if (a.esHoja()){
            return 0;
        }else{
            if (a.tieneHijoIzquierdo()){
                ri= 1+ alturaMaxArbol(a.getHijoIzquierdo());
            }
            if (a.tieneHijoDerecho()){
                rd=1+alturaMaxArbol(a.getHijoDerecho());
            }
        }
        return  Math.max(ri, rd);
    }
}
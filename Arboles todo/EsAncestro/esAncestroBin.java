package EsAncestro;

import Class.ArbolBinario;

public class esAncestroBin {

    public boolean esAncestro(ArbolBinario<Integer> a, int num1, int num2) {
        boolean ok = false;

        if ((!a.esVacio()) && (num1 != num2)) {
            ArbolBinario<Integer> aux = esAncestro(a, num1);
            if (aux != null) {
                aux = esAncestro(aux, num2);
                ok = (aux != null);
            }
        }
        return ok;
    }
    private ArbolBinario<Integer> esAncestro(ArbolBinario<Integer> a, int num) {
        ArbolBinario<Integer> aux = null;
        if (a.getDato().equals(num)) {
            aux = a;
        } else {
            if (!a.esHoja()) {
                if (a.tieneHijoIzquierdo()) {
                    aux = esAncestro(a.getHijoIzquierdo(), num);
                }
                if ((a.tieneHijoDerecho()) && (aux == null)) {
                    aux = esAncestro(a.getHijoDerecho(), num);
                }
            }
        }
        return aux;
    }
}

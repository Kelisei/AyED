package BuscarSiExisteConListaString;

import Class.ArbolGeneral;
import Class.ColaGenerica;
import Class.ListaGenerica;

public class ExisteIterativo {

    public boolean resolver(ArbolGeneral<Character> a, ListaGenerica<Character> secuencia) {
        ColaGenerica<ArbolGeneral<Character>> cola = new ColaGenerica<>();
        ArbolGeneral<Character> aux;
        int indice = 1;
        secuencia.comenzar();
        Character buscado = secuencia.proximo();
        cola.encolar(a);
        cola.encolar(null);
        while ((!cola.esVacia()) && (indice < secuencia.tamanio())) {
            aux = cola.desencolar();
            if (aux != null) {
                if (aux.getDato().equals(buscado)) {
                    System.out.println(aux.getDato());
                    if (aux.tieneHijos()) {
                        ListaGenerica<ArbolGeneral<Character>> h = aux.getHijos();
                        h.comenzar();
                        while (!h.fin()) {
                            cola.encolar(h.proximo());
                        }
                    }
                }
            } else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                    indice++;
                    buscado = secuencia.proximo();
                }
            }
        }
        return (indice == secuencia.tamanio());
    }
}

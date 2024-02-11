package Class;
public class ArbolDePrueba<T>{
    /*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22 - 200
                15 -26 - 224 - 287      |     |
                                      (-69)  269
        */
    private ArbolGeneral<Integer> arbol;

    public ArbolDePrueba() {
        ArbolGeneral<Integer> a4 = new ArbolGeneral(11);
        ArbolGeneral<Integer> a5 = new ArbolGeneral(12);
        ArbolGeneral<Integer> a6 = new ArbolGeneral(21);
        ArbolGeneral<Integer> a7 = new ArbolGeneral(22);
        ArbolGeneral<Integer> a7bis = new ArbolGeneral(-69);
        a7.agregarHijo(a7bis);
        ArbolGeneral<Integer> a8 = new ArbolGeneral(200);
        ArbolGeneral<Integer> a8bis = new ArbolGeneral(269);
        a8.agregarHijo(a8bis);
        ListaGenerica<ArbolGeneral<Integer>> hijos2 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (3)
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        hijos2.agregarFinal(a7);
        hijos2.agregarFinal(a8);
        ListaGenerica<ArbolGeneral<Integer>> hijos3 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (5)
        ArbolGeneral<Integer> a34 = new ArbolGeneral(15);
        ArbolGeneral<Integer> a35 = new ArbolGeneral(26);
        ArbolGeneral<Integer> a36 = new ArbolGeneral(224);
        ArbolGeneral<Integer> a37 = new ArbolGeneral(287);
        hijos3.agregarFinal(a34);
        hijos3.agregarFinal(a35);
        hijos3.agregarFinal(a36);
        hijos3.agregarFinal(a37);
        ArbolGeneral<Integer> a1 = new ArbolGeneral(5,hijos3);
        ArbolGeneral<Integer> a2 = new ArbolGeneral(1);
        ArbolGeneral<Integer> a3 = new ArbolGeneral(3, hijos2);
        ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (7)
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        this.arbol = new ArbolGeneral(7, hijos);//RAIZ
    }

    public ArbolGeneral<Integer> getArbol() {
        return arbol;
    }
}

package Class;
public class ArbolDePruebaDouble<T>{
    /*  Diagrama del arbol de prueba
                7    
                |    
                5 - 1 - 3
                |       |
                |        11 - 12 - 21 - 22
                15 -26 - 224 - 287
        */
    private ArbolGeneral<Double> arbol;

    public ArbolDePruebaDouble() {
        ArbolGeneral<Double> a4 = new ArbolGeneral(11);
        ArbolGeneral<Double> a5 = new ArbolGeneral(12);
        ArbolGeneral<Double> a6 = new ArbolGeneral(21);
        ArbolGeneral<Double> a7 = new ArbolGeneral(22);
        ListaGenerica<ArbolGeneral<Double>> hijos2 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (3)
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        hijos2.agregarFinal(a7);
        ListaGenerica<ArbolGeneral<Double>> hijos3 = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (5)
        ArbolGeneral<Double> a34 = new ArbolGeneral(15);
        ArbolGeneral<Double> a35 = new ArbolGeneral(26);
        ArbolGeneral<Double> a36 = new ArbolGeneral(224);
        ArbolGeneral<Double> a37 = new ArbolGeneral(287);
        hijos3.agregarFinal(a34);
        hijos3.agregarFinal(a35);
        hijos3.agregarFinal(a36);
        hijos3.agregarFinal(a37);
        ArbolGeneral<Double> a1 = new ArbolGeneral(5,hijos3);
        ArbolGeneral<Double> a2 = new ArbolGeneral(1);
        ArbolGeneral<Double> a3 = new ArbolGeneral(3, hijos2);
        ListaGenerica<ArbolGeneral<Double>> hijos = new ListaEnlazadaGenerica();   //HIJOS DE LA RAIZ (7)
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        this.arbol = new ArbolGeneral(7, hijos);//RAIZ
    }

    public ArbolGeneral<Double> getArbol() {
        return arbol;
    }
    
}

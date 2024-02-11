/**
 * recorrer el arbol evaluando que los caminos de la raiz a una hoja poseen la misma cantidad de valores
 * encaso de no tener devolver unFALSE
 */


package MonoDistante;

import Class.ArbolBinario;


public class monoDistanteClass {
    
    public boolean esMonodistante(ArbolBinario<Integer>a,int valor){
        boolean ok = false;
        if (!a.esVacio()) {
            ok = resolver(a,valor);
        }
        return ok;
    }
    private boolean resolver(ArbolBinario<Integer>a,int valor){
        boolean cumple = true;
        valor -= a.getDato();
        if (!a.esHoja()) {
            if (a.tieneHijoIzquierdo()) {
               cumple= resolver(a.getHijoIzquierdo(), valor);
            }
            if ((cumple)&&(a.tieneHijoDerecho())) {
               cumple= resolver(a.getHijoDerecho(), valor);
            }
        }else{
            cumple= (valor == 0);
            System.out.println("cumpple?: "+cumple);
        }
        return cumple;
    }
            
}

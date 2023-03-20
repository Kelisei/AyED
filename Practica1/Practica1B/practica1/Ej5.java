package practica1;

public class Ej5 {

	public static void main(String[] args) {
		int[] valores = {1, 2, 3, 4, 5, 12, 50, -4};
		int[] resultadosA = IncisoA(valores);
		
		B resultadosB = new B();
		IncisoB(valores, resultadosB);
	}
	public static int[] IncisoA(int[] valores) {
		int[] aux = new int[3];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = 0;
		}
		
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] > aux[0]) { aux[0] = valores[i];}
			if (valores[i] < aux[1]) { aux[1] = valores[i];}
			aux[2] += valores[i];
		}
		aux[2] /= valores.length;
		return aux;
	}
	public static void IncisoB(int[] valores, B resultadosB) {
		int[] aux = new int[3];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = 0;
		}
		
		for (int i = 0; i < valores.length; i++) {
			if (valores[i] > aux[0]) { aux[0] = valores[i];}
			if (valores[i] < aux[1]) { aux[1] = valores[i];}
			aux[2] += valores[i];
		}
		aux[2] /= valores.length;
		
		resultadosB.setMax(aux[0]);
		resultadosB.setMin(aux[1]);
		resultadosB.setPromedio(aux[2]);
	}
}

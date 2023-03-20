package practica1;
import java.util.Scanner;
public class Ej2 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Ingrese un numero");
		int n = lector.nextInt();
		int []arr = multiplos(n);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		lector.close();
	}
	public static int[] multiplos(int n) {
		int []arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n * (i + 1);
		}
		return arr;
	}

}

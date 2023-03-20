package practica1;
import java.util.Scanner;
public class Ej1 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Ingrese un numero");
		int low = lector.nextInt();
		System.out.println("Ingrese un numero");
		int high = lector.nextInt();
		
		a(high, low);
		b(high, low);
		c(high, low);
		
		lector.close();
	}	
	
	public static void a (int high, int low) {
		for (int i = low; i <= high; i++) {
			System.out.println(i);
		}
	}
	public static void b(int high, int low) {
		int i = low;
		while(i <= high) {
			System.out.println(i);
			i++;
		}
	}
	public static void c(int high, int low) {
		if (low <= high) {
			System.out.println(low);
			low++;
			c(high, low);
		}
	}
}

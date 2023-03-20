/**
 * 
 */
package practica1;

/**
 * @author frank
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Estudiante[] arrEstudiantes = new Estudiante[2];
		Profesor[] arrProfesor = new Profesor[3];
		
		arrEstudiantes[0] = new Estudiante("Francisco", "Percara", 1,"ñ@gmail.com","22/33");
		arrEstudiantes[1] = new Estudiante("Killian", "Experience", 1,"ñ@gmail.com","232");

		arrProfesor[0] = new Profesor("Juan Roman","Riquelme","ñ@gmail.com","ideas","unlp");
		arrProfesor[1] = new Profesor("Mike","Oxlong","ñ@gmail.com","ideas","unlp");
		arrProfesor[2] = new Profesor("Javier","Milei","ñ@gmail.com","ideas","unlp");
		
		for (int i = 0; i < arrProfesor.length; i++) {
			System.out.println(arrProfesor[i].tusDatos());
		}
		for (int i = 0; i < arrEstudiantes.length; i++) {
			System.out.println(arrEstudiantes[i].tusDatos());
		}
	}

}

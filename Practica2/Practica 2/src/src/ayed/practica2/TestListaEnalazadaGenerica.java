/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package src.ayed.practica2;
import ClasesPrehechas.*;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class TestListaEnalazadaGenerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
        for (int i = 0; i < 4; i++) {
            Estudiante estudiante = new Estudiante(in.nextLine(), in.nextLine(), in.nextInt(), in.nextLine(), in.nextLine());
            lista.agregarFinal(estudiante);
        }
        while(!lista.fin()){
            System.out.println(lista.proximo().tusDatos());
        }
    }
    
}

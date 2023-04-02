/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ayed.practica2;
import ClasesPrehechas.ListaDeEnterosEnlazada;
import ClasesPrehechas.*;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class TestListaDeEnterosEnlazada {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        Scanner lector = new Scanner(System.in);
        System.out.println("Cuantos numeros quiere ingresar");
        int i = lector.nextInt();
        for (int j = 0; j < i; j++) {
            System.out.println("Ingrese un numero");
            int num = lector.nextInt();
            lista.agregarFinal(num);
        }
        lista.comenzar();
        while(! lista.fin()){
            System.out.print(lista.proximo() + " " );
        }
        lector.close();
    }
}

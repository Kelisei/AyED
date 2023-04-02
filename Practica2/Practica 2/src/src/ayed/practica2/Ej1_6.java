/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ayed.practica2;

import ClasesPrehechas.ListaDeEnterosEnlazada;
import ClasesPrehechas.*;

/**
 *
 * @author frank
 */
public class Ej1_6 {

    public static ListaDeEnterosEnlazada calcularSucesion(int n) {
        ListaDeEnterosEnlazada lista;
        // Si llega al final de la sucesion creamos la lista para agregar todos los valores que ya calculamos
        if (n == 1) {
            lista = new ListaDeEnterosEnlazada();
            //Sino vamos pasando los valores a agregar a cada llamada del metodo
        } else {
            int x;
            if (n % 2 == 0) {
                x = n / 2;
            } else {
                x = 3 * n + 1;
            }
            lista = calcularSucesion(x);
        }
        // Siempre vamos a tener que agregar, la primera vez que agregamos va a ser el 1
        lista.agregarInicio(n);
        return lista;
    }

    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = calcularSucesion(6);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
}

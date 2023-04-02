package ayed.practica2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import ClasesPrehechas.ListaDeEnteros;
import ClasesPrehechas.ListaDeEnterosConArreglos;
import ClasesPrehechas.*;

/**
 *
 * @author frank
 */
public class Ej1_5 {
    public static void imprimirInverso(ListaDeEnteros lista){
        if(! lista.fin()){
            int x = lista.proximo();
            imprimirInverso(lista);
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
        lista.agregarFinal(1);
        lista.agregarFinal(3);
        lista.agregarFinal(6);
        imprimirInverso(lista);
    }
}

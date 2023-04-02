/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.ayed.practica2;
import ClasesHechas.PilaGenerica;
import ClasesPrehechas.ListaEnlazadaGenerica;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class Ej4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese un string con los caracteres {}[]() en cualquier orden");
        String S = in.nextLine();
        in.close();
        boolean balanceado = true;
        
        ListaEnlazadaGenerica<Character> inicio = new ListaEnlazadaGenerica<Character>();
        ListaEnlazadaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
        inicio.agregarFinal('(');
        inicio.agregarFinal('[');
        inicio.agregarFinal('{');
        cierre.agregarFinal(')');
        cierre.agregarFinal(']');
        cierre.agregarFinal('}');
        
        Character actual, elem;
        
        PilaGenerica<Character> pilaApertura = new PilaGenerica<Character>();
        for (int i = 0; i < S.length(); i++) {
            actual = S.charAt(i);                                       //Actual contendría el caracter actual de la iteración
            
            if (inicio.incluye(actual)){                                //Si es uno de los caracteres de apertura ([{ lo apila
                
                pilaApertura.apilar(actual);
                
            } else if(cierre.incluye(actual)){                          //Sino chequeamos, si el primero de la pila es par con otro esta balanceado
                                                                             //Es decir actual == } entonces elem == {
                elem = pilaApertura.desapilar();
                System.out.println("Actual"+actual);
                switch(actual){
                    case ')': 
                        actual = '(';
                        System.out.println("Case1");
                        break;
                    case '}': 
                        actual = '{';
                        System.out.println("Case2");                        
                        break;
                    case ']': 
                        actual = '[';
                        System.out.println("Case3");  
                        break;
                }
                
                System.out.println("Elemento del tope"+elem);
                System.out.println("El par del actual"+ elem);
                if(!actual.equals(elem)){
                    balanceado = false;
                    break;
                }
            }
        }
        if (balanceado){
            System.out.println("Esta balanceado");
        } else{
            System.out.println("No esta balanceado");
        }
    }
}

package test;

import entidades.Carta;
import entidades.Numero;
import entidades.Palos;

public class testCarta {

    public static void main(String[] args) {
     
        Palos palos = new Palos();

        
        Carta carta1 = new Carta(new Numero("A", 11), palos.getCorazonRojo()); // A-11, A-CR
        Carta carta2 = new Carta(new Numero("Q", 10), palos.getCorazonRojo()); // Q-10, Q-CR
        Carta carta3 = new Carta(new Numero("4", 4), palos.getTrebol());       // 4-4, 4-TR

       
        carta1.mostrarInfo(); // Muestra: A-11 y A-CR
        carta2.mostrarInfo(); // Muestra: Q-10 y Q-CR
        carta3.mostrarInfo(); // Muestra: 4-4 y 4-TR
    }
}
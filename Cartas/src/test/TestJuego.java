package test;

import entidades.Carta;
import entidades.Juego;



import java.util.ArrayList;

public class TestJuego {
    public static void main(String[] args) {
      
        ArrayList<Integer> idsJugadores = new ArrayList<>();
        idsJugadores.add(1);
        idsJugadores.add(2);
        idsJugadores.add(3);
        idsJugadores.add(4);

      
        Juego juego = new Juego(idsJugadores);

        // Repartimos 5 cartas a cada jugador
        juego.repartirCartas(5);

     
        ArrayList<ArrayList<Carta>> cartasDeJugadores = juego.getCartasJugador();
        for (int i = 0; i < cartasDeJugadores.size(); i++) {
            System.out.println("Cartas del Jugador " + (i + 1) + ":");
            for (Carta carta : cartasDeJugadores.get(i)) {
                carta.mostrarInfo();
            }
        }
    }
}

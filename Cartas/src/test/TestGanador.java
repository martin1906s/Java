package test;

import java.util.ArrayList;

import Jugadores.Java.Jugadores;
import servicio.Juego;

public class TestGanador {

    public static void main(String[] args) {

    
        Jugadores jugadores = new Jugadores();
        
     
        ArrayList<String> listaJugadores = new ArrayList<>();
        listaJugadores.add("Jugador 1");
        listaJugadores.add("Jugador 2");
        listaJugadores.add("Jugador 3");
        
        
        jugadores.setJugadores(listaJugadores);

      
        Juego juego = new Juego(jugadores);
        
      
        juego.entregarCartas(5);

      
        for (int i = 0; i < jugadores.getJugadores().size(); i++) {
            int total = juego.devolverTotal(i);
            System.out.println("Total del " + jugadores.getJugadores().get(i) + ": " + total);
        }

      
        String ganador = juego.determinarGanador();
        System.out.println("El ganador es: " + ganador);
    }
}

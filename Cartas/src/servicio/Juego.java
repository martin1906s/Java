package servicio;

import entidades.Carta;
import entidades.Naipe;
import java.util.ArrayList;

import Jugadores.Java.Jugadores;

public class Juego {
    private Naipe naipe;
    private ArrayList<Carta> naipeBarajado;
    private ArrayList<ArrayList<Carta>> cartasJugador;

    public Juego(Jugadores jugadores) {
        this.naipe = new Naipe();  
        this.naipeBarajado = naipe.barajar(); 
        this.cartasJugador = new ArrayList<>();

       
        for (int i = 0; i < jugadores.getJugadores().size(); i++) {
            cartasJugador.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Carta>> getCartasJugador() {
        return cartasJugador;
    }

    public void entregarCartas(int cartasPorJugador) {
        int index = 0;
        for (int i = 0; i < cartasPorJugador; i++) {
            for (int j = 0; j < cartasJugador.size(); j++) {
                if (index < naipeBarajado.size()) {
                    cartasJugador.get(j).add(naipeBarajado.get(index));
                    index++;
                }
            }
        }
    }

    public int devolverTotal(int idJugador) {
        int total = 0;
        for (Carta carta : cartasJugador.get(idJugador)) {
            total += carta.getNumero().getValor();  
        }
        return total;
    }

    public String determinarGanador() {
        int maxTotal = 0;
        int ganadorId = -1;
        for (int i = 0; i < cartasJugador.size(); i++) {
            int total = devolverTotal(i);
            if (total > maxTotal) {
                maxTotal = total;
                ganadorId = i;
            }
        }
        return " Jugador " + (ganadorId + 1) + " con total de " + maxTotal;
    }
}

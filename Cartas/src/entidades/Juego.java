package entidades;

import java.util.ArrayList;

public class Juego {
    private Naipe naipe;
    private ArrayList<ArrayList<Carta>> cartasJugador;

   
    public Juego(ArrayList<Integer> idsJugadores) {
        this.naipe = new Naipe();
        this.cartasJugador = new ArrayList<>();

      
        for (int i = 0; i < idsJugadores.size(); i++) {
            ArrayList<Carta> cartas = new ArrayList<>();
            cartasJugador.add(cartas);  
        }
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    public ArrayList<ArrayList<Carta>> getCartasJugador() {
        return cartasJugador;
    }

    public void setCartasJugador(ArrayList<ArrayList<Carta>> cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

  
    public void repartirCartas(int numeroCartasPorJugador) {
        ArrayList<Carta> cartasBarajadas = naipe.barajar();  // Barajar las cartas

        int index = 0;
      
        for (int i = 0; i < numeroCartasPorJugador; i++) {
            for (ArrayList<Carta> cartasDeJugador : cartasJugador) {
                if (index < cartasBarajadas.size()) {
                    cartasDeJugador.add(cartasBarajadas.get(index));  // Dar una carta al jugador
                    index++;
                }
            }
        }
    }
}

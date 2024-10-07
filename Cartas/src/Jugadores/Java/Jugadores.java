package Jugadores.Java;

import java.util.ArrayList;

public class Jugadores {
    private ArrayList<String> jugadores;

    
    
    
    
    public Jugadores() {
        this.jugadores = new ArrayList<>();
    }

    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }

    public void agregarJugador(String nombre) {
        jugadores.add(nombre);
    }

    public void mostrarJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("Jugador " + (i + 1) + ": " + jugadores.get(i));
        }
    }
}

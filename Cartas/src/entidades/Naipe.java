package entidades;

import java.util.ArrayList;

public class Naipe {
    private ArrayList<Carta> cartas;
    private ArrayList<Numero> numerosPosibles;

    
    
    
    public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Naipe() {
       
        this.numerosPosibles = new ArrayList<>();
        this.cartas = new ArrayList<>();

        numerosPosibles.add(new Numero("A", 11));
        numerosPosibles.add(new Numero("2", 2));
        numerosPosibles.add(new Numero("3", 3));
        numerosPosibles.add(new Numero("4", 4));
        numerosPosibles.add(new Numero("5", 5));
        numerosPosibles.add(new Numero("6", 6));
        numerosPosibles.add(new Numero("7", 7));
        numerosPosibles.add(new Numero("8", 8));
        numerosPosibles.add(new Numero("9", 9));
        numerosPosibles.add(new Numero("10", 10));
        numerosPosibles.add(new Numero("J", 10));
        numerosPosibles.add(new Numero("Q", 10));
        numerosPosibles.add(new Numero("K", 10));

     
        String[] palos = {"CR", "CN", "DI", "TR"};
        for (Numero numero : numerosPosibles) {
            for (String palo : palos) {
                cartas.add(new Carta(numero, palo));
            }
        }
    }

    public ArrayList<Carta> barajar() {
        ArrayList<Carta> auxiliar = new ArrayList<>();

        // Hacemos 100 iteraciones intentando agregar cartas en orden aleatorio
        for (int i = 0; i < 100; i++) {
            int posicionAleatoria = Random.obtenerPosicion();  // Obtener posición aleatoria
            Carta cartaSeleccionada = cartas.get(posicionAleatoria);  // Obtener la carta en esa posición

            // Si la carta no ha sido barajada, la agregamos al auxiliar y cambiamos su estado a "C"
            if (cartaSeleccionada.getEstado().equals("N")) {
                auxiliar.add(cartaSeleccionada);
                cartaSeleccionada.setEstado("C");
            }
        }

        // Al final de las 100 iteraciones, agregamos las cartas que aún no se han barajado
        for (Carta carta : cartas) {
            if (carta.getEstado().equals("N")) {
                auxiliar.add(carta);
                carta.setEstado("C");
            }
        }

        // Retornar el ArrayList auxiliar con todas las cartas barajadas
        return auxiliar;
    }
}

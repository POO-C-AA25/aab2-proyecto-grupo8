
package Vista;

import Modelo.Snack;
import java.util.ArrayList;

public class MostrarMenuPrincipal {
    
    public void mostrarTitulo() {
        System.out.println("+--------------------------------+");
        System.out.println("|      CINEMAS LOJA - SISTEMA    |");
        System.out.println("+--------------------------------+");
    }    
    // Metodo para Mostrar la cartelera con títulos, horarios, salas y precios
    public void mostrarCartelera(String[] titulos, ArrayList<ArrayList<String>> horarios, ArrayList<ArrayList<String>> salas, double[] precios) {
        System.out.println("\nCartelera CineMas Loja:");
        for (int i = 0; i < titulos.length; i++) {
            System.out.println("[" + (i + 1) + "] " + titulos[i] + " - Precio: $" + precios[i]);
            System.out.println("   Horarios disponibles:");
            for (int j = 0; j < horarios.get(i).size(); j++) {
                System.out.println("     (" + (j + 1) + ") " + horarios.get(i).get(j) + " - "+ salas.get(i).get(j));
            }
        }
    }   
    // Metodo para mostrar los snacks disponibles para compra
    public void mostrarSnacksDisponibles(ArrayList<Snack> snacks) {
        System.out.println("\nSnacks disponibles:");
        for (int i = 0; i < snacks.size(); i++) {
            Snack s = snacks.get(i);
            System.out.println("[" + (i + 1) + "] " + s.getNombre() + " - Precio: $" + s.getPrecio());
        }
        System.out.println("[" + (snacks.size() + 1) + "] Ninguno");
    }    
}

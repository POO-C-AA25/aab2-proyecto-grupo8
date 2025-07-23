
package Vista;
import Modelo.*;
import java.util.ArrayList;

public class MostrarMenu {

    public MostrarMenu() {
    }

   public void mostrarTitulo() {
        System.out.println("+--------------------------------+");
        System.out.println("|      CINEMAS LOJA - SISTEMA    |");
        System.out.println("+--------------------------------+");
    }

    public void mostrarCartelera(Pelicula[] peliculas) {
        System.out.println("\nCartelera CineMas Loja:");
        for (int i = 0; i < peliculas.length; i++) {
            Pelicula p = peliculas[i];
            System.out.println("[" + (i + 1) + "] " + p.getTitulo() + " - Precio: $" + p.getPrecio());
            System.out.println("   Horarios disponibles:");
            for (int j = 0; j < p.getHorarios().size(); j++) {
                System.out.println("     (" + (j + 1) + ") " + p.getHorarios().get(j) + " - " + p.getSalas().get(j));
            }
        }
    }

    public void mostrarSnacksDisponibles(ArrayList<Snack> snacks) {
        System.out.println("\nSnacks disponibles:");
        for (int i = 0; i < snacks.size(); i++) {
            Snack s = snacks.get(i);
            System.out.println("[" + (i + 1) + "] " + s.getNombre() + " - Precio: $" + s.getPrecio());
        }
        System.out.println("[" + (snacks.size() + 1) + "] Ninguno");
    }

    public void mostrarFactura(RegistroVenta registro) {
        System.out.println("\n+---- FACTURA ----+");
        System.out.println("Pelicula: " + registro.getPelicula().getTitulo());
        System.out.println("Horario: " + registro.getHorario());
        System.out.println("Sala: " + registro.getSala());
        System.out.println("Precio por boleto: $" + registro.getBoleto().getPrecio());
        System.out.println("Cantidad boletos: " + registro.getBoleto().getCantidad());
        System.out.println("Subtotal boletos: $" + registro.getBoleto().calcularTotal());

        System.out.println("\nSnacks comprados:");
        if(registro.getSnacks().isEmpty()){
            System.out.println("  Ninguno");
        } else {
            for (Snack s : registro.getSnacks()) {
                System.out.println("" + s.getNombre() + "\nCantidad: " + s.getCantidad() + "\nPrecio unitario: $" + s.getPrecio() + "\nSubtotal: $" + s.calcularTotal());
            }
        }

        double subtotalSnacks = 0;
        for (Snack s : registro.getSnacks()) {
            subtotalSnacks += s.calcularTotal();
        }
        System.out.println("Subtotal snacks: $" + subtotalSnacks);

        System.out.println("\nDescuento aplicado: $" + registro.getDescuentoAplicado());
        System.out.println("Motivo descuento: " + registro.getDescripcionDescuento());

        double total = registro.getBoleto().calcularTotal() + subtotalSnacks - registro.getDescuentoAplicado();
        System.out.println("----------------------------");
        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("----------------------------");
    }
}



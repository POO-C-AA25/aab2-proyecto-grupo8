
package Vista;

import Modelo.Snack;
import Modelo.RegistroVenta;

public class MostrarFactura {
    // Metodo para mostrar la factura
    public void mostrarFactura(RegistroVenta venta) {
        System.out.println("\n+---- FACTURA ----+");
        System.out.println("Pelicula: " + venta.getPelicula().getTitulo());
        System.out.println("Horario: " + venta.getHorario());
        System.out.println("Sala: " + venta.getSala());
        System.out.println("Precio por boleto: $" + venta.getBoleto().getPrecio());
        System.out.println("Cantidad boletos: " + venta.getBoleto().getCantidad());
        System.out.println("Subtotal boletos: $" + venta.getBoleto().calcularTotal());

        System.out.println("\nSnacks comprados:");
        if(venta.getSnacks().isEmpty()){
            System.out.println("  Ninguno");
        } else {
            for (Snack s : venta.getSnacks()) {
                System.out.println("\n" + s.getNombre() + "\nCantidad: " + s.getCantidad() + "\nPrecio unitario: $" + s.getPrecio() + "\nSubtotal: $" + s.calcularTotal());
            }
        }

        double subtotalSnacks = 0;
        for (Snack s : venta.getSnacks()) {
            subtotalSnacks += s.calcularTotal();
        }
        System.out.println("Subtotal snacks: $" + subtotalSnacks);

        System.out.println("\nDescuento aplicado: $" + venta.getDescuentoAplicado());
        System.out.println("Motivo descuento: " + venta.getDescripcionDescuento());

        double total = venta.getBoleto().calcularTotal() + subtotalSnacks - venta.getDescuentoAplicado();
        System.out.println("----------------------------");
        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("----------------------------");
    }    
    
}

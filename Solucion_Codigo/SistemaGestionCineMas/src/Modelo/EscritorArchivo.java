
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;

public class EscritorArchivo {
    // Metodo para guardar las Facturas en un archivo 
    public void guardarFacturaEnArchivo(Venta venta) {
        try {
            FileOutputStream fos = new FileOutputStream("RegistroVentas.txt", true);
            Formatter objPersistenciaFiles = new Formatter(fos);

            objPersistenciaFiles.format("+---- FACTURA ----+%n");
            objPersistenciaFiles.format("Pelicula: %s%n", venta.getPelicula().getTitulo());
            objPersistenciaFiles.format("Horario: %s%n", venta.getHorario());
            objPersistenciaFiles.format("Sala: %s%n", venta.getSala());
            objPersistenciaFiles.format("Precio por boleto: $%.2f%n", venta.getBoleto().getPrecio());
            objPersistenciaFiles.format("Cantidad boletos: %d%n", venta.getBoleto().getCantidad());
            objPersistenciaFiles.format("Subtotal boletos: $%.2f%n%n", venta.getBoleto().calcularTotal());

            objPersistenciaFiles.format("Snacks comprados:%n");
            if (venta.getSnacks().isEmpty()) {
                objPersistenciaFiles.format("  Ninguno%n");
            } else {
                for (Snack s : venta.getSnacks()) {
                    objPersistenciaFiles.format("  %s - Cantidad: %d - Precio unitario: $%.2f - Subtotal: $%.2f%n",
                            s.getNombre(), s.getCantidad(), s.getPrecio(), s.calcularTotal());
                }
            }

            double subtotalSnacks = 0;
            for (Snack s : venta.getSnacks()) {
                subtotalSnacks += s.calcularTotal();
            }
            objPersistenciaFiles.format("Subtotal snacks: $%.2f%n%n", subtotalSnacks);

            objPersistenciaFiles.format("Descuento aplicado: $%.2f%n", venta.getDescuentoAplicado());
            objPersistenciaFiles.format("Motivo descuento: %s%n", venta.getDescripcionDescuento());

            double total = venta.getBoleto().calcularTotal() + subtotalSnacks - venta.getDescuentoAplicado();
            objPersistenciaFiles.format("----------------------------%n");
            objPersistenciaFiles.format("TOTAL A PAGAR: $%.2f%n", total);
            objPersistenciaFiles.format("----------------------------%n");

            objPersistenciaFiles.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar la factura: " + e.getMessage());
        }
    }

}    

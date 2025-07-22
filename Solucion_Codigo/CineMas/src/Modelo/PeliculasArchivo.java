
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class PeliculasArchivo {

    // Metodo para Leer los Titulos de un archivo
    public void leerTitulos(String[] titulos) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Peliculas.csv"));
            if (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                for (int i = 0; i < partes.length; i++) {
                    titulos[i] = partes[i];
                }
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Precios de un archivo
    public void leerPrecios(double[] precios) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Peliculas.csv"));
            if (objLecturaFile.hasNextLine()) objLecturaFile.nextLine();
            if (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                for (int i = 0; i < partes.length; i++) {
                    precios[i] = Double.parseDouble(partes[i]);
                }
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Horarios de un archivo
    public void leerHorarios(ArrayList<ArrayList<String>> horarios) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Horarios.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (int i = 0; i < partes.length; i++) {
                    lista.add(partes[i]);
                }
                horarios.add(lista);
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer las Salas de un archivo
    public void leerSalas(ArrayList<ArrayList<String>> salas) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Salas.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (int i = 0; i < partes.length; i++) {
                    lista.add(partes[i]);
                }
                salas.add(lista);
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Snacks de un archivo
    public void leerSnacks(ArrayList<Snack> snacks) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Snacks.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                snacks.add(new Snack(partes[0], Double.parseDouble(partes[1]), 0));
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para guardar las Facturas en un archivo 
    public void guardarFacturaEnArchivo(RegistroVenta registro) {
        try {
            FileOutputStream fos = new FileOutputStream("RegistroVentas.txt", true);
            Formatter objPersistenciaFiles = new Formatter(fos);

            objPersistenciaFiles.format("+---- FACTURA ----+%n");
            objPersistenciaFiles.format("Pelicula: %s%n", registro.getPelicula().getTitulo());
            objPersistenciaFiles.format("Horario: %s%n", registro.getHorario());
            objPersistenciaFiles.format("Sala: %s%n", registro.getSala());
            objPersistenciaFiles.format("Precio por boleto: $%.2f%n", registro.getBoleto().getPrecio());
            objPersistenciaFiles.format("Cantidad boletos: %d%n", registro.getBoleto().getCantidad());
            objPersistenciaFiles.format("Subtotal boletos: $%.2f%n%n", registro.getBoleto().calcularTotal());

            objPersistenciaFiles.format("Snacks comprados:%n");
            if (registro.getSnacks().isEmpty()) {
                objPersistenciaFiles.format("  Ninguno%n");
            } else {
                for (Snack s : registro.getSnacks()) {
                    objPersistenciaFiles.format("  %s - Cantidad: %d - Precio unitario: $%.2f - Subtotal: $%.2f%n",
                            s.getNombre(), s.getCantidad(), s.getPrecio(), s.calcularTotal());
                }
            }

            double subtotalSnacks = 0;
            for (Snack s : registro.getSnacks()) {
                subtotalSnacks += s.calcularTotal();
            }
            objPersistenciaFiles.format("Subtotal snacks: $%.2f%n%n", subtotalSnacks);

            objPersistenciaFiles.format("Descuento aplicado: $%.2f%n", registro.getDescuentoAplicado());
            objPersistenciaFiles.format("Motivo descuento: %s%n", registro.getDescripcionDescuento());

            double total = registro.getBoleto().calcularTotal() + subtotalSnacks - registro.getDescuentoAplicado();
            objPersistenciaFiles.format("----------------------------%n");
            objPersistenciaFiles.format("TOTAL A PAGAR: $%.2f%n", total);
            objPersistenciaFiles.format("----------------------------%n");

            objPersistenciaFiles.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar la factura: " + e.getMessage());
        }
    }
}

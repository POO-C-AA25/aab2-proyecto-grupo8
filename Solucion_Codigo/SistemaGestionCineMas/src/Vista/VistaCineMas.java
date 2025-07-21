
package Vista;

import java.util.Scanner;
import Modelo.*;
import java.util.ArrayList;

public class VistaCineMas {
    private Scanner sc = new Scanner(System.in);

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
                System.out.println("     (" + (j + 1) + ") " + horarios.get(i).get(j) + " - Sala: " + salas.get(i).get(j));
            }
        }
    }

    // Metodo para solicitar al usuario que seleccione una pelicula
    public int seleccionarPelicula() {
        System.out.print("\nSeleccione la pelicula (1, 2, ...): ");
        return sc.nextInt() - 1; // Ajuste a índice 0-based
    }

    // Metodo para solicitar al usuario que seleccione un horario
    public int seleccionarHorario(int cantidadHorarios) {
        System.out.print("Seleccione el horario (1, 2, ...): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadHorarios){
            System.out.print("Opcion invalida. Seleccione horario (1, 2, ...): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

    // Metodo para solicitar al usuario la cantidad de boletos a comprar
    public int ingresarCantidadBoletos() {
        System.out.print("Cantidad de boletos: ");
        int cantidad = sc.nextInt();
        while(cantidad <= 0){
            System.out.print("Cantidad invalida. Ingrese cantidad de boletos: ");
            cantidad = sc.nextInt();
        }
        return cantidad;
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

    // Metodo para solicitar al usuario que seleccione un snack
    public int seleccionarSnack(int cantidadOpciones) {
        System.out.print("Seleccione snack (numero): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadOpciones){
            System.out.print("Opcion invalida. Seleccione snack (numero): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

    // Metodo para solicitar al usuario la cantidad de un snack elegido 
    public int ingresarCantidadSnack() {
        System.out.print("Cantidad de snack: ");
        int cantidad = sc.nextInt();
        while(cantidad <= 0){
            System.out.print("Cantidad invalida. Ingrese cantidad de snack: ");
            cantidad = sc.nextInt();
        }
        return cantidad;
    }

    // Metodo para mostrar la factura
    public void mostrarFactura(Venta venta) {
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
                System.out.println("  " + s.getNombre() + " - Cantidad: " + s.getCantidad() + " - Precio unitario: $" + s.getPrecio() + " - Subtotal: $" + s.calcularTotal());
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



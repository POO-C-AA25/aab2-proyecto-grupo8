
package Vista;

import java.util.Scanner;
import Modelo.*;
import java.util.ArrayList;

public class MenuDeSeleccion {
    private Scanner sc = new Scanner(System.in);
    
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
    
}



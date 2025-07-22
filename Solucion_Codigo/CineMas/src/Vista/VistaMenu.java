/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.util.Scanner;
public class VistaMenu {
    Scanner sc = new Scanner(System.in);
    public int seleccionarPelicula() {
        System.out.print("\nSeleccione la película (1, 2, ...): ");
        return sc.nextInt() - 1;
    }

    public int seleccionarHorario(int cantidadHorarios) {
        System.out.print("Seleccione el horario (1, 2, ...): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadHorarios){
            System.out.print("Opción inválida. Seleccione horario (1, 2, ...): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

    public int ingresarCantidadBoletos() {
        System.out.print("Cantidad de boletos: ");
        int cantidad = sc.nextInt();
        while(cantidad <= 0){
            System.out.print("Cantidad inválida. Ingrese cantidad de boletos: ");
            cantidad = sc.nextInt();
        }
        return cantidad;
    }

    public int seleccionarSnack(int cantidadOpciones) {
        System.out.print("Seleccione snack (número): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadOpciones){
            System.out.print("Opción inválida. Seleccione snack (número): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

    public int ingresarCantidadSnack() {
        System.out.print("Cantidad de snack: ");
        int cantidad = sc.nextInt();
        while(cantidad <= 0){
            System.out.print("Cantidad inválida. Ingrese cantidad de snack: ");
            cantidad = sc.nextInt();
        }
        return cantidad;
    }
}

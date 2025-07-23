
package Vista;
import java.util.Scanner;
public class MenuDeSeleccion {
    
    Scanner sc = new Scanner(System.in);

    public MenuDeSeleccion() {
    }

    public int seleccionarPelicula() {
        System.out.print("\nSeleccione la pelicula (1, 2, ...): ");
        return sc.nextInt() - 1;
    }

    public int seleccionarHorario(int cantidadHorarios) {
        System.out.print("Seleccione el horario (1, 2, ...): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadHorarios){
            System.out.print("Opcion invalida. Seleccione horario (1, 2, ...): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

    public int ingresarCantidadBoletos() {
        System.out.print("Cantidad de boletos: ");
        int cantidad = sc.nextInt();
        while(cantidad <= 0){
            System.out.print("Cantidad invalida. Ingrese cantidad de boletos: ");
            cantidad = sc.nextInt();
        }
        return cantidad;
    }

    public int seleccionarSnack(int cantidadOpciones) {
        System.out.print("Seleccione snack (numero): ");
        int opcion = sc.nextInt() - 1;
        while(opcion < 0 || opcion >= cantidadOpciones){
            System.out.print("Opción invalida. Seleccione snack (numero): ");
            opcion = sc.nextInt() - 1;
        }
        return opcion;
    }

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

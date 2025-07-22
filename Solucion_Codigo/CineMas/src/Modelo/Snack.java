package Modelo;

public class Snack extends Producto {

    public Snack() {
        super("", 0, 0);
    }

    public Snack(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularTotal() {
        return precio * cantidad;
    }
}


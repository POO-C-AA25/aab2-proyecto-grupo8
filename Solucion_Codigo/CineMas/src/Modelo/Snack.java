package Modelo;

public class Snack extends Producto {

    public Snack(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public double calcularTotal() {
        return precio * cantidad;
    }
}


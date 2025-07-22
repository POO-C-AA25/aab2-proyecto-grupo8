
package Modelo;

public class Boleto extends Producto {

    public Boleto() {
        super("", 0, 0);
    }

    public Boleto(int cantidad, double precio) {
        super("Boleto", precio, cantidad);
    }

    @Override
    public double calcularTotal() {
        return precio * cantidad;
    }
}


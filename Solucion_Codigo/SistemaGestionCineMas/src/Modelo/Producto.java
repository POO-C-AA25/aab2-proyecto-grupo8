
package Modelo;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    protected double precio;
    protected int cantidad;

    public Producto(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public abstract double calcularTotal();
}

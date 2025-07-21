
package Modelo;

public class Snack extends Producto{
    private String nombre;

    public Snack(String nombre, double precio, int cantidad) {
        super(precio, cantidad);
        this.nombre = nombre;
    }
    public double calcularTotal(){
        return this.precio * this.cantidad;
    }

}


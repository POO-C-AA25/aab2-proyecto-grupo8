
package Modelo;

public class Boleto extends Producto{
    private Funcion funcion;

    public Boleto(Funcion funcion, double precio, int cantidad) {
        super(precio, cantidad);
        this.funcion = funcion;
    }
    public double calcularTotal(){
        return this.precio * this.cantidad;
    }
}


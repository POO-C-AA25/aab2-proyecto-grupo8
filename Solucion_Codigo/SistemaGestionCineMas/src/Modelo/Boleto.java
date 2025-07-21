
package Modelo;

public class Boleto {
    private int cantidad;
    private double precio;
    
    public Boleto(){
        
    }
    public Boleto(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public double calcularTotal() {
        return cantidad * precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}


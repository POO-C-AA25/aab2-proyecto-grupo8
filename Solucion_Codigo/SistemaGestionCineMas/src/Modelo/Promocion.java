
package Modelo;

public abstract class Promocion {
    protected double precio;

    public Promocion(double precio) {
        this.precio = precio;
    }
    
    public abstract boolean esAplicable(int diaFuncion);
    public abstract double calcularPromocion(int diaFuncion);
}

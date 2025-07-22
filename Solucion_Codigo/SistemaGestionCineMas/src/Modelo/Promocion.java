
package Modelo;

import java.io.Serializable;

public abstract class Promocion implements Serializable{
    protected double precio;

    public Promocion(double precio) {
        this.precio = precio;
    }
    
    public abstract boolean esAplicable(int diaFuncion);
    public abstract double calcularPromocion(int diaFuncion);
}

package Modelo;

public abstract class Promocion {

    public Promocion() {
    }
    public abstract double aplicarPromocion(RegistroVenta venta);
    public abstract String getDescripcion();
}


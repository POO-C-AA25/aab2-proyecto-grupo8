
package Modelo;

public class PromocionPorCantidad extends Promocion{
    private int cantidad;

    public PromocionPorCantidad(int cantidad, double precio) {
        super(precio);
        this.cantidad = cantidad;
    }
    public boolean esAplicable(int cantidad){
        if (this.cantidad > cantidad){
            return true;
        }else{
            return false;
        }
    }
    public double calcularPromocion(int cantidad){
        if (esAplicable(cantidad)){
            return this.precio * 0.20;
        }else{
            return this.precio;
        }
    }
}

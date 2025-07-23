
package Modelo;

public class PromocionPorCantidad extends Promocion {

    public PromocionPorCantidad() {
        super();
    }

    @Override
    public double aplicarPromocion(RegistroVenta registro) {
        if (registro.getBoleto().getCantidad() >= 5) {
            return registro.getBoleto().calcularTotal() * 0.10;
        }
        return 0;
    }

    @Override
    public String getDescripcion() {
        return "Descuento por compra de 5 o mas boletos";
    }
}

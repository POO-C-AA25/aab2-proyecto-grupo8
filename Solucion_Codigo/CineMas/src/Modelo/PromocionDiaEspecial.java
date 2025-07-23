
package Modelo;

public class PromocionDiaEspecial extends Promocion {

    public PromocionDiaEspecial() {
        super();
    }

    @Override
    public double aplicarPromocion(RegistroVenta venta) {
        if (!venta.getSnacks().isEmpty() && venta.getBoleto().getCantidad() >= 3) {
            return 2.0;
        }
        return 0;
    }

    @Override
    public String getDescripcion() {
        return "Descuento combo snacks y boletos";
    }
}


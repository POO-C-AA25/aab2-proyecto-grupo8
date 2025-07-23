
package Controlador;
import Modelo.*;
import java.util.ArrayList;
public class GestorDescuentos {
    private ArrayList<Promocion> promociones;

    public GestorDescuentos() {
    }

    public void aplicarDescuentos(RegistroVenta registro) {
        double totalDescuento = 0;
        String descripcion = "";

        promociones = new ArrayList<>();
        promociones.add(new PromocionPorCantidad());
        promociones.add(new PromocionDiaEspecial());

        for (Promocion promo : promociones) {
            double d = promo.aplicarPromocion(registro);
            if (d > 0) {
                totalDescuento += d;
                if (!descripcion.isEmpty()) descripcion += " + ";
                descripcion += promo.getDescripcion();
            }
        }

        if (descripcion.isEmpty()) descripcion = "Ninguno";

        registro.setDescuentoAplicado(totalDescuento);
        registro.setDescripcionDescuento(descripcion);
    }
}

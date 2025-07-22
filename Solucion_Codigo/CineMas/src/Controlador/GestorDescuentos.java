/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import java.util.ArrayList;
public class GestorDescuentos {
    public void aplicarDescuentos(RegistroVenta registro) {
        double totalDescuento = 0;
        String descripcion = "";

        ArrayList<Promocion> promociones = new ArrayList<>();
        promociones.add(new PromocionPorCantidad());
        promociones.add(new PromocionDiaEspecial());

        for (Promocion promo : promociones) {
            double d = promo.aplicar(registro);
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

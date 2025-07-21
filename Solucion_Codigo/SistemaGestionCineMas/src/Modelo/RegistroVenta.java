
package Modelo;
import java.util.ArrayList;
public class RegistroVenta {
    private ArrayList<Funcion> funciones = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Promocion> promociones = new ArrayList<>();
    private double total;
    public double calcularTotal(){
        for(Producto p : productos){
            total += p.calcularTotal();
        }
        for (Promocion n : promociones){
            if (n.esAplicable(21)){
                total -= n.calcularPromocion(21);
            }
        }
        return total;
    }
}

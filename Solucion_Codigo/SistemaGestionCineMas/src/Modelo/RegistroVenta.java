
package Modelo;
import java.util.ArrayList;
public class RegistroVenta {
    private ArrayList<Funcion> funciones = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Promocion> promociones = new ArrayList<>();
    private double total;

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<Funcion> funciones) {
        this.funciones = funciones;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(ArrayList<Promocion> promociones) {
        this.promociones = promociones;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
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


package Modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class RegistroVenta implements Serializable {
    private Pelicula pelicula;
    private ArrayList<Producto> productos;
    private ArrayList<Promocion> promociones;

    public RegistroVenta(Pelicula pelicula, ArrayList<Producto> productos, ArrayList<Promocion> promociones) {
        this.pelicula = pelicula;
        this.productos = productos;
        this.promociones = promociones;
    }
    
    
}

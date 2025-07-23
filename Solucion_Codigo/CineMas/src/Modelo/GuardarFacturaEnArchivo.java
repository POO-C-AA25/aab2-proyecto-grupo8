
package Modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GuardarFacturaEnArchivo {

    public void guardarFactura(ArrayList<RegistroVenta> listaVentas) {
        try {
            File archivo = new File("RegistroVentas.dat");
            FileOutputStream fos = new FileOutputStream(archivo, false); 
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (RegistroVenta registro : listaVentas) {
                oos.writeObject(registro);
            }

            oos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la factura: " + e.getMessage());
        }
    }
}


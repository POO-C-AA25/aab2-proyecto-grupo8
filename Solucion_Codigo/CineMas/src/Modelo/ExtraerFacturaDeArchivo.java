
package Modelo;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.util.ArrayList;

public class ExtraerFacturaDeArchivo {

    public ArrayList<RegistroVenta> ExtraerFacturas() {
        ArrayList<RegistroVenta> lista = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("RegistroVentas.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                RegistroVenta registro = (RegistroVenta) ois.readObject();
                lista.add(registro);
            }

        } catch (EOFException e) {
            // Fin esperado, no hacer nada
        } catch (Exception e) {
            System.out.println("Error al leer facturas: " + e.getMessage());
        }

        return lista;
    }
}



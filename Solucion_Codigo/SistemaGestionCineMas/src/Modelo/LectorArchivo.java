
package Modelo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class LectorArchivo {
    
    // Metodo para Leer los Titulos de un archivo
    public void leerTitulos(String[] titulos) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Peliculas.csv"));
            if (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                for (int i = 0; i < partes.length; i++) {
                    titulos[i] = partes[i];
                }
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Precios de un archivo
    public void leerPrecios(double[] precios) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Peliculas.csv"));
            if (objLecturaFile.hasNextLine()) objLecturaFile.nextLine();
            if (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                for (int i = 0; i < partes.length; i++) {
                    precios[i] = Double.parseDouble(partes[i]);
                }
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Horarios de un archivo
    public void leerHorarios(ArrayList<ArrayList<String>> horarios) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Horarios.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (int i = 0; i < partes.length; i++) {
                    lista.add(partes[i]);
                }
                horarios.add(lista);
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer las Salas de un archivo
    public void leerSalas(ArrayList<ArrayList<String>> salas) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Salas.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (int i = 0; i < partes.length; i++) {
                    lista.add(partes[i]);
                }
                salas.add(lista);
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    // Metodo para Leer los Snacks de un archivo
    public void leerSnacks(ArrayList<Snack> snacks) {
        try {
            Scanner objLecturaFile = new Scanner(new File("Snacks.csv"));
            while (objLecturaFile.hasNextLine()) {
                String[] partes = objLecturaFile.nextLine().split(";");
                snacks.add(new Snack(partes[0], Double.parseDouble(partes[1]), 0));
            }
            objLecturaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

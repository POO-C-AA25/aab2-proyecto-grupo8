
package Controlador;
import Modelo.*;
import java.util.ArrayList;
public class CargadorDatos {
    private PeliculasArchivo archivos = new PeliculasArchivo();

    public Pelicula[] cargarPeliculas() {
        String[] titulos = new String[3];
        double[] precios = new double[3];
        ArrayList<ArrayList<String>> horarios = new ArrayList<>();
        ArrayList<ArrayList<String>> salas = new ArrayList<>();

        archivos.leerTitulos(titulos);
        archivos.leerPrecios(precios);
        archivos.leerHorarios(horarios);
        archivos.leerSalas(salas);

        Pelicula[] peliculas = new Pelicula[titulos.length];
        for (int i = 0; i < titulos.length; i++) {
            peliculas[i] = new Pelicula(titulos[i], horarios.get(i), salas.get(i), precios[i]);
        }

        return peliculas;
    }

    public ArrayList<Snack> cargarSnacks() {
        ArrayList<Snack> snacks = new ArrayList<>();
        archivos.leerSnacks(snacks);
        return snacks;
    }
}

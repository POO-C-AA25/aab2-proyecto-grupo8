
package Controlador;
import Modelo.*;
import java.util.ArrayList;
public class CargadorDatos {
    ArchivoPeliculas peliculaArchivos = new ArchivoPeliculas();
    ArchivoSalas salasArchivos = new ArchivoSalas();
    ArchivoHorarios horariosArchivos = new ArchivoHorarios();
    ArchivoSnacks snacksArchivos = new ArchivoSnacks();


    public CargadorDatos() {
    }
    
    public Pelicula[] cargarPeliculas() {
        String[] titulos = new String[3];
        double[] precios = new double[3];
        ArrayList<ArrayList<String>> horarios = new ArrayList<>();
        ArrayList<ArrayList<String>> salas = new ArrayList<>();

        peliculaArchivos.leerTitulos(titulos);
        peliculaArchivos.leerPrecios(precios);
        horariosArchivos.leerHorarios(horarios);
        salasArchivos.leerSalas(salas);

        Pelicula[] peliculas = new Pelicula[titulos.length];
        for (int i = 0; i < titulos.length; i++) {
            peliculas[i] = new Pelicula(titulos[i], horarios.get(i), salas.get(i), precios[i]);
        }

        return peliculas;
    }

    public ArrayList<Snack> cargarSnacks() {
        ArrayList<Snack> snacks = new ArrayList<>();
        snacksArchivos.leerSnacks(snacks);
        return snacks;
    }
}

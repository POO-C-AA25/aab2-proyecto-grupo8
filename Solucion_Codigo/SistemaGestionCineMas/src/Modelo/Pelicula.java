
package Modelo;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private ArrayList<String> horarios;
    private ArrayList<String> salas;
    private double precio;
    
    public Pelicula(){
    
    }
    
    public Pelicula(String titulo, ArrayList<String> horarios, ArrayList<String> salas, double precio) {
        this.titulo = titulo;
        this.horarios = horarios;
        this.salas = salas;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public ArrayList<String> getSalas() {
        return salas;
    }

    public double getPrecio() {
        return precio;
    }
}


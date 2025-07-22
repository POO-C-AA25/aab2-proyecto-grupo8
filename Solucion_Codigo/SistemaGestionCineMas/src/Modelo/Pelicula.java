package Modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable{

    private String titulo;
    private int duracion;
    private String genero;
    private ArrayList<Sala> salas;
    private ArrayList<Horario> horarios;

    public Pelicula(int duracion, String genero, String titulo, ArrayList<Sala> salas, ArrayList<Horario> horarios) {
        this.duracion = duracion;
        this.genero = genero;
        this.titulo = titulo;
        this.salas = salas;
        this.horarios = horarios;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public String getTitulo(){
        return this.titulo;
    }
}

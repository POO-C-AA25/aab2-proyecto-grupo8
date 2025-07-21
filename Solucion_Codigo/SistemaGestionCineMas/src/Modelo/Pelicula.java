package Modelo;
public class Pelicula {

    private int duracion;
    private String genero;
    private String titulo;

    public Pelicula(int duracion, String genero, String titulo) {
        this.duracion = duracion;
        this.genero = genero;
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
}

package Modelo;
public class Pelicula {

    private String titulo;
    private int duracion;
    private String genero;

    public Pelicula(int duracion, String genero, String titulo) {
        this.duracion = duracion;
        this.genero = genero;
        this.titulo = titulo;
    }
    
    public String getTitulo(String titulo){
        return this.titulo = titulo;
    }
    
    
    public String getTitulo(){
        return this.titulo;
    }
}


package Modelo;

public class Funcion {
    private Pelicula pelicula;
    private Sala sala;
    private Horario horario;

    public Funcion(Pelicula pelicula, Sala sala, Horario horario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Funcion{" + "pelicula=" + pelicula + ", sala=" + sala + ", horario=" + horario + '}';
    }
    
}

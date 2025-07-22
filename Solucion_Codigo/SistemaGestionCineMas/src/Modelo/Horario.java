
package Modelo;

public class Horario {
    private String dia;
    private String hora;
    private String minutos;

    public Horario(String dia, String hora, String minutos) {
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
    
    

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", hora=" + hora + ", minutos=" + minutos + '}';
    }
    
}

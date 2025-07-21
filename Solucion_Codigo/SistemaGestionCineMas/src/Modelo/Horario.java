/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", hora=" + hora + ", minutos=" + minutos + '}';
    }
    
}

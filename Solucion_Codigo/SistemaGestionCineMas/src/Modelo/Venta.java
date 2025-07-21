package Modelo;

import java.util.ArrayList;

public class Venta {
    private Pelicula pelicula;
    private String horario;
    private String sala;
    private Boleto boleto;
    private ArrayList<Snack> snacks;
    private double descuentoAplicado;
    private String descripcionDescuento;

    public Venta(Pelicula pelicula, String horario, String sala, Boleto boleto, ArrayList<Snack> snacks, double descuentoAplicado, String descripcionDescuento) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala = sala;
        this.boleto = boleto;
        this.snacks = snacks;
        this.descuentoAplicado = descuentoAplicado;
        this.descripcionDescuento = descripcionDescuento;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public String getDescripcionDescuento() {
        return descripcionDescuento;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public void setDescripcionDescuento(String descripcionDescuento) {
        this.descripcionDescuento = descripcionDescuento;
    }
}



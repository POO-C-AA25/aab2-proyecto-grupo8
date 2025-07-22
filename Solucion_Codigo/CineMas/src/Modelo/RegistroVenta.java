
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class RegistroVenta implements Serializable {
    private Pelicula pelicula;
    private String horario;
    private String sala;
    private Boleto boleto;
    private ArrayList<Snack> snacks;
    private double descuentoAplicado;
    private String descripcionDescuento;

    public RegistroVenta(Pelicula pelicula, String horario, String sala, Boleto boleto, ArrayList<Snack> snacks, double descuentoAplicado, String descripcionDescuento) {
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

    public void setDescuentoAplicado(double d) { 
        descuentoAplicado = d; 
    }
    public void setDescripcionDescuento(String d) { 
        descripcionDescuento = d; 
    }

    @Override
    public String toString() {
        return pelicula.getTitulo() + " | " + horario + " | " + sala + " | " + boleto.getCantidad() + " boletos";
    }
}


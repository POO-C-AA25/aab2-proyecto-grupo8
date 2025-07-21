
package Controlador;

import Modelo.*;
import Vista.VistaCineMas;
import java.util.ArrayList;

public class ControladorCineMas {
    private VistaCineMas vista = new VistaCineMas();
    private EntradaSalidaArchivos archivos = new EntradaSalidaArchivos();

    private Pelicula[] peliculas;
    private String[] titulos;
    private double[] precios;
    private ArrayList<ArrayList<String>> horarios;
    private ArrayList<ArrayList<String>> salas;
    private ArrayList<Snack> snacksDisponibles;
    private ArrayList<Venta> registroVentas; 

    public ControladorCineMas() {
        registroVentas = new ArrayList<>();

        // Inicializamos vacíos y llenamos desde archivos
        titulos = new String[3];
        precios = new double[3];
        horarios = new ArrayList<>();
        salas = new ArrayList<>();
        snacksDisponibles = new ArrayList<>();

        archivos.leerTitulos(titulos);
        archivos.leerPrecios(precios);
        archivos.leerHorarios(horarios);
        archivos.leerSalas(salas);
        archivos.leerSnacks(snacksDisponibles);

        // Creamos objetos de tipo Pelicula
        peliculas = new Pelicula[titulos.length];
        for (int i = 0; i < titulos.length; i++) {
            peliculas[i] = new Pelicula(titulos[i], horarios.get(i), salas.get(i), precios[i]);
        }
    }

    public void ejecutarPrograma() {
        vista.mostrarTitulo();

        // Metodo para mostrar la cartelera completa con horarios, salas y precios
        vista.mostrarCartelera(titulos, horarios, salas, precios);

        // Metodo para Seleccionar la pelicula
        int seleccionPelicula = vista.seleccionarPelicula();
        Pelicula peliculaElegida = peliculas[seleccionPelicula];

        // Metodo para Seleccionar el horario y sala
        int seleccionHorario = vista.seleccionarHorario(peliculaElegida.getHorarios().size());
        String horarioElegido = peliculaElegida.getHorarios().get(seleccionHorario);
        String salaElegida = peliculaElegida.getSalas().get(seleccionHorario);

        // Metodo para ingresar la Cantidad de boletos
        int cantidadBoletos = vista.ingresarCantidadBoletos();
        Boleto boleto = new Boleto(cantidadBoletos, peliculaElegida.getPrecio());

        // Metodo para selccionar los snacks
        ArrayList<Snack> snacksComprados = new ArrayList<>();
        while(true){
            vista.mostrarSnacksDisponibles(snacksDisponibles);
            int opcionSnack = vista.seleccionarSnack(snacksDisponibles.size() + 1);
            if(opcionSnack == snacksDisponibles.size()){ // Opcion "Ninguno"
                break;
            }
            int cantidadSnack = vista.ingresarCantidadSnack();
            Snack snackBase = snacksDisponibles.get(opcionSnack);
            snacksComprados.add(new Snack(snackBase.getNombre(), snackBase.getPrecio(), cantidadSnack));
        }

        // Crearmos venta con descuento inicial 0 y descripcion "Ninguno"
        Venta venta = new Venta(peliculaElegida, horarioElegido, salaElegida, boleto, snacksComprados, 0, "Ninguno");

        // Metodo para Aplicar descuentos automáticos que modifican la venta
        aplicarDescuentos(venta);

        // Metodo para Mostrar factura final
        vista.mostrarFactura(venta);

        // Metodo para Registrar venta para historial
        registroVentas.add(venta);
        archivos.guardarFacturaEnArchivo(venta);
        
        
    }

    // Metodo para Aplicar descuentos según reglas definidas
    private void aplicarDescuentos(Venta venta){
        double descuento = 0;
        String descripcion = "Ninguno";

        // Metodo que se encarga de dar un Descuento del 10% si compra 5 o más boletos
        if(venta.getBoleto().getCantidad() >= 5){
            descuento = venta.getBoleto().calcularTotal() * 0.10;
            descripcion = "Descuento por compra de 5 o mas boletos";
        }

        // Metodo que se encarga de dar un Descuento extra por combo snacks y boletos
        if(!venta.getSnacks().isEmpty() && venta.getBoleto().getCantidad() >= 3){
            descuento += 2.0;
            descripcion += " + Descuento combo snacks y boletos";
        }

        venta.setDescuentoAplicado(descuento);
        venta.setDescripcionDescuento(descripcion);
    }
}

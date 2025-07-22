
package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

public class ControladorCineMas {
    private MostrarMenuPrincipal menuPrincipal= new MostrarMenuPrincipal();
    private MenuDeSeleccion menuSeleccion = new MenuDeSeleccion();
    private MostrarFactura mostrarFactura = new MostrarFactura();
    private Promocion promocion = new PromocionDiaEspecial(12.0, 2);
    
    private LectorArchivo lector = new LectorArchivo();
    private EscritorArchivo escritor = new EscritorArchivo();
    private Pelicula[] peliculas;
    private String[] titulos;
    private double[] precios;
    private ArrayList<ArrayList<String>> horarios;
    private ArrayList<ArrayList<String>> salas;
    private ArrayList<Snack> snacksDisponibles;
    private ArrayList<RegistroVenta> registroVentas; 

    public ControladorCineMas() {
        registroVentas = new ArrayList<>();

        // Inicializamos vacíos y llenamos desde archivos
        titulos = new String[3];
        precios = new double[3];
        horarios = new ArrayList<>();
        salas = new ArrayList<>();
        snacksDisponibles = new ArrayList<>();

        lector.leerTitulos(titulos);
        lector.leerPrecios(precios);
        lector.leerHorarios(horarios);
        lector.leerSalas(salas);
        lector.leerSnacks(snacksDisponibles);

        // Creamos objetos de tipo Pelicula
        peliculas = new Pelicula[titulos.length];
        for (int i = 0; i < titulos.length; i++) {
            peliculas[i] = new Pelicula(titulos[i], horarios.get(i), salas.get(i), precios[i]);
        }
    }

    public void ejecutarPrograma() {
        menuPrincipal.mostrarTitulo();

        // Metodo para mostrar la cartelera completa con horarios, salas y precios
        menuPrincipal.mostrarCartelera(titulos, horarios, salas, precios);

        // Metodo para Seleccionar la pelicula
        int seleccionPelicula = menuSeleccion.seleccionarPelicula();
        Pelicula peliculaElegida = peliculas[seleccionPelicula];

        // Metodo para Seleccionar el horario y sala
        int seleccionHorario = menuSeleccion.seleccionarHorario(peliculaElegida.getHorarios().size());
        String horarioElegido = peliculaElegida.getHorarios().get(seleccionHorario);
        String salaElegida = peliculaElegida.getSalas().get(seleccionHorario);

        // Metodo para ingresar la Cantidad de boletos
        int cantidadBoletos = menuSeleccion.ingresarCantidadBoletos();
        Boleto boleto = new Boleto(cantidadBoletos, peliculaElegida.getPrecio());

        // Metodo para selccionar los snacks
        ArrayList<Snack> snacksComprados = new ArrayList<>();
        while(true){
            menuPrincipal.mostrarSnacksDisponibles(snacksDisponibles);
            int opcionSnack = menuSeleccion.seleccionarSnack(snacksDisponibles.size() + 1);
            if(opcionSnack == snacksDisponibles.size()){ // Opcion "Ninguno"
                break;
            }
            int cantidadSnack = menuSeleccion.ingresarCantidadSnack();
            Snack snackBase = snacksDisponibles.get(opcionSnack);
            snacksComprados.add(new Snack(snackBase.getNombre(), snackBase.getPrecio(), cantidadSnack));
        }

        // Crearmos venta con descuento inicial 0 y descripcion "Ninguno"
        RegistroVenta venta = new RegistroVenta(peliculaElegida, horarioElegido, salaElegida, boleto, snacksComprados, 0, "Ninguno");

        // Metodo para Aplicar descuentos automáticos que modifican la venta
        calcularPromocion();

        // Metodo para Mostrar factura final
        mostrarFactura.mostrarFactura(venta);

        // Metodo para Registrar venta para historial
        registroVentas.add(venta);
        escritor.guardarFacturaEnArchivo(venta);
        
        
    }
}

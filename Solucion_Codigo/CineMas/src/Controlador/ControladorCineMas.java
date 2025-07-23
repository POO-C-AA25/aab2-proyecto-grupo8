
package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

public class ControladorCineMas {
    private MostrarMenu menu = new MostrarMenu();
    private MenuDeSeleccion seleccion = new MenuDeSeleccion();
    private GuardarFacturaEnArchivo guardarArchivo = new GuardarFacturaEnArchivo();
    private ExtraerFacturaDeArchivo extraerFactura = new ExtraerFacturaDeArchivo();

    private Pelicula[] peliculas;
    private ArrayList<Snack> snacksDisponibles;
    private ArrayList<RegistroVenta> registroVentas;

    public ControladorCineMas() {
        registroVentas = extraerFactura.ExtraerFacturas();

        CargadorDatos cargador = new CargadorDatos();
        peliculas = cargador.cargarPeliculas();
        snacksDisponibles = cargador.cargarSnacks();
    }

    public void ejecutarPrograma() {
        menu.mostrarTitulo();
        menu.mostrarCartelera(peliculas);

        int seleccionPelicula = seleccion.seleccionarPelicula();
        Pelicula peliculaElegida = peliculas[seleccionPelicula];

        int seleccionHorario = seleccion.seleccionarHorario(peliculaElegida.getHorarios().size());
        String horarioElegido = peliculaElegida.getHorarios().get(seleccionHorario);
        String salaElegida = peliculaElegida.getSalas().get(seleccionHorario);

        int cantidadBoletos = seleccion.ingresarCantidadBoletos();
        Boleto boleto = new Boleto(cantidadBoletos, peliculaElegida.getPrecio());

        ArrayList<Snack> snacksComprados = new ArrayList<>();
        while (true) {
            menu.mostrarSnacksDisponibles(snacksDisponibles);
            int opcionSnack = seleccion.seleccionarSnack(snacksDisponibles.size() + 1);
            if (opcionSnack == snacksDisponibles.size()) break;

            int cantidadSnack = seleccion.ingresarCantidadSnack();
            Snack snackBase = snacksDisponibles.get(opcionSnack);
            snacksComprados.add(new Snack(snackBase.getNombre(), snackBase.getPrecio(), cantidadSnack));
        }

        RegistroVenta registro = new RegistroVenta(peliculaElegida, horarioElegido, salaElegida, boleto, snacksComprados, 0, "Ninguno");

        GestorDescuentos gestor = new GestorDescuentos();
        gestor.aplicarDescuentos(registro);

        menu.mostrarFactura(registro);
        registroVentas.add(registro);
        guardarArchivo.guardarFactura(registroVentas);
    }
}


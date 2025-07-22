
package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

public class ControladorCineMas {
    VistaCineMas vista = new VistaCineMas();
    VistaMenu vistaMenu = new VistaMenu();
    GuardarFacturaEnArchivo guardarArchivo = new GuardarFacturaEnArchivo();
    ExtraerFacturaDeArchivo extraerFactura = new ExtraerFacturaDeArchivo();

    Pelicula[] peliculas;
    ArrayList<Snack> snacksDisponibles;
    ArrayList<RegistroVenta> registroVentas;

    public ControladorCineMas() {
        registroVentas = extraerFactura.ExtraerFacturas();

        CargadorDatos cargador = new CargadorDatos();
        peliculas = cargador.cargarPeliculas();
        snacksDisponibles = cargador.cargarSnacks();
    }

    public void ejecutarPrograma() {
        vista.mostrarTitulo();
        vista.mostrarCartelera(peliculas);

        int seleccionPelicula = vistaMenu.seleccionarPelicula();
        Pelicula peliculaElegida = peliculas[seleccionPelicula];

        int seleccionHorario = vistaMenu.seleccionarHorario(peliculaElegida.getHorarios().size());
        String horarioElegido = peliculaElegida.getHorarios().get(seleccionHorario);
        String salaElegida = peliculaElegida.getSalas().get(seleccionHorario);

        int cantidadBoletos = vistaMenu.ingresarCantidadBoletos();
        Boleto boleto = new Boleto(cantidadBoletos, peliculaElegida.getPrecio());

        ArrayList<Snack> snacksComprados = new ArrayList<>();
        while (true) {
            vista.mostrarSnacksDisponibles(snacksDisponibles);
            int opcionSnack = vistaMenu.seleccionarSnack(snacksDisponibles.size() + 1);
            if (opcionSnack == snacksDisponibles.size()) break;

            int cantidadSnack = vistaMenu.ingresarCantidadSnack();
            Snack snackBase = snacksDisponibles.get(opcionSnack);
            snacksComprados.add(new Snack(snackBase.getNombre(), snackBase.getPrecio(), cantidadSnack));
        }

        RegistroVenta registro = new RegistroVenta(peliculaElegida, horarioElegido, salaElegida, boleto, snacksComprados, 0, "Ninguno");

        GestorDescuentos gestor = new GestorDescuentos();
        gestor.aplicarDescuentos(registro);

        vista.mostrarFactura(registro);
        registroVentas.add(registro);
        guardarArchivo.guardarFactura(registroVentas);
    }
}


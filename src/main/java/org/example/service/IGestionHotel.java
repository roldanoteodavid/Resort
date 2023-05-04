package org.example.service;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.domain.Reserva;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IGestionHotel {
    boolean anyadirHabitacion(Habitacion habitacion);

    boolean borrarHabitacion(int numeroHab);

    List<Habitacion> listarHabitaciones(boolean ascendente);

    boolean comprobarDisponibilidad(LocalDate date);


    boolean addReserva(Reserva reserva, Cliente cliente);

    List<Cliente> verClientes(); //booleano

    boolean borrarCliente(String dni);

    boolean anyadirCliente(Cliente cliente);

    boolean modificarNombreCliente(String dni, String nombre);

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente); //por dni

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);

    boolean isEmptyReservasList(); //borrar?

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(int id);

    List<Actividad> listarActividad(boolean ascendente); //booleano

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}

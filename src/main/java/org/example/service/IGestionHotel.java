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

    boolean comprobarDisponibilidad(LocalDate date);


    boolean addReserva(Reserva reserva, Cliente cliente);
    List<Cliente> verClientes();

    boolean borrarCliente(Cliente cliente);

    boolean anyadirCliente(Cliente cliente);

    boolean modificarNombreCliente(String dni, String nombre);

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente);

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);

    boolean isEmptyReservasList();

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(Actividad actividad);

    List<Actividad> listarActividad();

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}

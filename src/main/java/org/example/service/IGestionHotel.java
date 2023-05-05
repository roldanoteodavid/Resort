package org.example.service;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IGestionHotel {
    boolean anyadirHabitacion(Habitacion habitacion);

    boolean borrarHabitacion(int numeroHab);

    List<Habitacion> listarHabitaciones(boolean ascendente);

    boolean comprobarDisponibilidad(LocalDate date);


    boolean addReserva(Reserva reserva, String dni);//dni cliente

    List<Cliente> verClientes(boolean ascendente); //booleano

    boolean borrarCliente(String dni);

    boolean anyadirCliente(Cliente cliente);

    boolean modificarNombreCliente(String dni, String nombre);

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente); //por dni

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);

    boolean isEmptyReservasList(); //borrar?

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(int id);

    List<Actividad> listarActividades(boolean ascendente); //booleano

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}

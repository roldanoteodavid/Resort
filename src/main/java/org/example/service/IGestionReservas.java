package org.example.service;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface IGestionReservas {
    Hotel getHotel();
    List<Actividad> verMisActividades(Cliente cliente, boolean ascendente);
    boolean anyadirCliente(Cliente cliente);
    boolean iniciarSesion(String dni, String contrasenya);

    Cliente clientePorDni(String dni);

    boolean addReserva(Cliente cliente, Reserva reserva);

    boolean modificarContrasenya(String DNI, String contrasenya);

    boolean cancelarReserva(int id);

    boolean reservarActividad(int id, LocalDate entrada, LocalDate salida, Cliente cliente);

    boolean cancelarActividad(int id, Cliente cliente);

    List<Reserva> verReservas(boolean ascendente, Cliente cliente);

    boolean modificarReservaFecha(int id, LocalDate entrada, LocalDate salida);

    List<Habitacion> obtenerHabitaciones(LocalDate entrada, LocalDate salida);

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}

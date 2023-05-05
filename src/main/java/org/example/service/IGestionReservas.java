package org.example.service;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IGestionReservas {
    boolean anyadirCliente(Cliente cliente);
    boolean iniciarSesion(String dni, String contrasenya);

    Cliente clientePorDni(String dni);

    boolean addReserva(Cliente cliente, Reserva reserva);

    boolean modificarContrasenya(String DNI, String contrasenya);

    boolean cancelarReserva(int id);

    boolean reservarActividad(Actividad actividad, Cliente cliente);

    boolean cancelarActividad(int id, Cliente cliente);

    List<Reserva> verReservas(boolean ascendente);

    boolean modificarReservaFecha(String dni, LocalDate fecha);

    boolean escribirFicheroBinario();

    boolean cargarFicheroBinario();
}

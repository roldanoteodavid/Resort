package org.example.service;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IGestionReservas {
    boolean addReserva(Cliente cliente, Reserva reserva);
    boolean modificarContraseña(String DNI, String contraseña);
    boolean cancelarReserva(int id);
    boolean reservarActividad(Actividad actividad);
    boolean cancelarActividad(int id);
    List<Reserva> verReservas(boolean ascendente);
    boolean modificarReservaFecha(String dni, LocalDate fecha);


}

package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface DaoReservas {
    boolean addReserva(Cliente cliente, Reserva reserva);
    boolean modificarContraseña(String dni, String contraseña);
    boolean cancelarReserva(int id);
    boolean reservarActividad(Actividad actividad);
    boolean cancelarActividad(int id);
    List<Reserva> verReservas(boolean ascendente);

    boolean moficarReservaFecha(int id, int inquilinos);

}

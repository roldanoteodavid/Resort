package org.example.dao;

import org.example.domain.*;

import java.util.List;

public interface DaoReservas {
    Hotel getHotel();
    boolean iniciarSesion(String dni, String contrasenya);
    boolean addReserva(Cliente cliente, Reserva reserva);
    boolean modificarContrasenya(String dni, String contrasenya);
    boolean cancelarReserva(int id);
    boolean reservarActividad(Actividad actividad);
    boolean cancelarActividad(int id);
    List<Reserva> verReservas(boolean ascendente);
    Cliente clientePorDni(String dni);
    boolean moficarReservaFecha(int id, int inquilinos);

}

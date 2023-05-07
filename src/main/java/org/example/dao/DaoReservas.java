package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface DaoReservas {
    Hotel getHotel();
    void setHotel(Hotel hotel);
    boolean anyadirCliente(Cliente cliente);
    boolean iniciarSesion(String dni, String contrasenya);
    boolean addReserva(Cliente cliente, Reserva reserva);
    boolean modificarContrasenya(String dni, String contrasenya);
    boolean cancelarReserva(int id);
    boolean reservarActividad(int id, LocalDate entrada, LocalDate salida, Cliente cliente);
    boolean cancelarActividad(int id, Cliente cliente);
    List<Reserva> verReservas(boolean ascendente);
    Cliente clientePorDni(String dni);
    boolean moficarReservaFecha(int id, LocalDate entrada, LocalDate salida); // borrrar

    //boolean modificar

}

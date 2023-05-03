package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface DaoHotel {
    Hotel getHotel();
    void setHotel(Hotel hotel);
    boolean anyadirHabitacion(Habitacion habitacion);
    boolean borrarHabitacion(int numeroHab);
    List<Habitacion> verHabitaciones(boolean ascendente);
    boolean comprobarDisponibilidad(LocalDate date);
    boolean addReserva(Reserva reserva, Cliente cliente);
    List<Cliente> verClientes();
    boolean borrarCliente(String dni);
    boolean anyadirCliente(Cliente cliente);
    boolean modificarNombreCliente(String DNI, String nombre);
    boolean modificarContrasenyaCliente(String DNI, String contrasenya); //cambiar
    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente);
    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);//pablo
    boolean isEmptyReservasList();
    boolean anyadirActividad(Actividad actividad);
    boolean borrarActividad(int id);
    List<Actividad> listarActividad();
}

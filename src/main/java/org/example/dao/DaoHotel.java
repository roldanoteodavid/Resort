package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface DaoHotel {
    Hotel getHotel();
    void setHotel(Hotel hotel);
    boolean anyadirHabitacion(Habitacion habitacion);
    boolean borrarHabitacion(int numeroHab);
    boolean comprobarDisponibilidad(LocalDate date);
    boolean addReserva(Reserva reserva);
    List<Cliente> verClientes();
    boolean borrarCliente();
    boolean anyadirCliente(Cliente cliente);
    boolean modificarNombreCliente(String DNI, String nombre);
    boolean modificarContrasenyaCliente(String DNI, String contrasenya); //cambiar
    List<Reserva> listarReservasFecha(boolean ascendente);
    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);//pablo
    boolean isEmptyReservasList();
    boolean anyadirActividad(Actividad actividad);
    boolean borrarActividad(Actividad actividad);
    List<Actividad> listarActividad();
}

package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DaoHotel {
    Hotel getHotel();

    void setHotel(Hotel hotel);

    boolean anyadirHabitacion(Habitacion habitacion);

    Map<String,List<Cliente>> clientesporPais();

    boolean borrarHabitacion(int numeroHab);

    List<Habitacion> listarHabitaciones(boolean ascendente);

    boolean comprobarDisponibilidad(LocalDate date);

    boolean addReserva(Reserva reserva, String dni);

    List<Cliente> verClientes(boolean ascendente);

    boolean borrarCliente(String dni);

    boolean anyadirCliente(Cliente cliente);

    boolean modificarNombreCliente(String DNI, String nombre);

    boolean modificarContrasenyaCliente(String DNI, String contrasenya); //cambiar

    List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente);

    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);//pablo

    boolean isEmptyReservasList();

    boolean anyadirActividad(Actividad actividad);

    boolean borrarActividad(int id);

    boolean anyadirFechaActividad(LocalDate fecha, int id);

    List<Actividad> listarActividades(boolean ascendente);

    Map<String,Long> numeroClientesPais();
}

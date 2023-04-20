package org.example.dao;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface DaoHotel {
    boolean anyadirHabitacion(Habitacion habitacion);
    boolean borrarHabitacion(int numeroHab);
    boolean comprobarDisponibilidad(LocalDate date);
    boolean addReserva(Reserva reserva);
    List<Cliente> verClientes();
    boolean borrarCliente();
    boolean anyadirCliente(Cliente cliente);
    boolean modificarNombreCliente(String DNI, String nombre);
    boolean modificarContraseñaCliente(String DNI, String contraseña); //cambiar
    List<Reserva> listarReservasFecha(boolean ascendente);
    List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha);
    boolean isEmptyReservasList();
    boolean anyadirActividad(Actividad actividad);
    boolean borrarActividad(Actividad actividad);
    List<Actividad> listarActividad();
}

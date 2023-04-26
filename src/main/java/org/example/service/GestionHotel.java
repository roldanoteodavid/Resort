package org.example.service;

import org.example.dao.DaoHotel;
import org.example.dao.DaoHotelImplementacion;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class GestionHotel implements IGestionHotel {
    private final DaoHotel daoHotel;

    public GestionHotel() {
        daoHotel = new DaoHotelImplementacion();
    }

    public boolean anyadirHabitacion(Habitacion habitacion) {
        return daoHotel.anyadirHabitacion(habitacion);
    }

    public boolean borrarHabitacion(int numeroHab) {
        return daoHotel.borrarHabitacion(numeroHab);
    }

    public boolean comprobarDisponibilidad(LocalDate date) {
        return daoHotel.comprobarDisponibilidad(date);
    }

    public boolean addReserva(Reserva reserva) {
        return daoHotel.addReserva(reserva);
    }

    public List<Cliente> verClientes() {
        return daoHotel.verClientes();
    }

    public boolean borrarCliente() {
        return daoHotel.borrarCliente();
    }

    public boolean anyadirCliente(Cliente cliente) {
        return daoHotel.anyadirCliente(cliente);
    }

    public boolean modificarNombreCliente(String dni, String nombre) {
        return daoHotel.modificarNombreCliente(dni, nombre);
    }

    public boolean modificarContraseñaCliente(String dni, String contraseña) {
        return daoHotel.modificarContraseñaCliente(dni, contraseña);
    }

    ; //cambiar

    public List<Reserva> listarReservasFecha(boolean ascendente) {
        return daoHotel.listarReservasFecha(ascendente);
    }

    public List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha) {
        return daoHotel.listarHabitacionesOcupadas(fecha);
    }

    public boolean isEmptyReservasList() {
        return daoHotel.isEmptyReservasList();
    }

    public boolean anyadirActividad(Actividad actividad) {
        return daoHotel.anyadirActividad(actividad);
    }

    public boolean borrarActividad(Actividad actividad) {
        return daoHotel.borrarActividad(actividad);
    }

    public List<Actividad> listarActividad() {
        return daoHotel.listarActividad();
    }

}

package org.example.dao;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class DaoHotelImplementacion implements DaoHotel{
    protected final List<Cliente> clientes;

    public DaoHotelImplementacion(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public boolean anyadirHabitacion(Habitacion habitacion) {
        return false;
    }

    @Override
    public boolean borrarHabitacion(int numeroHab) {
        return false;
    }

    @Override
    public boolean comprobarDisponibilidad(LocalDate date) {
        return false;
    }

    @Override
    public boolean addReserva(Reserva reserva) {
        return false;
    }

    @Override
    public List<Cliente> verClientes() {
        return null;
    }

    @Override
    public boolean borrarCliente() {
        return false;
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarNombreCliente(String DNI, String nombre) {
        return false;
    }

    @Override
    public boolean modificarContraseñaCliente(String DNI, String contraseña) {
        return false;
    }

    @Override
    public List<Reserva> listarFecha(boolean ascendente) {
        return null;
    }

    @Override
    public List<Reserva> listarHabitacion(boolean ascendente) {
        return null;
    }

    @Override
    public boolean isEmptyReservasList() {
        return false;
    }

    @Override
    public boolean anyadirActividad(Actividad actividad) {
        return false;
    }

    @Override
    public boolean borrarActividad(Actividad actividad) {
        return false;
    }
}

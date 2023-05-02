package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public class DaoHotelImplementacion implements DaoHotel {
    protected final Hotel hotel;

    public DaoHotelImplementacion() {
        this.hotel = new Hotel();
    }
    public DaoHotelImplementacion(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public void setHotel(Hotel hotel) {

    }

    @Override
    public boolean anyadirHabitacion(Habitacion habitacion) {
        return hotel.getHabitaciones().add(habitacion);
    }

    @Override
    public boolean borrarHabitacion(int numeroHab) {
        Habitacion habitacion = hotel.getHabitaciones()
                .stream()
                .filter(h -> h.getNumero() == numeroHab)
                .findFirst()
                .orElse(null);
        return hotel.getHabitaciones().remove(habitacion);
    }

    @Override
    public boolean comprobarDisponibilidad(LocalDate date) {
        return false;
    }

    @Override
    public boolean addReserva(Reserva reserva, Cliente cliente) {
        return cliente.getReservas().add(reserva);
    }

    @Override
    public List<Cliente> verClientes() {
        return hotel.getClientes();
    }

    @Override
    public boolean borrarCliente(Cliente cliente) {
        return hotel.getClientes().remove(cliente);
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        return hotel.getClientes().add(cliente);
    }

    @Override
    public boolean modificarNombreCliente(String DNI, String nombre) {
        Cliente cliente= hotel.getClientes()
                .stream()
                .filter(c -> c.getDni().equals(DNI))
                .findFirst()
                .orElse(null);
        hotel.getClientes().remove(cliente);
        cliente.setNombre(nombre);
        return hotel.getClientes().add(cliente);
    }

    @Override
    public boolean modificarContrasenyaCliente(String DNI, String contrasenya) {
        Cliente cliente= hotel.getClientes()
                .stream()
                .filter(c -> c.getDni().equals(DNI))
                .findFirst()
                .orElse(null);
        hotel.getClientes().remove(cliente);
        cliente.setContrasenya(contrasenya);
        return hotel.getClientes().add(cliente);
    }

    @Override
    public List<Reserva> listarReservasFecha(boolean ascendente) {
        return null;
    }

    @Override
    public List<Habitacion> listarHabitacionesOcupadas(LocalDate fecha) {
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

    @Override
    public List<Actividad> listarActividad() {
        return null;
    }
}

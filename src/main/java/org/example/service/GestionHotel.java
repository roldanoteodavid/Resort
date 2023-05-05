package org.example.service;

import lombok.Data;
import org.example.dao.DaoHotel;
import org.example.dao.DaoHotelFicheros;
import org.example.dao.DaoHotelImplementacion;
import org.example.dao.DaoReservas;
import org.example.domain.*;

import java.time.LocalDate;
import java.util.List;

public class GestionHotel implements IGestionHotel {
    private final DaoHotel daoHotel;

    public GestionHotel(Hotel hotel) {
        daoHotel = new DaoHotelImplementacion(hotel);
    }

    public boolean anyadirHabitacion(Habitacion habitacion) {
        return daoHotel.anyadirHabitacion(habitacion);
    }

    public boolean borrarHabitacion(int numeroHab) {
        return daoHotel.borrarHabitacion(numeroHab);
    }

    public List<Habitacion> listarHabitaciones(boolean ascendente) {
        return daoHotel.listarHabitaciones(ascendente);
    }

    public boolean comprobarDisponibilidad(LocalDate date) {
        return daoHotel.comprobarDisponibilidad(date);
    }

    @Override
    public boolean addReserva(Reserva reserva, Cliente cliente) {
        return daoHotel.addReserva(reserva, cliente);
    }

    public boolean borrarCliente(String dni) {
        return daoHotel.borrarCliente(dni);
    }

    public boolean anyadirCliente(Cliente cliente) {
        return daoHotel.anyadirCliente(cliente);
    }

    public boolean modificarNombreCliente(String dni, String nombre) {
        return daoHotel.modificarNombreCliente(dni, nombre);
    }

    public List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente) {
        return daoHotel.listarReservasFecha(ascendente, cliente);
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

    public boolean borrarActividad(int id) {
        return daoHotel.borrarActividad(id);
    }

    public List<Actividad> listarActividades(boolean ascendente) {
        return daoHotel.listarActividad();
    }

    @Override
    public boolean escribirFicheroBinario() {
        return DaoHotelFicheros.escribirFicheroBinario(daoHotel.getHotel());
    }

    @Override
    public boolean cargarFicheroBinario() {
        boolean cargado = false;
        Hotel hotel = DaoHotelFicheros.leerFicheroBinario();
        if (hotel != null) {
            daoHotel.setHotel(hotel);
            cargado = true;
        }
        return cargado;
    }

}

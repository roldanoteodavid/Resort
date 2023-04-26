package org.example.service;

import org.example.dao.DaoReservas;
import org.example.dao.DaoReservasImplementacion;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class GestionReservas implements IGestionReservas{
    private final DaoReservas daoReservas;

    public GestionReservas() {
        this.daoReservas = new DaoReservasImplementacion();
    }
    public GestionReservas(Hotel hotel) {
        this.daoReservas = new DaoReservasImplementacion(hotel);
    }

    @Override
    public boolean iniciarSesion(String dni, String contrasenya) {
        return daoReservas.iniciarSesion(dni,contrasenya);
    }

    @Override
    public Cliente clientePorDni(String dni) {
        return daoReservas.clientePorDni(dni);
    }

    @Override
    public boolean addReserva(Cliente cliente, Reserva reserva) {
        return daoReservas.addReserva(cliente, reserva);
    }

    @Override
    public boolean modificarContraseña(String dni, String contraseña) {
        return daoReservas.modificarContraseña(dni, contraseña);
    }

    @Override
    public boolean cancelarReserva(int id) {
        return daoReservas.cancelarReserva(id);
    }

    @Override
    public boolean reservarActividad(Actividad actividad) {
        return daoReservas.reservarActividad(actividad);
    }

    @Override
    public boolean cancelarActividad(int id) {
        return daoReservas.cancelarActividad(id);
    }

    @Override
    public List<Reserva> verReservas(boolean ascendente) {
        return daoReservas.verReservas(ascendente);
    }

    @Override
    public boolean modificarReservaFecha(String dni, LocalDate fecha) {
        return false;
    }


}

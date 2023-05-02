package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public boolean modificarContrasenyaCliente(String DNI, String contrasenya) {
        return false;
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
        /*boolean hay = false;
        for (int i = 0; i < hotel.getClientes().size() && !hay; i++) {
            if (hotel.getClientes().get(i).getReservas()!=null)
               hay= true;
        }
        return hay;*/
        return hotel.getClientes().stream()
                .anyMatch(cliente -> cliente.getReservas() != null);
    }

    @Override
    public boolean anyadirActividad(Actividad actividad) {
        /*boolean anyadir = false;
        List<Actividad> actividades =hotel.getActividades();
        if (actividades.add(actividad))
            anyadir= true;
        hotel.setActividades(actividades);
        return anyadir;*/
        return Optional.ofNullable(hotel.getActividades())
                .map(lista -> {
                    boolean anyadir = lista.add(actividad);
                    hotel.setActividades(lista);
                    return anyadir;
                })
                .orElse(false);
    }

    @Override
    public boolean borrarActividad(Actividad actividad) {
        /*boolean borrar = false;
        List<Actividad> actividades =hotel.getActividades();
        if (actividades.remove(actividad)) {
            borrar= true;
        }
        hotel.setActividades(actividades);
        return borrar;*/
        return Optional.ofNullable(hotel.getActividades())
                .map(lista -> {
                    boolean borrar = lista.remove(actividad);
                    hotel.setActividades(lista);
                    return borrar;
                })
                .orElse(false);
    }

    @Override
    public List<Actividad> listarActividad() {
        /*List<Actividad> lista=hotel.getActividades();
        return lista;*/
        return Optional.ofNullable(hotel.getActividades())
                .orElse(Collections.emptyList());
    }
}

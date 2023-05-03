package org.example.dao;

import org.example.domain.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
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
    public List<Habitacion> verHabitaciones(boolean ascendente) {
        List<Habitacion> habitaciones= hotel.getHabitaciones();
        habitaciones.sort((Comparator<? super Habitacion>) habitaciones);
        if (!ascendente)
            ((Comparator<?>) habitaciones).reversed();
        return habitaciones;
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


    public List<Reserva> listarReservasFecha(boolean ascendente, Cliente cliente) {
        List<Reserva> reservas = cliente.getReservas();

        Comparator<Reserva> comparator = new Comparator<Reserva>() {
            @Override
            public int compare(Reserva r1, Reserva r2) {
                int numero;
                if (ascendente) {
                    numero= r1.getEntrada().compareTo(r2.getEntrada());
                } else {
                   numero= r2.getEntrada().compareTo(r1.getEntrada());
                }
                return numero;
            }
        };

        Collections.sort(reservas, comparator);

        return reservas;
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

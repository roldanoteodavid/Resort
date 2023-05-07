package org.example.dao;

import lombok.Data;
import org.example.domain.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
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
    public List<Habitacion> listarHabitaciones(boolean ascendente) {
        List<Habitacion> habitaciones = hotel.getHabitaciones();
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
    public boolean addReserva(Reserva reserva, String dni) {
        /*boolean hecho = false;
        for (int ç = 0; ç < hotel.getClientes().size(); ç++) {
            if (hotel.getClientes().get(ç).getDni().equalsIgnoreCase(dni)){
                hecho= true;
                List<Reserva> reservas= hotel.getClientes().get(ç).getReservas();
                reservas.add(reserva);
                hotel.getClientes().get(ç).setReservas(reservas);
            }
        }
        return hecho*/
        return hotel.getClientes().stream()
                .filter(cliente -> cliente.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .map(cliente -> {
                    List<Reserva> reservas = cliente.getReservas();
                    reservas.add(reserva);
                    cliente.setReservas(reservas);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<Cliente> verClientes(boolean ascendente) {
        List<Cliente> lista2;
        lista2 = this.hotel.getClientes();
        Collections.sort(lista2);
        if (!ascendente) {
            Collections.reverse(lista2);
        }
        return lista2;
    }

    /*        List<Cliente> clientes= hotel.getClientes();
            clientes.sort((Comparator<? super Cliente>) clientes);
            if (!ascendente)
                ((Comparator<?>) clientes).reversed();
            return clientes;
        }
    */
    @Override
    public boolean borrarCliente(String dni) {
        return hotel.getClientes().removeIf(cliente -> (dni).equalsIgnoreCase(cliente.getDni()));
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        return hotel.getClientes().add(cliente);
    }



    @Override
    public boolean modificarNombreCliente(String DNI, String nombre) {
        Cliente cliente = hotel.getClientes()
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
        Cliente cliente = hotel.getClientes()
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
                    numero = r1.getEntrada().compareTo(r2.getEntrada());
                } else {
                    numero = r2.getEntrada().compareTo(r1.getEntrada());
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
    public boolean borrarActividad(int id) {
        /*boolean borrar = false;
        List<Actividad> actividades =hotel.getActividades();
        for (int i = 0; i < actividades.size(); i++) {
            if (((Integer) id).equals(actividades.get(i).getId())) {
                actividades.remove(actividades.get(i));
                borrar= true;
            }
        }
        hotel.setActividades(actividades);
        return borrar;*/
        return hotel.getActividades()
                .removeIf(actividad -> ((Integer) id).equals(actividad.getId()));
    }

    @Override
    public List<Actividad> listarActividad() {
        return Optional.ofNullable(hotel.getActividades())
                .orElse(Collections.emptyList());
    }
}

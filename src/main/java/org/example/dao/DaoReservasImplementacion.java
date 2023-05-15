package org.example.dao;

import lombok.Data;
import org.example.domain.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public @Data class DaoReservasImplementacion implements DaoReservas {
    protected final Hotel hotel;

    public DaoReservasImplementacion() {
        this.hotel = new Hotel();
    }

    public DaoReservasImplementacion(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public void setHotel(Hotel hotel1) {
        //new DaoReservasImplementacion(hotel1);
        //pa que queremos meter un hotel?;
    }

    @Override
    public boolean anyadirCliente(Cliente cliente) {
        return hotel.getClientes().add(cliente);
    }

    @Override
    public boolean iniciarSesion(String dni, String contrasenya) {
        /*
        boolean inicio = false;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (hotel.getClientes().get(i).getDni().equalsIgnoreCase(dni)){
                if (hotel.getClientes().get(i).getContrasenya().equalsIgnoreCase(contrasenya)){
                    inicio = true;
                }
            }
        }
        return inicio;*/
        return hotel.getClientes().stream()
                .anyMatch(cliente -> cliente.getDni().equalsIgnoreCase(dni)
                        && cliente.getContrasenya().equalsIgnoreCase(contrasenya));
    }

    @Override
    public boolean addReserva(Cliente cliente, Reserva reserva) {
        return cliente.anyadirreserva(reserva);
    }

    @Override
    public boolean modificarContrasenya(String dni, String contrasenya) {
        /*Cliente cambio=null;
        boolean hecho=false;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (dni.equalsIgnoreCase(hotel.getClientes().get(i).getDni())){
                cambio=hotel.getClientes().get(i);
            }
        }
        if (cambio!=null){
            cambio.setContrasenya(contrasenya);
            hecho=true;
        }

        return hecho;*/
        Optional<Cliente> cambio = hotel.getClientes().stream()
                .filter(cliente -> dni.equalsIgnoreCase(cliente.getDni()))
                .findFirst();

        if (cambio.isPresent()) {
            cambio.get().setContrasenya(contrasenya);
            return true;
        }

        return false;
    }

    @Override
    public List<Actividad> verMisActividades(Cliente cliente, boolean ascendente) {
        List<Actividad> actividades = cliente.getActividades();
        Collections.sort(actividades);
        if (!ascendente)
            Collections.reverse(actividades);
        return actividades;
    }

    @Override
    public List<Actividad> listarActividades(boolean ascendente) {
        List<Actividad> lista2;
        lista2 = this.hotel.getActividades();
        Collections.sort(lista2);
        if (!ascendente) {
            Collections.reverse(lista2);
        }
        return lista2;
    }

    @Override
    public boolean cancelarReserva(int id, Cliente cliente) {
        return cliente.getReservas().stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .map(r -> {
                    cliente.getReservas().remove(r);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean reservarActividad(int id, Cliente cliente) {
        boolean hecho = false;
        Actividad actividad = null;
        for (int i = 0; i < hotel.getActividades().size(); i++) {
            if (((Integer) id).equals(hotel.getActividades().get(i).getId())) {
                actividad = hotel.getActividades().get(i);
            }
        }
        if (actividad != null) {
            cliente.getActividades().add(actividad);
            hecho = true;
        }
        return hecho;
    }

    @Override
    public boolean cancelarActividad(int id, Cliente cliente) {
        /*boolean hecho = false;
        List<Actividad> actividades = hotel.getActividades();
        for (int i = 0; i < hotel.getActividades().size(); i++) {
            if (((Integer) id).equals(hotel.getActividades().get(i).getId())) {
                hotel.getActividades().remove(hotel.getActividades().get(i));
            }
        }
        return hecho;*/
        List<Actividad> actividades = cliente.getActividades();
        boolean hecho = actividades.removeIf(a -> ((Integer) id).equals(a.getId()));
        if (hecho) {
            cliente.setActividades(actividades);
        }
        return hecho;
    }

    @Override
    public List<Reserva> verReservas(boolean ascendente, Cliente cliente) {
        List<Reserva> reservas = cliente.getReservas();
        Collections.sort(reservas);
        if (!ascendente)
            Collections.reverse(reservas);
        return reservas;
    }

    @Override
    public Cliente clientePorDni(String dni) {
        /*Cliente cliente = null;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (hotel.getClientes().get(i).equals(dni)){
                cliente = hotel.getClientes().get(i);
            }
        }
        return cliente;*/
        return hotel.getClientes().stream()
                .filter(cliente -> cliente.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }


    @Override
    public boolean moficarReservaFecha(int id, LocalDate entrada, LocalDate salida, Cliente cliente) {
        return cliente.getReservas().stream()
                .filter(r -> r.getId() == id)
                .map(r -> {
                    r.setEntrada(entrada);
                    r.setSalida(salida);
                    return true;
                })
                .findFirst()
                .orElse(false);
        /*boolean hecho = false;
        for (int i = 0; i < cliente.getReservas().size(); i++) {
            if (cliente.getReservas().get(i).getId()==id){
                cliente.getReservas().get(i).setEntrada(entrada);
                cliente.getReservas().get(i).setSalida(salida);
                hecho = true;
            }
        }
        return hecho;*/
    }

    @Override
    public List<Habitacion> obtenerHabitaciones(LocalDate entrada, LocalDate salida) {
        List<Habitacion> disponibles = null;
        for (int i = 0; i < hotel.getHabitaciones().size(); i++) {
            if (!hotel.getHabitaciones().get(i).estanOcupadas(entrada, salida))
                disponibles.add(hotel.getHabitaciones().get(i));
        }
        return disponibles;
    }

    @Override
    public int obtenerCosto(Reserva reserva) {
        List<Integer> aux = reserva.getHabitacion();
        LocalDate entrada = reserva.getEntrada();
        LocalDate salida = reserva.getSalida();
        int costo = 0;
        int dias = (int) ChronoUnit.DAYS.between(salida, entrada);
        for (int i = 0; i < aux.size(); i++) {
            for (int j = 0; j < hotel.getHabitaciones().size(); j++) {
                if (hotel.getHabitaciones().get(j).getNumero() == aux.get(i)) {
                    costo = costo + (hotel.getHabitaciones().get(j).getPrecio() * dias);
                    j = hotel.getHabitaciones().size();
                }
            }
        }
        return costo;
    }
}

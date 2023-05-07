package org.example.dao;

import lombok.Data;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public boolean cancelarReserva(int id) {
        /*boolean eliminar= false;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (hotel.getClientes().get(i).getReservas()!=null)
                for (int j = 0; j < hotel.getClientes().get(i).getReservas().size(); j++) {
                    if (((Integer) id).equals(hotel.getClientes().get(i).getReservas().get(j).getId())){
                    hotel.getClientes().get(i).getReservas().remove(j);
                    eliminar=true;
                    }
                }
        }
        return eliminar;*/
        boolean eliminar = hotel.getClientes().stream()
                .filter(cliente -> cliente.getReservas() != null)
                .flatMap(cliente -> cliente.getReservas().stream())
                .anyMatch(reserva -> Objects.equals(reserva.getId(),id));

        if (eliminar) {
            hotel.getClientes().forEach(cliente -> {
                if (cliente.getReservas() != null) {
                    cliente.getReservas().removeIf(reserva -> Objects.equals(reserva.getId(),id));
                }
            });
        }
        return eliminar;
    }

    @Override
    public boolean reservarActividad(int id, LocalDate entrada, LocalDate salida, Cliente cliente) {
        boolean hecho= false;
        //LocalDate entrada= null;
        //LocalDate salida= null;
        Actividad actividad= null;
        for (int i = 0; i < hotel.getActividades().size(); i++) {
            if(((Integer) id).equals(hotel.getActividades().get(i).getId())){
               actividad= hotel.getActividades().get(i);
            }
        }
        if (actividad.Disponible(cliente,entrada,salida)){
            cliente.getActividades().add(actividad);
            hecho=true;
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
    public List<Reserva> verReservas(boolean ascendente) {
        /*List<Reserva> reservas = null;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (hotel.getClientes().get(i).getReservas()!=null){
                for (int j = 0; j < hotel.getClientes().get(i).getReservas().size(); j++) {
                    reservas.add(hotel.getClientes().get(i).getReservas().get(j));
                }
            }
        }
        return reservas;*/
        List<Reserva> reservas = hotel.getClientes().stream()
                .flatMap(cliente -> cliente.getReservas() != null ? cliente.getReservas().stream() : Stream.empty())
                .collect(Collectors.toList());
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
    public boolean moficarReservaFecha(int id, LocalDate entrada, LocalDate salida) { // Hacemos otra de fecha?
        /*boolean hecho= false;
        for (int i = 0; i < hotel.getClientes().size(); i++) {
            if (hotel.getClientes().get(i).getReservas()!=null){
                for (int j = 0; j < hotel.getClientes().get(i).getReservas().size() && !hecho; j++) {
                    if (((Integer) id).equals(hotel.getClientes().get(i).getReservas().get(j).getId())){
                        hotel.getClientes().get(i).getReservas().get(j).setInquilinos(inquilinos);
                        hecho= true;
                    }
                }
            }
        }
        return hecho;*/
        boolean hecho = hotel.getClientes().stream()
                .filter(cliente -> cliente.getReservas() != null)
                .flatMap(cliente -> cliente.getReservas().stream())
                .filter(reserva -> ((Integer) reserva.getId()).equals(Integer.valueOf(id)))
                .findFirst()
                .map(reserva -> {
                    reserva.setEntrada(entrada);
                    reserva.setSalida(salida);
                    return true;
                })
                .orElse(false);
        return hecho;
    }

}

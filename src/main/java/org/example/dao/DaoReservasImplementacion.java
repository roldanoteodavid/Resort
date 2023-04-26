package org.example.dao;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class DaoReservasImplementacion implements DaoReservas {
    protected final Hotel hotel;

    public DaoReservasImplementacion() {
        this.hotel = new Hotel();
    }

    public DaoReservasImplementacion(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Hotel getHotel() {
        return null;
    }

    @Override
    public void setHotel(Hotel hotel) {

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
        /*
        List<Cliente> clientes=hotel.getClientes();
        Cliente cambio=null;
        boolean hecho=false;
        for (int i = 0; i < clientes.size(); i++) {
            if (dni.equalsIgnoreCase(clientes.get(i).getDni())){
                cambio=clientes.get(i);
            }
        }
        if (cambio!=null){
            cambio.setContraseña(contraseña);
        }*/

        return false;
    }

    @Override
    public boolean cancelarReserva(int id) {
        return false;
    }

    @Override
    public boolean reservarActividad(Actividad actividad) {
        return false;
    }

    @Override
    public boolean cancelarActividad(int id) {
        return false;
    }

    @Override
    public List<Reserva> verReservas(boolean ascendente) {
        return null;
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
    public boolean moficarReservaFecha(int id, int inquilinos) {
        return false;
    }

}

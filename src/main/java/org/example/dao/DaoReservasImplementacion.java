package org.example.dao;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class DaoReservasImplementacion implements DaoReservas{
    protected final Hotel hotel;

    public DaoReservasImplementacion() {
        this.hotel = new Hotel();
    }

    @Override
    public boolean addReserva(Cliente cliente, Reserva reserva) {
        return cliente.anyadirreserva(reserva);
    }

    @Override
    public boolean modificarContraseña(String dni, String contraseña) {
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
    public boolean moficarReservaFecha(int id, int inquilinos) {
        return false;
    }

}

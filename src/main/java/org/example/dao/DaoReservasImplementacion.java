package org.example.dao;

import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;

import java.time.LocalDate;
import java.util.List;

public class DaoReservasImplementacion implements DaoReservas{

    @Override
    public boolean addReserva(Reserva reserva) {
        return false;
    }

    @Override
    public boolean modificarCliente(String DNI) {
        return false;
    }
}

package org.example.dao;

import org.example.domain.*;

import java.util.List;

public interface DaoReservas {
    boolean addReserva(Reserva reserva);
    boolean modificarCliente(String DNI);

}

package org.example.domain;

import lombok.Data;

import java.util.List;

public @Data class Hotel {
    private List<Actividad> actividades;
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    public boolean anyadirActividad(Actividad actividad){
        return actividades.add(actividad);
    }
    public boolean anyadirHabitacion(Habitacion habitacion){
        return habitaciones.add(habitacion);
    }
    public boolean anyadirCliente(Cliente cliente){
        return clientes.add(cliente);
    }

}

package org.example.domain;

import lombok.Data;
import org.example.common.Comprobacion;
import org.example.common.TipoException;

import java.time.LocalDate;
import java.util.List;

public @Data class Habitacion implements Comparable<Habitacion>{
    private int numero;
    private int capacidad;
    private int precio;
    private String tipo;
    private List<LocalDate> fechasocupadas;

    public Habitacion(int numero, int capacidad, int precio, String tipo) throws TipoException {
        this.numero = numero;
        this.capacidad = capacidad;
        this.precio = precio;
        Comprobacion.tipoOk(tipo);
        this.tipo = tipo;
    }

    public Habitacion(int numero, int capacidad, String tipo) throws TipoException{
        this.numero = numero;
        this.capacidad = capacidad;
        Comprobacion.tipoOk(tipo);
        this.tipo = tipo;
    }
}

package org.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public @Data class Reserva implements Serializable {
    private int id;
    private LocalDate entrada;
    private LocalDate salida;
    private String dnicliente;
    private int costo;
    private int inquilinos;
    private Habitacion habitacion;

    public Reserva(LocalDate entrada, LocalDate salida, String dnicliente, int costo, int inquilinos, Habitacion habitacion) {
        this.entrada = entrada;
        this.salida = salida;
        this.dnicliente = dnicliente;
        this.costo = costo;
        this.inquilinos = inquilinos;
        this.habitacion = habitacion;
    }

    public Reserva(LocalDate entrada, LocalDate salida, String dnicliente, int inquilinos) {
        this.entrada = entrada;
        this.salida = salida;
        this.dnicliente = dnicliente;
        this.inquilinos = inquilinos;
    }


}

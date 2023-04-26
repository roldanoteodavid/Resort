package org.example.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class Reserva {
    private int id;
    private LocalDate entrada;
    private LocalDate salida;
    private String dnicliente;
    private int costo;
    private int inquilinos;
    private List<Integer> habitaciones;

    public Reserva(LocalDate entrada, LocalDate salida, String dnicliente, int costo, int inquilinos, List<Integer> habitaciones) {
        this.entrada = entrada;
        this.salida = salida;
        this.dnicliente = dnicliente;
        this.costo = costo;
        this.inquilinos = inquilinos;
        this.habitaciones = habitaciones;
    }
}

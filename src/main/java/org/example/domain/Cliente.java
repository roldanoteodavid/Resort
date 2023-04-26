package org.example.domain;

import lombok.Data;
import org.example.common.AlFrancesException;
import org.example.common.Comprobacion;

import java.time.LocalDate;
import java.util.List;

public @Data class Cliente {
    private String dni;
    private String nombre;
    private LocalDate nacimiento;
    private String telefono;
    private List<Reserva> reservas;
    private String pais;
    private String contrasenya;
    public Cliente() {
        nacimiento = LocalDate.of(2001, 12, 31);
    }

    public Cliente(String dni, String nombre, LocalDate nacimiento, String telefono, List<Reserva> reservas, String pais, String contrasenya) throws AlFrancesException{
        this.dni = dni;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.reservas = reservas;
        Comprobacion.alFrances(pais);
        this.pais = pais;
        this.contrasenya = contrasenya;
    }

    public Cliente(String nombre, String pais) throws AlFrancesException{
        this.dni = "123213";
        this.nombre = nombre;
        nacimiento = LocalDate.of(2001, 12, 31);
        this.telefono = telefono;
        Comprobacion.alFrances(pais);
        this.pais = pais;
    }

    public boolean anyadirreserva(Reserva reserva){
        return reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", telefono='" + telefono + '\'' +
                ", reservas=" + reservas +
                ", pais='" + pais + '\'' +
                '}';
    }
}

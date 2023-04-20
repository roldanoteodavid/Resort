package org.example.domain;

import lombok.Data;
import org.example.common.Comprobacion;
import org.example.common.LugarException;

import java.time.LocalDate;
import java.util.List;

public @Data class Actividad {
    private int id;
    private String nombre;
    private String lugar;
    private double precio;
    private List<LocalDate> fechas;

    public Actividad(int id,String nombre,String lugar,double precio) throws LugarException {
        this.id=id;
        this.nombre=nombre;
        Comprobacion.lugarOk(lugar);
        this.lugar=lugar;
        this.precio=precio;
    }
    public Actividad(int id,String nombre,String lugar) throws LugarException {
        this.id=id;
        this.nombre=nombre;
        Comprobacion.lugarOk(lugar);
        this.lugar=lugar;
    }
}

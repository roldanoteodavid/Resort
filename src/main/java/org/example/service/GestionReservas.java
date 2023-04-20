package org.example.service;

import org.example.dao.DaoReservas;
import org.example.dao.DaoReservasImplementacion;

public class GestionReservas implements IGestionReservas{
    private final DaoReservas daoReservas;

    public GestionReservas() {
        this.daoReservas = new DaoReservasImplementacion();
    }
}

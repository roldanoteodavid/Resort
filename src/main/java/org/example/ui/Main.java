package org.example.ui;

import org.example.common.AlFrancesException;
import org.example.domain.Cliente;
import org.example.domain.Reserva;

public class Main {
    public static void main(String[] args) {
        try {
            Cliente frances = new Cliente("1021312", "Francia");
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
    }
}
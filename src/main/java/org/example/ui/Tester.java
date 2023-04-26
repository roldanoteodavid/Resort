package org.example.ui;
import org.example.common.AlFrancesException;
import org.example.common.Constantes;
import org.example.common.LugarException;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Reserva;
import org.example.service.GestionHotel;

public class Tester {
    public static void main(String[] args) {
        Cliente frances = null;
        try {
            frances = new Cliente("1021312", "Francia");
            System.out.println(frances.toString());
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
        try {
            Actividad actividad = new Actividad(12312, "Test", "prueba", 22);
            System.out.println(actividad);
        } catch (LugarException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}

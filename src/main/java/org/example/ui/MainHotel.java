package org.example.ui;

import org.example.common.Constantes;
import org.example.dao.DaoHotelFicheros;

import java.io.IOException;
import java.util.Scanner;

public class MainHotel {

    public void main() {
        Scanner teclado = new Scanner(System.in);
        try {
            DaoHotelFicheros.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean fin = false;
        do {
            System.out.println("Introduzca 1 si eres administrador o 2 si eres administrador.");
            switch (teclado.nextInt()) {
                case 1:
                    GestionarClientes clientes = new GestionarClientes();
                    clientes.gestion();
                    break;
                case 2:
                    GestionarHotel hotel = new GestionarHotel();
                    hotel.gestion();
                case 3:
                    fin = true;
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (!fin);
    }


}

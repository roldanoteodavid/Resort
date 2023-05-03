package org.example.ui;

import org.example.common.Constantes;
import org.example.dao.DaoHotelFicheros;

import java.io.IOException;
import java.util.InputMismatchException;
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
            System.out.println("Introduzca 1 si eres cliente o 2 si eres administrador.");
            try {
                int respuesta = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un numero");
                fin = true;
            }
            switch (teclado.nextInt()) {
                case 1:
                    GestionarClientes clientes = new GestionarClientes();
                    clientes.gestion();
                    break;
                case 2:
                    GestionarHotel hotel = new GestionarHotel();
                    hotel.gestion();
                    break;
                case 3:
                    fin = true;
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (!fin);
    }


}

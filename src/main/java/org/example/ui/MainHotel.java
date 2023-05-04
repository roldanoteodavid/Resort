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
        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
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
    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca 1 si eres cliente o 2 si eres administrador.");
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                //System.out.println(Constantes.INTRODUCE_NÚMERO);
                num = teclado.nextInt();
                vuelve = true;
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println("Tienes que introducir un número, no una letra");
                System.out.println(exception.getMessage());
                teclado.nextLine();
            }
        }
        return num;
    }


}

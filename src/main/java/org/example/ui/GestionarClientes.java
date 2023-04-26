package org.example.ui;

import org.example.service.GestionHotel;
import org.example.service.GestionReservas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionarClientes {
    public static void gestion(){
        Scanner teclado = new Scanner(System.in);
        GestionReservas gestionReservas = new GestionReservas();

    }
    public static int mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        //System.out.println(Constantes.MENU + "\n" + Constantes.OPCION1 + "\n" + Constantes.OPCION2 + "\n" + Constantes.OPCION3 + "\n" + Constantes.OPCION4 + "\n" + Constantes.OPCION5);
        boolean vuelve = false;
        int num = 0;
        while (!vuelve) {
            try {
                System.out.println("Introduce número");
                num = teclado.nextInt();
                vuelve = true;
                //has metido un número!!
            } catch (InputMismatchException exception) {
                System.out.println("Tienes que introducir un número, no una letra.");
                System.out.println(exception.getMessage());
                teclado.nextLine();
            }
        }
        return num;
    }
}

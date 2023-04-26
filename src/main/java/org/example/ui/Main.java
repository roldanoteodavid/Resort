package org.example.ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean fin = false;
        do {
            System.out.println("Introduzca 1 si eres administradocr o 2 si eres administrador.");
            switch (teclado.nextInt()) {
                case 1 -> GestionarClientes.gestion();
                case 2 -> GestionarHotel.gestion();
                case 3 -> fin = true;
                default -> System.out.println("Introduzca una opción válida.");
            }
        } while (!fin);
    }
}
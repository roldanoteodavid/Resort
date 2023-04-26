package org.example.ui;

import org.example.common.Constantes;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Hotel;
import org.example.service.GestionHotel;
import org.example.service.IGestionHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionarHotel {
    private static final String pass = "2223";
    private final IGestionHotel serviciosHotel;

    public GestionarHotel() {
        this.serviciosHotel = new GestionHotel(DaoHotelFicheros.leerFicheroBinario());
    }
    public void gestion(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca contraseña.");
        if (teclado.nextLine().equals(pass)) {
            System.out.println("Contraseña correcta.");
            int opcion = 0;
            do {
                opcion = mostrarMenu();
                switch (opcion) {

                    case 1:
                        //listarOrdenados(gestionElementos);
                        break;
                    case 2:
                        //
                        break;
                    case 3:
                        //modificarElemento(gestionElementos);
                        break;
                    case 4:
                        //eliminarElemento(gestionElementos);
                        break;
                    case 5:
                        System.out.println("Ha elegido salir.");
                        break;
                    default:
                        System.out.println("Introduzca una opción válida.");
                }

            } while (opcion != 5);
        } else {
            System.out.println("Contraseña incorrecta.");
        }
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

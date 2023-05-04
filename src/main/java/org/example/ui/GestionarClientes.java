package org.example.ui;

import com.sun.source.tree.IfTree;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Cliente;
import org.example.service.GestionHotel;
import org.example.service.GestionReservas;
import org.example.service.IGestionHotel;
import org.example.service.IGestionReservas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionarClientes {
    private final IGestionReservas serviciosReservas;
    private Cliente cliente;

    public GestionarClientes() {
        this.serviciosReservas = new GestionReservas(DaoHotelFicheros.leerFicheroBinario());
    }

    public void gestion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca su usuario");
        String dni = teclado.nextLine();
        System.out.println("Introduzca la contraseña");
        if (serviciosReservas.iniciarSesion(dni,teclado.nextLine())) {
            System.out.println("Acceso concedido.");
            cliente = serviciosReservas.clientePorDni(dni);
            int opcion = 0;
            do {
                opcion = mostrarMenu();
                switch (opcion) {
                    case 1:
                        anyadirReserva();
                        break;
                    case 2:
                        modificarContrasenya();
                        break;
                    case 3:
                        cancelarReserva();
                        break;
                    case 4:
                        //reservarActividad();
                        break;
                    case 5:
                        //verClientes();
                        break;
                    case 6:
                        //comprobarDisponibilidad();
                        break;
                    case 7:
                        //comprobarDisponibilidad();
                        break;
                    case 8:
                        //comprobarDisponibilidad();
                        break;
                    case 9:
                        //comprobarDisponibilidad();
                        break;
                    case 10:
                        System.out.println("Ha elegido salir.");
                        break;
                    default:
                        System.out.println("Introduzca una opción válida.");
                }

            } while (opcion != 10);
        } else {
            System.out.println("Contraseña o usuario incorrectos.");
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

    public void anyadirReserva(){
        System.out.println("Introduce el id");
        //serviciosReservas.addReserva(cliente,)
    }

    public static void modificarContrasenya(){

    }

    public static void cancelarReserva(){

    }

}

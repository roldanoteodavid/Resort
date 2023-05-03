package org.example.ui;

import org.example.common.Constantes;
import org.example.common.LugarException;
import org.example.common.TipoException;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Actividad;
import org.example.domain.Habitacion;
import org.example.domain.Hotel;
import org.example.service.GestionHotel;
import org.example.service.IGestionHotel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionarHotel {
    private static final String pass = "2223";
    private final IGestionHotel serviciosHotel;

    public GestionarHotel() {
        this.serviciosHotel = new GestionHotel(DaoHotelFicheros.leerFicheroBinario());
    }

    public void gestion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca contraseña.");
        if (teclado.nextLine().equals(pass)) {
            System.out.println("Contraseña correcta.");
            int opcion = 0;
            do {
                opcion = mostrarMenu();
                switch (opcion) {
                    case 1:
                        listarHabitaciones();
                        break;
                    case 2:
                        anyadirHabitacion();
                        break;
                    case 3:
                        borrarHabitacion();
                        break;
                    case 4:
                        comprobarDisponibilidad();
                        break;
                    case 5:
                        verClientes();
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

    public static void listarHabitaciones() {

    }

    public void anyadirHabitacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el número de habitación.");
        int numero = teclado.nextInt();
        System.out.println("Introduzca la capacidad de la habitación.");
        int capacidad = teclado.nextInt();
        System.out.println("Introduzca el tipo de habitación.");
        String tipo = teclado.next();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(numero, capacidad, tipo);
            if (this.serviciosHotel.anyadirHabitacion(habitacion)) {
                System.out.println("Añadida.");
            } else {
                System.out.println("Error al añadir la habitación.");
            }
        } catch (TipoException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public void borrarHabitacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el número de la habitación que desea borrar.");
        if (serviciosHotel.borrarHabitacion(teclado.nextInt())) {
            System.out.println("Habitación borrada.");
        } else {
            System.out.println("Error al eliminar la habitación.");
        }

    }

    public void comprobarDisponibilidad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el día.");
        int dia = teclado.nextInt();
        System.out.println("Introduzca el mes.");
        int mes = teclado.nextInt();
        System.out.println("Introduzca el año.");
        int anyo = teclado.nextInt();
        serviciosHotel.comprobarDisponibilidad(LocalDate.of(dia, mes, anyo));
    }

    public void verClientes() {
        //Scanner teclado = new Scanner(System.in);
        System.out.println(serviciosHotel.verClientes());
    }

    public void borrarCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el dni del cliente que desea borrar.");
        if (serviciosHotel.borrarCliente(teclado.nextInt())) {
            System.out.println("Cliente borrado");
        }else {
            System.out.println("Error al eliminar el cliente.");
        }
    }
    public void anyadirActividad(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el id de la actividad");
        int id = teclado.nextInt();
        System.out.println("Introduzca el nombre de la actividad");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca el lugar donde se va  arealizar la actividad.");
        String lugar = teclado.nextLine();
        System.out.println("Introduzca el precio de la actividad.");
        int precio = teclado.nextInt();
        try {
            if (serviciosHotel.anyadirActividad(new Actividad(id, nombre, lugar, precio))){
                System.out.println("Actividad añadida.");
            }else {
                System.out.println("Error al añadir la actividad.");
            }
        } catch (LugarException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}

package org.example.ui;

import org.example.common.AlFrancesException;
import org.example.common.LugarException;
import org.example.common.TipoException;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Habitacion;
import org.example.service.GestionHotel;
import org.example.service.IGestionHotel;

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
                System.out.println("Introduzca 1 para gestionar los clientes, 2 para gestionar habitaciones y 3 para las actividades.");
                opcion = mostrarMenu();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca 1 para ver la lista de clientes, 2 para añadir un cliente, 3 para borrar un cliente y 4 para salir.");
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verClientes();
                                break;
                            case 2:
                                anyadirCliente();
                                break;
                            case 3:
                                borrarCliente();
                                break;
                            case 4:
                                System.out.println("Ha elegido salir.");
                                DaoHotelFicheros.escribirFicheroBinario(serviciosHotel.getHotel());
                                break;
                            default:
                                System.out.println("Introduzca una opción válida.");
                        }
                    case 2:
                        System.out.println("Introduzca 1 para ver la lista de habitaciones, 2 para añadir una habitación, 3 para borrar una habitación, 4 para comprobar la disponibilidad y 5 para salir.");
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verHabitaciones();
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
                                System.out.println("Ha elegido salir.");
                                break;
                            default:
                                System.out.println("Introduzca una opción válida.");
                        }
                        anyadirHabitacion();
                        break;
                    case 3:
                        System.out.println("Introduzca 1 para ver la lista de actividades, 2 para añadir una actividad, 3 para borrar una actividad, 4 para salir.");
                        opcion = mostrarMenu();
                        switch (opcion) {
                            case 1:
                                verActividades();
                                break;
                            case 2:
                                anyadirActividad();
                                break;
                            case 3:
                                borrarActividad();
                                break;
                            case 4:
                                System.out.println("Ha elegido salir.");
                                break;
                            default:
                                System.out.println("Introduzca una opción válida.");
                        }
                        break;
                    case 4:
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

    public void anyadirHabitacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el número de habitación.");
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduzca la capacidad de la habitación.");
        int capacidad = teclado.nextInt();
        teclado.nextLine();
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
        teclado.nextLine();
    }

    public void comprobarDisponibilidad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el día.");
        int dia = teclado.nextInt();
        System.out.println("Introduzca el mes.");
        int mes = teclado.nextInt();
        System.out.println("Introduzca el año.");
        int anyo = teclado.nextInt();
        teclado.nextLine();
        serviciosHotel.comprobarDisponibilidad(LocalDate.of(dia, mes, anyo));
    }

    public void verClientes() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println("Introduzca 1 si desea ver la lista ascendente o 2 para descendente.");
        if (teclado.nextInt() == 1) {
            ascendente = true;
        } else if (teclado.nextInt() == 2) {
            ascendente = false;
        }
        teclado.nextLine();
        System.out.println(serviciosHotel.verClientes(ascendente));
    }

    public void borrarCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el dni del cliente que desea borrar.");
        if (serviciosHotel.borrarCliente(teclado.nextLine())) {
            System.out.println("Cliente borrado");
        } else {
            System.out.println("Error al eliminar el cliente.");
        }
    }

    public void anyadirActividad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el id de la actividad");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduzca el nombre de la actividad");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca el lugar donde se va  arealizar la actividad.");
        String lugar = teclado.nextLine();
        System.out.println("Introduzca el precio de la actividad.");
        int precio = teclado.nextInt();
        teclado.nextLine();
        try {
            if (serviciosHotel.anyadirActividad(new Actividad(id, nombre, lugar, precio))) {
                System.out.println("Actividad añadida.");
            } else {
                System.out.println("Error al añadir la actividad.");
            }
        } catch (LugarException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public void borrarActividad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el id de la actividad que desea borrar");
        if (serviciosHotel.borrarActividad(teclado.nextInt())) {
            System.out.println("Actividad borrada.");
        } else {
            System.out.println("Error al eliminar la actividad.");
        }
        teclado.nextLine();
    }

    public void anyadirCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el dni del cliente.");
        String dni = teclado.nextLine();
        System.out.println("Introduzca el nombre del cliente.");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca el teléfono del cliente.");
        String telefono = teclado.nextLine();
        System.out.println("Introduzca la contraseña del cliente.");
        String contrasenya = teclado.nextLine();
        System.out.println("Introduzca el país del cliente.");
        String pais = teclado.nextLine();
        System.out.println("Introduzca el día de nacimiento del cliente.");
        int dia = teclado.nextInt();
        System.out.println("Introduzca el mes de nacimiento del cliente.");
        int mes = teclado.nextInt();
        System.out.println("Introduzca el año de nacimiento del cliente.");
        int anyo = teclado.nextInt();
        teclado.nextLine();
        try {
            Cliente cliente = new Cliente(dni, nombre, LocalDate.of(anyo, mes, dia), telefono, pais, contrasenya);
            if (serviciosHotel.anyadirCliente(cliente)) {
                System.out.println("Cliente añadido.");
            } else {
                System.out.println("Error al añadir el cliente.");
            }
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public void verHabitaciones() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println("Introduzca 1 si desea ver la lista ascendente o 2 para descendente.");
        if (teclado.nextInt() == 1) {
            ascendente = true;
        } else if (teclado.nextInt() == 2) {
            ascendente = false;
        }
        teclado.nextLine();
        System.out.println(serviciosHotel.listarHabitaciones(ascendente));
    }

    public void verActividades() {
        Scanner teclado = new Scanner(System.in);
        boolean ascendente = true;
        System.out.println("Introduzca 1 si desea ver la lista ascendente o 2 para descendente.");
        if (teclado.nextInt() == 1) {
            ascendente = true;
        } else if (teclado.nextInt() == 2) {
            ascendente = false;
        }
        teclado.nextLine();
        System.out.println(serviciosHotel.listarActividades(ascendente));
    }
}

package org.example.ui;

import com.sun.source.tree.IfTree;
import org.example.common.AlFrancesException;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Cliente;
import org.example.service.GestionHotel;
import org.example.service.GestionReservas;
import org.example.service.IGestionHotel;
import org.example.service.IGestionReservas;

import java.time.LocalDate;
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
        boolean valido = false;
        do {
            System.out.println("Introduzca 1 para iniciar sesión, 2 para registrarse y 3 para salir.");
            int opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    boolean entrar = false;
                    while (!entrar) {
                        System.out.println("Introduzca su usuario");
                        String dni = teclado.nextLine();
                        System.out.println("Introduzca la contraseña");
                        if (serviciosReservas.iniciarSesion(dni, teclado.nextLine())) {
                            entrar = true;
                            cliente = serviciosReservas.clientePorDni(dni);
                            sacarMenu();
                            valido = true;
                        } else {
                            System.out.println("Contraseña o usuario incorrecto");
                        }
                    }
                    break;
                case 2:
                    if (registrarse()) {
                        valido = true;
                        sacarMenu();
                    }
                    break;
                case 3:
                    System.out.println("Ha elegido salir.");
                    valido = true;
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }
        } while (!valido);
    }

    public boolean registrarse() {
        Scanner teclado = new Scanner(System.in);
        boolean iniciado = false;
        System.out.println("Introduzca su dni.");
        String dni = teclado.nextLine();
        System.out.println("Introduzca su nombre.");
        String nombre = teclado.nextLine();
        System.out.println("Introduzca su teléfono.");
        String telefono = teclado.nextLine();
        System.out.println("Introduzca su contraseña.");
        String contrasenya = teclado.nextLine();
        System.out.println("Introduzca su país.");
        String pais = teclado.nextLine();
        System.out.println("Introduzca su día de nacimiento.");
        int dia = teclado.nextInt();
        System.out.println("Introduzca su mes de nacimiento.");
        int mes = teclado.nextInt();
        System.out.println("Introduzca su año de nacimiento.");
        int anyo = teclado.nextInt();
        try {
            Cliente cliente = new Cliente(dni, nombre, LocalDate.of(anyo, mes, dia), telefono, pais, contrasenya);
            if (serviciosReservas.anyadirCliente(cliente)) {
                System.out.println("Cliente registrado.");
                iniciado = true;
            } else {
                System.out.println("Error al registrarse.");
            }
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
        return iniciado;
    }

    public void sacarMenu() {

        //cliente = serviciosReservas.clientePorDni(dni);
        int opcion = 0;
        do {
            System.out.println("Introduzca 1 para gestionar las reservas, 2 para gestionar las actividades y 3 para cambiar la contraseña.");
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca 1 para ver la lista de clientes, 2 para añadir un cliente, 3 para borrar un cliente y 4 para salir.");
                    opcion = mostrarMenu();
                    switch (opcion){
                        case 1:
                            anyadirReserva();
                            break;
                        case 2:
                            cancelarReserva();
                            break;
                        case 3:
                            //verReservas();
                            break;
                        case 4:
                            //modificarReservaFecha();
                            break;
                        case 5:
                            System.out.println("Ha elegido salir.");
                            break;
                        default:
                            System.out.println("Introduzca una opción válida.");
                    }

                    break;
                case 2:
                    modificarContrasenya();
                    break;
                case 3:

                    break;
                case 4:
                    //reservarActividad();
                    break;
                case 5:
                    //cancelarActividad();
                    break;
                case 6:

                    break;
                case 7:
                    //modificarReservaFecha();
                    break;
                case 8:
                    System.out.println("Ha elegido salir.");
                    break;
                default:
                    System.out.println("Introduzca una opción válida.");
            }

        } while (opcion != 10);
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

    public void anyadirReserva() {
        System.out.println("Introduce el id");
        //serviciosReservas.addReserva(cliente,)
    }

    public static void modificarContrasenya() {

    }

    public static void cancelarReserva() {

    }

}

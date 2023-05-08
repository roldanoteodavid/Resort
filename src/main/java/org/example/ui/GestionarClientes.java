package org.example.ui;

import com.sun.source.tree.IfTree;
import org.example.common.AlFrancesException;
import org.example.common.LugarException;
import org.example.dao.DaoHotelFicheros;
import org.example.domain.Actividad;
import org.example.domain.Cliente;
import org.example.domain.Hotel;
import org.example.domain.Reserva;
import org.example.service.GestionHotel;
import org.example.service.GestionReservas;
import org.example.service.IGestionHotel;
import org.example.service.IGestionReservas;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        boolean passvalid = false;
        String contrasenya = null;
        do {
            System.out.println("Introduzca su contraseña.");
            contrasenya = teclado.nextLine();
            Pattern p = Pattern.compile("^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$");
            Matcher mat = p.matcher(contrasenya);
            if (mat.matches()) {
                passvalid = true;
            }

        } while (!passvalid);
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
            System.out.println("Introduzca 1 para gestionar las reservas, 2 para gestionar las actividades, 3 para cambiar la contraseña y 4 para salir");
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca 1 para ver la lista de clientes, 2 para añadir un cliente, 3 para borrar un cliente y 4 para salir.");
                    opcion = mostrarMenu();
                    switch (opcion) {
                        case 1 -> anyadirReserva();
                        case 2 -> cancelarReserva();
                        case 3 -> verReservas();
                        case 4 -> modificarReservaFecha();
                        case 5 -> System.out.println("Has elegido salir.");
                        default -> System.out.println("Introduzca una opción válida.");
                    }

                    break;
                case 2:
                    System.out.println("Introduzca 1 para reservar una actividad, 2 para cancelar una actividad y 3 para salir.");
                    opcion = mostrarMenu();
                    switch (opcion) {
                        case 1 -> anyadirActividad();
                        case 2 -> cancelarActividad();
                        case 3 -> System.out.println("Has elegido salir.");
                        default -> System.out.println("Introduzca una opción válida.");
                    }
                    break;
                case 3:
                    modificarContrasenya();
                    break;
                case 4:
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dia, mes y año de la llegada");
        LocalDate entrada = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Introduce el dia, mes y año de la salida");
        LocalDate salida = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Introduce la cantidad de personas");
        int personas = sc.nextInt();
        serviciosReservas.addReserva(cliente, new Reserva(entrada, salida, cliente.getDni(), personas));
    }

    public void cancelarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id de la reserva");
        serviciosReservas.cancelarReserva(sc.nextInt());
    }

    public void verReservas() {
        boolean sigue = false;
        boolean ascendente = false;
        do {

            System.out.println("Pulse 1 si lo quiere de manera ascendente y 2 si lo quiere descendente");
            int opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    ascendente = true;
                    sigue = true;
                case 2:
                    sigue = true;
                default:
            }
        } while (!sigue);
        System.out.println(serviciosReservas.verReservas(ascendente));
    }

    public void modificarReservaFecha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dia, mes y año de la nueva fecha de llegada");
        LocalDate entrada = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Introduce el dia, mes y año de la nueva fecha de salida");
        LocalDate salida = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Introduce el id de la reserva");
        int id = sc.nextInt();
        serviciosReservas.modificarReservaFecha(id, entrada, salida);

    }

    public void anyadirActividad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el id de la actividad");
        int id = sc.nextInt();
        System.out.println("Introduce el dia, mes y año de tu fecha de llegada");
        LocalDate entrada = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("Introduce el dia, mes y año de tu fecha de salida");
        LocalDate salida = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        if (serviciosReservas.reservarActividad(id, entrada, salida, cliente))
            System.out.println("Actividad reservada cn exito");
    }

    public void cancelarActividad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el id de la actividad que deseas cancelar");
        serviciosReservas.cancelarActividad(sc.nextInt(), cliente);
    }

    public void modificarContrasenya() {
        Scanner teclado = new Scanner(System.in);
        String contrasenya = null;
        for (boolean coinciden = false; !coinciden; ) {
            System.out.println("Introduce una nueva contraseña");
            contrasenya = teclado.nextLine();
            System.out.println("Confirmar contraseña");
            String cotrasenya2 = teclado.nextLine();
            if (contrasenya.equalsIgnoreCase(cotrasenya2))
                coinciden = true;
        }
        serviciosReservas.modificarContrasenya(cliente.getDni(), contrasenya);
    }

}

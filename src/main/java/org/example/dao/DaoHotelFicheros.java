package org.example.dao;

import org.example.domain.Hotel;

import java.io.*;
import java.util.List;

public class DaoHotelFicheros {
    //public static final String FICHERO = "Fichero";
    public static final String FICHEROB = "FicheroBinario";

    public static void crearFicheros() throws IOException {
        //File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROB);
        /*if (!fichero1.exists())
            fichero1.createNewFile();*/
        if (!fichero2.exists()){
            fichero2.createNewFile();
            Hotel hotel = new Hotel();
            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
                os.writeObject(hotel);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
            }
        }

    }
    public static Hotel leerFicheroBinario() {
        Hotel auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            auxiliar = (Hotel) is.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }
        return auxiliar;
    }
    public static boolean escribirFicheroBinario(Hotel hotel) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(hotel);
            escrito = true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            java.util.logging.Logger.getLogger(DaoHotelFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
}

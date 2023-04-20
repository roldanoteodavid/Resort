package org.example.common;

import java.util.Arrays;

public class AlFrancesException extends Exception {
    private static final String[] mensajes = {
            "Puto frances",
            "A comer baguetes",
            "A conquistar tu puto país, imbecil."
    };

    public AlFrancesException() {
        super(mensajes[(int) (Math.random() * mensajes.length)]);
    }
}

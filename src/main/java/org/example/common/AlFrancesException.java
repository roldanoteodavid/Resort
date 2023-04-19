package org.example.common;

import java.util.Arrays;

public class AlFrancesException extends Exception {
    public AlFrancesException() {
        super(switch ((int) ((Math.random() * 3) + 1)) {
            case 1 -> "Puto frances";
            case 2 -> "A comer baguetes";
            case 3 -> "A conquistar tu puto país, imbecil";
            default -> "te has librado";
        });


    }

}

package br.edu.ifpb.util;

public class IdGeneratorSale {
    private static int idCounter = 0;

    public static int generateIdSale() {
        return ++idCounter;
    }
}

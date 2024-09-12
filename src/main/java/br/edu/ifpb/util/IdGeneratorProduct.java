package br.edu.ifpb.util;

public class IdGeneratorProduct {
    private static int idCounter = 0;

    public static int generateIdProduct() {
        return ++idCounter;
    }
}

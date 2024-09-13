package br.edu.ifpb.util;

public class IdGeneratorSaleItem {
    private static int idCounter = 0;

    public static int generateIdSaleItem() {
        return ++idCounter;
    }
}

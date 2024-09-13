package br.edu.ifpb.util;

public class IdGeneratorReplacement {
    private static int idCounter = 0;

    public static int generateIdReplacement() {
        return ++idCounter;
    }
}

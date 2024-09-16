package br.edu.ifpb.util;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private  int idCounter;

    private final static Map<String, IdGenerator> instances = new HashMap<String, IdGenerator>();

    private IdGenerator() {
        this.idCounter = 0;
    }

    public static IdGenerator getInstance(String key) {
        instances.computeIfAbsent(key, k -> new IdGenerator());
        return instances.get(key);
    }

    public int generateId() {
        return ++idCounter;
    }
}

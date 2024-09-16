package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class Product extends Entity{
    private String type;
    private float saleValue;
    private String description;
    private String color;
    private final List<Replacement> replacements;

    // Construtor padrão
    public Product() {
        this.replacements = new ArrayList<>();
    }

    // Construtor com parâmetros
    public Product(String type, float saleValue, String description, String color) {
        this();
        this.type = type;
        this.saleValue = saleValue;
        this.description = description;
        this.color = color;

    }

    // Getters e Setters
    public Integer getId() { return id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public float getSaleValue() { return saleValue; }

    public void setSaleValue(float saleValue) { this.saleValue = saleValue; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public List<Replacement> getReplacements() { return replacements; }

    @Override
    public String toString() {
        String productInfo = String.format("ID: %d | Tipo: %s | Valor de Venda: %.2f | Descrição: %s | Cor: %s",
                id, type, saleValue, description, color);
        if (!replacements.isEmpty()) {
            productInfo += "\nReposições do produto\n";
            for (Replacement replacement : replacements) {
                productInfo += replacement.toString() + "\n";
            }
        } else {
            productInfo += "\nSem reposição.";
        }
        return productInfo;
    }
}

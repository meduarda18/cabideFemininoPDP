package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGeneratorProduct;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Integer id;
    private String type;
    private float saleValue;
    private String description;
    private String color;
    private final List<Replacement> replacements;

    // Construtor padrão
    public Product() {
        this.replacements = new ArrayList<>();
        this.id = IdGeneratorProduct.generateIdProduct();
    }

    // Construtor com parâmetros
    public Product( String type, float saleValue, String description, String color) {
        this.id = IdGeneratorProduct.generateIdProduct();
        this.type = type;
        this.saleValue = saleValue;
        this.description = description;
        this.color = color;
        this.replacements = new ArrayList<>();
    }

    // Getters e Setters
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public float getSaleValue() { return saleValue; }

    public void setSaleValue(float saleValue) { this.saleValue = saleValue; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public List<Replacement> getReplacements() { return replacements; }

    // Adiciona uma reposição à lista
    public void addReplacement(Replacement replacement) { this.replacements.add(replacement); }

    // Remove uma reposição da lista
    public void removeReplacement(Replacement replacement) { this.replacements.remove(replacement); }

    @Override
    public String toString() {
        return String.format("ID: %d | Tipo: %s | Valor de Venda: %.2f | Descrição: %s | Cor: %s",
                id, type, saleValue, description, color);
    }
}

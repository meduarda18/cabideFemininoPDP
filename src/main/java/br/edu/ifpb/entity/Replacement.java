package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGenerator;

public class Replacement {
    private Integer id;
    private Product product; // Referência ao produto
    private String size;
    private int quantity;
    private String replacementDate;
    private float buyValue;

    //construtor padrão
    public  Replacement(){
        this.id = IdGenerator.generateId();
    }

    public Replacement(Product product, String size, int quantity, String replacementDate, float buyValue) {
        this.product = product;
        this.size = size;
        this.quantity = quantity;
        this.replacementDate = replacementDate;
        this.buyValue = buyValue;
    }

    public Integer getId(){
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReplacementDate() {
        return replacementDate;
    }

    public void setReplacementDate(String replacementDate) {
        this.replacementDate = replacementDate;
    }

    public float getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(float buyValue) {
        this.buyValue = buyValue;
    }
}

package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGenerator;

public class SaleItem {
    private Integer id;
    private Product product;
    private String size;
    private float unitValue;
    private int quantity;
    private Sale sale;

    //Construtor padrão
    public SaleItem(){
        this.id = IdGenerator.generateId();
    }

    public SaleItem(Product product, String size, float unitValue, int quantity, Sale sale) {
        this.id = IdGenerator.generateId();
        this.product = product;
        this.size = size;
        this.unitValue = unitValue;
        this.quantity = quantity;
        this.sale = sale;
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

    public float getUnitValue() {
        return unitValue;
    }
    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}

package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private Integer id;
    private final List<SaleItem> items; //impede que a referencia seja modificada
    private String saleDate;
    private String paymentMethod;
    private int instalment;
    private float discount;


    public Sale(){
        this.items = new ArrayList<>();
        this.id = IdGenerator.generateId();
    }

    public Sale(List<SaleItem> items, String saleDate, String paymentMethod, int instalment, float discount) {
        this.items = items;
        this.saleDate = saleDate;
        this.paymentMethod = paymentMethod;
        this.instalment = instalment;
        this.discount = discount;
    }

    public Integer getId(){
        return id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getInstalment() {
        return instalment;
    }

    public void setInstalment(int instalment) {
        this.instalment = instalment;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}

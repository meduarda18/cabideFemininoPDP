package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGeneratorSale;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private Integer id;
    private final List<SaleItem> items; //impede que a referencia seja modificada
    private String saleDate;
    private String paymentMethod;
    private int instalment;
    private float discount;
    //private SaleItem saleItem;


    public Sale(){
        this.items = new ArrayList<>();
        this.id = IdGeneratorSale.generateIdSale();
    }

    public Sale(List<SaleItem> items, String saleDate, String paymentMethod, int instalment, float discount) {
        this.items = new ArrayList<>();
        this.id = IdGeneratorSale.generateIdSale();
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

    public float getDiscount() { return discount; }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotalSale(){
        float total = 0;

        for(SaleItem saleItem : items){
            total += (saleItem.getUnitValue() * saleItem.getQuantity()) - discount;
        }
        return total;
    }

    @Override
    public String toString() {
        String saleInfo = String.format("ID: %d | Data da venda: %s | Forma de pagamento: %s | Parcelas: %d | Desconto: %.2f | Total da venda: %.2f",
                id, saleDate, paymentMethod, instalment, discount, getTotalSale());

        if (!items.isEmpty()) {
            saleInfo += "\nItens da venda:\n";
            for (SaleItem item : items) {
                saleInfo += item.toString() + "\n";
            }
        } else {
            saleInfo += "\nNenhum item de venda.";
        }

        return saleInfo;
    }

}

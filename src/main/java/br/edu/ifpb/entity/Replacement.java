package br.edu.ifpb.entity;

public class Replacement extends Entity{
    private Product product;
    private String size;
    private int quantity;
    private String replacementDate;
    private float buyValue;

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

    @Override
    public String toString() {
        return String.format("ID: %d | Produto: %s | Tamanho: %s | Quantidade: %d | Data da Reposição: %s | Valor de Compra: %.2f",
                id, product.getType(), size, quantity, replacementDate, buyValue);
    }
}

package br.edu.ifpb.validator;

import br.edu.ifpb.entity.SaleItem;

import java.util.List;

public class SaleItemValidator {
    public static void validateSaleItem(SaleItem saleItem){
        if(saleItem.getProduct() == null){
            throw new IllegalArgumentException("O produto não pode ser nulo ou vazio.");
        }
        if(saleItem.getSize() == null || saleItem.getSize().isBlank()){
            throw new IllegalArgumentException("O tamanho do item de venda não pode ser nulo ou vazio.");
        }
        if(saleItem.getUnitValue() <= 0.0){
            throw new IllegalArgumentException("O valor unitário do item de venda deve ser maior que zero.");
        }
        if(saleItem.getQuantity() <= 0){
            throw new IllegalArgumentException("A quantidade de um item de venda deve ser maior que zero.");
        }
        if(saleItem.getSale() == null){
            throw new IllegalArgumentException("A venda não pode ser nula ou vazia.");
        }
    }

    public static boolean saleItemExists(SaleItem saleItem, List<SaleItem> salesItems){
        for (SaleItem s : salesItems) { //para cada item de venda s na lista salesItems
            if (s.getId().equals(saleItem.getId())) {
                return true;
            }
        }
        return false;
    }
}

package br.edu.ifpb.service;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.validator.SaleItemValidator;

import java.util.ArrayList;
import java.util.List;

public class SaleItemService implements CrudService<SaleItem, Integer> {

    List<SaleItem> salesItems = new ArrayList<>();

    @Override
    public void add(SaleItem saleItem) {
        if(SaleItemValidator.saleItemExists(saleItem, salesItems)){
            throw new IllegalArgumentException("Este item de venda já existe.");
        }
        SaleItemValidator.validateSaleItem(saleItem);
        salesItems.add(saleItem);
    }

    @Override
    public boolean remove(Integer id) {
        SaleItem saleItem = searchID(id);

        if(saleItem != null){
            salesItems.remove(saleItem);
            return true;
        }
        return false;
    }

    @Override
    public List<SaleItem> list() {
        return salesItems;
    }

    @Override
    public boolean update(Integer id, SaleItem item) {
        SaleItem saleItem = searchID(id);

        if(saleItem != null){
            saleItem.setProduct(item.getProduct());
            saleItem.setSize(item.getSize());
            saleItem.setUnitValue(item.getUnitValue());
            saleItem.setQuantity(item.getQuantity());
            //saleItem.setSale(item.getSale()); verificar se pode alterar a venda de um item de venda

            return true;
        }
        return false;
    }

    @Override
    public SaleItem searchID(Integer id) {
        for (SaleItem saleItem : salesItems) {
            if (saleItem.getId().equals(id)) {
                return saleItem;
            }
        }
        throw new IllegalArgumentException("Item de venda com ID " + id + " não encontrado.");
    }

    public void printSalesItems() {
        if (salesItems.isEmpty()) {
            System.out.println("Nenhum item de venda disponível.");
        } else {
            for (SaleItem saleItem : salesItems) {
                System.out.println(saleItem);
            }
        }
    }
}

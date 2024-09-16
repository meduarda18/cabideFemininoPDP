package br.edu.ifpb.service;

import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.validator.SaleItemValidator;
import br.edu.ifpb.validator.SaleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SaleService implements CrudService<Sale, Integer>{
    private final List<Sale> sales = new ArrayList<>();

    @Override
    public void add(Sale sale) {
        if(sale.getItems() == null || sale.getItems().isEmpty()){
            throw new IllegalArgumentException("A venda não contém items de venda.");
        }
        SaleValidator.validateSale(sale);
        sales.add(sale);
    }

    @Override
    public boolean remove(Integer id) {
        Sale sale = searchID(id);
        if(sale != null){
            sales.remove(sale);
        }
        return false;
    }

    @Override
    public List<Sale> list() {
        return sales;
    }

    @Override
    public boolean update(Integer id, Sale saleUpdate) {
        Sale sale = searchID(id);
        if(sale != null){
            if(saleUpdate.getSaleDate() != null && !saleUpdate.getSaleDate().isEmpty()){
                sale.setSaleDate(saleUpdate.getSaleDate());
            }
            if(saleUpdate.getPaymentMethod() != null && !saleUpdate.getPaymentMethod().isEmpty()){
                sale.setPaymentMethod(saleUpdate.getPaymentMethod());
            }
            if(saleUpdate.getInstalment() > 0){
                sale.setInstalment(saleUpdate.getInstalment());
            }
            if(saleUpdate.getDiscount() >= 0){
                sale.setDiscount(saleUpdate.getDiscount());
            }
            return true;
        }
        return false;
    }

    @Override
    public Sale searchID(Integer id) {
        if(id == null){
            throw new NoSuchElementException("O id não pode ser nulo.");
        }
        for (Sale sale : sales) {
            if (sale.getId().equals(id)) {
                return sale;
            }
        }
        throw new NoSuchElementException("Venda com ID " + id + " não encontrado.");
    }

    public void printSales() {
        if (sales.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Sale sale : sales) {
                System.out.println(sale);
            }
        }
    }

    public void addSaleItems(Sale sale, SaleItem saleItem){
        SaleItemValidator.validateSaleItem(saleItem);
        sale.getItems().add(saleItem);
    }

    public void removeSaleItems(SaleItem saleItem, Sale sale) {
        SaleItemValidator.saleItemExists(saleItem, sale.getItems());
        sale.getItems().remove(saleItem);
    }
}

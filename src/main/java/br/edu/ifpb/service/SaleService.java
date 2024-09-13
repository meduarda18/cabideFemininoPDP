package br.edu.ifpb.service;

import br.edu.ifpb.entity.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleService implements CrudService<Sale, Integer>{
    private final List<Sale> sales = new ArrayList<>();

    @Override
    public void add(Sale sale) {
        if(sale.getItems() == null || sale.getItems().isEmpty()){
            throw new IllegalArgumentException("A venda não contém items de venda.");
        }
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
            sale.setSaleDate(saleUpdate.getSaleDate());
            sale.setPaymentMethod(saleUpdate.getPaymentMethod());
            sale.setInstalment(saleUpdate.getInstalment());
            sale.setDiscount(saleUpdate.getDiscount());

            return true;
        }
        return false;
    }

    @Override
    public Sale searchID(Integer id) {
        for (Sale sale : sales) {
            if (sale.getId().equals(id)) {
                return sale;
            }
        }
        throw new IllegalArgumentException("Venda com ID " + id + " não encontrado.");
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
}

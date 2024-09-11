package br.edu.ifpb.service;

import br.edu.ifpb.entity.Sale;

import java.util.List;

public class SaleService implements CrudService<Sale, Integer>{
    @Override
    public Sale add(Sale item) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<Sale> list() {
        return List.of();
    }

    @Override
    public Sale update(Integer id) {
        return null;
    }
}

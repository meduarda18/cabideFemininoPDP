package br.edu.ifpb.service;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements CrudService<Product, Integer> {
    private final List<Product> products =  new ArrayList<>();

    @Override
    public Product add(Product prod) {
        if(ProductValidator.productExists(prod.getType(), prod.getColor(), products)){
            throw new IllegalArgumentException("O produto já existe.");
        }
        ProductValidator.validateProduct(prod);
        products.add(prod);
        return prod;
    }

    @Override
    public void remove(Integer id) {
        Product productToRemove = null; // variável para armazenar o produto a ser removido

        for (Product prod : products) {
            if (prod.getId().equals(id)) {
                productToRemove = prod;
                break; // Encontra o produto e sai do loop
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
        } else {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
    }

    @Override
    public List<Product> list() {
        return List.of();
    }

    @Override
    public Product update(Integer id) {
        return null;
    }
}

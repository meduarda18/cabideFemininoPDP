package br.edu.ifpb.service;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Replacement;
import br.edu.ifpb.validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService implements CrudService<Product, Integer> {
    private final List<Product> products =  new ArrayList<>();

    @Override
    public void add(Product prod) {
        if(ProductValidator.productExists(prod.getType(), prod.getColor(), products)){
            throw new IllegalArgumentException("Este produto já existe.");
        }
        ProductValidator.validateProduct(prod);
        products.add(prod);
    }

    @Override
    public boolean remove(Integer id) {
        Product prod = searchID(id);

        if(prod != null){
            products.remove(prod);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> list() {
        if(products.isEmpty()){
            return new ArrayList<>();
        }
        return products;
    }

    @Override
    public boolean update(Integer id, Product productUpdate) {
        Product existingProduct = searchID(id);
        if(existingProduct != null){
            if(productUpdate.getType() != null && !productUpdate.getType().isEmpty()){
                existingProduct.setType(productUpdate.getType());
            }
            if(productUpdate.getSaleValue() > 0){
                existingProduct.setSaleValue(productUpdate.getSaleValue());
            }
            if(productUpdate.getDescription() != null && !productUpdate.getDescription().isEmpty()){
                existingProduct.setDescription(productUpdate.getDescription());
            }
            if(productUpdate.getColor() != null && !productUpdate.getColor().isEmpty()){
                existingProduct.setColor(productUpdate.getColor());
            }
            return true;
        }
        return false;
    }

    @Override
    public Product searchID(Integer id) {
        if(id == null){
            throw new NoSuchElementException("O id não pode ser nulo.");
        }
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new NoSuchElementException("Produto com ID " + id + " não encontrado.");
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void addReplacement(Product product, Replacement replacement) {
        product.getReplacements().add(replacement);  // Manipulação da lista de reposições
    }

    public void removeReplacement(Product product, Replacement replacement) {
        product.getReplacements().remove(replacement);  // Manipulação da lista de reposições
    }
}

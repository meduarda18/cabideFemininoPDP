package br.edu.ifpb.service;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Replacement;
import br.edu.ifpb.validator.ProductValidator;

import java.util.ArrayList;
import java.util.List;

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
        return products;
    }

    @Override
    public boolean update(Integer id, Product productUpdate) {
        Product product = searchID(id);
        if(product != null){
            product.setType(productUpdate.getType());
            product.setSaleValue(productUpdate.getSaleValue());
            product.setDescription(productUpdate.getDescription());
            product.setColor(productUpdate.getColor());

            return true;
        }

        return false;
    }

    @Override
    public Product searchID(Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
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

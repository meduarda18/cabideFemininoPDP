package br.edu.ifpb.validator;

import br.edu.ifpb.entity.Product;
import java.util.List;

public class ProductValidator {
    public static void validateProduct(Product product) {
        if (product.getType() == null || product.getType().isBlank()) {
            throw new IllegalArgumentException("O tipo do produto não pode ser nulo ou vazio.");
        }
        if (product.getSaleValue() <= 0.0) {
            throw new IllegalArgumentException("O valor de venda deve ser maior que zero.");
        }
        if (product.getDescription() == null || product.getDescription().isBlank()) {
            throw new IllegalArgumentException("A descrição do product não pode ser nula ou vazia.");
        }
        if (product.getColor() == null || product.getColor().isBlank()) {
            throw new IllegalArgumentException("A cor do product não pode ser nula ou vazia.");
        }
    }

    public static boolean productExists(String type, String color, List<Product> products) {
        for (Product p : products) { // Para cada produto p na lista products
            if (p.getType().equals(type) && p.getColor().equals(color)) {
                return true; // Produto encontrado
            }
        }
        return false; // Produto não encontrado
    }

}

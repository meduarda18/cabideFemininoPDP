package br.edu.ifpb;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        Product p1 = new Product("Calça WidLeg", 150.00f, "Calça Mon jeans com lavagem clara.", "Azul Claro");
        Product p2 = new Product("Calça Mon", 150.00f, "Calça WidLeg jeans com lavagem escura.", "Azul Claro");
        Product p3 = new Product("Camiseta", 25.00f, "Camiseta regata", "Branca");
        Product p4 = new Product("Blusa", 35.00f, "Blusa com manga curta.", "Preta");

        System.out.println("Produtos adicionados: ");
        productService.add(p1);
        productService.add(p2);
        productService.add(p3);
        productService.add(p4);

        productService.printProducts();


        System.out.println("Removendo um produto:");
        productService.remove(2);

        productService.printProducts();

        Product p5 = new Product("Calça Mon", 150.00f, "Calça WidLeg jeans com lavagem escura.", "Azul Claro");

        productService.add(p5);

        System.out.println("nova lista");
        productService.printProducts();

        //System.out.println("Produto selecionado");
        //System.out.println(productService.searchID(7));

        Product updatedProduct = new Product("Blusa", 40.00f, "Blusa com manga curta.", "Vermelha");

        boolean update = productService.update(p4.getId(), updatedProduct);

        System.out.println("\nLista de produtos após a atualização:");
        productService.printProducts();
    }
}

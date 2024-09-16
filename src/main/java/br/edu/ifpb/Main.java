package br.edu.ifpb;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Replacement;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.service.ProductService;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.SaleService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        SaleService saleService = new SaleService();

        Product p1 = new Product("Calça WidLeg", 150.00f, "Calça Mon jeans com lavagem clara.", "Azul Claro");
        Product p2 = new Product("Calça Mon", 150.00f, "Calça WidLeg jeans com lavagem escura.", "Azul Claro");
        Product p3 = new Product("Camiseta", 25.00f, "Camiseta regata", "Branca");
        Product p4 = new Product("Blusa", 35.00f, "Blusa com manga curta.", "Preta");
        Product p5 =  new Product("Cinto", 30.00f, "Cinto de couro básico", "Preto");

        //adicionando os produtos criados a lista de produtos
        System.out.println("\nProdutos adicionados: ");
        productService.add(p1);
        productService.add(p2);
        productService.add(p3);
        productService.add(p4);
        productService.add(p5);

        productService.printProducts();

        //criando uma reposição
        Replacement rep = new Replacement(p5, "Único", 2, "2024-09-12", 15.00f);

        productService.addReplacement(p5, rep);

        System.out.println("\nProdutos depois da reposicao");
        productService.printProducts();

        productService.removeReplacement(p5, rep);

        System.out.println("\nProdutos depois da reposicao");
        productService.printProducts();

        /*
        //Criando itens de venda
        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 2, null);  // Produto 1, tamanho M, quantidade 2
        SaleItem saleItem2 = new SaleItem(p2, "G", p2.getSaleValue(), 1, null);  // Produto 2, tamanho G, quantidade 1

        // Criar uma lista de items de venda
        List<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(saleItem1);
        saleItems.add(saleItem2);

        //Criar uma venda
        Sale sale1 = new Sale(saleItems, "2024-09-12", "Cartão de Crédito", 3, 10.0f);
        saleService.add(sale1);


        // Exibir detalhes da venda
        System.out.println("\nDetalhes da venda:");
        saleService.printSales();


        productService.printProducts();


        System.out.println("Removendo um produto:");
        productService.remove(2);

        productService.printProducts();

        //adicionando depois da remoção
        Product p5 = new Product("Calça Mon", 150.00f, "Calça WidLeg jeans com lavagem escura.", "Azul Claro");

        productService.add(p5);

        System.out.println("Novo produto adicionado:");
        productService.printProducts();

        //System.out.println("Produto selecionado");
        //System.out.println(productService.searchID(7));

        Product updatedProduct = new Product("Blusa", 40.00f, "Blusa com manga curta.", "Vermelha");

        boolean update = productService.update(p4.getId(), updatedProduct);


        System.out.println("\nLista de produtos após a atualização:");
         */
        //productService.printProducts();
    }
}

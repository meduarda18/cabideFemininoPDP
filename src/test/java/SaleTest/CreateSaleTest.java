package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ShopFacade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CreateSaleTest {

    //given = dado, when = quando, then = então
    @Test
    public  void givenValidSale_whenCreateNewSale_thenReturnValidSaleTest(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        shopFacade.addSale(s1);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(s1.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getInstalment(), retrievedSale.getInstalment(), "O total de parcelas da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser a mesma.");
    }

    @Test
    public  void givenInvalidSale_whenCreateNewSale_thenException(){
        ShopFacade shopFacade = new ShopFacade();

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addSale(s1);},
                "Deveria lançar uma exceção ao tentar criar uma venda sem itens.");
    }

    @Test
    public  void givenInvalidSaleDate_whenCreateNewSale_thenException(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addSale(s1);}, "Deveria lançar um exceção ao tentar criar uma venda com data vazia.");
    }

    @Test
    public  void givenInvalidPaymentMethod_whenCreateNewSale_thenException(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addSale(s1);
        }, "Deveria lançar uma exceção ao tentar criar uma venda com método de pagamento inválido.");
    }

    @Test
    public  void givenInvalidInstalment_whenCreateNewSale_thenException(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 0, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addSale(s1);
        }, "Deveria lançar uma exceção ao tentar criar uma venda com a parcela inválida.");
    }

    @Test
    public  void givenInvalidDiscount_whenCreateNewSale_thenException(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, -10);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addSale(s1);
        }, "Deveria lançar uma exceção ao tentar criar uma venda com o desconto inválida.");
    }

    @Test
    public void givenDiscountGreaterThanTotal_whenCreateNewSale_thenException() {
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 200);  // Desconto maior que o total

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addSale(s1);
        }, "Deveria lançar uma exceção ao tentar criar uma venda com desconto maior que o valor total.");
    }
}

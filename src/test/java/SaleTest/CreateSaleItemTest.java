package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CreateSaleItemTest {

    @Test
    public void givenValidSale_whenAddValidSaleItem_thenSuccessAddSaleItem(){
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

        Assertions.assertEquals(s1.getItems(), retrievedSale.getItems(), "Os item da venda deveriam ser iguais.");
    }

    @Test
    public void givenValidSale_whenAddInvalidSaleItem_thenFailedAddSaleItem(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "", 0.00f, 0, s1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addSaleItems(s1, saleItem1);},
                "Deveria lançar uma exceção ao tentar criar uma venda com items de venda inválidos.");
    }

    @Test
    public void givenValidSale_whenAddInvalidSaleItemSize_thenFailedAddSaleItem(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "", p1.getSaleValue(), 1, s1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addSaleItems(s1, saleItem1);},
                "Deveria lançar uma exceção ao tentar criar uma venda com items de venda inválidos.");
    }


    @Test
    public void givenValidSale_whenAddInvalidSaleItemQuantity_thenFailedAddSaleItem(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 0, s1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addSaleItems(s1, saleItem1);},
                "Deveria lançar uma exceção ao tentar criar uma venda com items de venda inválidos.");
    }
}

package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import br.edu.ifpb.service.ShopFacade;

public class RemoveSaleTest {

    //given = dado, when = quando, then = então

    @Test
    public void givenValidId_whenRemoveSale_thenSuccessRemoveSale(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        shopFacade.removeSale(s1.getId());

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.searchIdSale(s1.getId());
        });
    }

    @Test
    public void givenInvalidId_whenRemoveSale_thenFailedRemoveSale(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        int idInvalid = 10;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeSale(idInvalid);
        });
    }

    @Test
    public void givenValidId_whenDuplicateRemoveSale_thenSuccessRemoveSale(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        shopFacade.removeSale(s1.getId());

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeSale(s1.getId());
        });
    }
    @Test
    public void givenIdEmptyList_whenRemoveSale_thenFailedRemoveSale(){
        ShopFacade shopFacade = new ShopFacade();

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeSale(10);
        });
    }
}

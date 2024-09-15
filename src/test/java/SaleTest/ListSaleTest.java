package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListSaleTest {
    //given = dado, when = quando, then = então

    @Test
    public void givenSale_whenAddedToList_thenSaleExistsInList(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);
        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        // Verifica se a venda foi adicionada corretamente à lista de vendas
        Assertions.assertTrue(shopFacade.listSale().contains(s1), "A lista deveria conter a venda s1.");
    }


    @Test
    public void givenSaleWithItems_whenItemsAddedToSale_thenItemsExistInSale(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        Product p2 = new Product("Camisão", 50.00f, "Camisa de botões listrada", "Rosa");
        Product p3 = new Product("Cinto", 30.00f, "Cinto de corrente", "Prata");
        shopFacade.addProduct(p1);
        shopFacade.addProduct(p2);
        shopFacade.addProduct(p3);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Product retrievedProduct2 = shopFacade.searchIdProduct(p2.getId());
        Product retrievedProduct3 = shopFacade.searchIdProduct(p3.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");
        Assertions.assertNotNull(retrievedProduct2, "Produto deveria estar presente na lista.");
        Assertions.assertNotNull(retrievedProduct3, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        SaleItem saleItem2 = new SaleItem(p3, "Unico", p3.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);
        s1.getItems().add(saleItem2);

        shopFacade.addSale(s1);
        Assertions.assertTrue(shopFacade.listSale().contains(s1), "A lista deveria conter a venda s1.");

        Sale retrievedSale = shopFacade.listSale().get(0);
        Assertions.assertTrue(retrievedSale.getItems().contains(saleItem1), "A lista de items de venda deveria conter o item de venda 1.");
        Assertions.assertTrue(retrievedSale.getItems().contains(saleItem2), "A lista de items de venda deveria conter o item de venda 2.");
    }

    @Test
    public void givenListSalesEmpty_whenReadList_thenListReadSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Assertions.assertTrue(shopFacade.listSale().isEmpty(), "A lista está vazia.");

    }

}

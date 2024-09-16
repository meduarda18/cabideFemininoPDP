package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RemoverSaleItemTest {

    @Test
    public void givenValidSale_whenRemoveValidSaleItem_thenSuccessRemoveSaleItem() {
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça wideleg", "Azul");
        shopFacade.addProduct(p1);

        Sale s1 = new Sale(new ArrayList<>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        shopFacade.addSaleItems(s1, saleItem1);

        shopFacade.addSale(s1);

        shopFacade.removeSaleItems(saleItem1, s1);

        // Recuperar a venda e verificar se o item foi removido
        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());
        Assertions.assertTrue(retrievedSale.getItems().isEmpty(), "Item de venda deveria ter sido removido.");
    }

}

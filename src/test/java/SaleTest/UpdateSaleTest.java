package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class UpdateSaleTest {

    @Test
    public  void givenValidId_whenUpdateSale_thenUpdateSaleSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        Sale saleUpdate = new Sale(new ArrayList<SaleItem>(), "2024-09-14", "Cartão", 2, 0 );

        shopFacade.updateSale(s1.getId(), saleUpdate);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(saleUpdate.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");
        Assertions.assertEquals(saleUpdate.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento deveria ser a mesma.");
        Assertions.assertEquals(saleUpdate.getInstalment(), retrievedSale.getInstalment(), "A quantidade de parcelas deveria ser a mesma.");
        Assertions.assertEquals(saleUpdate.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser o mesmo.");
    }

    @Test
    public void givenValidId_whenUpdateSaleDate_thenUpdateSaleSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        Sale saleUpdate = new Sale(new ArrayList<SaleItem>(), "2024-09-14", "", 0, -10 );

        shopFacade.updateSale(s1.getId(), saleUpdate);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(saleUpdate.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");

        Assertions.assertEquals(s1.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento deveria ser a mesma.");
        Assertions.assertEquals(s1.getInstalment(), retrievedSale.getInstalment(), "A quantidade de parcelas deveria ser a mesma.");
        Assertions.assertEquals(s1.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser o mesmo.");
    }

    @Test
    public void givenValidId_whenUpdateSalePaymentMethod_thenUpdateSaleSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        Sale saleUpdate = new Sale(new ArrayList<SaleItem>(), "", "Cartão", 0, -10 );

        shopFacade.updateSale(s1.getId(), saleUpdate);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(saleUpdate.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento deveria ser a mesma.");

        Assertions.assertEquals(s1.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getInstalment(), retrievedSale.getInstalment(), "A quantidade de parcelas deveria ser a mesma.");
        Assertions.assertEquals(s1.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser o mesmo.");
    }

    @Test
    public void givenValidId_whenUpdateSaleInstalment_thenUpdateSaleSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        Sale saleUpdate = new Sale(new ArrayList<SaleItem>(), "", "", 3, -10 );

        shopFacade.updateSale(s1.getId(), saleUpdate);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(saleUpdate.getInstalment(), retrievedSale.getInstalment(), "A quantidade de parcelas deveria ser a mesma.");

        Assertions.assertEquals(s1.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento deveria ser a mesma.");
        Assertions.assertEquals(s1.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser o mesmo.");
    }

    @Test
    public void givenValidId_whenUpdateSaleDiscount_thenUpdateSaleSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        Sale s1 = new Sale(new ArrayList<SaleItem>(), "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        s1.getItems().add(saleItem1);

        shopFacade.addSale(s1);

        Sale saleUpdate = new Sale(new ArrayList<SaleItem>(), "", "", 0, 10 );

        shopFacade.updateSale(s1.getId(), saleUpdate);

        Sale retrievedSale = shopFacade.searchIdSale(s1.getId());

        Assertions.assertEquals(saleUpdate.getDiscount(), retrievedSale.getDiscount(), "O desconto da venda deveria ser o mesmo.");

        Assertions.assertEquals(s1.getSaleDate(), retrievedSale.getSaleDate(), "A data da venda deveria ser a mesma.");
        Assertions.assertEquals(s1.getPaymentMethod(), retrievedSale.getPaymentMethod(), "A forma de pagamento deveria ser a mesma.");
        Assertions.assertEquals(s1.getInstalment(), retrievedSale.getInstalment(), "A quantidade de parcelas deveria ser a mesma.");
    }
}

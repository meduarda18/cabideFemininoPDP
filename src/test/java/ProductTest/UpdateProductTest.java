package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateProductTest {
    //given = dado, when = quando, then = então

    @Test
    public void givenValidId_whenUpdateProduct_thenUpdateProductSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product updateProduct = new Product("Calça jeans", 170.00f, "Calça jeans skin", "Azul claro");
        shopFacade.updateProduct(p1.getId(), updateProduct);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(updateProduct.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo.");
        Assertions.assertEquals(updateProduct.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(updateProduct.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
        Assertions.assertEquals(updateProduct.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }

    @Test
    public void givenValidId_whenUpdateProductType_thenUpdateProductSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product updateProduct = new Product("Calça jeans", 0.0f, "", "");
        shopFacade.updateProduct(p1.getId(), updateProduct);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(updateProduct.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo.");

        Assertions.assertEquals(p1.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
        Assertions.assertEquals(p1.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }

    @Test
    public void givenValidId_whenUpdateProductSaleValue_thenUpdateProductSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product updateProduct = new Product("", 170.00f, "", "");
        shopFacade.updateProduct(p1.getId(), updateProduct);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(updateProduct.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");

        Assertions.assertEquals(p1.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo");
        Assertions.assertEquals(p1.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
        Assertions.assertEquals(p1.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }

    @Test
    public void givenValidId_whenUpdateProductDescription_thenUpdateProductSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product updateProduct = new Product("", 0.0f, "Calça skin", "");
        shopFacade.updateProduct(p1.getId(), updateProduct);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(updateProduct.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");

        Assertions.assertEquals(p1.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo");
        Assertions.assertEquals(p1.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }

    @Test
    public void givenValidId_whenUpdateProductColor_thenUpdateProductSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product updateProduct = new Product("", 0.0f, "", "Branca");
        shopFacade.updateProduct(p1.getId(), updateProduct);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(updateProduct.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");

        Assertions.assertEquals(p1.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo");
        Assertions.assertEquals(p1.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
    }
}

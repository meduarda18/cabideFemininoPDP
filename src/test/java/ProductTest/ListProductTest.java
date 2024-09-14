package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListProductTest {
    //given = dado, when = quando, then = então

    @Test
    public void givenListProducts_whenReadList_thenListReadSuccess(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        Product p2 = new Product("Blusa", 25.00f, "Blusa básica de manga curta", "Bege");
        Product p3 = new Product("Saia", 80.00f, "Saia jeans cargo", "Bege");
        shopFacade.addProduct(p1);
        shopFacade.addProduct(p2);
        shopFacade.addProduct(p3);

        Assertions.assertTrue(shopFacade.listProducts().contains(p1), "A lista deveria conter o produto p1.");
        Assertions.assertTrue(shopFacade.listProducts().contains(p2), "A lista deveria conter o produto p2.");
        Assertions.assertTrue(shopFacade.listProducts().contains(p3), "A lista deveria conter o produto p3.");

    }

    @Test
    public void givenListProductsEmpty_whenReadList_thenListReadSuccess(){
        ShopFacade shopFacade = new ShopFacade();

        Assertions.assertTrue(shopFacade.listProducts().isEmpty(), "A lista está vazia.");

    }
}

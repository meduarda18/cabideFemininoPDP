package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProductTest {

    //giver = dado, when = quando, then = então

    @Test
    public void givenValidProduct_whenCreateNewProduct_thenReturnValidProductTest(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");
        Assertions.assertEquals(p1.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
        Assertions.assertEquals(p1.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }

    @Test
    public void givenBlankType_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("", 150.00f, "Calça widleg", "Azul");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenNegativeSaleValue_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", -150.00f, "Calça widleg", "Azul");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenBlankDescription_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "", "Azul");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenBlankColor_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenAllProductInvalid_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("", -150.00f, "", "");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenNullType_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product(null, 150.00f, "Calça widleg", "Azul");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenNullDescription_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, null, "Azul");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenNullColor_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

    @Test
    public void givenAllProductAttributesNull_whenCreateNewProduct_thenException(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product(null, -1, null, null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shopFacade.addProduct(p1);
        });
    }

}
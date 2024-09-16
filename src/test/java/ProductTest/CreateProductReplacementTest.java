package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Replacement;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProductReplacementTest {

    @Test
    public void givenValidProduct_whenAddReplacement_thenSuccessAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "G", 2, "2024-09-16", 75.00f);

        shopFacade.addReplacementProduct(p1, replacement);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(p1.getReplacements(), retrievedProduct.getReplacements(), "As reposições deveriam ser iguais.");
    }

    @Test
    public void givenValidProduct_whenAddReplacementInvalid_thenFailedAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "", -10, "", 0.00f);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addReplacementProduct(p1, replacement);},
                "Deveria lançar uma exceção ao tentar criar uma reposição inválida.");
    }

    @Test
    public void givenValidProduct_whenAddReplacementSizeInvalid_thenFailedAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "", 1, "2024-09-16", 75.00f);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addReplacementProduct(p1, replacement);},
                "Deveria lançar uma exceção ao tentar criar uma reposição inválida.");;
    }

    @Test
    public void givenValidProduct_whenAddReplacementQuantityInvalid_thenFailedAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "M", 0, "2024-09-16", 75.00f);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addReplacementProduct(p1, replacement);},
                "Deveria lançar uma exceção ao tentar criar uma reposição inválida.");;
    }

    @Test
    public void givenValidProduct_whenAddReplacementDateInvalid_thenFailedAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "M", 1, "", 75.00f);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addReplacementProduct(p1, replacement);},
                "Deveria lançar uma exceção ao tentar criar uma reposição inválida.");;
    }

    @Test
    public void givenValidProduct_whenAddReplacementBuyValueInvalid_thenFailedAddReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "M", 1, "2024-09-16", 0.00f);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {shopFacade.addReplacementProduct(p1, replacement);},
                "Deveria lançar uma exceção ao tentar criar uma reposição inválida.");;
    }
}

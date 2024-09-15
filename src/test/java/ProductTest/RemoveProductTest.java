package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ShopFacade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


public class RemoveProductTest {
    //given = dado, when = quando, then = então

    @Test
    public void givenValidId_whenRemoveProduct_thenProductSuccessRemove(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        shopFacade.removeProduct(p1.getId());

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.searchIdProduct(p1.getId());  // Deve lançar exceção pois o produto foi removido
        });
    }

    @Test
    public void givenInvalidId_whenRemoveProduct_thenProductFailedRemove(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        int invalidID = 20;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeProduct(invalidID);  // Deve lançar exceção pois o produto não existe
        });

    }

    @Test
    public void givenValidId_whenDuplicateRemoveProduct_thenProductFailedRemove(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        shopFacade.removeProduct(p1.getId());

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeProduct(p1.getId());  // Deve lançar exceção pois o produto foi removido
        });
    }

    @Test
    public void givenIdEmptyList_whenRemoveProduct_thenProductFailedRemove(){
        ShopFacade shopFacade = new ShopFacade();

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            shopFacade.removeProduct(10);  // Deve lançar exceção pois o produto não existe
        });

    }
}

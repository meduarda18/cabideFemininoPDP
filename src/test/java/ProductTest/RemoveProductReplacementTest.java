package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Replacement;
import br.edu.ifpb.service.ShopFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveProductReplacementTest {

    @Test
    public void givenValidIdProduct_whenRemoveReplacementProduct_thenSuccessRemoveReplacement(){
        ShopFacade shopFacade = new ShopFacade();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        shopFacade.addProduct(p1);

        Replacement replacement = new Replacement(p1, "G", 2, "2024-09-16", 75.00f);

        shopFacade.addReplacementProduct(p1, replacement);

        Product retrievedProduct = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertEquals(p1.getReplacements(), retrievedProduct.getReplacements(), "As reposições deveriam ser iguais.");

        shopFacade.removeReplacementProduct(p1,replacement);

        Product retrievedProduct2 = shopFacade.searchIdProduct(p1.getId());

        Assertions.assertFalse(retrievedProduct2.getReplacements().contains(replacement), "Deveria dizer ue é false porque a reposição foi removida anteriormente.");
    }
}

package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProductTest {

    @Test
    public void createSuccessTest(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        productService.add(p1);

        Product retrievedProduct = productService.searchID(p1.getId());

        // Verifica se o produto foi adicionado corretamente
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");
        Assertions.assertEquals(p1.getType(), retrievedProduct.getType(), "Tipo do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getSaleValue(), retrievedProduct.getSaleValue(), "Valor de venda do produto deveria ser o mesmo.");
        Assertions.assertEquals(p1.getDescription(), retrievedProduct.getDescription(), "Descrição do produto deveria ser a mesma.");
        Assertions.assertEquals(p1.getColor(), retrievedProduct.getColor(), "Cor do produto deveria ser a mesma.");
    }
}

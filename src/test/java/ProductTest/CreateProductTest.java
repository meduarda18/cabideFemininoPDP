package ProductTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProductTest {

    //giver = dado, when = quando, then = então

    @Test
    public void givenValidProduct_whenCreateNewProduct_thenReturnValidProductTest(){
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

    @Test
    public void givenBlankType_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("", 150.00f, "Calça widleg", "Azul");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto inválido
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenNegativeSaleValue_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", -150.00f, "Calça widleg", "Azul");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto inválido
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenBlankDescription_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", 150.00f, "", "Azul");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto inválido
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenBlankColor_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto inválido
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenAllProductInvalid_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("", -150.00f, "", "");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto inválido
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenNullType_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product(null, 150.00f, "Calça widleg", "Azul");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto com type null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenNullDescription_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", 150.00f, null, "Azul");

        // Verifica se uma exceção é lançada quando tenta adicionar um produto com descrição null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenNullColor_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product("Calça", 150.00f, "Calça widleg", null);

        // Verifica se uma exceção é lançada quando tenta adicionar um produto com cor null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

    @Test
    public void givenAllProductAttributesNull_whenCreateNewProduct_thenException(){
        ProductService productService = new ProductService();
        Product p1 = new Product(null, -1, null, null);

        // Verifica se uma exceção é lançada quando tenta adicionar um produto com todos os atributos null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            productService.add(p1);  // O método add lança IllegalArgumentException
        });
    }

}
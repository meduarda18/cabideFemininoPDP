package SaleTest;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;
import br.edu.ifpb.entity.SaleItem;
import br.edu.ifpb.service.ProductService;
import br.edu.ifpb.service.SaleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateSaleTest {

    @Test
    public  void CreateSuccessTest(){
        SaleService saleService = new SaleService();
        ProductService productService = new ProductService();

        Product p1 = new Product("Calça", 150.00f, "Calça widleg", "Azul");
        productService.add(p1);
        Product retrievedProduct = productService.searchID(p1.getId());
        Assertions.assertNotNull(retrievedProduct, "Produto deveria estar presente na lista.");

        List<SaleItem> items = new ArrayList<>();

        Sale s1 = new Sale(items, "2024-09-12", "Dinheiro", 1, 0);

        SaleItem saleItem1 = new SaleItem(p1, "M", p1.getSaleValue(), 1, s1);
        items.add(saleItem1);

        saleService.add(s1);


    }
}

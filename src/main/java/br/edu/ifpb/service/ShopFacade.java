package br.edu.ifpb.service;

import br.edu.ifpb.entity.Product;
import br.edu.ifpb.entity.Sale;

import java.util.List;

public class ShopFacade {
    private final ProductService productService;
    private final SaleService saleService;

    public ShopFacade(){
        this.saleService = new SaleService();
        this.productService = new ProductService();
    }

    public void addProduct(Product product){
        productService.add(product);
    }

    public void removeProduct(Integer productId){
        productService.remove(productId);
    }

    public List<Product> listProducts(){
        return productService.list();
    }

    public void updateProduct(Integer productId, Product productUpdate){
        productService.update(productId, productUpdate);
    }

    public Product searchIdProduct(Integer productId){
       return productService.searchID(productId);
    }


    public void addSale(Sale sale){
        saleService.add(sale);
    }

    public void removeSale(Integer saleId){
        saleService.remove(saleId);
    }

    public List<Sale> listSale(){
        return saleService.list();
    }

    public void updateSale(Integer saleId, Sale saleUpdate){
        saleService.update(saleId, saleUpdate);
    }

    public Sale searchIdSale(Integer saleId){
        return saleService.searchID(saleId);
    }
}

package thankous.eshopAppbackend.services;


import thankous.eshopAppbackend.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product getProductById(long id);
    void deleteProductById(long id);
    void deleteAllProducts();
    Product updateProduct(long id, Product product);
}

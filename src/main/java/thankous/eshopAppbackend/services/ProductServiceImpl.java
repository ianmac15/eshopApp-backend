package thankous.eshopAppbackend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thankous.eshopAppbackend.exceptions.ResourceNotFoundException;
import thankous.eshopAppbackend.models.Product;
import thankous.eshopAppbackend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);

    }

    @Override
    public Product getProductById(long id) {

//        if (id.equals(null)) {
//            throw new InvalidInputException("Id is not valid!. Id must be a number!");
//        }
        Optional<Product> productToFind = productRepository.findById(id);
        Product product;
//        Product product1 = productRepository.findById(id);
//        return new ResponseEntity<>(product1, HttpStatus.OK);
        if (productToFind.isPresent()) {
            product = productToFind.get();
            return product;
        } else {
            throw new ResourceNotFoundException("Product with id: " + id + ", not found");
////            return new ResponseEntity<>(new RuntimeException(), HttpStatus.NOT_FOUND);
////            throw new ResourceNotFoundException("Product wasn't found");
        }
//        return product;
    }

    @Override
    public void deleteProductById(long id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Product with id: " + id + ", not found");
        }

    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public Product updateProduct(long id, Product product) {
        Product product1 = getProductById(id);
        product1.setName(product.getName());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());
        product1.setImage(product.getImage());
        product1.setQuantity(product.getQuantity());
        return productRepository.save(product1);
    }
}

package thankous.eshopAppbackend.controllers;

import org.springframework.web.bind.annotation.*;
import thankous.eshopAppbackend.models.Product;
import thankous.eshopAppbackend.services.ProductServiceImpl;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/product")
public class ProductController {

//    @Autowired
    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(value = "id") long id) {

        return productService.getProductById(id);
//        Product user = this.productRepository.findById(id).orElseThrow(
//                ()-> new ResourceNotFoundException("User not found")
//        );
//
//        return  ResponseEntity.ok().body(user);


    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        Product product1 = productService.saveProduct(product);
        return product1;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable(value = "id") long id, @RequestBody Product product) {
        Product product1 = productService.updateProduct(id, product);
        return product1;
//        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value = "id") long id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }


//    @PostMapping("addProduct")
//    public ResponseEntity<Object> addNewProduct(@RequestBody Product product) {
//        productService.saveProduct(product);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }

//    @PostMapping("newproduct/{productVariables}")
//    public String newProduct(@PathVariable(value = "productVariables") String[] aProduct) {
//        productService.saveProduct(new Product(aProduct[0],aProduct[1],aProduct[2]));
//        return "Product " + aProduct[0] + " has been added to the list.";
//    }


}

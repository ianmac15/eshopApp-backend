package thankous.eshopAppbackend.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import thankous.eshopAppbackend.models.Cart;
import thankous.eshopAppbackend.models.Product;
import thankous.eshopAppbackend.repositories.CartRepository;
import thankous.eshopAppbackend.repositories.ProductRepository;

@Component
public class BootstrapData implements CommandLineRunner {


    private final ProductRepository productRepository;


    private final CartRepository cartRepository;

    public BootstrapData(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Product samsungGalaxy = new Product("Samsung Galaxy", "mobile phone",
                "250 euro", 15, "image-link");
        Product iphone= new Product("I-phone", "mobile phone",
                "300 euro", 20, "image-link");

        Cart cart1 = new Cart("cartA");
        Cart cart2 = new Cart("cartB");

        productRepository.save(samsungGalaxy);
        productRepository.save(iphone);
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        samsungGalaxy.getCarts().add(cart1);
        samsungGalaxy.getCarts().add(cart2);
        iphone.getCarts().add(cart1);
        cart1.getProducts().add(samsungGalaxy);
        cart2.getProducts().add(samsungGalaxy);
        cart1.getProducts().add(iphone);

        productRepository.save(samsungGalaxy);
        productRepository.save(iphone);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
    }
}

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


    private ProductRepository productRepository;
    private CartRepository cartRepository;

    @Autowired
    public BootstrapData(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Product samsungGalaxy = new Product("Samsung Galaxy", "mobile phone",
                250, 15, "https://a.scdn.gr/images/sku_main_images/026813/26813649/xlarge_20210127122756_hp_255_g8_ryzen_3_3250u_8gb_256gb_fhd_w10.jpeg");
        Product iphone= new Product("I-phone", "mobile phone",
                300, 20, "https://a.scdn.gr/images/sku_main_images/027856/27856120/xlarge_20210324113544_dell_vostro_3500_i3_1115g4_8gb_256gb_fhd_w10_home.jpeg");

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

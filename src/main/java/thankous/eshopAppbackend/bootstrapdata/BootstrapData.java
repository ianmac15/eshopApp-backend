package thankous.eshopAppbackend.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import thankous.eshopAppbackend.models.*;
import thankous.eshopAppbackend.repositories.CartRepository;
import thankous.eshopAppbackend.repositories.ProductRepository;
import thankous.eshopAppbackend.repositories.RoleRepository;
import thankous.eshopAppbackend.repositories.UserRepository;

@Component
public class BootstrapData implements CommandLineRunner {


    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public BootstrapData(ProductRepository productRepository, CartRepository cartRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Product samsungGalaxy = new Product("Samsung Galaxy", "mobile phone",
                250, 15, "https://a.scdn.gr/images/sku_main_images/026813/26813649/xlarge_20210127122756_hp_255_g8_ryzen_3_3250u_8gb_256gb_fhd_w10.jpeg");
        Product iphone= new Product("I-phone", "mobile phone",
                300, 20, "https://a.scdn.gr/images/sku_main_images/027856/27856120/xlarge_20210324113544_dell_vostro_3500_i3_1115g4_8gb_256gb_fhd_w10_home.jpeg");
        productRepository.save(samsungGalaxy);
        productRepository.save(iphone);


        Role userRole = new Role((ERole.ROLE_USER));
        Role adminRole = new Role(ERole.ROLE_ADMIN);
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User administrator = new User("ianmac", "12345","3thita@gmail.com");
        administrator.getRoles().add(adminRole);
        User bob = new User("bob", "12345", "bob@dmail.com");
        bob.getRoles().add(userRole);
        User jim = new User("jim", "12345", "jim@dmail.com");
        jim.getRoles().add(userRole);
        userRepository.save(bob);
        userRepository.save(jim);
        userRepository.save(administrator);


        cartRepository.save(bob.getCart());
        cartRepository.save(jim.getCart());

        samsungGalaxy.getCarts().add(bob.getCart());
        samsungGalaxy.getCarts().add(jim.getCart());
        iphone.getCarts().add(bob.getCart());
        bob.getCart().getProducts().add(samsungGalaxy);
        jim.getCart().getProducts().add(samsungGalaxy);
        bob.getCart().getProducts().add(iphone);

        productRepository.save(samsungGalaxy);
        productRepository.save(iphone);
        cartRepository.save(bob.getCart());
        cartRepository.save(jim.getCart());





    }
}

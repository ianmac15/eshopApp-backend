package thankous.eshopAppbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thankous.eshopAppbackend.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}

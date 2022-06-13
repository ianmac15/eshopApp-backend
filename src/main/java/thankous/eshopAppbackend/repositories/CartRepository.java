package thankous.eshopAppbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thankous.eshopAppbackend.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}

package thankous.eshopAppbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import thankous.eshopAppbackend.models.ERole;
import thankous.eshopAppbackend.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

package ma.enset.jpa_enset.repositories;

import ma.enset.jpa_enset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}

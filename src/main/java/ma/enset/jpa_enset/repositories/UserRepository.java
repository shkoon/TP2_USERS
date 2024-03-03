package ma.enset.jpa_enset.repositories;

import ma.enset.jpa_enset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}

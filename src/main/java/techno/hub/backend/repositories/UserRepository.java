package techno.hub.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techno.hub.backend.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}

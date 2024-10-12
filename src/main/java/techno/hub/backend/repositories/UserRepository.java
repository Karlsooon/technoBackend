package techno.hub.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import techno.hub.backend.entities.UserImpl;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserImpl, Integer> {
    Optional<UserImpl> findByUsername(String username);
}

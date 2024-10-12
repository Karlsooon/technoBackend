package techno.hub.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techno.hub.backend.entities.UserImpl;
import techno.hub.backend.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public Optional<UserImpl> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

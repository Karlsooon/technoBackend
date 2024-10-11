package techno.hub.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import techno.hub.backend.entities.UserImpl;
import techno.hub.backend.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(UserImpl userImpl) {
        userImpl.setPassword(passwordEncoder.encode(userImpl.getPassword()));
        userImpl.setRole("ROLE_USER");
        userImpl.setRegistrationDate(LocalDateTime.now());
        userRepository.save(userImpl);
    }
}

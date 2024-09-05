package techno.hub.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import techno.hub.backend.dtos.LoginDTO;
import techno.hub.backend.dtos.RegisterDTO;
import techno.hub.backend.entities.User;
import techno.hub.backend.repositories.UserRepository;
import techno.hub.backend.security.JwtUtil;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;
    public String register(RegisterDTO registerDTO) {
        User newUser = new User();
        newUser.setUsername(registerDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        newUser.setRole("USER");
        userRepository.save(newUser);
        return login(newUser.getUsername(), newUser.getPassword());

    }
    public String login(LoginDTO loginDTO) {
        return login(loginDTO.getUsername(), loginDTO.getPassword());
    }
    private String login(String email, String password) {
        System.out.println("GG2");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        System.out.println("GG3");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("GG4");
        return jwtTokenUtils.generateToken(authentication);
    }

}

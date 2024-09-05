package techno.hub.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import techno.hub.backend.repositories.UserRepository;

@Service
@AllArgsConstructor
public class TechnoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var oUser = userRepository.findByUsername(username);
        return oUser.orElseThrow(() -> new UsernameNotFoundException("[" + username + "] not found!"));
    }
}

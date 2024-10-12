package techno.hub.backend.controllers;

import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techno.hub.backend.dtos.AuthenticationDTO;
import techno.hub.backend.dtos.RefreshTokenDTO;
import techno.hub.backend.entities.UserImpl;
import techno.hub.backend.mappers.UserMapper;
import techno.hub.backend.security.JWTUtil;
import techno.hub.backend.services.RegistrationService;
import techno.hub.backend.services.UserService;
import techno.hub.backend.util.UserValidator;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserValidator userValidator;

    @Autowired
    private final RegistrationService registrationService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/registration")
    public Map<String, String> performRegistration(@RequestBody AuthenticationDTO authenticationDTO,
                                                   BindingResult bindingResult) {
        UserImpl userImpl = userMapper.convertToUserImpl(authenticationDTO);
        userValidator.validate(userImpl, bindingResult);
        if (bindingResult.hasErrors()) {
            return Map.of("message", "Ошибка!");
        }

        registrationService.register(userImpl);

        String accessToken = jwtUtil.generateAccessToken(userImpl.getUsername(), userImpl.getRole());
        String refreshToken = jwtUtil.generateRefreshToken(userImpl.getUsername());

        return Map.of("access-token", accessToken, "refresh-token", refreshToken);

    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());
        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            return Map.of("message", "Incorrect credentials!");
        }

        Optional<UserImpl> user = userService.findByUsername(authenticationDTO.getUsername());
        String accessToken = jwtUtil.generateAccessToken(authenticationDTO.getUsername(), user.get().getRole());
        String refreshToken = jwtUtil.generateRefreshToken(authenticationDTO.getUsername());

        return Map.of("access-token", accessToken, "refresh-token", refreshToken);
    }

    @PostMapping("/refresh-token")
    public Map<String, String> refreshAccessToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {

        try {
            String username = jwtUtil.validateTokenAndRetrieveClaim(refreshTokenDTO.getRefreshToken(), "refresh");

            Optional<UserImpl> user = userService.findByUsername(username);

            if (user.isPresent()) {
                String newAccessToken = jwtUtil.generateAccessToken(username, user.get().getRole());
                return Map.of("access-token", newAccessToken);
            } else {
                return Map.of("message", "User not found");
            }

        } catch (JWTVerificationException e) {
            return Map.of("message", "Invalid refresh token");
        }
    }


}

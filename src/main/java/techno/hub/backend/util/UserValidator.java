package techno.hub.backend.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import techno.hub.backend.entities.UserImpl;
import techno.hub.backend.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return UserImpl.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserImpl userImpl = (UserImpl) target;

        if(userRepository.findByUsername(userImpl.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Username is already in use");
        }
    }
}

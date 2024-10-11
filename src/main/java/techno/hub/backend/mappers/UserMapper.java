package techno.hub.backend.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.AuthenticationDTO;
import techno.hub.backend.entities.UserImpl;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserImpl convertToUserImpl(AuthenticationDTO authenticationDTO) {
        return modelMapper.map(authenticationDTO, UserImpl.class);
    }
}

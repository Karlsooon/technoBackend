package techno.hub.backend.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO {

    @NotEmpty(message = "Username should consist smth")
    @Size(min = 2, max = 100, message = "Username should be between 2 and 100 characters")
    private String username;

    private String password;
}

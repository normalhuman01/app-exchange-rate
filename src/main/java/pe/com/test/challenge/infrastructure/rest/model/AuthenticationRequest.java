package pe.com.test.challenge.infrastructure.rest.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}

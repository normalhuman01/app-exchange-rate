package pe.com.test.challenge.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.test.challenge.application.UserService;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AuthenticationResponse> create(@Validated @RequestBody AuthenticationRequest authenticationRequest) {

        return userService.login(authenticationRequest);
    }

}

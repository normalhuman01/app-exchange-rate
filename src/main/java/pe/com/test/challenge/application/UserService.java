package pe.com.test.challenge.application;

import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<AuthenticationResponse> login(AuthenticationRequest authenticationRequest);
}

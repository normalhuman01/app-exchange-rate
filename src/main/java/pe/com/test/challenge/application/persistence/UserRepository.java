package pe.com.test.challenge.application.persistence;

import pe.com.test.challenge.domain.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> findFirstByUsernameAndPassword(String username, String password);
}

package pe.com.test.challenge.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.com.test.challenge.domain.User;
import reactor.core.publisher.Mono;

public interface UserInMemoryRepository extends ReactiveCrudRepository<User, String> {
    Mono<User> findFirstByUsernameAndPassword(
            String username,
            String password);

}

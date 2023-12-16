package pe.com.test.challenge.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.com.test.challenge.application.persistence.UserRepository;
import pe.com.test.challenge.domain.User;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserInMemoryRepository userInMemoryRepository;

    @Override
    public Mono<User> findFirstByUsernameAndPassword(String username, String password) {

        return userInMemoryRepository.findFirstByUsernameAndPassword(username, password);
    }

}

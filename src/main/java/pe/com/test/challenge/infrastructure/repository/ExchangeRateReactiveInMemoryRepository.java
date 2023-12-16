package pe.com.test.challenge.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import reactor.core.publisher.Mono;

public interface ExchangeRateReactiveInMemoryRepository extends ReactiveCrudRepository<ExchangeRateEntity, String> {

    Mono<ExchangeRateEntity> findFirstByCurrencySourceAndCurrencyTarget(
            String currencySource,
            String currencyTarget);
}

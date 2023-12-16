package pe.com.test.challenge.application.persistence;

import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateSearchCriteriaDto;
import reactor.core.publisher.Mono;

public interface ExchangeRateRepository {
    Mono<ExchangeRateEntity> search(ExchangeRateSearchCriteriaDto exchangeRateSearchCriteriaDto);

    Mono<ExchangeRateEntity> save(ExchangeRateEntity exchangeRateEntity);
}

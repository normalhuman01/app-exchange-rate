package pe.com.test.challenge.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.com.test.challenge.application.persistence.ExchangeRateRepository;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateSearchCriteriaDto;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private final ExchangeRateReactiveInMemoryRepository exchangeRateReactiveInMemoryRepository;

    public Mono<ExchangeRateEntity> search(ExchangeRateSearchCriteriaDto exchangeRateSearchCriteriaDto) {

        return exchangeRateReactiveInMemoryRepository.findFirstByCurrencySourceAndCurrencyTarget(
                        exchangeRateSearchCriteriaDto.getCurrencySource(),
                        exchangeRateSearchCriteriaDto.getCurrencyTarget())
                .doOnSuccess(exchangeRateEntity -> log.debug("ExchangeRateEntity -> {}", exchangeRateEntity));
    }

    @Override
    public Mono<ExchangeRateEntity> save(ExchangeRateEntity exchangeRateEntity) {
        return exchangeRateReactiveInMemoryRepository.save(exchangeRateEntity);
    }
}

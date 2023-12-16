package pe.com.test.challenge.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.test.challenge.application.ExchangeRateMapper;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.application.persistence.ExchangeRateRepository;
import pe.com.test.challenge.domain.exception.CurrencyNotFoundException;
import pe.com.test.challenge.domain.exception.UserNotFoundException;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;

    @Override
    public Mono<ExchangeRateResponse> calculate(ExchangeRateRequest exchangeRateRequest) {

        return Mono.just(exchangeRateRequest)
                .map(exchangeRateMapper::toExchangeRateSearchCriteriaDto)
                .flatMap(exchangeRateRepository::search)
                .switchIfEmpty(Mono.error(new CurrencyNotFoundException("Currency not found")))
                .flatMap(exchangeRateEntity -> Mono.just(exchangeRateEntity)
                        .map(exchangeRateMapper::toExchangeRate)
                        .map(exchangeRate -> exchangeRate.calculate(exchangeRateRequest.getAmount()))
                        .map(amount -> exchangeRateMapper.toExchangeRateResponse(exchangeRateEntity, exchangeRateRequest, amount)));
    }

    @Override
    public Mono<ExchangeRateUpdateResponse> update(ExchangeRateUpdateRequest exchangeRateUpdateRequest) {
        return Mono.just(exchangeRateUpdateRequest)
                .map(exchangeRateMapper::toExchangeRateSearchCriteriaDto)
                .flatMap(exchangeRateRepository::search)
                .switchIfEmpty(Mono.error(new CurrencyNotFoundException("Currency not found")))
                .flatMap(exchangeRateEntity -> {
                    exchangeRateEntity.setExchangeRateAmount(exchangeRateUpdateRequest.getExchangeRateAmount());
                    return exchangeRateRepository.save(exchangeRateEntity);
                })
                .map(this.exchangeRateMapper::toExchangeRateUpdateResponse);
    }

}

package pe.com.test.challenge.application.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.test.challenge.application.ExchangeRateMapperImpl;
import pe.com.test.challenge.application.persistence.ExchangeRateRepository;
import pe.com.test.challenge.domain.Currency;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateSearchCriteriaDto;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceImplTest {

    @Mock
    private ExchangeRateRepository exchangeRateRepository;
    @Spy
    private ExchangeRateMapperImpl exchangeRateMapperImpl;
    @InjectMocks
    private ExchangeRateServiceImpl exchangeRateServiceImpl;

    @DisplayName("Return exchange rate calculated when currencies exist in repository")
    @Test
    void returnExchangeRateCalculatedWhenCurrenciesExistInRepository() {

        var exchangeRateEntity = new ExchangeRateEntity(1, new BigDecimal("0.26"), "PEN", "USD");
        var exchangeRateRequest = new ExchangeRateRequest(new BigDecimal("100"), Currency.PEN, Currency.USD);

        when(exchangeRateRepository.search(any(ExchangeRateSearchCriteriaDto.class)))
                .thenReturn(Mono.just(exchangeRateEntity));

        StepVerifier.create(exchangeRateServiceImpl.calculate(exchangeRateRequest))
                .expectNextMatches(exchangeRateResponse ->
                        exchangeRateResponse.getQuotationAmount().compareTo(new BigDecimal("26")) == 0)
                .verifyComplete();
    }
}
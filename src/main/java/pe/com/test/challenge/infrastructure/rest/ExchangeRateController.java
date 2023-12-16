package pe.com.test.challenge.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ExchangeRateResponse> create(@Validated @RequestBody ExchangeRateRequest exchangeRateRequest) {

        return exchangeRateService.calculate(exchangeRateRequest);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ExchangeRateUpdateResponse> update(@Validated @RequestBody ExchangeRateUpdateRequest exchangeRateUpdateRequest) {

        return exchangeRateService.update(exchangeRateUpdateRequest);
    }
}

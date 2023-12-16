package pe.com.test.challenge.infrastructure.rest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.com.test.challenge.domain.Currency;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class ExchangeRateUpdateResponse {
    private Currency currencySource;
    private Currency currencyTarget;
    private BigDecimal exchangeRateAmount;
}

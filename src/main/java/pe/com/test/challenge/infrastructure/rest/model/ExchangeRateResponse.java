package pe.com.test.challenge.infrastructure.rest.model;

import lombok.*;
import pe.com.test.challenge.domain.Currency;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ExchangeRateResponse {
    private BigDecimal amount;
    private Currency currencySource;
    private Currency currencyTarget;
    private BigDecimal exchangeRateAmount;
    private BigDecimal quotationAmount;
}

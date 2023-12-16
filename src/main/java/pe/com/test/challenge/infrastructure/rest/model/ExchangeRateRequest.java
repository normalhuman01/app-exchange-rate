package pe.com.test.challenge.infrastructure.rest.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import pe.com.test.challenge.domain.Currency;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ExchangeRateRequest {
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Currency currencySource;
    @NotNull
    private Currency currencyTarget;
}
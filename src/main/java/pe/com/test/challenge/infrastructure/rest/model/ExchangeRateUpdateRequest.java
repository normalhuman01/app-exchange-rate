package pe.com.test.challenge.infrastructure.rest.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class ExchangeRateUpdateRequest {

    @NotNull
    private BigDecimal exchangeRateAmount;
    @NotNull
    private String currencySource;
    @NotNull
    private String currencyTarget;
}

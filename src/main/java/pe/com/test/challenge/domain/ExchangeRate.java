package pe.com.test.challenge.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRate {

    private BigDecimal exchangeRateAmount;

    public BigDecimal calculate(BigDecimal amount) {
        return amount.multiply(exchangeRateAmount);
    }
}

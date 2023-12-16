package pe.com.test.challenge.infrastructure.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ExchangeRateSearchCriteriaDto {
    private String currencySource;
    private String currencyTarget;
}

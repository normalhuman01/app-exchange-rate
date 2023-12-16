package pe.com.test.challenge.infrastructure.repository.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(name = "ExchangeRate")
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
public class ExchangeRateEntity {
    @Id
    private Integer id;
    private BigDecimal exchangeRateAmount;
    private String currencySource;
    private String currencyTarget;
}

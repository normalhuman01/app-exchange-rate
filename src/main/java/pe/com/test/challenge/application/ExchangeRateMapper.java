package pe.com.test.challenge.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pe.com.test.challenge.domain.ExchangeRate;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateSearchCriteriaDto;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateUpdateResponse;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ExchangeRateMapper {

    ExchangeRateSearchCriteriaDto toExchangeRateSearchCriteriaDto(ExchangeRateRequest exchangeRateRequest);

    ExchangeRateSearchCriteriaDto toExchangeRateSearchCriteriaDto(ExchangeRateUpdateRequest exchangeRateUpdateRequest);

    ExchangeRate toExchangeRate(ExchangeRateEntity exchangeRateEntity);

    @Mapping(target = "currencySource", source = "exchangeRateEntity.currencySource")
    @Mapping(target = "currencyTarget", source = "exchangeRateEntity.currencyTarget")
    @Mapping(target = "exchangeRateAmount", source = "exchangeRateEntity.exchangeRateAmount")
    @Mapping(target = "quotationAmount", source = "amount")
    ExchangeRateResponse toExchangeRateResponse(ExchangeRateEntity exchangeRateEntity,
                                                ExchangeRateRequest exchangeRateRequest, BigDecimal amount);

    @Mapping(target = "currencySource", source = "exchangeRateEntity.currencySource")
    @Mapping(target = "currencyTarget", source = "exchangeRateEntity.currencyTarget")
    @Mapping(target = "exchangeRateAmount", source = "exchangeRateEntity.exchangeRateAmount")
    ExchangeRateUpdateResponse toExchangeRateUpdateResponse(ExchangeRateEntity exchangeRateEntity);
}

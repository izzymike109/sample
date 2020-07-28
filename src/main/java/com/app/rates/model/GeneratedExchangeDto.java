package com.app.rates.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO referring to a converted/generated Exchange Rate based on the available requested amount and rate per currency.
 *
 */
@Data
@NoArgsConstructor
public class GeneratedExchangeDto extends ExchangeRateDto {

    private BigDecimal requestedAmount;
    private BigDecimal convertedAmount;

    public GeneratedExchangeDto(final BigDecimal requestedAmount, final BigDecimal convertedAmount, final String currency, final String provider, final BigDecimal value, final BigDecimal fee, final LocalDate date) {

        super(currency, provider, value, fee, date);
        this.requestedAmount = requestedAmount;
        this.convertedAmount = convertedAmount;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

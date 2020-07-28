package com.app.rates.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO referring to an Exchange Rate contained within the system.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDto {

    private String currency;
    private String provider;
    private BigDecimal value;
    private BigDecimal fee;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

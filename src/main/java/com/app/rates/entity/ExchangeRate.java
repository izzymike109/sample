package com.app.rates.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity to identify an Exchange Rate.
 *
 */
@Data
@Entity(name = "RATES")
public class ExchangeRate {

    @Id
    @GeneratedValue
    private int id;

    private String currency;
    private String provider;
    private BigDecimal value;
    private BigDecimal fee;
    private LocalDate date;

    public ExchangeRate() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

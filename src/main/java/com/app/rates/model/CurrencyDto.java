package com.app.rates.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO referring to a Currency contained within the system.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {

    private String code;
    private String name;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

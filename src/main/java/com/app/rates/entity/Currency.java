package com.app.rates.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity to identify a Currency.
 *
 */
@Data
@Entity(name = "CURRENCIES")
public class Currency {

    @Id
    @GeneratedValue
    private int id;

    private String code;
    private String name;

    public Currency() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

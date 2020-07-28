package com.app.rates.controller;

import com.app.rates.model.CurrencyDto;
import com.app.rates.model.ExchangeRateDto;
import com.app.rates.model.GeneratedExchangeDto;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeRatesControllerTest extends AbstractTest {

    @Test
    public void getBestRates() throws Exception {

        final BigDecimal requestedAmount = TEN;
        final String currencyFrom = "EUR";
        final String currencyTo = "GBP";
        String uri = String.format("/rates/bestrates?amount=%s&currencyFrom=%s&currencyTo=%s", requestedAmount.toPlainString(), currencyFrom, currencyTo);

        LocalDate date = LocalDate.parse("17-09-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        GeneratedExchangeDto generatedExchangeDto = new GeneratedExchangeDto(TEN, new BigDecimal("9.1120"), currencyFrom, "Bank Of Ireland", new BigDecimal("0.91120"), ZERO, date);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        GeneratedExchangeDto[] result = super.mapFromJson(content, GeneratedExchangeDto[].class);
        assertTrue(result.length > 0);
        assertThat(result).contains(generatedExchangeDto);
    }

    @Test
    public void getLatestRates() throws Exception {

        String uri = "/rates/latest";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        ExchangeRateDto[] result = super.mapFromJson(content, ExchangeRateDto[].class);
        assertTrue(result.length > 0);
    }

    @Test
    public void getCurrencies() throws Exception {

        String uri = "/rates/currencies";
        CurrencyDto currency = new CurrencyDto("EUR", "Euro");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

        CurrencyDto[] result = super.mapFromJson(content, CurrencyDto[].class);
        assertTrue(result.length > 0);
        assertThat(result).contains(currency);
    }

    // TODO: more comprehensive test cases required

}

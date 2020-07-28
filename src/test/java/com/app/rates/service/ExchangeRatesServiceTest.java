package com.app.rates.service;

import com.app.rates.Application;
import com.app.rates.converter.ExchangeRateConverter;
import com.app.rates.entity.Currency;
import com.app.rates.entity.ExchangeRate;
import com.app.rates.model.CurrencyDto;
import com.app.rates.model.ExchangeRateDto;
import com.app.rates.model.GeneratedExchangeDto;
import com.app.rates.repository.ExchangeRatesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = Application.class)
public class ExchangeRatesServiceTest {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @MockBean
    private ExchangeRatesRepository exchangeRatesRepositoryMock;

    @Test
    public void getCurrencies() throws IOException {

        // given
        final Currency euroEntity = new Currency();
        euroEntity.setCode("EUR");
        euroEntity.setName("Euro");
        final CurrencyDto euroDto = ExchangeRateConverter.toCurrencyDto(euroEntity);

        when(exchangeRatesRepositoryMock.getCurrencies()).thenReturn(Arrays.asList(euroEntity));

        // when
        final List<CurrencyDto> result = exchangeRatesService.getCurrencies();

        // then
        Assert.assertNotNull(result);
        assertThat(result).contains(euroDto);
    }

    @Test
    public void getBestRates() throws IOException {

        // given
        final String currency = "EUR";
        final BigDecimal requestedAmount = new BigDecimal("100.00");
        final String currencyFrom = "GBP";

        final ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency(currency);
        exchangeRate.setProvider("Euro Bank");
        exchangeRate.setValue(new BigDecimal("0.001"));
        exchangeRate.setFee(new BigDecimal("0.00"));

        final GeneratedExchangeDto rateExchangeDto = ExchangeRateConverter.toRateExchangeDto(exchangeRate, requestedAmount, requestedAmount.multiply(exchangeRate.getValue()));
        when(exchangeRatesRepositoryMock.getLatestByCurrency(currency)).thenReturn(Arrays.asList(exchangeRate));

        // when
        final List<GeneratedExchangeDto> result = exchangeRatesService.getBestRates(requestedAmount, currencyFrom, currency);

        // then
        Assert.assertNotNull(result);
        assertThat(result).contains(rateExchangeDto);
    }

    @Test
    public void getLatestRates() throws IOException {

        // given
        final String currency = "EUR";
        final BigDecimal requestedAmount = new BigDecimal("100.00");
        final String currencyFrom = "GBP";

        final ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency(currency);
        exchangeRate.setProvider("Euro Bank");
        exchangeRate.setValue(new BigDecimal("0.001"));
        exchangeRate.setFee(new BigDecimal("0.00"));

        final ExchangeRateDto rateDto = ExchangeRateConverter.toRateDto(exchangeRate);
        when(exchangeRatesRepositoryMock.findAll()).thenReturn(Arrays.asList(exchangeRate));

        // when
        final List<ExchangeRateDto> result = exchangeRatesService.getLatestRates();

        // then
        Assert.assertNotNull(result);
        assertThat(result).contains(rateDto);
    }

    // TODO: more comprehensive test cases required

}

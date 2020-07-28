package com.app.rates.controller;

import com.app.rates.model.CurrencyDto;
import com.app.rates.model.ExchangeRateDto;
import com.app.rates.model.GeneratedExchangeDto;
import com.app.rates.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Exchange Rates Controller. The purpose of this controller class is to provide endpoints allowing retrieval
 * of foreign exchange rates, currencies and best available foreign exchange rates contained within the system.
 *
 */
@RestController
@RequestMapping("/rates")
public class ExchangeRatesController {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @RequestMapping(value = "/bestrates", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<GeneratedExchangeDto> getBestRates(@RequestParam(name = "amount") final BigDecimal amount, @RequestParam(name = "currencyFrom") final String currencyFrom, @RequestParam(name = "currencyTo") final String currencyTo) {

        return exchangeRatesService.getBestRates(amount, currencyFrom, currencyTo);
    }

    @RequestMapping(value = "/latest", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<ExchangeRateDto> getLatestRates() {

        return exchangeRatesService.getLatestRates();
    }

    @RequestMapping(value = "/currencies", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<CurrencyDto> getCurrencies() {

        return exchangeRatesService.getCurrencies();
    }
}

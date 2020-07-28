package com.app.rates.service;

import com.app.rates.converter.ExchangeRateConverter;
import com.app.rates.entity.ExchangeRate;
import com.app.rates.exception.InvalidDataException;
import com.app.rates.model.CurrencyDto;
import com.app.rates.model.ExchangeRateDto;
import com.app.rates.model.GeneratedExchangeDto;
import com.app.rates.repository.ExchangeRatesRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class handling all service layer interaction between Web and Data layers while carrying out any required business logic
 * to assist in exchange rate conversions or retrieving best exchange rates available.
 *
 */
@Service
public class ExchangeRatesService {

    private static final Logger LOGGER= LoggerFactory.getLogger(ExchangeRatesService.class);

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    /**
     * Get the best exchange rates available to the application in order of best converted value based on the requested
     * <code>requestedAmount</code> to the given currency <code>currencyTo</code>.
     *
     * @param requestedAmount
     * @param currencyFrom
     * @param currencyTo
     * @return exchange rates in order of best exchanged rate value
     */
    public List<GeneratedExchangeDto> getBestRates(final BigDecimal requestedAmount, final String currencyFrom, final String currencyTo) {

        ArrayList<GeneratedExchangeDto> exchangeRateDtos = new ArrayList<>();

        LOGGER.info("Attempting to search for best rates available: requestedAmount {}, convert from {}, converted to {}", requestedAmount, currencyFrom, currencyTo);

        if (StringUtils.isNotBlank(currencyFrom) && StringUtils.isNotBlank(currencyTo)) {

            final boolean sameCurrency = currencyFrom.equalsIgnoreCase(currencyTo);
            final List<ExchangeRate> exchangeRates = exchangeRatesRepository.getLatestByCurrency(currencyTo.toUpperCase());
            exchangeRateDtos = ExchangeRateConverter.toRateExchangeDtos(exchangeRates, requestedAmount, sameCurrency);

            if (CollectionUtils.isNotEmpty(exchangeRateDtos)) {
                final GeneratedExchangeDto topExchangeRate = exchangeRateDtos.get(0);
                LOGGER.info("Found top exchange rate available: requestedAmount {}, convert from {}, converted to {}, convertedAmount {}", requestedAmount, currencyFrom, currencyTo, topExchangeRate.getConvertedAmount());
            }

        } else {
            throw new InvalidDataException("Missing currency to convert from or to!");
        }

        return exchangeRateDtos;
    }

    /**
     * Get the latest exchange rates available for today.
     *
     * @return latest exchange rate for today
     */
    public List<ExchangeRateDto> getLatestRates() {

        return ExchangeRateConverter.toRateDtos(exchangeRatesRepository.findAll());
    }

    /**
     * Get all currencies currently supported by the application.
     *
     * @return list of currencies supported
     */
    public List<CurrencyDto> getCurrencies() {

        return ExchangeRateConverter.toCurrencyDtos(exchangeRatesRepository.getCurrencies());
    }

}

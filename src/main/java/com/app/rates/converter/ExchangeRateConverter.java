package com.app.rates.converter;

import com.app.rates.entity.Currency;
import com.app.rates.entity.ExchangeRate;
import com.app.rates.model.CurrencyDto;
import com.app.rates.model.ExchangeRateDto;
import com.app.rates.model.GeneratedExchangeDto;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Helper class to support conversion bewtween Web and Data layer objects.
 *
 */
public class ExchangeRateConverter {

    public static List<ExchangeRateDto> toRateDtos(final List<ExchangeRate> exchangeRates) {

        return exchangeRates.stream().map(exchangeRate -> toRateDto(exchangeRate))
                .collect(Collectors.toList());
    }

    public static ExchangeRateDto toRateDto(final ExchangeRate exchangeRate) {

        return new ExchangeRateDto(exchangeRate.getCurrency(), exchangeRate.getProvider(), exchangeRate.getValue(), exchangeRate.getFee(), exchangeRate.getDate());
    }

    public static ArrayList<GeneratedExchangeDto> toRateExchangeDtos(final List<ExchangeRate> exchangeRates, final BigDecimal requestedAmount, final boolean sameCurrency) {

        ArrayList<GeneratedExchangeDto> exchangeRateDtos = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(exchangeRates)) {

            exchangeRates.stream().forEach(r -> {
                // check if the same currency - no need to convert
                final BigDecimal convertedAmount = sameCurrency ? requestedAmount : requestedAmount.multiply(r.getValue());
                exchangeRateDtos.add(toRateExchangeDto(r, requestedAmount, convertedAmount));
            });
        }

        return exchangeRateDtos;
    }

    public static GeneratedExchangeDto toRateExchangeDto(final ExchangeRate exchangeRate, final BigDecimal requestedAmount, final BigDecimal convertedAmount) {

        return new GeneratedExchangeDto(requestedAmount, convertedAmount, exchangeRate.getCurrency(), exchangeRate.getProvider(), exchangeRate.getValue(), exchangeRate.getFee(), exchangeRate.getDate());
    }

    public static List<CurrencyDto> toCurrencyDtos(List<Currency> currencies) {

        ArrayList<CurrencyDto> currencyDtos = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(currencies)) {

            currencies.stream().forEach(c -> currencyDtos.add(toCurrencyDto(c)));
        }

        return currencyDtos;
    }

    public static CurrencyDto toCurrencyDto(Currency currency) {

        return new CurrencyDto(currency.getCode(), currency.getName());
    }
}

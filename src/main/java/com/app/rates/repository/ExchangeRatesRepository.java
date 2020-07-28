package com.app.rates.repository;

import com.app.rates.entity.Currency;
import com.app.rates.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRate, Long> {

    @Query("SELECT r FROM RATES r WHERE UPPER(r.currency) = :currency order by r.value DESC")
    public List<ExchangeRate> getLatestByCurrency(final String currency);

    @Query("SELECT c FROM CURRENCIES c")
    public List<Currency> getCurrencies();
}

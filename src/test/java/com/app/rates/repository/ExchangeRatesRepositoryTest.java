package com.app.rates.repository;

import com.app.rates.entity.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExchangeRatesRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Test
    public void getCurrencies() {

        // when
        List<Currency> result = exchangeRatesRepository.getCurrencies();

        // then
        assertNotNull(result);
        assertThat(result.size()).isGreaterThan(1);
    }

    // TODO: more comprehensive test cases required
}

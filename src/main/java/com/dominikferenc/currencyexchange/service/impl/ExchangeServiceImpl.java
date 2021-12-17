package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.model.AmountAfterExchange;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    //private final ExchangeRateDTO exchangeRateDTO;
    /*private final BigDecimal amount;
    private final BigDecimal currency;
    private final BigDecimal fromCurrency;
    private final BigDecimal toCurrency;*/
    private final AmountAfterExchange amountAfterExchange;


    @Override
    public Exchange currencyExchange() {
        BigDecimal amount = BigDecimal.valueOf(123);
        new AmountAfterExchange(amount);
        return null;
    }
}

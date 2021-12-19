package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;

public interface ExchangeService {
    void currencyExchange(ExchangeRateDTO exchangeRateDto);
}

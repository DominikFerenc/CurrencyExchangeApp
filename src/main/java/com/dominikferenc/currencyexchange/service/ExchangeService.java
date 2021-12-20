package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.AfterExchangeDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;

public interface ExchangeService {
    AfterExchangeDTO currencyExchange(ExchangeRateDTO exchangeRateDto);
}

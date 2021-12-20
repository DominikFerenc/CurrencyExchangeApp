package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;

public interface ApiClient {
    ApiResponseDTO.Rate getRate(String currency);
    ApiAllRatesResponseDTO getAllRates();
}

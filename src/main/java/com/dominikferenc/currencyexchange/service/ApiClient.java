package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;

public interface ApiClient {
    ApiResponseDTO getRate();
    ApiAllRatesResponseDTO getAllRates();
}

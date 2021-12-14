package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;

public interface ApiClient {
    ApiResponseDTO.Rate getRate();
}

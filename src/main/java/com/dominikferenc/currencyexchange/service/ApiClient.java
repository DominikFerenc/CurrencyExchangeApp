package com.dominikferenc.currencyexchange.service;

import com.dominikferenc.currencyexchange.dto.ApiDTO;

public interface ApiClient {
    ApiDTO getRate();
}

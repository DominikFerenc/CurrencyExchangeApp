package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.service.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class ApiClientImpl implements ApiClient {
    private final RestTemplate restTemplate;

    @Override
    public ApiResponseDTO.Rate getRate() {
        ResponseEntity<ApiResponseDTO> response;
        Exchange exchange = new Exchange();
        Integer statusCode;
        final String endpointNBPPath = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today?format=json";
        response = restTemplate.getForEntity(endpointNBPPath, ApiResponseDTO.class);
        statusCode = response.getStatusCodeValue();
        var rates = response.getBody();
        return rates.getRates().stream().findFirst().orElseThrow();
    }
}

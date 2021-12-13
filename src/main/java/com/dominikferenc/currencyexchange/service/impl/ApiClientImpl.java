package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
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
        Integer statusCode;
        //"http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/today?format=json";
        final String endpointNBPPath = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today?format=json";
        response = restTemplate.getForEntity(endpointNBPPath, ApiResponseDTO.class);
        statusCode = response.getStatusCodeValue();
        var rates = response.getBody();
        System.out.println(rates.getTable());
        System.out.println(rates.getCode());
        System.out.println(statusCode);
        //return rates;
        return rates.getRates().stream().findFirst().orElseThrow();
    }
}

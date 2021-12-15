package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.service.ApiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
@AllArgsConstructor
public class ApiClientImpl implements ApiClient {
    private final RestTemplate restTemplate;

    @Override
    public ApiResponseDTO getRate() {
        ResponseEntity<ApiResponseDTO> response;
        Exchange exchange = new Exchange();
        Integer statusCode;
        final String endpointNBPPath = "http://api.nbp.pl/api/exchangerates/rates/a/usd/today";
        response = restTemplate.getForEntity(endpointNBPPath, ApiResponseDTO.class);
        statusCode = response.getStatusCodeValue();
        var rates = response.getBody();
        return Arrays.stream(new ApiResponseDTO[]{rates}).findAny().get();
        //rates.getRates().stream().findFirst().orElseThrow();

    }

    @Override
    public ApiAllRatesResponseDTO getAllRates() {
        ResponseEntity<ApiAllRatesResponseDTO[]> response;
        Exchange exchange = new Exchange();
        Integer statusCode;
        final String endpoint = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
        response = restTemplate.getForEntity(endpoint, ApiAllRatesResponseDTO[].class);
        statusCode = response.getStatusCodeValue();
        var rates = response.getBody();
        return Arrays.stream(rates).findAny().get();
    }
}

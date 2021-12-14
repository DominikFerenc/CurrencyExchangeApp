package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.ApiDTO;
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
    public ApiDTO getRate() {
        ResponseEntity<ApiDTO[]> response;
        Integer statusCode;
        //"http://api.nbp.pl/api/exchangerates/rates/c/" + currency + "/today?format=json";
        //http://api.nbp.pl/api/exchangerates/tables/c/today/?format=json
        //final String endpointNBPPath = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today?format=json";
        final String endpointNBPPath = "http://api.nbp.pl/api/exchangerates/tables/c/today/?format=json";
        //response = restTemplate.getForEntity(endpointNBPPath, ApiResponseDTO.class);
        response = restTemplate.getForEntity(endpointNBPPath, ApiDTO[].class);
        statusCode = response.getStatusCodeValue();
        var rates = response.getBody();

        //return rates;
        return Arrays.stream(rates).findAny().get();
                //getRates().stream().findFirst().orElseThrow();
    }
}

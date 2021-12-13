package com.dominikferenc.currencyexchange.controller.impl;


import com.dominikferenc.currencyexchange.controller.CurrencyExchangeController;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.service.ApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeControllerImpl implements CurrencyExchangeController {
    private final ApiClient client;

    @Override
    public ResponseEntity<ApiResponseDTO.Rate> getAllRate() {
        return new ResponseEntity<>(client.getRate(), HttpStatus.BAD_REQUEST);
    }
}

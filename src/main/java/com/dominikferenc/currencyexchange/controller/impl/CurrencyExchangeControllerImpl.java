package com.dominikferenc.currencyexchange.controller.impl;


import com.dominikferenc.currencyexchange.controller.CurrencyExchangeController;
import com.dominikferenc.currencyexchange.dto.AfterExchangeDTO;
import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;
import com.dominikferenc.currencyexchange.enums.Current;
import com.dominikferenc.currencyexchange.repository.CurrencyExchangeRepository;
import com.dominikferenc.currencyexchange.service.ApiClient;
import com.dominikferenc.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeControllerImpl implements CurrencyExchangeController {
    private final ApiClient client;
    private final ExchangeService exchangeService;



    @Override
    public ResponseEntity<ApiAllRatesResponseDTO.Rate> getAllRate() {
        return new ResponseEntity(client.getAllRates(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AfterExchangeDTO> currencyExchange(@RequestBody ExchangeRateDTO exchangeRateDTO) {
        var afterExchange =  exchangeService.currencyExchange(exchangeRateDTO);
        return new ResponseEntity<>(afterExchange, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Current>> getAllCurrency() {
        return new ResponseEntity<>(Arrays.asList(Current.values()), HttpStatus.OK);
    }
}

package com.dominikferenc.currencyexchange.controller.impl;


import com.dominikferenc.currencyexchange.controller.CurrencyExchangeController;
import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.enums.Current;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.repository.CurrencyExchangeRepository;
import com.dominikferenc.currencyexchange.service.ApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeControllerImpl implements CurrencyExchangeController {
    private final ApiClient client;
    private final CurrencyExchangeRepository currencyExchangeRepository;


    @Override
    public ResponseEntity<ApiResponseDTO.Rate> getRate() {
        return new ResponseEntity(client.getRate(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiAllRatesResponseDTO.Rate> getAllRate() {
        return new ResponseEntity(client.getAllRates(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Exchange> saveCurrency(Exchange toSave) {
        currencyExchangeRepository.save(toSave);
        var currency = toSave;
        System.out.println(currency.getCurrency());

        return new ResponseEntity<>(currency, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Current>> getAllCurrency() {
        return new ResponseEntity<>(Arrays.asList(Current.values()), HttpStatus.OK);
    }
}

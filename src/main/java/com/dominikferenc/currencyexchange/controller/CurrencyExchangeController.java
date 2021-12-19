package com.dominikferenc.currencyexchange.controller;

import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;
import com.dominikferenc.currencyexchange.enums.Current;
import com.dominikferenc.currencyexchange.model.Exchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/current")
public interface CurrencyExchangeController {
    @GetMapping
    ResponseEntity<ApiResponseDTO.Rate> getRate();

    @GetMapping("/rates")
    ResponseEntity<ApiAllRatesResponseDTO.Rate> getAllRate();

    @PostMapping("")
    ResponseEntity<Exchange> saveCurrency(@RequestBody ExchangeRateDTO toSave);

    @GetMapping(value = "/currency")
    ResponseEntity<List<Current>> getAllCurrency();
}

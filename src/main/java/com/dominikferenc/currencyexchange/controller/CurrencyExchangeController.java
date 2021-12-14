package com.dominikferenc.currencyexchange.controller;

import com.dominikferenc.currencyexchange.dto.ApiDTO;
import com.dominikferenc.currencyexchange.model.Exchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/current")
public interface CurrencyExchangeController {
    @GetMapping
    ResponseEntity<ApiDTO.Rate> getAllRate();

    @PostMapping("/currency")
    ResponseEntity<Exchange> saveCurrency(@RequestBody Exchange toSave);
}

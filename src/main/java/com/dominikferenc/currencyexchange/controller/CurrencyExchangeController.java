package com.dominikferenc.currencyexchange.controller;

import com.dominikferenc.currencyexchange.dto.ApiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/current")
public interface CurrencyExchangeController {
    @GetMapping
    ResponseEntity<ApiResponseDTO.Rate> getAllRate();
}

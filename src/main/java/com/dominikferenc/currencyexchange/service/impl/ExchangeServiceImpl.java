package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.ApiAllRatesResponseDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.repository.CurrencyExchangeRepository;
import com.dominikferenc.currencyexchange.service.ApiClient;
import com.dominikferenc.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ApiClient apiClient;
    private final CurrencyExchangeRepository currencyExchangeRepository;



    @Override
    public void currencyExchange(ExchangeRateDTO exchangeRateDto) {
        var exchange = new Exchange();


        //serwis;
        var amount = exchangeRateDto.getAmount();
        var fromCurrency = exchangeRateDto.getFromCurrency();
        var toCurrnecy = exchangeRateDto.getToCurrency();
        
        exchange.setFromCurrency(exchangeRateDto.getFromCurrency());
        exchange.setToCurrency(exchangeRateDto.getToCurrency());
        exchange.setAmount(exchangeRateDto.getAmount());

        currencyExchangeRepository.save(exchange);





        BigDecimal amountAfterexchannge;

        if (fromCurrency != "PLN" && toCurrnecy != "PLN") {
            var rateFromCurrency = apiClient.getRate(fromCurrency);
            var rateToCurrency = apiClient.getRate(toCurrnecy);
            var toCurrencPln = amount.multiply(rateFromCurrency.getMid());
            amountAfterexchannge = toCurrencPln.divide(rateToCurrency.getMid(), 2, RoundingMode.HALF_UP);

        }
        else if (fromCurrency == "PLN") {
            var rateToCurrency = apiClient.getRate(toCurrnecy);
            amountAfterexchannge = amount.divide(rateToCurrency.getMid(), 2, RoundingMode.HALF_UP);

        }
        else {
            var rateFromCurrency = apiClient.getRate(fromCurrency);
            amountAfterexchannge = amount.multiply(rateFromCurrency.getMid());
            System.out.println(amountAfterexchannge);
        }
        System.out.println(amountAfterexchannge);




    }
}

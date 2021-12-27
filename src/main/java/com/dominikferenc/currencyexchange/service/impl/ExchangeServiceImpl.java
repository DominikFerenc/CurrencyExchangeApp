package com.dominikferenc.currencyexchange.service.impl;

import com.dominikferenc.currencyexchange.dto.AfterExchangeDTO;
import com.dominikferenc.currencyexchange.dto.ExchangeRateDTO;
import com.dominikferenc.currencyexchange.model.Exchange;
import com.dominikferenc.currencyexchange.repository.CurrencyExchangeRepository;
import com.dominikferenc.currencyexchange.service.ApiClient;
import com.dominikferenc.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ApiClient apiClient;
    private final CurrencyExchangeRepository currencyExchangeRepository;


    @Override
    public AfterExchangeDTO currencyExchange(ExchangeRateDTO exchangeRateDto) {
        var exchange = new Exchange();
        AfterExchangeDTO afterExchangeDTO = new AfterExchangeDTO();
        var amount = exchangeRateDto.getAmount();
        var fromCurrency = exchangeRateDto.getFromCurrency();
        var toCurrnecy = exchangeRateDto.getToCurrency();

        BigDecimal amountAfterexchannge;

        if (fromCurrency.equals("PLN") && toCurrnecy.equals("PLN")) {
            var rateFromCurrency = apiClient.getRate(fromCurrency);
            var rateToCurrency = apiClient.getRate(toCurrnecy);
            var toCurrencyPln = amount.multiply(rateFromCurrency.getMid());
            amountAfterexchannge = toCurrencyPln.divide(rateToCurrency.getMid(), 2, RoundingMode.HALF_UP);

        }
        else if (fromCurrency.equals("PLN")) {
            var rateToCurrency = apiClient.getRate(toCurrnecy);
            amountAfterexchannge = amount.divide(rateToCurrency.getMid(), 2, RoundingMode.HALF_UP);

        }
        else {
            var rateFromCurrency = apiClient.getRate(fromCurrency);
            amountAfterexchannge = amount.multiply(rateFromCurrency.getMid());
        }

        afterExchangeDTO.setAmountAfterExchange(amountAfterexchannge);

        exchange.setAmountAfterExchange(amountAfterexchannge);
        exchange.setFromCurrency(exchangeRateDto.getFromCurrency());
        exchange.setToCurrency(exchangeRateDto.getToCurrency());
        exchange.setAmount(exchangeRateDto.getAmount());

        currencyExchangeRepository.save(exchange);
        return afterExchangeDTO;
    }
}

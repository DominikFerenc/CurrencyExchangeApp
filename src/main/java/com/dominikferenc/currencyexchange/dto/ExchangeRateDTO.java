package com.dominikferenc.currencyexchange.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class ExchangeRateDTO {
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
    private String currency;
    private BigDecimal amountAfterExchange;
}

package com.dominikferenc.currencyexchange.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class ApiAllRatesResponseDTO {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<Rate> rates;
    @Data
    public static final class Rate {
        private String currency;
        private String code;
        private BigDecimal Mid;
    }

}

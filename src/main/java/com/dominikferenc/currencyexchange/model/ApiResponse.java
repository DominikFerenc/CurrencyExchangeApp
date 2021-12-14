package com.dominikferenc.currencyexchange.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "api_response")
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    @Id
    private Long id;

    private String table;
    private String no;
    private LocalDate tradingDate;
    private LocalDate effectiveDate;
    @OneToMany
    private List<Rate> rates;


    @Entity
    public static final class Rate {
        @Id
        private int id;
        private String currency;
        private String code;
        private BigDecimal bid;
        private BigDecimal ask;
    }
}

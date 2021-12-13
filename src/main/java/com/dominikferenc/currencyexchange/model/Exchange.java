package com.dominikferenc.currencyexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchanges")
@Getter
@Setter
@NoArgsConstructor

public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amountAfterExchange;
    private LocalDateTime dateTime;

}

package com.dominikferenc.currencyexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(max = 3, min = 3)
    private BigDecimal currency;
    private BigDecimal amount;
    @Size(max = 3, min = 3)
    private BigDecimal fromCurrency;
    @Size(max = 3, min = 3)
    private BigDecimal toCurrency;
    private BigDecimal amountAfterExchange;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;

}

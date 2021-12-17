package com.dominikferenc.currencyexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "amount")
@Getter
@Setter
@NoArgsConstructor
public class AmountAfterExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amountAfterExchange;

    public AmountAfterExchange(BigDecimal amountAfterExchange) {
        this.amountAfterExchange = amountAfterExchange;
    }
}

package com.dominikferenc.currencyexchange.repository;

import com.dominikferenc.currencyexchange.model.AmountAfterExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountAfterExchangeRepository extends JpaRepository<AmountAfterExchange, Long> {
}

package com.dominikferenc.currencyexchange.repository;

import com.dominikferenc.currencyexchange.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   CurrencyExchangeRepository extends JpaRepository<Exchange, Long> {
    Exchange save(Exchange entity);
}

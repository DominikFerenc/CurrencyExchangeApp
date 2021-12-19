
drop table if exists exchanges;
create table exchange
(
    id      SERIAL PRIMARY KEY,
    amount NUMERIC,
    from_currency VARCHAR(3),
    to_currency VARCHAR(3),
    amount_after_exchange NUMERIC,
    date_time TIMESTAMP
);
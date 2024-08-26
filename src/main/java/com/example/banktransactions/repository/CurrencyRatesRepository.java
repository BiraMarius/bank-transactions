package com.example.banktransactions.repository;

import com.example.banktransactions.entity.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CurrencyRatesRepository extends JpaRepository<CurrencyRates,Long> {

    CurrencyRates findCurrencyRatesByDate(LocalDate localDate);
}

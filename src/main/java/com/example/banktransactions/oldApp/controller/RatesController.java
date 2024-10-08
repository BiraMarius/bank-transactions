package com.example.banktransactions.oldApp.controller;

import com.example.banktransactions.oldApp.entity.CurrencyRates;
import com.example.banktransactions.oldApp.repository.CurrencyRatesRepository;
import com.example.banktransactions.oldApp.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@AllArgsConstructor
public class RatesController {
    private final CurrencyExchangeService currencyExchangeService;
    private final CurrencyRatesRepository currencyRatesRepository;

    @PostMapping("/save-currency")
    public void saveCurrency(){
        CurrencyRates cr = currencyExchangeService.apiiii();
        currencyRatesRepository.save(cr);
    }

    @GetMapping("/get-rates")
    public Map<String, String> ratesMap(){
       CurrencyRates cr = currencyRatesRepository.findCurrencyRatesByDate(LocalDate.now());
       Map<String, String> mapCR = cr.getRates();
       return mapCR;
    }


}

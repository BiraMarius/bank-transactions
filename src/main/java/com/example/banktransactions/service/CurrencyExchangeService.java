package com.example.banktransactions.service;

import com.example.banktransactions.entity.Currency;
import com.example.banktransactions.entity.CurrencyRates;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyExchangeService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl="http://api.exchangeratesapi.io/v1/latest?access_key=979be363141fc830cbd6f64cd7f9b308";

    //TODO Adauga url + key in property ( @Value aici)
    public CurrencyRates getLatestRates() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(apiUrl, String.class);

        String productsJson = response.getBody();
        return null;

//        return this.webClient.get()
//                .uri("/latest?access_key=979be363141fc830cbd6f64cd7f9b308")
//                .retrieve()
//
    }

    public String getLatestRatesv() {
        ResponseEntity<String> response
                = restTemplate.getForEntity(apiUrl, String.class);

        String productsJson = response.getBody();
        return null;

//        return this.webClient.get()
//                .uri("/latest?access_key=979be363141fc830cbd6f64cd7f9b308")
//                .retrieve()
//
    }


    //ObjectMapper objectMapper = new ObjectMapper();
    //
    //File file = new File("data/car.json");
    //
    //Car car = objectMapper.readValue(file, Car.class);
    //https://jenkov.com/tutorials/java-json/jackson-objectmapper.html


    //Metoda ce verifica daca moneda introdusa(currency) este valida, si exista in currnecy enum
    public String verifyCurrency(CurrencyRates currencyRates, Currency currency){
        Map<String, String> rates = currencyRates.getRates();
        if(rates.containsKey(currency.toString())){
            return "YAY";
        } else {
            return "NAW";
        }
    }

    public CurrencyRates getCurrencyRatesFromApi(){
        ResponseEntity<CurrencyRates> response
                = restTemplate.getForEntity(apiUrl, CurrencyRates.class);
        CurrencyRates currenciesJson = response.getBody();
        return currenciesJson;
    }

    public CurrencyRates apiiii(){
        WebClient.Builder apiCall = WebClient.builder();
       // String responseFromApi = apiCall.build().get().uri(apiUrl).retrieve().bodyToMono(String.class).block();
        CurrencyRates cr= apiCall.build().get().uri(apiUrl).retrieve().bodyToMono(CurrencyRates.class).block();
        //return responseFromApi;
        return cr;
    }

    public void updateCurrencyRates(){

    }

//    public void verifyDate(){
//        LocalDate localDate = LocalDate.now();
//        *SELECT DATE FROM CurrencyRates WHERE DATE=""*
//    }




}

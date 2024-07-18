package com.example.banktransactions.oldApp.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "RATES")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CurrencyRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean success;

    @Column
    private long timestamp;

    @Column
    private String base;

    @Column
    private LocalDate date;

    @ElementCollection
    private Map<String, String> rates;

    //@OneToMany(mappedBy = "Rate", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Rate> rates = new ArrayList<>();

}

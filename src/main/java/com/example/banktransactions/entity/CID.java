package com.example.banktransactions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CID {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;



}

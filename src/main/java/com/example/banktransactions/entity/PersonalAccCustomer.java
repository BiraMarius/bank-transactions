package com.example.banktransactions.entity;

import com.example.banktransactions.entity.enums.Country;
import com.example.banktransactions.entity.enums.County;
import com.example.banktransactions.entity.enums.Gender;
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
public class PersonalAccCustomer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    private CID ci;

    @Column
    private Gender gender;

    @Column
    private Country country;

    @Column
    private County county;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    //Proof of identity

//    @Column
//    private Photo idDoc;



}

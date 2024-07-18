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
public class BusinessAccCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    @Column
    private String name;

    @Column
    private String cif;

    @Column
    private String caen;//Classification of Activities in the National Economy

    @Column
    private String registrationNumber;

    @Column
    private Country country;

    @Column
    private County county;

    @Column
    private String address;

    //Admin info

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    private CID ci;

    @Column
    private Gender gender;

    @Column
    private Country countryOfAdmin;

    @Column
    private County countyOfAdmin;

    @Column
    private String addressOfAdmin;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String role;

    //Proof of identity

//    @Column
//    private photo associationDocument;
//
//    @Column
//    private photo cifDocument;
//
//    @Column
//    private photo adminDocument;//attorneyDocument

}

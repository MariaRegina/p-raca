package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String street;

    private String number;

    private String complement;

    private String city;

    private String state;

    private String zipcode;

    @ManyToOne(optional = false)
    private Person person;

}

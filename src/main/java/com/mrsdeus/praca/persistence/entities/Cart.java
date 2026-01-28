package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Table
@Entity(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private Person person;

    public Cart(){}

    public Cart(Person person){
        this.person = person;
    }

}
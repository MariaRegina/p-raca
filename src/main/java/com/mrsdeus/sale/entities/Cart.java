package com.mrsdeus.sale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table
@Entity(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    private UUID id;

}

package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table
@Entity(name = "item-cart")
public class ItemCart {

    @Id
    @GeneratedValue
    private UUID id;

    private Product product;

    private int amount;
}

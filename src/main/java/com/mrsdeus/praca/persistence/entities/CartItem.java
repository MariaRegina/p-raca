package com.mrsdeus.praca.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Table
@Entity(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int amount;

    private int clothingSize;
}
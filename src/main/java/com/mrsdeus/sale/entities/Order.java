package com.mrsdeus.sale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;


@Entity
@Table(name = "order")
public class Order {
    private UUID id;
}

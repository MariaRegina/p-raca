package com.mrsdeus.praca.persistence.services;

import com.mrsdeus.praca.persistence.entities.Cart;

import java.util.UUID;


public interface CartService {
    public Cart findByPerson_id(UUID id);
}

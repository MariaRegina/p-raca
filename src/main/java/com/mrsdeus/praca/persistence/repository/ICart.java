package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICart extends JpaRepository<Cart, UUID> {
    public Cart findByPerson_id(UUID id);
}
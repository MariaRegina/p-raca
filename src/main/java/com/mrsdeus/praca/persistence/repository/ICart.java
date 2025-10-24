package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ICart extends CrudRepository<Cart, UUID> {
}

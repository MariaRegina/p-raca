package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICartItem extends JpaRepository<CartItem, UUID> {
    CartItem findByCart_idAndProduct_idAndClothingSize(UUID cartId, UUID productId, int clothingSizes);
    List<CartItem> findByCart_id(UUID cartId);
}

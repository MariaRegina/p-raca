package com.mrsdeus.praca.persistence.services;

import com.mrsdeus.praca.persistence.dao.CartDao;
import com.mrsdeus.praca.persistence.entities.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class CartService {
    @Inject
    CartDao dao;

    public List<Product> getProdutsInCart(UUID userId){
        return dao.getProdutsInCart(userId);
    }
}

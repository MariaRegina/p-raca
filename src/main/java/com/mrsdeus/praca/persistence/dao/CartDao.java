package com.mrsdeus.praca.persistence.dao;

import com.mrsdeus.praca.persistence.entities.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class CartDao {
    @Inject
    EntityManager em;

    public List<Product> getProdutsInCart(UUID userId){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT P FROM cart C ");
        sql.append(" INNER JOIN cart_item CI ON C.id = CI.cart.id ");
        sql.append(" INNER JOIN Product P ON P.id = CI.product.id ");
        sql.append(" WHERE C.person.id = :userId ");

        Query query = em.createQuery(sql.toString());
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}
